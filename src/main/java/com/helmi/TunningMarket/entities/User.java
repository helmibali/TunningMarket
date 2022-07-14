package com.helmi.TunningMarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long  user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "naissace")
    private Date naissance;

    @Column(name="filename")
    private String filename;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "username")
    private List<Comment> comments;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "username")
    private List<Article> articles;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "username")
    private List<Produit> produits;

    @ManyToOne
    @JoinColumn(name = "delegation_id")
    private Delegation delegation;


}
