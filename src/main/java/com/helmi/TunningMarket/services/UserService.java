package com.helmi.TunningMarket.services;

import com.helmi.TunningMarket.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    User findByUsername(String username);
    void delete(long id);
    public void deleteAll();

}
