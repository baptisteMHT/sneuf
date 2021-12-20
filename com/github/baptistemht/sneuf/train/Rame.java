package com.github.baptistemht.sneuf.train;

import java.util.ArrayList;

public class Rame {

    private final int numero;
    private final int nombreSieges;
    private final Classe classe;
    private final ArrayList<Siege> sieges;
    private final boolean etage;

    private int nombreSiegesDispo;

    public Rame(int numero, int nombreSieges, Classe classe, boolean etage) {
        this.numero             = numero;
        this.nombreSieges       = nombreSieges;
        this.classe             = classe;
        this.sieges             = new ArrayList<>();
        this.etage              = etage;

        this.nombreSiegesDispo  = nombreSieges;
        
        for(int i = 0; i<nombreSieges; i++){
            sieges.add(new Siege(i+1, TypeSiege.DUO, false, i>nombreSieges/2));
        }
    }

    public int getNumero() {
        return numero;
    }

    public int getNombreSieges() {
        return nombreSieges;
    }

    public int getNombreSiegesDispo() {
        return nombreSiegesDispo;
    }

    public Classe getClasse() {
        return classe;
    }

    public ArrayList<Siege> getSieges() {
        return sieges;
    }

    public boolean isEtage() {
        return etage;
    }

}
