package com.logimastore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Promotion implements Serializable {

    @Id
    private Float pourcentage;

    @OneToMany(mappedBy = "promotionArticleGroupe.pourcentage")
    private Collection<PromotionArticleGroupe> promotionArticleGroupes;
}
