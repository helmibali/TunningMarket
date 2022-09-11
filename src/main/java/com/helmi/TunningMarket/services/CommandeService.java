package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.*;
import com.helmi.TunningMarket.repositories.*;
import com.helmi.TunningMarket.requests.CartRequest;
import com.helmi.TunningMarket.requests.CommandeRequest;
import com.helmi.TunningMarket.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    PanierRepository panierRepository;
    @Autowired
    UserService userService;
    @Autowired
    DelegationRepository delegationRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    public List<Commande> findAll(){return commandeRepository.findAllByDateCreation();}
    public Commande findCommandeById(long id){return commandeRepository.getById(id);}
    public void deleteCommande(long id){ commandeRepository.deleteById(id);}
    public Commande saveCommande(CommandeRequest commandeRequest){
        User user = userService.userByUserName(commandeRequest.getUser());
        Delegation delegation = delegationRepository.findById(commandeRequest.getDelegation()).get();
        Commande commande=new Commande();
        commande.setPrixCommande(commandeRequest.getPrixCommande());
        /*
        commande.setUser(user);
        commande.setDateCreation(commandeRequest.getDateCreation());
        commande.setDelegation(delegation);
        commande.setLivraison(commandeRequest.getLivraison());
        commande.setQty(commandeRequest.getQty());

        commande.setAdresse(commandeRequest.getAdresse());

        commande.setCarts(commandeRequest.getCarts()
                .stream()
                .map(carts ->{
                            Cart c = carts;
                            if(c.getId()>0){
                                c = cartRepository.findById(c.getId()).get();
                            }
                            c.getCommandes().add(commande);
                            return c;
                        }
                ).collect(Collectors.toList()));




         */


        return  commandeRepository.save(commande) ;

    }
    public Commande saveUser(CommandeRequest commandeRequest){

        Commande c = new Commande();

        User user = userRepository.findByUsername(commandeRequest.getUser());
        Delegation delegation = delegationRepository.findById(commandeRequest.getDelegation()).get();


        c.setPrixCommande(commandeRequest.getPrixCommande());

        c.setUser(user);
        c.setDateCreation(commandeRequest.getDateCreation());
        c.setDelegation(delegation);
        c.setLivraison(commandeRequest.getLivraison());
        c.setQty(commandeRequest.getQty());


/*
        c.setCarts(commandeRequest.getCarts()
                .stream()
                .map(carts ->{
                            Cart car = carts;
                            if(car.getId()>0){
                                car = cartRepository.findById(car.getId()).get();
                            }
                            car.getCommandes().add(c);
                            return car;
                        }
                ).collect(Collectors.toList()));

 */
        return commandeRepository.save(c);

    }


    public Commande saveCart(CommandeRequest commandeRequest) {
        User user = userRepository.findByUsername(commandeRequest.getUser());
        Delegation delegation = delegationRepository.findById(commandeRequest.getDelegation()).get();
        Commande c = new Commande();
        c.setPrixCommande(commandeRequest.getPrixCommande());
        c.setUser(user);
        c.setDateCreation(commandeRequest.getDateCreation());
        c.setDelegation(delegation);
        c.setLivraison(commandeRequest.getLivraison());
        c.setQty(commandeRequest.getQty());

        c.setAddress(commandeRequest.getAddress());
        c.setCarts(commandeRequest.getCarts()
                .stream()
                .map(carts ->{
                            Cart car = carts;
                            if(car.getId()>0){
                                car = cartRepository.findById(car.getId()).get();
                            }
                            car.getCommandes().add(c);
                            return car;
                        }
                ).collect(Collectors.toList()));
        return  commandeRepository.save(c) ;
    }


    public Commande saveCmd(CommandeRequest commandeRequest) {
        User user = userRepository.findByUsername(commandeRequest.getUser());
        Delegation delegation = delegationRepository.findById(commandeRequest.getDelegation()).get();
        Commande c = new Commande();
        c.setPrixCommande(commandeRequest.getPrixCommande());
        c.setUser(user);
        c.setDateCreation(commandeRequest.getDateCreation());
        c.setDelegation(delegation);
        c.setLivraison(commandeRequest.getLivraison());
        c.setQty(commandeRequest.getQty());

        c.setAddress(commandeRequest.getAddress());
        c.setPaniers(commandeRequest.getPaniers()
                .stream()
                .map(paniers ->{
                            Panier p = paniers;
                            if(p.getId()>0){
                                p = panierRepository.findById(p.getId()).get();
                            }
                            p.getCommandes().add(c);
                            return p;
                        }
                ).collect(Collectors.toList()));
        return  commandeRepository.save(c) ;
    }

    public Commande validateCommande(CommandeRequest commandeRequest,Long id){
        Commande c = commandeRepository.getById(id);
        c.setValidation(commandeRequest.isValidation());
        c.setAnnulation(commandeRequest.isAnnulation());
        return commandeRepository.save(c);

    }


}
