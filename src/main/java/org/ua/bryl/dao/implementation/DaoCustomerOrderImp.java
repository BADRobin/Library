package org.ua.bryl.dao.implementation;

import org.hibernate.Query;
import org.ua.bryl.dao.Dao_CustomerOrder;
import org.ua.bryl.model.Customer;
import org.ua.bryl.model.CustomerOrder;
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
public class DaoCustomerOrderImp implements Dao_CustomerOrder {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();

    }
    public List<CustomerOrder> getAllCustomerOrders(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder");

        return (List<CustomerOrder>) query.list();
    }
}
