package com.helmi.TunningMarket.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "add_to_cart")
public class AddtoCart {
    @Id
    private long id;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "produit_id")
    private  Produit produit;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private  User user;
    private int qty;
    private double prix;
    private Date dateCreation;



}
