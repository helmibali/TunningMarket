package com.helmi.TunningMarket.controllers;

import com.helmi.TunningMarket.entities.User;
import com.helmi.TunningMarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    UserRepository userRep;
    @RequestMapping(value ="/login/{username}",method = RequestMethod.GET)
    public User getUserByUsernamePassword(@PathVariable("username") String
                                                  username) {
        return userRep.findByUsername(username);
    }
}
