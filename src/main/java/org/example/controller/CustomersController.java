package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    @Autowired
    private CustomerService customerService;

    //@GetMapping
    //public List<Customer> getAllCustomers()
    //{
     //   return customerService.getAllCustomer();
   // }

    @GetMapping
    @RequestMapping("{id}")
    public Customer getCustomer(@PathVariable Long id)
    {
        //System.out.println("Customer ID recieved: "+ id);
        return customerService.getCustomer(id);
    }
}
