package org.example.model;

import javax.persistence.*;
import java.sql.Date;

//Entity does not belong to Spring it is from java enterprise ..we need to specify that it fetches data from customers table
@Entity(name="customers")
public class Customer {

    @Id//It is for stating that it is a primary key
    @GeneratedValue(strategy=GenerationType.IDENTITY)//It is for the auto-increment part of customer_id
    @Column(name="customer_id")//It is done as we do not have the same column name
    private Long id;
    private String name;
    private String city;
    private Date date_of_birth;
    private Integer status;
    private String zipcode;

    //We just need to add the default constructor
    public Customer(){}

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", status=" + status +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
