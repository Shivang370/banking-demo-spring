package org.example.app;

import org.example.AppConfig;
import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService service = context.getBean("customerService", CustomerService.class);

        List<Customer> customers = service.getAllCustomer();
        customers.forEach(System.out::println);
    }
}