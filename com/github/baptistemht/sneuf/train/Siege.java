package com.github.baptistemht.sneuf.train;

import com.github.baptistemht.sneuf.client.Client;

public class Siege {

    private final int numero;
    private final boolean fenetre;
    private final boolean etage;
    private final TypeSiege typeSiege;
    private Client personne;


    public Siege(int numero, TypeSiege typeSiege, boolean fenetre, boolean etage) {
        this.numero     = numero;
        this.fenetre    = fenetre;
        this.etage      = etage;
        this.personne   = null;
        this.typeSiege  = typeSiege;
    }


    public int getNumero() {
        return numero;
    }

    public boolean isFenetre() {
        return fenetre;
    }

    public boolean isEtage() {
        return etage;
    }

    public Client getPersonne() {
        return personne;
    }

    public void setPersonne(Client personne) {
        this.personne = personne;
    }

    public boolean isFree(){
        return this.personne == null;
    }

    public TypeSiege getTypeSiege() {
        return typeSiege;
    }
    
}
