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

    @ManyToOne
    @JoinColumn(name = "gouvernorat_id")
    private Gouvernorat gouvernorat;

    @ManyToOne
    @JoinColumn(name = "delegation_id")
    private Delegation delegation;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;


    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="produit_modele",
            joinColumns = @JoinColumn(name="produit_id"),
            inverseJoinColumns = @JoinColumn(name="modele_id"))
    private Set<Modele> modeles = new HashSet<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Gouvernorat getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(Gouvernorat gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }

    public Produit(int idProduit, String nomProduit, Double prixProduit, Date dateCreation, String filename, Categorie categorie, Gouvernorat gouvernorat, Delegation delegation, User user, Set<Modele> modeles) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
        this.filename = filename;
        this.categorie = categorie;
        this.gouvernorat = gouvernorat;
        this.delegation = delegation;
        this.user = user;
        this.modeles = modeles;
    }

    public Produit() {
    }
}
