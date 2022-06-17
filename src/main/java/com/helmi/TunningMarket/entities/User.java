package com.helmi.TunningMarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Gouvernorat delegation;

    @ManyToOne
    @JoinColumn(name = "gouvernorat_id")
    private Gouvernorat gouvernorat;



    public User() {
    }

    public User(Long user_id, String username, String password, Boolean enabled, String nom, String prenom, Date naissance, String filename, List<Role> roles, List<Comment> comments, List<Article> articles, List<Produit> produits, Gouvernorat delegation, Gouvernorat gouvernorat) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.filename = filename;
        this.roles = roles;
        this.comments = comments;
        this.articles = articles;
        this.produits = produits;
        this.delegation = delegation;
        this.gouvernorat = gouvernorat;
    }

    public String getFilename() {return filename;}

    public void setFilename(String filename) {this.filename = filename;}

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }
    public List<Comment> getComments() {
        return comments;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Gouvernorat getDelegation() {
        return delegation;
    }

    public void setDelegation(Gouvernorat delegation) {
        this.delegation = delegation;
    }

    public Gouvernorat getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(Gouvernorat gouvernorat) {
        this.gouvernorat = gouvernorat;
    }
}
