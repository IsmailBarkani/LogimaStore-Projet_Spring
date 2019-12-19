package com.logimastore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Ville implements Serializable {
    @Id @GeneratedValue
    private Long idVille;
    @NotNull
    private String nomVille;
    @NotNull
    private int codePostale;
    @NotNull
    private String provaince;
    @NotNull
    private String region;

    @OneToMany(mappedBy = "ville")
    private Collection<User> user;

    public Ville( String nomVille, int codePostale, String provaince, String region) {
        this.nomVille = nomVille;
        this.codePostale = codePostale;
        this.provaince = provaince;
        this.region = region;
    }

    public Ville() {
    }

    public Long getIdVille() {
        return idVille;
    }

    public void setIdVille(Long idVille) {
        this.idVille = idVille;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getProvaince() {
        return provaince;
    }

    public void setProvaince(String provaince) {
        this.provaince = provaince;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }
}
