package com.github.baptistemht.sneuf.train;

import java.util.ArrayList;

import com.github.baptistemht.sneuf.client.Booking;
import com.github.baptistemht.sneuf.client.Client;


public class Train {

    private final String id;
    private final String marque;

    private final int nombrePlaces;
    private int nombrePlacesDispo;

    private final ArrayList<Rame> rames;
    private final int nombreRames;

    private final boolean etage;

    public Train(String id, String marque, int nombrePlaces, int nbRames, boolean etage) {
        this.id                 = id;
        this.marque             = marque;

        this.nombrePlaces       = nombrePlaces;
        this.nombrePlacesDispo  = nombrePlaces;

        this.rames              = new ArrayList<>();
        this.nombreRames        = nbRames;

        this.etage              = etage;

        for(int i = 0; i<nbRames; i++){
            this.rames.add(new Rame(i+1, Math.round(nombrePlaces/nbRames), Classe.SECONDE, etage));
        }
    }

    public String getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public int getNombrePlacesDispo() {
        return nombrePlacesDispo;
    }

    public ArrayList<Rame> getRames() {
        return rames;
    }

    public int getNombreRames() {
        return nombreRames;
    }

    public boolean isEtage() {
        return etage;
    }

    public Booking book(Client p, Classe classe){
        int rame = 0;
        int seat = 0;
        Siege s = getSiegeFromNumber(rame, seat);

        while(s.getPersonne() != null){
            seat += 1;
            if(seat == 99){
                rame += 1;
                seat = 0;
            }
            
            s = getSiegeFromNumber(rame, seat);
        }

        Booking b = new Booking(this.id, rame+1, seat+1, classe);

        rames.get(rame).getSieges().get(seat).setPersonne(p);
        this.nombrePlacesDispo-=1;
        p.getBookings().add(b);

        return b;
    }

    public void display(){
        System.out.println("The train is filled up at " + (nombrePlaces-nombrePlacesDispo)/nombrePlaces*100 + "%. " + nombrePlacesDispo + " seats remaining.");
        System.out.println("");

        int nbPlacesParRame = Math.round(nombrePlaces/nombreRames);
        
        for(int i = 0; i<nombreRames; i++){
            System.out.println("Rame n°"+(i+1));
            System.out.println("      ---------------");

            for(int j = 0; j<Math.round(nbPlacesParRame/4); j++){
                if(j<9){
                    System.out.print(" 0" + (j+1) + "   ");
                }else{
                    System.out.print(" " + (j+1) + "   ");
                }

                for(int k = 0; k<4; k++){
                    int noPlace = j*4 + k;

                    Siege s = getSiegeFromNumber(i, noPlace);
                    if(s != null){
                        if(s.getPersonne() == null){
                            System.out.print(" . ");   
                        }else{
                            System.out.print(" B ");
                        }
                    }

                    if(k == 1) System.out.print("   ");
                }

                System.out.println();
            }

            System.out.println("      ---------------");
            System.out.println("");
        }
    }

    public Siege getSiegeFromNumber(int rame, int number){
        return rames.get(rame).getSieges().get(number);
    }

    @Override
    public String toString() {
        return "Train n°" + id + " from " + marque + " is made of " + nombreRames + " rames. " + (nombrePlaces-nombrePlacesDispo)/nombrePlaces*100 + "% filled.";
    }
    
}
