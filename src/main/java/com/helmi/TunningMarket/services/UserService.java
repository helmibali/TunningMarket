package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.Produit;
import com.helmi.TunningMarket.entities.Role;
import com.helmi.TunningMarket.entities.User;
import com.helmi.TunningMarket.repositories.RoleRepository;
import com.helmi.TunningMarket.repositories.UserRepository;
import com.helmi.TunningMarket.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    public User userById(Long id){
        return userRepository.findById(id).get();
    }

    public User userByUserName (String username){ return userRepository.findByUsername(username);}

    public List<User> getUsers(){ return userRepository.findAll();};

    public User saveUser(UserRequest userRequest){
        User u = new User();
        u.setUsername(userRequest.getUsername());
        u.setPrenom(userRequest.getPrenom());
        u.setNom(userRequest.getNom());
        u.setNaissance(userRequest.getNaissance());
        u.setPassword(userRequest.getPassword());
        u.setFilename(userRequest.getFilename());
/*
        u.setRoles(userRequest.roles
                .stream()
                .map(roles ->{
                            Role r = roles;
                            if(r.getId()>0){
                                r = roleRepository.findById(r.getId());
                            }
                            r.getUsers().add(u);
                            return r;
                        }
                ).collect(Collectors.toList()));

 */

        return userRepository.save(u);
    }

    public User updatePassword(UserRequest userRequest,Long user_id){
        User u = userRepository.findById(user_id).get();
        u.setPassword(userRequest.getPassword());

        return userRepository.save(u);
    }
    public User updateUser(UserRequest userRequest, long user_id){
        User u = userRepository.findById(user_id).get();
    // u.setUsername(userRequest.getUsername());
        u.setPrenom(userRequest.getPrenom());
        u.setNom(userRequest.getNom());
      // u.setNaissance(userRequest.getNaissance());
      //  u.setPassword(userRequest.getPassword());
       // u.setFilename(userRequest.getFilename());

        u.setRoles(userRequest.roles
                .stream()
                .map(roles ->{
                            Role r = roles;
                            if(r.getId()>0){
                                r = roleRepository.findById(r.getId());
                            }
                            r.getUsers().add(u);
                            return r;
                        }
                ).collect(Collectors.toList()));



        return userRepository.save(u);
    }

    public User updateImageUser(UserRequest userRequest, long user_id){
        User u = userRepository.findById(user_id).get();
        u.setFilename(userRequest.getFilename());
        return userRepository.save(u);
    }

}
