package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.Categorie;
import com.helmi.TunningMarket.entities.Modele;
import com.helmi.TunningMarket.entities.Produit;
import com.helmi.TunningMarket.repositories.CategorieRepository;
import com.helmi.TunningMarket.repositories.ModeleRepository;
import com.helmi.TunningMarket.repositories.ProduitRepository;
import com.helmi.TunningMarket.requests.ProduitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ModeleRepository modeleRepository;

    public List<Produit> getProduits(){
        return produitRepository.findAll();
    }

    public Produit getProduitById(int id){ return produitRepository.findById(id);};

    public Produit saveProduit(ProduitRequest produitRequest) {
        Categorie categorie = categorieRepository.findById(produitRequest.categorie_id);
        Produit produit = new Produit();
        produit.setNomProduit(produitRequest.nomProduit);
        produit.setPrixProduit(produitRequest.prixProduit);
        produit.setDateCreation(produitRequest.dateCreation);
        produit.setCategorie(categorie);
        produit.setModeles(produitRequest.modeles
                .stream()
                .map(modeles ->{
                    Modele mods = modeles;
                    if(mods.getId()>0){
                        mods = modeleRepository.findById(mods.getId());
                    }
                    mods.getProduits().add(produit);
                    return mods;
         }
         ).collect(Collectors.toSet()));

        return  produitRepository.save(produit) ;
    }


    public void DeleteProduitById( int id ){ this.produitRepository.deleteById(id);  }


    public Produit updateProduit(ProduitRequest produitRequest,int id ){
            Categorie categorie = categorieRepository.findById(produitRequest.categorie_id);
            Produit produit = produitRepository.findById(id);
            produit.setNomProduit(produitRequest.nomProduit);
            produit.setPrixProduit(produitRequest.prixProduit);
            produit.setDateCreation(produitRequest.dateCreation);
            produit.setCategorie(categorie);

            produit.setModeles(produitRequest.modeles
                    .stream()
                    .map(modeles ->{
                                Modele mods = modeles;
                                if(mods.getId()>0){
                                    mods = modeleRepository.findById(mods.getId());
                                }
                                mods.getProduits().add(produit);
                                return mods;
                            }
                    ).collect(Collectors.toSet()));

            // success 200
            return this.produitRepository.save(produit);




    }
}
