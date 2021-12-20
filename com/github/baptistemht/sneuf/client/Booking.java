package com.github.baptistemht.sneuf.client;

import com.github.baptistemht.sneuf.train.Classe;

public class Booking {

    private final String train;
    private final int rame;
    private final int seat;
    private final Classe classe;
    
    public Booking(String train, int rame, int seat, Classe classe) {
        this.train = train;
        this.rame = rame;
        this.seat = seat;
        this.classe = classe;
    }

    public String getTrain() {
        return train;
    }

    public int getRame() {
        return rame;
    }
    
    public int getSeat() {
        return seat;
    }

    public Classe getClasse() {
        return classe;
    }

    @Override
    public String toString() {
        return "Booking train n°" + train + ", rame n°" + rame + ", seat n°" + seat + ", " + classe + " class";
    }
    
}
