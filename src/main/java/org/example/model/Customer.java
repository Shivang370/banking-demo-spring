package org.example.model;

import javax.persistence.*;

//Entity does not belong to Spring it is from java enterprise ..we need to specify that it fetches data from customers table
@Entity(name="customers")
public class Customer {

    @Id//It is for stating that it is a primary key
    @GeneratedValue(strategy=GenerationType.IDENTITY)//It is for the auto-increment part of customer_id
    @Column(name="customer_id")
    private String id;
    private String name;//They have same name as in customers database
    private String city;//They have same name as in customers database

    //We just need to add the default constructor
    public Customer(){}
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
