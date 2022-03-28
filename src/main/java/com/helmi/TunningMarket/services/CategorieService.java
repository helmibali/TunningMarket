package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.Categorie;
import com.helmi.TunningMarket.repositories.CategorieRepository;
import com.helmi.TunningMarket.requests.CategorieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie getCategorieById(@PathVariable int id){
        return categorieRepository.findById(id); }

    public List<Categorie> getAllCategories(){
        return categorieRepository.findAll();}

    public Categorie addCategorie(@RequestBody CategorieRequest categorieRequest){
        Categorie categorie = new Categorie();
        categorie.setNomCategorie(categorieRequest.nomCategorie);
        categorie.setDescriptionCategorie(categorieRequest.descriptionCategorie);
        return categorieRepository.save(categorie);}
    public Categorie updateCategorie(CategorieRequest categorieRequest,int id){
        Categorie categorie = categorieRepository.findById(id);
        categorie.setNomCategorie(categorieRequest.nomCategorie);
        categorie.setDescriptionCategorie(categorieRequest.descriptionCategorie);
        return categorieRepository.save(categorie);

    }
    public void DeleteCategorie(int id){
         this.categorieRepository.deleteById(id);
    }
}
