package org.ua.bryl.services.implementation;

import org.ua.bryl.dao.Dao_CartItem;
import org.ua.bryl.model.Cart;
import org.ua.bryl.model.CartItem;
import org.ua.bryl.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by olegbryl 13/08/2018.
 */

@Service
public class CartItemServiceImp implements CartItemService {

    @Autowired
    private Dao_CartItem dao_cartItem;

    public void addCartItem(CartItem cartItem){
        dao_cartItem.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem){
        dao_cartItem.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
        dao_cartItem.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int product_id){
        return dao_cartItem.getCartItemByProductId(product_id);
    }

}
