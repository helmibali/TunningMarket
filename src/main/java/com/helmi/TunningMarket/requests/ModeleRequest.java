package com.helmi.TunningMarket.requests;

public class ModeleRequest {
    public int id;
    public String libelleModele;
    public int marque_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleModele() {
        return libelleModele;
    }

    public void setLibelleModele(String libelleModele) {
        this.libelleModele = libelleModele;
    }

    public int getMarque_id() {
        return marque_id;
    }

    public void setMarque_id(int marque_id) {
        this.marque_id = marque_id;
    }

    public ModeleRequest(int id, String libelleModele, int marque_id) {
        this.id = id;
        this.libelleModele = libelleModele;
        this.marque_id = marque_id;
    }

    public ModeleRequest() {
    }

    public ModeleRequest(String libelleModele, int marque_id) {
        this.libelleModele = libelleModele;
        this.marque_id = marque_id;
    }
}
