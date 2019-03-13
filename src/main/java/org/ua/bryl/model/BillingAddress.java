package org.ua.bryl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
/**
 * Created by olegbryl 03/08/2018.
 */

@Entity
public class BillingAddress implements Serializable {

    private static final long serialVersionUID = 4335766282473181233L;

    @Id
    @GeneratedValue
    private int billing_address_id;

    private String card_holder;
    private String card_number;
    private String date_expiration;
    private String security_code;

    @OneToOne
    @JsonBackReference
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getBilling_address_id() {
        return billing_address_id;
    }

    public void setBilling_address_id(int billing_address_id) {
        this.billing_address_id = billing_address_id;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder (String card_holder) {
        this.card_holder = card_holder;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiracion(String date_expiration) {
        this.date_expiration = date_expiration;
    }

    public String getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "card_holder='" + card_holder + '\'' +
                ", card_number='" + card_number + '\'' +
                ", date_expiration='" + date_expiration + '\'' +
                ", security_code='" + security_code + '\'' +
                ", customer=" + customer +
                '}';
    }
}
