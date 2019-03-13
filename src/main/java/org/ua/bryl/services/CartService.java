package org.ua.bryl.services;

import org.ua.bryl.model.Cart;

import java.io.IOException;
/**
 * Created by olegbryl 13/08/2018.
 */

public interface CartService {

    Cart getCartById(int cart_id);

    void update(Cart cart);

    Cart validate(int cart_id) throws IOException;

}
