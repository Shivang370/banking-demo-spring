package org.example.app;

import org.example.model.Customer;
import org.example.repository.CustomerReositoryDB;
import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryStub;
import org.example.service.CustomerService;
import org.example.service.DefaultCustomerService;

import java.util.List;
//Application is the layer that drives the flow...
//Repository is the external source from we get the data
//service is the layer that joins controller & repository.... Any type of transformation is done in service layer like if name hs to start with ***name1***
//Seperation of concern : controller never talks to repository only service talks to them.we are writing into different classes to avoid overwriting responsibility also for it to be lossely coupled
public class Application {
    public static void main(String[] args) {

        //Creating the Instances of repository types to pass to the default customer service... now whether the db is down or up in both cases we just need to pass the type of instance to the defaultcustomer service
                //******Inverting the control & now t is working as a IOC container(Application)

        //Once the functions are made for them we dont require to have it through new
        //CustomerRepository stubrepository=new CustomerRepositoryStub();
        //CustomerRepository dbrepository=new CustomerReositoryDB();
        //DefaultCustomerService service=new DefaultCustomerService(newCustomerReositoryDB());
        //DefaultCustomerService service=new DefaultCustomerService(newCustomerRepositoryStub());

        //Wiring of the application
        //DefaultCustomerService service=new DefaultCustomerService(dbrepository);

        //these are the concrete implementation rather we can have code to interface rather than having that to implementation
        //DefaultCustomerService service=new DefaultCustomerService(stubrepository);
// wiring your application
        CustomerService service = new DefaultCustomerService(newCustomerReositoryDB());
        List<Customer> customers=service.getAllCustomer();
        //List<Customer> customers1=service.getAllCustomerwithstar();
        //customers.forEach(System.out::println);
        customers.forEach(System.out::println);
    }
    public static CustomerReositoryDB newCustomerReositoryDB() {
        return new CustomerReositoryDB();
    }

    public static CustomerRepositoryStub newCustomerRepositoryStub() {
        return new CustomerRepositoryStub();
    }
}
