package com.helmi.TunningMarket.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmi.TunningMarket.entities.Panier;
import com.helmi.TunningMarket.entities.User;
import com.helmi.TunningMarket.requests.PanierRequest;
import com.helmi.TunningMarket.requests.UserRequest;
import com.helmi.TunningMarket.services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PanierController {

    @Autowired
    PanierService panierService;
    @PostMapping("/panier")
    public Panier createArticle (
            @RequestParam("panier") String panier) throws JsonParseException, JsonMappingException, Exception
    {
        System.out.println("Save panier...");
        PanierRequest p = new ObjectMapper().readValue(panier, PanierRequest.class);

        return panierService.save(p);
    }
}
