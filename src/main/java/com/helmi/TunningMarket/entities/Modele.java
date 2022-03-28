package com.helmi.TunningMarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="modeles")
public class Modele {
    @Id
    @Column(name="modele_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "libelle_modelle")
    private String libelleModele;

    @ManyToOne
    @JoinColumn(name = "marque_id" )
    private Marque marque;

    @ManyToMany(mappedBy="modeles")
    @JsonIgnore
    private Set<Produit> produits = new HashSet<>();

    public Modele() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleModele() {
        return libelleModele;
    }

    public void setLibelleModele(String libelleModele) {
        this.libelleModele = libelleModele;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }
    public void addProduit( Produit produit){
        this.produits.add(produit);
    }
}
