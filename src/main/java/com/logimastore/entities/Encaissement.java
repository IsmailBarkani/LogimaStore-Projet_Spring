package com.logimastore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Encaissement implements Serializable {
    @Id @GeneratedValue
    private Long idEncaissement;
    private double montant;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_modePaiment")
    private ModePaiment modePaiment;

   // @ManyToOne
    //@JoinColumn(name = "panier")
   private Panier panier;

    public Encaissement(double montant, Date date, ModePaiment modePaiment, Panier panier) {
        this.montant = montant;
        this.date = date;
        this.modePaiment = modePaiment;
       // this.panier = panier;
    }

    public Encaissement() {
    }

    public Long getIdEncaissement() {
        return idEncaissement;
    }

    public void setIdEncaissement(Long idEncaissement) {
        this.idEncaissement = idEncaissement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ModePaiment getModePaiment() {
        return modePaiment;
    }

    public void setModePaiment(ModePaiment modePaiment) {
        this.modePaiment = modePaiment;
    }


}
