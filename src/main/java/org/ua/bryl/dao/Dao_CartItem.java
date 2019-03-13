package org.ua.bryl.dao;

import org.ua.bryl.model.Cart;
import org.ua.bryl.model.CartItem;
/**
 * Created by olegbryl 01/08/2018.
 */

public interface Dao_CartItem {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int product_id);
}
