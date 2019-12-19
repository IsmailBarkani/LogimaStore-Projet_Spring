package com.logimastore.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class PromotionArticleGroupeCPC implements Serializable {

    @Column(name = "pourcentage")
    private Float pourcentage;
    @Column(name = "DateDebut")
    private Date dateDBDebut;
    @Column(name = "titreGroupe")
    private String titreGroupe;
    @Column(name = "idArticlePromotion")
    private Long idArticlePromotion;

}
