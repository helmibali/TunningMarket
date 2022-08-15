package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
