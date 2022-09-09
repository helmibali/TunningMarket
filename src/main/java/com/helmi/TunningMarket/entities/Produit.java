package com.helmi.TunningMarket.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="produit_id")
    private long idProduit;

    @Column(name = "nom_produit")
    private String nomProduit;

    @Column(name="prix_produit")
    private Double prixProduit;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name="filename")
    private String filename;

    @Column(length = 2048)
    private String description;

    @Column(name="carburant")
    private String carburant;

    @Column(name="annee")
    private int annee;

    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "id")
    private  List<Cart> carts;


    @ManyToOne
    @JoinColumn(name = "delegation_id")
    private Delegation delegation;


    @ManyToOne
    @JsonIgnoreProperties(value = {"password","roles"})
    @JoinColumn(name = "username")
    private User user;


    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="produit_modele",
            joinColumns = @JoinColumn(name="produit_id"),
            inverseJoinColumns = @JoinColumn(name="modele_id"))
    private Set<Modele> modeles = new HashSet<>();

    public int getAnnee() {
        return annee;
    }


    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public long getIdProduit() {
        return idProduit;
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



    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }



    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public Produit() {
    }

    public Produit(long idProduit, String nomProduit, Double prixProduit, Date dateCreation, String filename, String description, String carburant, int annee, Boolean enabled, Categorie categorie, List<Cart> cart, Delegation delegation, User user, Set<Modele> modeles) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
        this.filename = filename;
        this.description = description;
        this.carburant = carburant;
        this.annee = annee;
        this.enabled = enabled;
        this.categorie = categorie;
        this.carts = carts;
        this.delegation = delegation;
        this.user = user;
        this.modeles = modeles;
    }

    public Produit(long idProduit, String nomProduit, Double prixProduit, Date dateCreation, String filename, String description, String carburant, Categorie categorie, Delegation delegation, User user, Set<Modele> modeles) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
        this.filename = filename;
        this.description = description;
        this.carburant = carburant;
        this.categorie = categorie;
        this.delegation = delegation;
        this.user = user;
        this.modeles = modeles;
    }

    public Produit(long idProduit, String nomProduit, Double prixProduit, Date dateCreation, String filename, String description, String carburant, int annee, Boolean enabled, Categorie categorie, Delegation delegation, User user, Set<Modele> modeles) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
        this.filename = filename;
        this.description = description;
        this.carburant = carburant;
        this.annee = annee;
        this.enabled = enabled;
        this.categorie = categorie;
        this.delegation = delegation;
        this.user = user;
        this.modeles = modeles;
    }
}
