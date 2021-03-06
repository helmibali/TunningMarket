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
            res.setMessage("Produit supprim?? avec succ??!");
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


    @GetMapping("produit/user/{user_id}")
    public List<Produit> findAllByUser(@PathVariable long user_id){return produitRepository.findAllByUser(user_id);
    }



    @GetMapping("produit/modele/{id_mod}")
    public List<Produit> findByMod(@PathVariable int id_mod){return produitRepository.findAllByLibelleModele(id_mod);
    }

    @GetMapping(path="/imgp/{id}")
    public byte[] getPhoto(@PathVariable("id") int id) throws Exception{
        Produit Produit   = produitRepository.findById(id);
        return Files.readAllBytes(Paths.get(context.getRealPath("/ImagesProduit/")+Produit.getFilename()));
    }
    @GetMapping("produit/modelebycat/{id_mod}/{id_cat}/{id_marque}")
    public List<Produit> findByModeleAndCategorie(@PathVariable int id_mod, @PathVariable int id_cat, @PathVariable int id_marque){
        return produitRepository.findAllByModeleAndCategorieAndMarque(id_mod,id_cat,id_marque);
    }

    @GetMapping("produit/modele/{id_mod}/{id_cat}/{id_gouvernorat}")
    public List<Produit> findByModeleAndCategorieAndGouvernorat(@PathVariable int id_mod, @PathVariable int id_cat,@PathVariable Long id_gouvernorat){
        return produitRepository.findAllByModeleAndCategorieAndGouvernorat(id_mod,id_cat,id_gouvernorat);
    }

    @GetMapping("produit/modeleByGov/{id_marque}/{id_mod}/{id_gouvernorat}")
    public List<Produit> findByModeleAndGouvernorat(@PathVariable int id_marque,@PathVariable int id_mod,@PathVariable Long id_gouvernorat){
        return produitRepository.findAllByModeleGouvernorat(id_marque,id_mod,id_gouvernorat);
    }


    @GetMapping("produit/modele/{id_mod}/{id_cat}/{id_gouvernorat}/{id_delegation}")
    public List<Produit> findByModeleAndCategorieAndGouvernoratAndDelegation(@PathVariable int id_mod, @PathVariable int id_cat,@PathVariable Long id_gouvernorat,@PathVariable Long id_delegation){
        return produitRepository.findAllByModeleAndCategorieAndGouvernoratAndDelegation(id_mod,id_cat,id_gouvernorat,id_delegation);
    }
    @GetMapping("produit/delegation/{id_mod}/{id_cat}/{id_delegation}")
    public List<Produit> findByModeleAndCategorieAndDelegation(@PathVariable int id_mod, @PathVariable int id_cat,@PathVariable Long id_delegation){
        return produitRepository.findAllByModeleAndCategorieAndDelegation(id_mod,id_cat,id_delegation);
    }
    @GetMapping("produit/delegationAndGouvernorat/{id_gouvernorat}/{id_delegation}")
    public List<Produit> findByGouvernoratAndDelegation(@PathVariable Long id_gouvernorat,@PathVariable Long id_delegation){
        return produitRepository.findAllByGouvernoratAndDelegation(id_gouvernorat,id_delegation);
    }

    @GetMapping("produit/gouvernorat/{id_gouvernorat}")
    public List<Produit> findByGouvernorat(@PathVariable Long id_gouvernorat){
        return produitRepository.findAllByGouvernorat(id_gouvernorat);
    }

    @GetMapping("produit/gouvernoratAndCategorie/{id_gouvernorat}/{id_cat}")
    public List<Produit> findByGouvernoratAndCategorie(@PathVariable Long id_gouvernorat,@PathVariable int id_cat){
        return produitRepository.findAllByGouvernoratAndCategorie(id_gouvernorat,id_cat);
    }
    @GetMapping("produit/delegationAndCategorie/{id_delegation}/{id_cat}")
    public List<Produit> findByDelegationAndCategorie(@PathVariable Long id_delegation,@PathVariable int id_cat){
        return produitRepository.findAllByDelegationAndCategorie(id_delegation,id_cat);
    }
    @GetMapping("produit/gouvernoratAndModeles/{id_gouvernorat}/{id_mod}")
    public List<Produit> findByGouvernoratAndModeles(@PathVariable Long id_gouvernorat,@PathVariable int id_mod){
        return produitRepository.findAllByGouvernoratAndModeles(id_gouvernorat,id_mod);
    }
    @GetMapping("produit/delegationAndModeles/{id_delegation}/{id_mod}")
    public List<Produit> findByDelegationAndModeles(@PathVariable Long id_delegation,@PathVariable int id_mod){
        return produitRepository.findAllByDelegationAndModeles(id_delegation,id_mod);
    }

    @GetMapping("produit/marque/{id_marque}")
    public List<Produit> findByProduitAndMarque(@PathVariable int id_marque){
        return produitRepository.findAllByMarque(id_marque);
    }

    @GetMapping("produit/marque/categorie/{id_marque}/{id_cat}")
    public List<Produit> findByProduitAndMarqueAndCategorie(@PathVariable int id_marque,@PathVariable int id_cat){
        return produitRepository.findAllByMarqueAndCategorie(id_marque,id_cat);
    }


    @GetMapping("produit/gouvernoratAndMarque/{id_gouvernorat}/{id_marque}")
    public List<Produit> findByGouvernoratAndMarque(@PathVariable Long id_gouvernorat,@PathVariable int id_marque){
        return produitRepository.findAllByGouvernoratAndMarque(id_gouvernorat,id_marque);
    }

    @GetMapping("produit/gouvernoratAndMarqueAndDelegation/{id_gouvernorat}/{id_marque}/{id_delegation}")
    public List<Produit> findByGouvernoratAndMarqueAndDelegation(@PathVariable Long id_gouvernorat,@PathVariable int id_marque,@PathVariable Long id_delegation){
        return produitRepository.findAllByGouvernoratAndDelegationAndMarque(id_gouvernorat,id_marque,id_delegation);
    }
    @GetMapping("produit/gouvernoratAndMarqueAndDelegationAndCategorie/{id_gouvernorat}/{id_marque}/{id_delegation}/{id_cat}")
    public List<Produit> findByGouvernoratAndMarqueAndCategorie(@PathVariable Long id_gouvernorat,@PathVariable int id_marque,@PathVariable Long id_delegation,@PathVariable int id_cat){
        return produitRepository.findAllByGouvernoratAndDelegationAndMarqueAndCategorie(id_gouvernorat,id_marque,id_delegation,id_cat);
    }

    @GetMapping("produit/gouvernoratAndMarqueAndCategorie/{id_gouvernorat}/{id_marque}/{id_cat}")
    public List<Produit> findByGouvernoratAndMarqueAndCategorie(@PathVariable Long id_gouvernorat,@PathVariable int id_marque,@PathVariable int id_cat){
        return produitRepository.findAllByGouvernoratAndMarqueAndCategorie(id_gouvernorat,id_marque,id_cat);
    }

}
