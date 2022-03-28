package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
Produit findById(int id);
}
