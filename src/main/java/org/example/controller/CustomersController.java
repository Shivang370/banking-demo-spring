package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id)
    {

        return customerService.getCustomer(id);
    }
    //It is always good to have method parameter in request mapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Long id)
    {
           customerService.deleteCustomer(id);
    }
}
