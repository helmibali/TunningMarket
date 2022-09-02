package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @Query("select c from Commande c order by c.dateCreation desc")
    public List<Commande> findAllByDateCreation();
}
