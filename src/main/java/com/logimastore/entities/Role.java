package com.logimastore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
public class Role implements Serializable {
    @Id @NotNull
    String role;

    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }
}
