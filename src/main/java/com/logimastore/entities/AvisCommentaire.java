package com.logimastore.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class AvisCommentaire implements Serializable {
    @Id @GeneratedValue
    private Long idCommentaire;
    private int star;

    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;


    public AvisCommentaire(int star, Article article) {
        this.star = star;
        this.article = article;
    }

    public AvisCommentaire() {
    }

    public Long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Long idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
