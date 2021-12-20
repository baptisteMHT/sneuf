package com.github.baptistemht.sneuf;

import java.util.ArrayList;

import com.github.baptistemht.sneuf.client.Booking;
import com.github.baptistemht.sneuf.client.Client;
import com.github.baptistemht.sneuf.train.Classe;
import com.github.baptistemht.sneuf.train.Train;

import in.keyboard.Keyboard;

public class Main {

    public static void main(String[] args){
        System.out.println("Sneuf v1.0 - Let's fill some trains.");

        final ArrayList<Train> trains = new ArrayList<>();
        
        Client c = new Client("Baptiste", "Maheut", 19);

        Train t0 = new Train("1", "Alstom",500,5,false);
        trains.add(t0);

        displayMenu();
        Train t = null;
        int choix = Keyboard.getInt();

        while(choix != 7){
            switch(choix){
                case 1:
                    if(c != null){
                        System.out.println("Account already defined.");
                        System.out.println(c);
                        break;
                    }

                    c = setupClient();
                    System.out.println("Account successfully set up.");
                break;


                case 2:
                    if(c == null){
                        System.out.println("Account not defined.");
                        break;
                    }

                    if(c.getBookings().size() == 0){
                        System.out.println("Booking list is empty.");
                        break;
                    }

                    System.out.println("Booking list : ");
                    for(int i = 0; i<c.getBookings().size(); i++){
                        System.out.println(i+1+". " + c.getBookings().get(i));
                    }
                break;


                case 3:
                    if(c == null){
                        System.out.println("Account not defined.");
                        break;
                    }

                    System.out.print("Train id : ");
                    t = findTrainById(trains, Keyboard.getString());

                    while(t == null){
                        System.out.println("Unknown train id.");
                        System.out.print("Train id : ");
                        t = findTrainById(trains, Keyboard.getString());
                    }

                    System.out.print("Class (PREMIERE, SECONDE) : ");
                    Classe classe = Classe.fromString(Keyboard.getString());

                    while(classe == null){
                        System.out.println("Unknown class.");
                        System.out.print("Class : ");
                        classe = Classe.fromString(Keyboard.getString());
                    }
                    
                    Booking b = t.book(c, classe);

                    if(b == null){
                        System.out.println("Couldn't find a seat. Sorry for the inconvenience.");
                    }else{
                        System.out.println(b);
                    }


                break;


                case 4:
                    t = createTrain();
                    trains.add(t);
                    System.out.println(t);
                break;


                case 5:
                    if(trains.size() == 0){
                        System.out.println("Train list is empty.");
                        break;
                    }

                    System.out.println("Train list : ");
                    for(int i = 0; i<trains.size(); i++){
                        System.out.println(i+1+". " + trains.get(i));
                    }
                break;

                case 6:
                    if(trains.size() == 0){
                        System.out.println("Train list is empty.");
                        break;
                    }

                    System.out.print("Train id : ");
                    t = findTrainById(trains, Keyboard.getString());

                    while(t == null){
                        System.out.println("Unknown train id.");
                        System.out.print("Train id : ");
                        t = findTrainById(trains, Keyboard.getString());
                    }

                    System.out.println(t);
                    t.display();


                break;
                
                default:
                    System.out.println("Wrong input.");
                break;
            }
            displayMenu();
            choix = Keyboard.getInt();
        }

        System.out.println("Thank you for choosing sneuf.");
    }

    private static void displayMenu(){
        System.out.println("");
        System.out.println("What would you like to do ?");
        System.out.println("1. Set up an account");
        System.out.println("2. View booking");
        System.out.println("3. Book a seat");
        System.out.println("4. Create a train");
        System.out.println("5. Display train list");
        System.out.println("6. Display a train");
        System.out.println("7. Exit");
        System.out.println("");
        System.out.print("> ");
    }

    private static Client setupClient(){
        System.out.print("First name : ");
        String fName = Keyboard.getString();

        System.out.print("Last name : ");
        String lName = Keyboard.getString();

        System.out.print("Age : ");
        int age = Keyboard.getInt();

        return new Client(fName, lName, age);
    }

    private static Train findTrainById(ArrayList<Train> trains, String id){
        for(int i = 0; i<trains.size(); i++){
            if(trains.get(i).getId().equalsIgnoreCase(id)) return trains.get(i);
        }
        return null;
    }

    private static Train createTrain(){
        System.out.print("Train id : ");
        String id = Keyboard.getString();

        System.out.print("Brand : ");
        String brand = Keyboard.getString();

        System.out.print("Number of seats : ");
        int seats = Keyboard.getInt();

        System.out.print("Number of rames : ");
        int rames = Keyboard.getInt();

        System.out.print("Floor (y/n): ");
        boolean etage = Keyboard.getChar()=='y';

        return new Train(id, brand, seats, rames, etage);
    }

}