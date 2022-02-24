package org.example.repository;

import org.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA Handles all the CRUD Operations
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
