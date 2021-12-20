package com.github.baptistemht.sneuf.train.seat;

import com.github.baptistemht.sneuf.client.Client;

public class Seat {

    private final int number;
    private final boolean window;
    private final boolean upstair;
    private final SeatType seatType;
    private Client client;


    public Seat(int number, SeatType seatType, boolean window, boolean upstair) {
        this.number     = number;
        this.window     = window;
        this.upstair    = upstair;
        this.client     = null;
        this.seatType   = seatType;
    }


    public int getnumber() {
        return number;
    }

    public boolean isWindow() {
        return window;
    }

    public boolean isUpstair() {
        return upstair;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isFree(){
        return this.client == null;
    }

    public SeatType getSeatType() {
        return seatType;
    }
    
}
