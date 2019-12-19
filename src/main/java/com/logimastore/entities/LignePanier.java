package com.logimastore.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class LignePanier implements Serializable {
    //cle composer
   @EmbeddedId
   @AttributeOverrides({
           @AttributeOverride(name = "idPanierArticle.idUser",column = @Column(name = "idUser")),
           @AttributeOverride(name = "idPanierArticle.idArticle",column = @Column(name = "idArticle"))
   })

   private LingePanierCPC idPanierArticle;
   private int quantite;

    public LignePanier(LingePanierCPC idPanierArticle, int quantite) {
        this.idPanierArticle = idPanierArticle;
        this.quantite = quantite;
    }

    public LignePanier() {
    }

    public LingePanierCPC getIdPanierArticle() {
        return idPanierArticle;
    }

    public void setIdPanierArticle(LingePanierCPC idPanierArticle) {
        this.idPanierArticle = idPanierArticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
