package org.ua.bryl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by olegbryl 03/08/2018.
 */

@Entity
public class Customer implements Serializable{

    private static final long serialVersionUID = -2039869419395635053L;

    @Id
    @GeneratedValue
    private int customer_id;

    @NotEmpty(message = "The name is required")
    private String customer_name;

    @NotEmpty(message = "Email is required")
    private String customer_email;
    private String customer_phone;

    @NotEmpty(message = "The username is required")
    private String customer_username;

    @NotEmpty(message = "Password required")
    private String customer_password;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "billing_address_id")
    @JsonManagedReference
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shipping_address_id")
    @JsonManagedReference
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
