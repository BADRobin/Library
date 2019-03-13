package org.ua.bryl.dao.implementation;

import org.ua.bryl.dao.Dao_Customer;
import org.ua.bryl.model.Authorities;
import org.ua.bryl.model.Cart;
import org.ua.bryl.model.Customer;
import org.ua.bryl.model.Users;
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
public class DaoCustomerImp implements Dao_Customer {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(customer.getCustomer_username());
        newUser.setPassword(customer.getCustomer_password());
        newUser.setEnabled(true);
        newUser.setCustomer_id(customer.getCustomer_id());

        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(customer.getCustomer_username());
        newAuthorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where customer_username = ?");
        query.setString(0, username);

        return (Customer) query.uniqueResult();
    }

    public Customer getCustomerById(int customer_id){
        Session session = sessionFactory.getCurrentSession();

        return (Customer) session.get(Customer.class, customer_id);
    }

    public List<Customer> getAllCustomers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");

        return (List<Customer>) query.list();
    }



}
