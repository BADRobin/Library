package org.ua.bryl.services.implementation;

import org.ua.bryl.dao.Dao_CustomerOrder;
import org.ua.bryl.model.Cart;
import org.ua.bryl.model.CartItem;
import org.ua.bryl.model.CustomerOrder;
import org.ua.bryl.services.CartService;
import org.ua.bryl.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by olegbryl 13/08/2018.
 */

@Service
public class CustomerOrderServiceImp implements CustomerOrderService {

    @Autowired
    private Dao_CustomerOrder dao_customerOrder;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        dao_customerOrder.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cart_id) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cart_id);
        List<CartItem> cartItems = cart.getCart_items();

        for (CartItem item : cartItems){
            grandTotal += item.getTotal_price();
        }

        return grandTotal;
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrders() {
        return dao_customerOrder.getAllCustomerOrders();
    }
}
