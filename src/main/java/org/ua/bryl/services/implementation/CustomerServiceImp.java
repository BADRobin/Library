package org.ua.bryl.services.implementation;

import org.ua.bryl.dao.Dao_Customer;
import org.ua.bryl.model.Customer;
import org.ua.bryl.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by olegbryl 13/08/2018.
 */
@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    Dao_Customer dao_customer;

    public List<Customer> getAllCustomers() {
        return dao_customer.getAllCustomers();
    }

    public Customer getCustomerById(int customer_id) {
        return dao_customer.getCustomerById(customer_id);
    }

    public void addCustomer(Customer customer) {
         dao_customer.addCustomer(customer);
    }

    public Customer getCustomerByUsername(String customer_username) {
        return dao_customer.getCustomerByUsername(customer_username);
    }
}
