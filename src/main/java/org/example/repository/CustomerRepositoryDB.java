package org.example.repository;

import org.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryDB implements CustomerRepository {
    public List<Customer> findAll()  {
        List<Customer> customers=new ArrayList<>();

        try {
            //Connection is an interface ,driver manager helps interface to know & establish connection
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/banking?user=root&password=student");//finds driver in the classpath, if we have the connection url then it proceeds
            PreparedStatement ps=conn.prepareStatement("SELECT customer_id,name,city from customers");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Customer customer=new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                    //  rs.getString("customer_id"),
                   //   rs.getString("name"),
                  //    rs.getString("City")
                );
                customers.add(customer);
                //rs.getString(1); Its using column number to refer to customer_id
                //rs.getString(2); Its using column number to refer to name
                //rs.getString(3); Its using column number to refer to city
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
