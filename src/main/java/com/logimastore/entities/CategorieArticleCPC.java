package com.logimastore.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class CategorieArticleCPC implements Serializable {

    @Column(name = "libelleCategorie")
    private String libelleCategorie;
    @Column(name = "idArticlec")
    private Long idArticlec;

    public CategorieArticleCPC() {
    }

    public CategorieArticleCPC(String libelleCategorie, Long idArticlec) {
        this.libelleCategorie = libelleCategorie;
        this.idArticlec = idArticlec;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public Long getIdArticlec() {
        return idArticlec;
    }

    public void setIdArticlec(Long idArticlec) {
        this.idArticlec = idArticlec;
    }
}

