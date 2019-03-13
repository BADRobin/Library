package org.ua.bryl.services;

import org.ua.bryl.model.CustomerOrder;

import java.util.List;

/**
 * Created by olegbryl 13/08/2018.
 */

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);

    List<CustomerOrder> getAllCustomerOrders();
}
