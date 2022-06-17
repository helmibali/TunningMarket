package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Delegation;
import com.helmi.TunningMarket.entities.Modele;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DelegationRepository extends JpaRepository<Delegation, Long> {
    List<Delegation> findByGouvernorat_Id(Long id);
}
