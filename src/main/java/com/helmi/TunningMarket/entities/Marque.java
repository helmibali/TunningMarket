package com.helmi.TunningMarket.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "marques")
public class Marque {
    @Id
    @Column(name="marque_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "libelle_marque")
    private String libelleMarque;


    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "marque_id")
    private Set<Modele> modeles;

    public Marque() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleMarque() {
        return libelleMarque;
    }

    public void setLibelleMarque(String libelleMarque) {
        this.libelleMarque = libelleMarque;
    }
}
