package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("customerService")

public class DefaultCustomerService implements CustomerService{

    @Autowired
    private CustomerRepository repository;

    //Setter Injection
    public void setCustomerRepository(CustomerRepository repository)
    {
        this.repository=repository;
    }
    public DefaultCustomerService() {}


    public List<Customer> getAllCustomer()
    {

        return repository.findAll();
    }
    //To have customers with star
    public List<Customer> getAllCustomerwithstar()
    {
        return repository.findAll().stream()
                .map(c->new Customer(c.getId(),"*****"+c.getName()+"*****",c.getCity()))
                .collect(Collectors.toList());
    }

}
