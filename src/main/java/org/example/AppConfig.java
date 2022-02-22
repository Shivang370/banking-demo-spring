package org.example;

import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryDB;
import org.example.service.CustomerService;
import org.example.service.DefaultCustomerService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@ComponentScan({"org.example"})
@Configuration
public class AppConfig {

    //It is autowiring...using @ComponentSan({"org.example"})..@service("customerService")...@repository()
    //By default it is a singleton scope as default customer service & customer Repository have single instance
//    @Bean("customerService")
//    @Scope(value= BeanDefinition.SCOPE_PROTOTYPE)
//    public CustomerService getCustomerService() {
//        CustomerService service = new DefaultCustomerService(getCustomerRepositoryDB());
//        return service;
//    }
//    @Bean("customerRepository")
//    public CustomerRepository getCustomerRepositoryDB() {
//        return new CustomerRepositoryDB();
//    }
}


