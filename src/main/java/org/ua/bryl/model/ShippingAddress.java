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
public class ShippingAddress implements Serializable{

    private static final long serialVersionUID = 4045861295293075512L;

    @Id
    @GeneratedValue
    private int shipping_address_id;

    private String street;
    private String division;
    private String number_apartment;
    private String city;
    private String state;
    private String country;
    private String zip;

    @OneToOne
    @JsonBackReference
    private Customer customer;

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getShipping_address_id() {
        return shipping_address_id;
    }

    public void setShipping_address_id(int shipping_address_id) {
        this.shipping_address_id = shipping_address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber_apartment() {
        return number_apartment;
    }

    public void setNumber_apartment(String number_apartment) {
        this.number_apartment = number_apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Override
    public String toString() {
        return "ShippingAddress{" +
                "street='" + street + '\'' +
                ", number_apartment='" + number_apartment + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                ", customer=" + customer +
                '}';
    }
}
