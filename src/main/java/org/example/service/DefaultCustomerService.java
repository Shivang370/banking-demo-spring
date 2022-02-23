package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Service("customerService")
//@Component
public class DefaultCustomerService implements CustomerService{
    //private CustomerRepositoryDB repository=new CustomerRepositoryDB();
    //private CustomerRepositoryStub repository=new CustomerRepositoryStub();
    //Primary is must for qualifier & autowire annotation at repository side but vice versa is not true ..just by passing primary we can do the thing
    //@Autowired
    //@Qualifier("stub")
    private CustomerRepository repository;

    //Passing the repository using dependency
    //Injecting the repository using constructor...as repository is a dependency

    //With Autowiring we dont require the constructor spring will take care of it...but with only primary we require it
//    public DefaultCustomerService(CustomerRepository repository)
//    {
//
//        this.repository=repository;
//    }

//    //With xml Configuration we need a constructor with one argument for constructor-args tag
//    public DefaultCustomerService(CustomerRepository repository)
//        {
//
//        this.repository=repository;
//    }

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
