package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername (String username);
}
