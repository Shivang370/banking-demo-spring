package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
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
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"customer not found");
    }

    //We can also delete the customer & show the output on postman
//    @Override
//    public ResponseEntity<Customer> deleteCustomer(Long id) {
//        Optional<Customer> optionalCustomer=repository.findById(id);
//        //Using lambda Expression ..Reference method...one can also use optionalcustomer.ispresent for checking
//        if(optionalCustomer.isPresent())
//        {
//            ResponseEntity response=new ResponseEntity<>( optionalCustomer.get(),HttpStatus.OK);
//            repository.deleteById(id);
//            return  response;
//
//        }
////        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"customer not found");
//
//
//    }
    //Instead of using ispresent we can also use response entity to collect & then check for status code
    public  void deleteCustomer(Long id)
    {
        ResponseEntity<Customer> customer =getCustomer(id);
        Optional<Customer> optionalCustomer=repository.findById(id);
        if(customer.getStatusCode().is4xxClientError())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"customer not found");
        repository.deleteById(id);
    }


}
