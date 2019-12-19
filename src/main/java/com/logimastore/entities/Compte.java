package com.logimastore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
public class Compte implements Serializable {
    @Id @NotNull
    private String login;
    @NotNull
    private String password;
    private int active;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;


    public Compte(String login, String password, User user) {
        this.login = login;
        this.password = password;
        this.user = user;
        this.active=1;
    }

    public Compte() {
        this.active=1;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
