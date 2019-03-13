package org.ua.bryl.dao;

import org.ua.bryl.model.Cart;

import java.io.IOException;
/**
 * Created by olegbryl 01/08/2018.
 */
public interface Dao_Cart {

    Cart getCartById(int cart_id);

    void update(Cart cart);

    Cart validate(int cart_id) throws IOException;


}
