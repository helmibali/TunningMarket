package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.Panier;
import com.helmi.TunningMarket.entities.Produit;
import com.helmi.TunningMarket.entities.User;
import com.helmi.TunningMarket.repositories.PanierRepository;
import com.helmi.TunningMarket.repositories.ProduitRepository;
import com.helmi.TunningMarket.repositories.UserRepository;
import com.helmi.TunningMarket.requests.PanierRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanierService {
    @Autowired
    PanierRepository panierRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProduitRepository produitRepository;
    public Panier save(PanierRequest panierRequest){
        User user= userRepository.findByUsername(panierRequest.getUser());
        Produit produit = produitRepository.findById(panierRequest.getProduit()).get();
        Panier p = new Panier();
        p.setProduit(produit);
        p.setUser(user);
        p.setDateCreation(panierRequest.getDateCreation());
        p.setPrix(panierRequest.getPrix());
        return panierRepository.save(p);
    }
}
