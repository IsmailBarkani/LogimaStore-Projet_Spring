package com.logimastore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class ModePaiment implements Serializable {
    @Id @GeneratedValue
    private Long idModePaiment;
    private String libModePaiment;

    @OneToMany(mappedBy = "modePaiment")
    private Collection<Encaissement> encaissements;

    public ModePaiment(String libModePaiment, Collection<Encaissement> encaissements) {
        this.libModePaiment = libModePaiment;
        this.encaissements = encaissements;
    }

    public ModePaiment() {
    }

    public Long getIdModePaiment() {
        return idModePaiment;
    }

    public void setIdModePaiment(Long idModePaiment) {
        this.idModePaiment = idModePaiment;
    }

    public String getLibModePaiment() {
        return libModePaiment;
    }

    public void setLibModePaiment(String libModePaiment) {
        this.libModePaiment = libModePaiment;
    }

    public Collection<Encaissement> getEncaissements() {
        return encaissements;
    }

    public void setEncaissements(Collection<Encaissement> encaissements) {
        this.encaissements = encaissements;
    }
}
