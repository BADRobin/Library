package org.ua.bryl.dao;

import org.ua.bryl.model.CustomerOrder;

import java.util.List;

/**
 * Created by olegbryl 01/08/2018.
 */

public interface Dao_CustomerOrder {

    void addCustomerOrder(CustomerOrder customerOrder);


    List<CustomerOrder> getAllCustomerOrders();
}
