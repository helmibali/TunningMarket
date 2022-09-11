package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository  extends JpaRepository<Panier, Long> {
}
