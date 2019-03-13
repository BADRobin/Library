package org.ua.bryl.dao.implementation;

import org.ua.bryl.dao.Dao_Product;
import org.ua.bryl.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by olegbryl 01/08/2018.
 */

@Repository
@Transactional
public class DaoProductImp implements Dao_Product {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> list_products = query.list();
        session.flush();

        return list_products;
    }

    public Product getProductById(int product_id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, product_id);
        session.flush();

        return product;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}
