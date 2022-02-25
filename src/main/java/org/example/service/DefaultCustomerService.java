package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("customerService")

public class DefaultCustomerService implements CustomerService{

    @Autowired
    private CustomerRepository repository;

    public DefaultCustomerService() {}

    //Setter Injection
    public void setCustomerRepository(CustomerRepository repository)
    {
        this.repository=repository;
    }

    public List<Customer> getAllCustomer()
    {
        return repository.findAll();
    }

    public ResponseEntity<Customer> getCustomer(Long id)
    {
        Optional<Customer> optionalCustomer=repository.findById(id);
        //Using lambda Expression ..Reference method...one can also use optionalcustomer.ispresent for checking
        if(optionalCustomer.isPresent())
            return new ResponseEntity<>(optionalCustomer.get(),HttpStatus.OK);
        //  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"customer not found");
    }

    public  void deleteCustomer(Long id)
    {
        ResponseEntity<Customer> customer =getCustomer(id);
        Optional<Customer> optionalCustomer=repository.findById(id);
        if(customer.getStatusCode().is4xxClientError())//Checking for particular status code
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"customer not found");
        repository.deleteById(id);
    }
    @Override
    public Customer saveCustomer(Customer customer)
    {
        return repository.saveAndFlush(customer);//It will add to the database & commit the changes
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        ResponseEntity<Customer> responseEntity=getCustomer(id);
        if(responseEntity.getStatusCode().is4xxClientError())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Customer ID !!");
        Customer existingCustomer=responseEntity.getBody();
        BeanUtils.copyProperties(customer,existingCustomer,"id");//Here customer is the requestbody & existing customer is having all parameters ...we are just ignoring the id so that new record does not gets created
        return repository.saveAndFlush(existingCustomer);//we can also ignore multiple fields else we have to set for each entity in update customer if bean utils is not present
    }
}
