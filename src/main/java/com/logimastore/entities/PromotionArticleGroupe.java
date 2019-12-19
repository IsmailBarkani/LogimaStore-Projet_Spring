package com.logimastore.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PromotionArticleGroupe implements Serializable {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name ="promotionArticleGroupe.pourcentage", column = @Column(name = "pourcentage")),
            @AttributeOverride(name ="promotionArticleGroupe.idArticlePromotion", column = @Column(name = "idArticlePromotion")),
            @AttributeOverride(name ="promotionArticleGroupe.DateDebut", column = @Column(name = "DateDebut")),
            @AttributeOverride(name ="promotionArticleGroupe.titreGroupe", column = @Column(name = "titreGroupe"))
    })
    private PromotionArticleGroupeCPC promotionArticleGroupe;

    public PromotionArticleGroupe() {
    }

    public PromotionArticleGroupe(PromotionArticleGroupeCPC promotionArticleGroupe) {
        this.promotionArticleGroupe = promotionArticleGroupe;
    }

    public PromotionArticleGroupeCPC getPromotionArticleGroupe() {
        return promotionArticleGroupe;
    }

    public void setPromotionArticleGroupeCPC(PromotionArticleGroupeCPC promotionArticleGroupe) {
        this.promotionArticleGroupe = promotionArticleGroupe;
    }
}
