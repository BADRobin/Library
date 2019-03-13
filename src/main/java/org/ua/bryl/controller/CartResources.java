package org.ua.bryl.controller;

import org.ua.bryl.model.Cart;
import org.ua.bryl.model.CartItem;
import org.ua.bryl.model.Customer;
import org.ua.bryl.model.Product;
import org.ua.bryl.services.CartItemService;
import org.ua.bryl.services.CartService;
import org.ua.bryl.services.CustomerService;
import org.ua.bryl.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by olegbryl 02/08/2018.
 */

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/{cart_id}")
    public @ResponseBody
    Cart getCartById(@PathVariable(value = "cart_id") int cart_id){
        return cartService.getCartById(cart_id);
    }

    @RequestMapping(value = "/add/{product_id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value = "product_id") int product_id, @AuthenticationPrincipal User active_user){
        Customer customer = customerService.getCustomerByUsername(active_user.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(product_id);
        List<CartItem> cart_items = cart.getCart_items();

        for (int i=0; i < cart_items.size(); i++){
            if(product.getProduct_id() == cart_items.get(i).getProduct().getProduct_id()){
                CartItem cartItem = cart_items.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotal_price(product.getPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotal_price(product.getPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @RequestMapping(value = "/remove/{product_id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "product_id") int product_id) {
        CartItem cartItem = cartItemService.getCartItemByProductId(product_id);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cart_id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cart_id") int cart_id){
        Cart cart = cartService.getCartById(cart_id);
        cartItemService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors (Exception ex){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors (Exception ex){

    }
}
