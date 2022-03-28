package com.helmi.TunningMarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categorie_id")
    private int id;

    @Column(name="nom_categorie")
    private String nomCategorie;

    @Column(name="description_categorie")
    private String descriptionCategorie;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "categorie_id")
    private List<Produit> produits;

    public Categorie(int id) {
        this.id = id;
    }

    public Categorie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDescriptionCategorie() {
        return descriptionCategorie;
    }

    public void setDescriptionCategorie(String descriptionCategorie) {
        this.descriptionCategorie = descriptionCategorie;
    }
}
