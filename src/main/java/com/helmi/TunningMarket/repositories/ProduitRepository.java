package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
Produit findById(int id);
List<Produit> findByCategorie_Id(int id);



@Query("select  p from Produit p join p.modeles m where m.id = :id_mod")
    List<Produit> findAllByLibelleModele(@Param("id_mod") int id_mod);

    @Query("select  p from Produit p join p.user u where u.user_id = :user_id")
    List<Produit> findAllByUser(@Param("user_id") long user_id);

    @Query("select  p from Produit p join p.modeles m join p.categorie c where m.id = :id_mod and c.id = :id_cat  and m.marque.id=:id_marque")
    List<Produit> findAllByModeleAndCategorieAndMarque(@Param("id_mod") int id_mod, @Param("id_cat") int id_cat,@Param("id_marque") int id_marque);

    @Query("select  p from Produit p join p.modeles m join p.delegation.gouvernorat g where m.marque.id=:id_marque and m.id = :id_mod and g.id=:id_gouvernorat ")
    List<Produit> findAllByModeleGouvernorat(@Param("id_marque") int id_marque, @Param("id_mod") int id_mod,@Param("id_gouvernorat") Long id_gouvernorat);

    @Query("select  p from Produit p join p.modeles m join p.categorie c join p.delegation.gouvernorat g where m.id = :id_mod and c.id = :id_cat and g.id=:id_gouvernorat ")
    List<Produit> findAllByModeleAndCategorieAndGouvernorat(@Param("id_mod") int id_mod, @Param("id_cat") int id_cat,@Param("id_gouvernorat") Long id_gouvernorat);

    @Query("select  p from Produit p join p.modeles m join p.categorie c join p.delegation.gouvernorat g join p.delegation d where m.id = :id_mod and c.id = :id_cat and g.id=:id_gouvernorat and d.id=:id_delegation")
    List<Produit> findAllByModeleAndCategorieAndGouvernoratAndDelegation(@Param("id_mod") int id_mod, @Param("id_cat") int id_cat,@Param("id_gouvernorat") Long id_gouvernorat,@Param("id_delegation") Long id_delegation);

    @Query("select  p from Produit p join p.modeles m join p.categorie c join  p.delegation d where m.id = :id_mod and c.id = :id_cat and d.id=:id_delegation")
    List<Produit> findAllByModeleAndCategorieAndDelegation(@Param("id_mod") int id_mod, @Param("id_cat") int id_cat,@Param("id_delegation") Long id_delegation);

    @Query("select  p from Produit p join p.delegation.gouvernorat g join p.delegation d where  g.id=:id_gouvernorat and d.id=:id_delegation")
    List<Produit> findAllByGouvernoratAndDelegation(@Param("id_gouvernorat") Long id_gouvernorat,@Param("id_delegation") Long id_delegation);

    @Query("select  p from Produit p join p.delegation.gouvernorat g where  g.id=:id_gouvernorat")
    List<Produit> findAllByGouvernorat(@Param("id_gouvernorat") Long id_gouvernorat);

    @Query("select  p from Produit p join p.delegation.gouvernorat g join p.categorie c where  g.id=:id_gouvernorat and c.id=:id_cat")
    List<Produit> findAllByGouvernoratAndCategorie(@Param("id_gouvernorat") Long id_gouvernorat, @Param("id_cat") int id_cat);

    @Query("select  p from Produit p join p.delegation d join p.categorie c where  d.id=:id_delegation and c.id=:id_cat")
    List<Produit> findAllByDelegationAndCategorie(@Param("id_delegation") Long id_delegation, @Param("id_cat") int id_cat);

    @Query("select  p from Produit p join p.delegation d join p.modeles m where  d.id=:id_delegation and m.id=:id_mod")
    List<Produit> findAllByDelegationAndModeles(@Param("id_delegation") Long id_delegation, @Param("id_mod") int id_cat);

    @Query("select  p from Produit p join p.delegation.gouvernorat g join p.modeles m where  g.id=:id_gouvernorat and m.id=:id_mod")
    List<Produit> findAllByGouvernoratAndModeles(@Param("id_gouvernorat") Long id_gouvernorat, @Param("id_mod") int id_cat);

    @Query("select  p from Produit p join p.modeles m where  m.marque.id=:id_marque")
    List<Produit> findAllByMarque(@Param("id_marque") int id_marque);

    @Query("select  p from Produit p join p.modeles m join p.categorie c where  m.marque.id=:id_marque and c.id=:id_cat")
    List<Produit> findAllByMarqueAndCategorie(@Param("id_marque") int id_marque,@Param("id_cat") int id_cat);

    @Query("select  p from Produit p join p.delegation.gouvernorat g join p.modeles m where  g.id=:id_gouvernorat and m.marque.id=:id_marque")
    List<Produit> findAllByGouvernoratAndMarque(@Param("id_gouvernorat") Long id_gouvernorat,@Param("id_marque") int id_marque);

    @Query("select  p from Produit p join p.delegation d join p.delegation.gouvernorat g join p.modeles m where  g.id=:id_gouvernorat and m.marque.id=:id_marque and d.id =:id_delegation")
    List<Produit> findAllByGouvernoratAndDelegationAndMarque(@Param("id_gouvernorat") Long id_gouvernorat,@Param("id_marque") int id_marque, @Param("id_delegation") Long id_delegation);

    @Query("select  p from Produit p join p.delegation d join p.delegation.gouvernorat g join p.modeles m join p.categorie c where  g.id=:id_gouvernorat and m.marque.id=:id_marque and d.id =:id_delegation and c.id =:id_cat ")
    List<Produit> findAllByGouvernoratAndDelegationAndMarqueAndCategorie(@Param("id_gouvernorat") Long id_gouvernorat, @Param("id_marque") int id_marque, @Param("id_delegation") Long id_delegation, @Param("id_cat") int id_cat);

    @Query("select  p from Produit p join p.delegation.gouvernorat g join p.modeles m join p.categorie c where  g.id=:id_gouvernorat and m.marque.id=:id_marque and c.id =:id_cat ")
    List<Produit> findAllByGouvernoratAndMarqueAndCategorie(@Param("id_gouvernorat") Long id_gouvernorat, @Param("id_marque") int id_marque, @Param("id_cat") int id_cat);


}
