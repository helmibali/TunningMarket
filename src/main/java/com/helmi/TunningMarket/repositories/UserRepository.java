package com.helmi.TunningMarket.repositories;

import com.helmi.TunningMarket.entities.Delegation;
import com.helmi.TunningMarket.entities.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername (String username);
    User findByRoles(String role);


   // @Query("SELECT u.nom, u.prenom, u.naissance ,u.user_id, u.delegation.libelle FROM User u")
    //List<Object[]> findAllPublic();

 ;
    @Query("SELECT new User(u.user_id, u.username, u.nom, u.prenom, u.telephone, u.naissance, u.delegation)FROM User u")
    List<User> PublicUser();
    @Query("SELECT new User(u.user_id, u.username, u.nom, u.prenom, u.telephone, u.naissance, u.delegation)FROM User u WHERE u.username=:username")
    User findUserByUsernamePublic(@Param("username") String username);
    @Query("SELECT new User(u.user_id, u.username, u.nom, u.prenom, u.telephone, u.naissance,u.delegation)FROM User u WHERE u.user_id=:id")
    User findUserByIdPublic(@Param("id") Long id);
    @Query("SELECT new User( u.username)FROM User u")
    List<User> findUsername();




}
