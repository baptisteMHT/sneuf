package com.github.baptistemht.sneuf.train.car;

import java.util.ArrayList;

import com.github.baptistemht.sneuf.train.seat.Seat;
import com.github.baptistemht.sneuf.train.seat.SeatType;

public class Car {

    private final int number;
    private final int seatsNumber;
    private final CarClass carClass;
    private final ArrayList<Seat> seats;
    private final boolean upstair;

    private int seatsRemaining;

    public Car(int number, int seatsNumber, CarClass carClass, boolean upstair) {
        this.number             = number;
        this.seatsNumber        = seatsNumber;
        this.carClass           = carClass;
        this.seats              = new ArrayList<>();
        this.upstair            = upstair;

        this.seatsRemaining  = seatsNumber;
        
        for(int i = 0; i<seatsNumber; i++){
            seats.add(new Seat(i+1, SeatType.DUO, false, i>seatsNumber/2));
        }
    }

    public int getnumber() {
        return number;
    }

    public int getNombreSieges() {
        return seatsNumber;
    }

    public int getseatsRemaining() {
        return seatsRemaining;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public boolean hasUpstair() {
        return upstair;
    }

}
