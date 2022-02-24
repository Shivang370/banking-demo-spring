package org.example.service;

import org.example.model.Customer;

import java.util.List;

public interface CustomerService {
    //Public is not required as every method in interface is by default public
         List<Customer> getAllCustomer();
         Customer getCustomer(Long id);
          void deleteCustomer(Long id);
}

