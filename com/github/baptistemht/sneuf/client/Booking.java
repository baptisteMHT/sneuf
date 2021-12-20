package com.github.baptistemht.sneuf.client;

import com.github.baptistemht.sneuf.train.car.CarClass;

public class Booking {

    private final String train;
    private final int car;
    private final int seat;
    private final CarClass carClass;
    
    public Booking(String train, int car, int seat, CarClass carClass) {
        this.train = train;
        this.car = car;
        this.seat = seat;
        this.carClass = carClass;
    }

    public String getTrain() {
        return train;
    }

    public int getCar() {
        return car;
    }
    
    public int getSeat() {
        return seat;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    @Override
    public String toString() {
        return "Booking train n°" + train + ", car n°" + car + ", seat n°" + seat + ", " + carClass + " class";
    }
    
}
