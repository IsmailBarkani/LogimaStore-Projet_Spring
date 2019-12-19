package com.logimastore.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Favouriser implements Serializable {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idUserArticle.idArticle",column = @Column(name = "idArticle")),
            @AttributeOverride(name = "idUserArticle.idUser",column = @Column(name = "idUser"))
    })
    private FavouriserCPC idUserArticle;

    public Favouriser(FavouriserCPC idUserArticle) {
        this.idUserArticle = idUserArticle;
    }

    public Favouriser() {
    }

    public FavouriserCPC getIdUserArticle() {
        return idUserArticle;
    }

    public void setIdUserArticle(FavouriserCPC idUserArticle) {
        this.idUserArticle = idUserArticle;
    }
}
