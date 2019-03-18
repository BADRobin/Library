package org.ua.bryl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by olegbryl 18/03/2019.
 */

@Entity
public class People implements Serializable{

    private static final long serialVersionUID = -2039869419395635053L;

    @Id
    @GeneratedValue
    private int people_id;

    @NotEmpty(message = "The name is required")
    private String people_name;

    @NotEmpty(message = "Email is required")
    private String people_email;
    private String people_phone;

    @NotEmpty(message = "The username is required")
    private String people_username;

    @NotEmpty(message = "Password required")
    private String people_password;

    private boolean enabled;






    @OneToOne
//    @JoinColumn(name = "cart_id")
    @JsonIgnore


    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    public String getPeople_name() {
        return people_name;
    }

    public void setPeople_name(String people_name) {
        this.people_name = people_name;
    }

    public String getPeople_email() {
        return people_email;
    }

    public void setPeople_email(String people_email) {
        this.people_email = people_email;
    }

    public String getPeople_phone() {
        return people_phone;
    }

    public void setPeople_phone(String people_phone) {
        this.people_phone = people_phone;
    }

    public String getPeople_username() {
        return people_username;
    }

    public void setPeople_username(String people_username) {
        this.people_username = people_username;
    }

    public String getPeople_password() {
        return people_password;
    }

    public void setPeople_password(String people_password) {
        this.people_password = people_password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }






}
