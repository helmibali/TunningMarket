package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.Delegation;
import com.helmi.TunningMarket.entities.Produit;
import com.helmi.TunningMarket.entities.Role;
import com.helmi.TunningMarket.entities.User;
import com.helmi.TunningMarket.repositories.DelegationRepository;
import com.helmi.TunningMarket.repositories.RoleRepository;
import com.helmi.TunningMarket.repositories.UserRepository;
import com.helmi.TunningMarket.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DelegationRepository delegationRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


   // public List<Object[]> UsersPublic(){
     //   return userRepository.findAllPublic();
   // }
    public User saveUser2(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User addRoleToUser(String username, String rolename) {
        User usr = userRepository.findByUsername(username);
        Role r = roleRepository.findByRole(rolename);
        usr.getRoles().add(r);
        return usr;
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

public User userByUsernamePublic(String username){return userRepository.findUserByUsernamePublic(username);}

    public User userById(Long id){
        return userRepository.findUserByIdPublic(id);
    }

    public User userByUserName (String username){ return userRepository.findByUsername(username);}

    public List<User> getUsers(){ return userRepository.findAll();};

    public User saveUser(UserRequest userRequest){
        Delegation delegation = delegationRepository.findById(userRequest.getDelegation_id()).get();
        User u = new User();
        u.setUsername(userRequest.getUsername());
        u.setPrenom(userRequest.getPrenom());
        u.setNom(userRequest.getNom());
        //u.setNaissance(userRequest.getNaissance());
        u.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
       /* u.setFilename(userRequest.getFilename());

        */
        u.setTelephone(userRequest.getTelephone());

        u.setDelegation(delegation);



        u.setRoles(userRequest.roles
                .stream()
                .map(roles ->{
                            Role r = roles;
                            if(r.getId()>0){
                                r = roleRepository.findById(r.getId()).get();
                            }
                            r.getUsers().add(u);
                            return r;
                        }
                ).collect(Collectors.toList()));



        return userRepository.save(u);
    }

    public User saveUserWithImg(UserRequest userRequest){
        Delegation delegation = delegationRepository.findById(userRequest.getDelegation_id()).get();
        User u = new User();
        u.setUsername(userRequest.getUsername());
        u.setPrenom(userRequest.getPrenom());
        u.setNom(userRequest.getNom());
       // u.setNaissance(userRequest.getNaissance());
        u.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
         u.setFilename(userRequest.getFilename());
        u.setTelephone(userRequest.getTelephone());

        u.setDelegation(delegation);



        u.setRoles(userRequest.roles
                .stream()
                .map(roles ->{
                            Role r = roles;
                            if(r.getId()>0){
                                r = roleRepository.findById(r.getId()).get();
                            }
                            r.getUsers().add(u);
                            return r;
                        }
                ).collect(Collectors.toList()));



        return userRepository.save(u);
    }

    public User updatePassword(UserRequest userRequest,Long user_id){
        User u = userRepository.findById(user_id).get();
        u.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));

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
                                r = roleRepository.findById(r.getId()).get();
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

    public void DeleteUserById( long id ){ this.userRepository.deleteById(id);  }


}
