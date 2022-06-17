package com.helmi.TunningMarket.requests;

import com.helmi.TunningMarket.entities.Modele;

import java.util.Date;
import java.util.Set;

public class ProduitRequest {
    public int id;
    public String nomProduit;
    public  Double prixProduit;
    public Date dateCreation;
    public int categorie_id;
    public String filename;
    public Set<Modele> modeles;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Set<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(Set<Modele> modeles) {
        this.modeles = modeles;
    }
}
