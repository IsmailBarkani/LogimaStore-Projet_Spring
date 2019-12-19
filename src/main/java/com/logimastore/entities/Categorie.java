package com.logimastore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Categorie implements Serializable {
    @Id
    private String libelleCategorie;

    @OneToMany(mappedBy = "categorieArticle.libelleCategorie")
    private Collection<CategorieArticle> categorieArticles;


    public Categorie(String libelleCategorie, Collection<CategorieArticle> categorieArticles) {
        this.libelleCategorie = libelleCategorie;
        this.categorieArticles = categorieArticles;
    }

    public Categorie() {
    }

    public Categorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }



}
