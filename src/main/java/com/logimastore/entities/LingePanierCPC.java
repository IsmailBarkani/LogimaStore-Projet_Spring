package com.logimastore.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
public class LingePanierCPC implements Serializable {
    @Column(name = "idUser")
    private Long idUser;
    @Column(name = "idArticle")
    private Long idArticle;

    public LingePanierCPC(Long idPanier, Long idArticle) {
        this.idUser = idPanier;
        this.idArticle = idArticle;
    }

    public LingePanierCPC() {
    }

    public Long getIdPanier() {
        return idUser;
    }

    public void setIdPanier(Long idPanier) {
        this.idUser = idPanier;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }
}
