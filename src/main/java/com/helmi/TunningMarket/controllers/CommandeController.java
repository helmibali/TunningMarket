package com.helmi.TunningMarket.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmi.TunningMarket.entities.Cart;
import com.helmi.TunningMarket.entities.Commande;
import com.helmi.TunningMarket.requests.CartRequest;
import com.helmi.TunningMarket.requests.CommandeRequest;
import com.helmi.TunningMarket.response.ApiResponse;
import com.helmi.TunningMarket.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CommandeController{
    @Autowired
    CommandeService commandeService;
    @GetMapping("commande/liste")
    List<Commande> findAll(){return commandeService.findAll();}
    @GetMapping("commande/{id}")
    Commande findById(long id){return commandeService.findCommandeById(id);}

    @DeleteMapping("/commande/{id}")
    public ResponseEntity<?> DeleteCommande(@PathVariable long id){

        try {

            commandeService.deleteCommande(id);

            ApiResponse res = new ApiResponse();
            res.setSuccess(true);
            res.setMessage("Commande supprimé avec succé!");
            return ResponseEntity.ok(res);
        }catch(Exception e) {
            return ResponseEntity.notFound().build().ok("Commande introuvable!");
        }
    }

    @PostMapping("/commande/add")
    public Commande addCommande (
            @RequestParam("commande") String commande) throws JsonParseException, JsonMappingException, Exception
    {
        System.out.println("Save commande...");
        CommandeRequest c = new ObjectMapper().readValue(commande, CommandeRequest.class);
        return commandeService.saveUser(c);
    }

    @PostMapping("/commande")
    public Commande add (
            @RequestParam("commande") String commande) throws JsonParseException, JsonMappingException, Exception
    {
        System.out.println("Save commande...");
        CommandeRequest c = new ObjectMapper().readValue(commande, CommandeRequest.class);
        return commandeService.saveCmd(c);
    }

    @PutMapping("/commande/etat/{id}")
    public Commande validate(@RequestParam("commande") String commande, @PathVariable Long id) throws JsonParseException, JsonMappingException, Exception
    {
        System.out.println("Save commande...");
        CommandeRequest c = new ObjectMapper().readValue(commande, CommandeRequest.class);
        return commandeService.validateCommande(c,id);
    }


}
