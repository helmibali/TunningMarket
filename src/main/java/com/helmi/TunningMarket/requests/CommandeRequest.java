package com.helmi.TunningMarket.requests;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.helmi.TunningMarket.entities.Cart;
import com.helmi.TunningMarket.entities.Delegation;
import com.helmi.TunningMarket.entities.Produit;
import com.helmi.TunningMarket.entities.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class CommandeRequest {
    private long id;
    private List<Cart> carts;
    private String user;
    private int qty;
    private double prixCommande;
    private Date dateCreation;
    private String livraison;
    private long delegation;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrixCommande() {
        return prixCommande;
    }

    public void setPrixCommande(double prixCommande) {
        this.prixCommande = prixCommande;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLivraison() {
        return livraison;
    }

    public void setLivraison(String livraison) {
        this.livraison = livraison;
    }

    public long getDelegation() {
        return delegation;
    }

    public void setDelegation(long delegation) {
        this.delegation = delegation;
    }


}
