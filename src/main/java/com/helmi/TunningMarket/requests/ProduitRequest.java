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
    public Set<Modele> modeles;
}
