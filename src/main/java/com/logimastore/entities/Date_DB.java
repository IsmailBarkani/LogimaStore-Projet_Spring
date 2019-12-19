package com.logimastore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Date_DB implements Serializable {

    @Id
    private Date date_debut;
    private int duree;

    @OneToMany(mappedBy = "promotionArticleGroupe.dateDBDebut")
    private Collection<PromotionArticleGroupe> promotionArticleGroupeCollection;
}
