package com.helmi.TunningMarket.requests;

import com.helmi.TunningMarket.entities.Role;

import java.util.Date;
import java.util.List;

public class UserRequest {
    public String nom;
    public String prenom;
    public String username;
    public Date naissance;
    public String password;
    public List<Role> roles;

}
