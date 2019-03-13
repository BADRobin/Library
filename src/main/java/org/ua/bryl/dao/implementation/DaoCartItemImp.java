package org.ua.bryl.dao.implementation;

import org.ua.bryl.dao.Dao_CartItem;
import org.ua.bryl.model.Cart;
import org.ua.bryl.model.CartItem;
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
public class DaoCartItemImp implements Dao_CartItem{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem){
        Session session = sessionFactory.getCurrentSession();
        if(cartItem.getQuantity() > 1) {
            cartItem.setQuantity(cartItem.getQuantity()-1);
            cartItem.setTotal_price(cartItem.getProduct().getPrice()*cartItem.getQuantity());
            session.saveOrUpdate(cartItem);
        }
        else{
            session.delete(cartItem);
        }

        session.flush();
    }

    public void removeAllCartItems(Cart cart){
        Session session = sessionFactory.getCurrentSession();
        List<CartItem> cartItems = cart.getCart_items();
        for (CartItem item : cartItems){
            session.delete(item);
        }
        session.flush();
    }

    public CartItem getCartItemByProductId(int product_id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where product_id = ?");
        query.setInteger(0, product_id);
        session.flush();

        return (CartItem) query.uniqueResult();
    }
}
