package com.logimastore.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
public class User implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String nom;
    @NotNull
    private String Prenom;
    @NotNull
    private String adresse;
    @NotNull
    private String telephone;
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_ville")
    private Ville ville;

    @OneToMany(mappedBy = "idPanierArticle.idUser")
    private Collection<LignePanier> lignePaniers;

    @ManyToOne
    @JoinColumn(name = "groupe")
    private Groupe groupe;

   // @OneToMany(mappedBy = "user2")

    @OneToMany(mappedBy = "idUserArticle.idUser")
    private Collection<Favouriser> favourisers;

    @OneToMany(mappedBy = "user")
    private Collection<Compte> comptes;
    public User(String nom, String prenom, Date date_naissance, String adresse, String telephone, Ville ville, Groupe groupe) {
        this.nom = nom;
        Prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.ville = ville;
        this.groupe = groupe;
    }

    public User() {
    }


    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

}
