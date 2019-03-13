package org.ua.bryl.services;

import org.ua.bryl.model.Cart;
import org.ua.bryl.model.CartItem;
/**
 * Created by olegbryl 13/08/2018.
 */

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int product_id);
}
