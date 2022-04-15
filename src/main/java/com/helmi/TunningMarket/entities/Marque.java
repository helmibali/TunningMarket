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

    @Column(name="filename")
    private String filename;


    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "marque_id")
    private Set<Modele> modeles;





    public Set<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(Set<Modele> modeles) {
        this.modeles = modeles;
    }

    public Marque() {}

    public Marque(int id, String libelleMarque, String filename, Set<Modele> modeles) {
        this.id = id;
        this.libelleMarque = libelleMarque;
        this.filename = filename;
        this.modeles = modeles;
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", libelleMarque='" + libelleMarque + '\'' +
                ", filename='" + filename + '\'' +
                ", modeles=" + modeles +
                '}';
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

    public String getFilename() {return filename;}

    public void setFilename(String filename) {this.filename = filename;}
}
