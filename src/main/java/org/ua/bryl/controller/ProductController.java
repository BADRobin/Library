package org.ua.bryl.controller;

import org.ua.bryl.model.Product;
import org.ua.bryl.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
/**
 * Created by olegbryl 01/08/2018.
 */

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String getProducts(Model model) {
        List<Product> list_products = productService.getProductList();
        model.addAttribute("list_products", list_products);
        return "product";
    }

    @RequestMapping("/productDetails/{product_id}")
    public String detailsProduct(@PathVariable int product_id, Model model) throws IOException {
        Product product = productService.getProductById(product_id);
        model.addAttribute(product);

        return "productDetails";
    }
}
