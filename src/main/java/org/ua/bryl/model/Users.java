package org.ua.bryl.model;

import javax.persistence.*;

/**
 * Created by olegbryl 03/08/2018.
 */
@Entity
public class Users {

    @Id
    @GeneratedValue
    private int     user_id;
    private String  username;
    private String  password;
    private boolean enabled;
    private int     people_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }
}
