package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.Gouvernorat;
import com.helmi.TunningMarket.repositories.GouvernoratRepository;
import com.helmi.TunningMarket.requests.GouvernoratRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GouvernoratService {

    @Autowired
    GouvernoratRepository gouvernoratRepository;

    public List<Gouvernorat> getGouvernorat(){
        return gouvernoratRepository.findAll();
    }
    public Gouvernorat getGouvernoratById(Long id){ return gouvernoratRepository.findById(id).get();}

    public Gouvernorat saveGouvernorat(GouvernoratRequest gouvernoratRequest) {
        Gouvernorat gouvernorat = new Gouvernorat();
        gouvernorat.setLibelle(gouvernoratRequest.getLibelle());
        return  gouvernoratRepository.save(gouvernorat);
    }
}
