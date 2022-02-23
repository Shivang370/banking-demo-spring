package org.example.app;

import org.example.AppConfig;
import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        //Java Configuration
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //Xml Configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CustomerService service = context.getBean("customerService", CustomerService.class);
        //with prototype we will have different service ID's
        /*CustomerService service1 = context.getBean("customerService", CustomerService.class);
        CustomerService service2 = context.getBean("customerService", CustomerService.class);

        System.out.println(service);
        System.out.println(service1);
        System.out.println(service2);*/
        List<Customer> customers = service.getAllCustomer();
        customers.forEach(System.out::println);
    }
}