package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findById(int id);
}
