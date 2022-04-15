package com.helmi.TunningMarket.controllers;


import com.helmi.TunningMarket.entities.Produit;
import com.helmi.TunningMarket.repositories.ProduitRepository;
import com.helmi.TunningMarket.requests.ProduitRequest;
import com.helmi.TunningMarket.response.ApiResponse;
import com.helmi.TunningMarket.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletContext;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProduitController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private ServletContext context;
    @Autowired
    ProduitRepository produitRepository;

    @GetMapping("/produits")
    public List<Produit> getProduits(){ return produitService.getProduits();}

    @GetMapping("/produit/{id}")
    public Produit getProduitById(@PathVariable int id){
        return produitService.getProduitById(id);}

    @PostMapping("/produit/add")
    public Produit saveProduit(@RequestBody ProduitRequest produitRequest){
        return produitService.saveProduit(produitRequest);}

    @DeleteMapping("/produit/delete/{id}")
    public ResponseEntity<?> DeleteProduit(@PathVariable int id){

        try {

            produitService.DeleteProduitById(id);

            ApiResponse res = new ApiResponse();
            res.setSuccess(true);
            res.setMessage("Produit supprimé avec succé!");
            return ResponseEntity.ok(res);
        }catch(Exception e) {
            return ResponseEntity.notFound().build().ok("Produit introuvable!");
        }
    }

    @PutMapping("/produit/update/{id}")
    public Produit updateProduit(@RequestBody ProduitRequest produitRequest, @PathVariable int id) {
        return produitService.updateProduit(produitRequest,id);}

}
