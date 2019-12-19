package com.logimastore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class UserRole implements Serializable {
    @Id
    private String user;
    private String role;

    public UserRole() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserRole(String user, String role) {
        this.user = user;
        this.role = role;
    }
}
