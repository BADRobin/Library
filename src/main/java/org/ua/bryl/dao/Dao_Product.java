package org.ua.bryl.dao;

import org.ua.bryl.model.Product;

import java.util.List;
/**
 * Created by olegbryl 01/08/2018.
 */

public interface Dao_Product {

    List<Product> getProductList();

    Product getProductById(int product_id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
