package com.helmi.TunningMarket.repositories;


import com.helmi.TunningMarket.entities.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends JpaRepository<Marque,Integer> {
    Marque findById(int id);
}
