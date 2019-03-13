package org.ua.bryl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
  Created by olegbryl 01/08/2018.
 */

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = -5275312162791227880L;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    private int product_id;

    @NotEmpty(message = "The name of the product is required")
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String firstName;

    private String description;
    private String category;
//    private String condition;
    private String manufacturing;

    @Min(value = 0, message = "The units in existence can not be less than zero")
    private int units_in_existence;

    @Min(value = 0, message = "The price of the product can not be less than zero")
    private double price;

    @Transient
    private MultipartFile image;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore

    public List<CartItem> cartItemList;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public String getCondition() {
//        return condition;
//    }

//    public void setCondition(String condition) {
//        this.condition = condition;
//    }

    public String getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(String manufacturing) {
        this.manufacturing = manufacturing;
    }

    public int getUnits_in_existence() {
        return units_in_existence;
    }

    public void setUnits_in_existence(int units_in_existence) {
        this.units_in_existence = units_in_existence;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
