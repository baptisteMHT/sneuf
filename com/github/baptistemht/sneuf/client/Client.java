package com.github.baptistemht.sneuf.client;

import java.util.ArrayList;

public class Client {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final ArrayList<Booking> bookings;

    public Client(String firstName, String lastName, int age){
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.age        = age;
        this.bookings   = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + " yo)";
    }
    
}
