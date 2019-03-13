package org.ua.bryl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by olegbryl 03/08/2018.
 */


@Entity
public class CartItem implements Serializable{

    private static final long serialVersionUID = -5425701670023632251L;

    @Id
    @GeneratedValue
    private int cartItem_id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private double total_price;

    public int getCartItem_id() {
        return cartItem_id;
    }

    public void setCartItem_id(int cartItem_id) {
        this.cartItem_id = cartItem_id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
