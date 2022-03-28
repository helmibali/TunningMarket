package com.helmi.TunningMarket.repositories;
import com.helmi.TunningMarket.entities.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleRepository extends JpaRepository<Modele,Integer> {
    Modele findByLibelleModele(String libelleModele);
    Modele findById(int id);
}
