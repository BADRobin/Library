package org.ua.bryl.controller;

import org.ua.bryl.model.Cart;
import org.ua.bryl.model.Customer;
import org.ua.bryl.model.CustomerOrder;
import org.ua.bryl.services.CartService;
import org.ua.bryl.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by olegbryl 01/08/2018.
 */

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cart_id}")
    public String createOrder(@PathVariable("cart_id") int cart_id){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cart_id);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customer.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?id="+cart_id;
    }

}
