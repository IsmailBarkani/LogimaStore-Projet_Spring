package com.logimastore.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CategorieArticle implements Serializable {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "categorieArticle.idArticlec",column = @Column(name = "idArticlec")),
            @AttributeOverride(name = "categorieArticle.libelleCategorie",column = @Column(name = "libelleCategorie"))
    })
    private CategorieArticleCPC categorieArticle;

    public CategorieArticle(CategorieArticleCPC categorieArticle) {
        this.categorieArticle = categorieArticle;
    }

    public CategorieArticle() {
    }

    public CategorieArticleCPC getCategorieArticle() {
        return categorieArticle;
    }

    public void setCategorieArticle(CategorieArticleCPC categorieArticle) {
        this.categorieArticle = categorieArticle;
    }
}
