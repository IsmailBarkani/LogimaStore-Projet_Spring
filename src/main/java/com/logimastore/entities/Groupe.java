package com.logimastore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
@Entity
public class Groupe implements Serializable {

    @Id
    private String titre_groupe;

    @OneToMany(mappedBy = "groupe")
    private Collection<User> users;

    @OneToMany(mappedBy = "promotionArticleGroupe.titreGroupe")
    private Collection<PromotionArticleGroupe> promotionArticleGroupes;

    public Groupe(String titre_groupe) {
        this.titre_groupe = titre_groupe;
    }

    public Groupe() {
    }

    public String getTitre_groupe() {
        return titre_groupe;
    }

    public void setTitre_groupe(String titre_groupe) {
        this.titre_groupe = titre_groupe;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
