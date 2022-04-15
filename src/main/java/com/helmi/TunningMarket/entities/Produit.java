package com.helmi.TunningMarket.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="produit_id")
    private int idProduit;

    @Column(name = "nom_produit")
    private String nomProduit;

    @Column(name="prix_produit")
    private Double prixProduit;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name="filename")
    private String filename;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;


    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="produit_modele",
            joinColumns = @JoinColumn(name="produit_id"),
            inverseJoinColumns = @JoinColumn(name="modele_id"))
    private Set<Modele> modeles = new HashSet<>();

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(Double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Set<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(Set<Modele> modeles) {
        this.modeles = modeles;
    }

    public String getFilename() {return filename;}

    public void setFilename(String filename) {this.filename = filename;}

}
