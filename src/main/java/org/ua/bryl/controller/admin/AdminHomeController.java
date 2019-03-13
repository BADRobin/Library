package org.ua.bryl.controller.admin;

import org.ua.bryl.model.Customer;
import org.ua.bryl.model.CustomerOrder;
import org.ua.bryl.model.Product;
import org.ua.bryl.services.CustomerOrderService;
import org.ua.bryl.services.CustomerService;
import org.ua.bryl.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by olegbryl 07/08/2018.
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping
    public String adminHomePage() {
        return "admin";
    }

    @RequestMapping("/inventory")
    public String inventory(Model model) {
        List<Product> list_products = productService.getProductList();
        model.addAttribute("list_products", list_products);

                return "InventoryProduct";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);
        return "adminUsersList";
    }
    @RequestMapping("/customerorder")
    public String customerOrderManagement(Model model) {
        List<CustomerOrder> customerOrderList = customerOrderService.getAllCustomerOrders();
        model.addAttribute("customerOrderList", customerOrderList);
        return "adminOrdersList";
    }

}
