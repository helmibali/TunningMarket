package com.helmi.TunningMarket.controllers;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmi.TunningMarket.entities.Marque;
import com.helmi.TunningMarket.entities.Modele;
import com.helmi.TunningMarket.entities.Produit;
import com.helmi.TunningMarket.entities.User;
import com.helmi.TunningMarket.repositories.ProduitRepository;
import com.helmi.TunningMarket.requests.ProduitRequest;
import com.helmi.TunningMarket.requests.UserRequest;
import com.helmi.TunningMarket.response.ApiResponse;
import com.helmi.TunningMarket.services.ProduitService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

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

    @PostMapping("/produit/addd")
    public Produit saveProduit(@RequestBody ProduitRequest produitRequest){
        return produitService.saveProduit(produitRequest);}

    @GetMapping("/produit_cat/{id}")
public List<Produit>  getProduitByIdCat(@PathVariable int id){
        return produitService.ProduitByCategorie_id(id);
    }



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





    @PostMapping("/produit/add")
    public Produit createProduit (@RequestParam("file") MultipartFile file,
                               @RequestParam("produit") String produit) throws JsonParseException, JsonMappingException, Exception
    {

        ProduitRequest p = new ObjectMapper().readValue(produit, ProduitRequest.class);
        boolean isExit = new File(context.getRealPath("/ImagesProduit/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/ImagesProduit/")).mkdir();

        }

        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/ImagesProduit/"+File.separator+newFileName));
        try
        {
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }
        p.setFilename(newFileName);
        return produitService.saveProduit(p);
    }

    @PutMapping("/produit/{id}")
    public Produit createProduit (@RequestParam("file") MultipartFile file,
                                  @RequestParam("produit") String produit,
                                  @PathVariable int id) throws JsonParseException, JsonMappingException, Exception
    {

        ProduitRequest p = new ObjectMapper().readValue(produit, ProduitRequest.class);
        boolean isExit = new File(context.getRealPath("/ImagesProduit/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/ImagesProduit/")).mkdir();

        }

        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/ImagesProduit/"+File.separator+newFileName));
        try
        {
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }
        p.setFilename(newFileName);
        return produitService.updateProduit(p,id);
    }


    @GetMapping("produit/modele/{id}")
    public List<Produit> findByMod(@PathVariable int id){
      return produitRepository.findAllByLibelleModele(id);
    }

    @GetMapping(path="/imgp/{id}")
    public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
        Produit Produit   = produitRepository.findById(id);
        return Files.readAllBytes(Paths.get(context.getRealPath("/ImagesProduit/")+Produit.getFilename()));
    }
    @GetMapping("produit/modele/{id_mod}/{id_cat}")
    public List<Produit> findByModeleAndCategorie(@PathVariable int id_mod, @PathVariable int id_cat){
        return produitRepository.findAllByModeleAndCategorie(id_mod,id_cat);
    }
    @GetMapping("produit/modele/{id_mod}/{id_cat}/{id_gouvernorat}")
    public List<Produit> findByModeleAndCategorieAndGouvernorat(@PathVariable int id_mod, @PathVariable int id_cat,@PathVariable Long id_gouvernorat){
        return produitRepository.findAllByModeleAndCategorieAndGouvernorat(id_mod,id_cat,id_gouvernorat);
    }
    @GetMapping("produit/modele/{id_mod}/{id_cat}/{id_gouvernorat}/{id_delegation}")
    public List<Produit> findByModeleAndCategorieAndGouvernoratAndDelegation(@PathVariable int id_mod, @PathVariable int id_cat,@PathVariable Long id_gouvernorat,@PathVariable Long id_delegation){
        return produitRepository.findAllByModeleAndCategorieAndGouvernoratAndDelegation(id_mod,id_cat,id_gouvernorat,id_delegation);
    }
    @GetMapping("produit/delegation/{id_mod}/{id_cat}/{id_delegation}")
    public List<Produit> findByModeleAndCategorieAndDelegation(@PathVariable int id_mod, @PathVariable int id_cat,@PathVariable Long id_delegation){
        return produitRepository.findAllByModeleAndCategorieAndDelegation(id_mod,id_cat,id_delegation);
    }
}
