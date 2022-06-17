package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Categorie;
import com.helmi.TunningMarket.entities.Modele;
import com.helmi.TunningMarket.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
Produit findById(int id);
List<Produit> findByCategorie_Id(int id);



@Query("select  p from Produit p join p.modeles m where m.id = :id")
List<Produit> findAllByLibelleModele(@Param("id") int id);

    @Query("select  p from Produit p join p.modeles m join p.categorie c where m.id = :id_mod and c.id = :id_cat ")
    List<Produit> findAllByModeleAndCategorie(@Param("id_mod") int id_mod, @Param("id_cat") int id_cat);

    @Query("select  p from Produit p join p.modeles m join p.categorie c join p.gouvernorat g where m.id = :id_mod and c.id = :id_cat and g.id=:id_gouvernorat ")
    List<Produit> findAllByModeleAndCategorieAndGouvernorat(@Param("id_mod") int id_mod, @Param("id_cat") int id_cat,@Param("id_gouvernorat") Long id_gouvernorat);

    @Query("select  p from Produit p join p.modeles m join p.categorie c join p.gouvernorat g join p.delegation d where m.id = :id_mod and c.id = :id_cat and g.id=:id_gouvernorat and d.id=:id_delegation")
    List<Produit> findAllByModeleAndCategorieAndGouvernoratAndDelegation(@Param("id_mod") int id_mod, @Param("id_cat") int id_cat,@Param("id_gouvernorat") Long id_gouvernorat,@Param("id_delegation") Long id_delegation);

    @Query("select  p from Produit p join p.modeles m join p.categorie c join  p.delegation d where m.id = :id_mod and c.id = :id_cat and d.id=:id_delegation")
    List<Produit> findAllByModeleAndCategorieAndDelegation(@Param("id_mod") int id_mod, @Param("id_cat") int id_cat,@Param("id_delegation") Long id_delegation);
}
