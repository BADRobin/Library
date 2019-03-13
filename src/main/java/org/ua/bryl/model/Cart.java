package org.ua.bryl.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * Created by olegbryl 03/08/2018.
 */


@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = -181789378355886642L;

    @Id
    @GeneratedValue
    private int cart_id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cart_items;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private double grand_total;

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public List<CartItem> getCart_items() {
        return cart_items;
    }

    public void setCart_items(List<CartItem> cart_items) {
        this.cart_items = cart_items;
    }

    public double getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(double grand_total) {
        this.grand_total = grand_total;
    }
}
