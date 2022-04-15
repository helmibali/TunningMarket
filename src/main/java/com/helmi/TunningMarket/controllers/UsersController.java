package com.helmi.TunningMarket.controllers;

import com.helmi.TunningMarket.entities.Modele;
import com.helmi.TunningMarket.entities.Role;
import com.helmi.TunningMarket.entities.User;
import com.helmi.TunningMarket.repositories.RoleRepository;
import com.helmi.TunningMarket.repositories.UserRepository;
import com.helmi.TunningMarket.requests.ModeleRequest;
import com.helmi.TunningMarket.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    UserRepository userRep;
    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value ="/login/{username}",method = RequestMethod.GET)
    public User getUserByUsernamePassword(@PathVariable("username") String username) {
        return userRep.findByUsername(username);
    }
    @GetMapping("/users/liste")
    public List<User> getAllUsers(){
        return userRep.findAll();

    }
    @PostMapping("/user/add")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest){
       User u = new User();
       u.setPassword(userRequest.password);
       u.setNaissance(userRequest.naissance);
       u.setNom(userRequest.nom);
       u.setPrenom(userRequest.prenom);
       u.setUsername(userRequest.username);
    return  ResponseEntity.ok(this.userRep.save(u));
    }
}
