package org.ua.bryl.dao;

import org.ua.bryl.model.Customer;

import java.util.List;
/**
 * Created by olegbryl 01/08/2018.
 */

public interface Dao_Customer {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customer_id);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String customer_username);
}
