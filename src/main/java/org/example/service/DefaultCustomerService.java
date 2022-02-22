package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("customerService")
//@Component
public class DefaultCustomerService implements CustomerService{
    //private CustomerRepositoryDB repository=new CustomerRepositoryDB();
    //private CustomerRepositoryStub repository=new CustomerRepositoryStub();
    private CustomerRepository repository;

    //Passing the repository using dependency
    //Injecting the repository using constructor...as repository is a dependency
    public DefaultCustomerService(CustomerRepository repository)
    {

        this.repository=repository;
    }
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
