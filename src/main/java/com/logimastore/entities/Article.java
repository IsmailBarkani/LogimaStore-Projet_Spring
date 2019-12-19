package com.logimastore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@Entity
public class Article implements Serializable {
    @Id @GeneratedValue
    private Long idArticle;
    private String libArticle;
    private double prix;
    private int quantiteStock;
    private String marque;
    private Date dateAjoute;
    private String etat;
    private String description;
    private String image1_front;
    private String image1;
    private String image2;
    private String image3;
    private String image4;

    @OneToMany(mappedBy = "article")
    private Collection<AvisCommentaire> avisCommentaire;


    @OneToMany(mappedBy = "idPanierArticle.idArticle")
    private Collection<LignePanier> lignePaniers;

    @OneToMany(mappedBy = "idUserArticle.idArticle")
    private Collection<Favouriser> favourisers;

    @OneToMany(mappedBy = "promotionArticleGroupe.idArticlePromotion")
    private Collection<PromotionArticleGroupe> promotionArticleGroupes;

    @OneToMany(mappedBy = "categorieArticle.idArticlec")
    private Collection<CategorieArticle> categorieArticles;



    public Article(String libArticle, double prix, int quantiteStock, String marque, String description,String image1_front ,String image1, String image2, String image3, String image4,String etat) {
        this.libArticle = libArticle;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.marque = marque;
        this.description = description;
        this.image1_front = image1_front;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.etat = etat;
        this.dateAjoute = Calendar.getInstance().getTime();
    }

    public String getImage1_front() {
        return image1_front;
    }

    public void setImage1_front(String image1_front) {
        this.image1_front = image1_front;
    }

    public Article() {
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getLibArticle() {
        return libArticle;
    }

    public void setLibArticle(String libArticle) {
        this.libArticle = libArticle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public Collection<AvisCommentaire> getAvisCommentaire() {
        return avisCommentaire;
    }

    public void setAvisCommentaire(Collection<AvisCommentaire> avisCommentaire) {
        this.avisCommentaire = avisCommentaire;
    }

    public Date getDateAjoute() {
        return dateAjoute;
    }

    public void setDateAjoute(Date dateAjoute) {
        this.dateAjoute = dateAjoute;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    public Collection<LignePanier> getLignePaniers() {
        return lignePaniers;
    }

    public void setLignePaniers(Collection<LignePanier> lignePaniers) {
        this.lignePaniers = lignePaniers;
    }
}
