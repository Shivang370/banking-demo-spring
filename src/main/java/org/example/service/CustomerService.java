package org.example.service;

import org.example.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    //Public is not required as every method in interface is by default public
         List<Customer> getAllCustomer();
         ResponseEntity<Customer> getCustomer(Long id);
          void deleteCustomer(Long id);
          Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);
}

