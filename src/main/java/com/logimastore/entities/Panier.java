package com.logimastore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

//@Entity
public class Panier implements Serializable {
    @Id @GeneratedValue
    private Long idPanier;

    @OneToMany(mappedBy = "panier")
    private Collection<Encaissement> encaissements;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private User user2;

    //@OneToMany(mappedBy = "idPanierArticle.idPanier")
    private Collection<LignePanier> lignePaniers;

    public Panier() {
    }

    public Panier(User user2) {
        this.encaissements = encaissements;
        this.user2 = user2;
        this.lignePaniers = lignePaniers;
    }

    public Long getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Long idPanier) {
        this.idPanier = idPanier;
    }

    public Collection<Encaissement> getEncaissements() {
        return encaissements;
    }

    public void setEncaissements(Collection<Encaissement> encaissements) {
        this.encaissements = encaissements;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Collection<LignePanier> getLignePaniers() {
        return lignePaniers;
    }

    public void setLignePaniers(Collection<LignePanier> lignePaniers) {
        this.lignePaniers = lignePaniers;
    }
}
