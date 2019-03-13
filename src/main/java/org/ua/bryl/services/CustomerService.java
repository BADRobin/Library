package org.ua.bryl.services;

import org.ua.bryl.model.Customer;

import java.util.List;
/**
 * Created by olegbryl 13/08/2018.
 */

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customer_id);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String customer_username);

}
