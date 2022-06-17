package com.helmi.TunningMarket.controllers;

import com.helmi.TunningMarket.entities.Country;
import com.helmi.TunningMarket.entities.Delegation;
import com.helmi.TunningMarket.requests.CountryRequest;
import com.helmi.TunningMarket.requests.DelegationRequest;
import com.helmi.TunningMarket.services.DelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DelegationController {
    @Autowired
    DelegationService delegationService;

    @GetMapping("delegations")
    public List<Delegation> getDelegations(){
        return delegationService.getDelegations();
    }

    @GetMapping("delegation/{id}")
    public Delegation getDelegationById(@PathVariable Long id) { return delegationService.getDelegationById(id);}
    @GetMapping("delegations/{id}")
    public List <Delegation> getDelegationByGouvernorat_id(@PathVariable Long id) { return delegationService.GetDeleGationByGouvernoratId(id);}

    @PostMapping("delegation")
    public Delegation saveDelegation(@RequestBody DelegationRequest delegationRequest){ return delegationService.saveDelegation(delegationRequest);}
}
