package org.ua.bryl.services.implementation;

import org.ua.bryl.dao.Dao_Product;
import org.ua.bryl.model.Product;
import org.ua.bryl.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by olegbryl 13/08/2018.
 */
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private Dao_Product dao_product;

    public List<Product> getProductList() {
        return dao_product.getProductList();
    }

    public Product getProductById(int id) {
        return dao_product.getProductById(id);
    }

    public void addProduct(Product product) {
        dao_product.addProduct(product);
    }

    public void editProduct(Product product) {
        dao_product.editProduct(product);
    }

    public void deleteProduct(Product product) {
        dao_product.deleteProduct(product);
    }
}
