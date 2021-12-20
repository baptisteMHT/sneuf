package com.github.baptistemht.sneuf.train;

import java.util.ArrayList;

import com.github.baptistemht.sneuf.client.Booking;
import com.github.baptistemht.sneuf.client.Client;
import com.github.baptistemht.sneuf.train.car.Car;
import com.github.baptistemht.sneuf.train.car.CarClass;
import com.github.baptistemht.sneuf.train.seat.Seat;


public class Train {

    private final String id;
    private final String brand;

    private final int seatsNumber;
    private int seatsRemaining;

    private final ArrayList<Car> cars;
    private final int carsNumber;

    private final boolean upstair;

    public Train(String id, String brand, int seatsNumber, int nbRames, boolean upstair) {
        this.id                 = id;
        this.brand              = brand;

        this.seatsNumber        = seatsNumber;
        this.seatsRemaining     = seatsNumber;

        this.cars              = new ArrayList<>();
        this.carsNumber        = nbRames;

        this.upstair           = upstair;

        for(int i = 0; i<nbRames; i++){
            this.cars.add(new Car(i+1, Math.round(seatsNumber/nbRames), CarClass.SECOND, upstair));
        }
    }

    public String getId() {
        return id;
    }

    public String getMarque() {
        return brand;
    }

    public int getNombrePlaces() {
        return seatsNumber;
    }

    public int getNombrePlacesDispo() {
        return seatsRemaining;
    }

    public ArrayList<Car> getRames() {
        return cars;
    }

    public int getNombreRames() {
        return carsNumber;
    }

    public boolean isEtage() {
        return upstair;
    }

    public Booking book(Client p, CarClass classe){
        int rame = 0;
        int seat = 0;
        Seat s = getSiegeFromNumber(rame, seat);

        while(s.getClient() != null){
            seat += 1;
            if(seat == 99){
                rame += 1;
                seat = 0;
            }
            
            s = getSiegeFromNumber(rame, seat);
        }

        Booking b = new Booking(this.id, rame+1, seat+1, classe);

        cars.get(rame).getSeats().get(seat).setClient(p);
        this.seatsRemaining-=1;
        p.getBookings().add(b);

        return b;
    }

    public void display(){
        System.out.println("The train is filled up at " + (seatsNumber-seatsRemaining)/seatsNumber*100 + "%. " + seatsRemaining + " seats remaining.");
        System.out.println("");

        int nbPlacesParRame = Math.round(seatsNumber/carsNumber);
        
        for(int i = 0; i<carsNumber; i++){
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

                    Seat s = getSiegeFromNumber(i, noPlace);
                    if(s != null){
                        if(s.getClient() == null){
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

    public Seat getSiegeFromNumber(int rame, int number){
        return cars.get(rame).getSeats().get(number);
    }

    @Override
    public String toString() {
        return "Train n°" + id + " from " + brand + " is made of " + carsNumber + " cars. " + (seatsNumber-seatsRemaining)/seatsNumber*100 + "% filled.";
    }
    
}
