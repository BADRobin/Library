package org.ua.bryl.services;

import org.ua.bryl.model.Product;

import java.util.List;

/**
 * Created by olegbryl 13/08/2018.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}
