package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    ArrayList<Room> unbookedrooms = new ArrayList<>();
    ArrayList<Room> bookedrooms = new ArrayList<>();
    ArrayList<Customer> cus = new ArrayList<>();

    public static void main(String[] args) {
        boolean cont = true;
        Main myApp = new Main();

        myApp.allrooms();
        while (cont) {
            myApp.Menu();
        }

    }

    protected void allrooms() {

        unbookedrooms.add(new Room("100", 900, "Signle bed no balcony"));
        unbookedrooms.add(new Room("101", 900, "Signle bed no balcony"));
        unbookedrooms.add(new Room("102", 900, "Signle bed no balcony"));
        unbookedrooms.add(new Room("103", 900, "Signle bed no balcony"));
        unbookedrooms.add(new Room("200", 1200, "Single bed with a balcony"));
        unbookedrooms.add(new Room("201", 1200, "Single bed with a balcony"));
        unbookedrooms.add(new Room("202", 1200, "Single bed with a balcony"));
        unbookedrooms.add(new Room("203", 1200, "Single bed with a balcony"));
        unbookedrooms.add(new Room("300", 1500, "Double beds No balcony"));
        unbookedrooms.add(new Room("301", 1500, "Double beds No balcony"));
        unbookedrooms.add(new Room("302", 1500, "Double beds No balcony"));
        unbookedrooms.add(new Room("303", 1500, "Double beds No balcony"));
        unbookedrooms.add(new Room("400", 2000, "Double beds with a balcony"));
        unbookedrooms.add(new Room("401", 2000, "Double beds with a balcony"));
        unbookedrooms.add(new Room("402", 2000, "Double beds with a balcony"));
        unbookedrooms.add(new Room("403", 2000, "Double beds with a balcony"));


    }

    public void Menu() {
        System.out.println("-----MENU-----");
        System.out.println("1)  Book a room");
        System.out.println("2)  Unbook a room");
        System.out.println("3)  View booked rooms");
        System.out.println("4)  View unbooked rooms");
        System.out.println("5)  View bookings");
        System.out.println("6)  Search for booking");
        System.out.println("7)  Edit room");
        System.out.println("8)  Remove a room");
        try {
            int a = input.nextInt();
            if (a == 1) {
                bookRoom();
            }
        } catch (Exception e) {
            System.out.println("Unvalid");
            Menu();
        }

    }

    protected void bookRoom() {
        Customer c = new Customer();
        System.out.println("___________________");
        for (int i = 0; i < unbookedrooms.size(); i++) {
            System.out.println("---------------");
            System.out.println("[" + i + "]" + unbookedrooms.get(i));
        }
        System.out.println("_______________");

        System.out.println("Enter the index of the room you would like to book: ");
        try {
            int a = input.nextInt();

            bookedrooms.add(unbookedrooms.get(a));
            unbookedrooms.remove(unbookedrooms.get(a));

            System.out.println("Enter the name of the customer: ");
            c.setName(input.next());
            System.out.println("Enter SSN of the customer: ");
            c.setSSN(input.next());
            System.out.println("Enter address of the customer: ");
            c.setAdd(input.next());
            System.out.println("Enter phonenumber of the customer");
            c.setNumber(input.next());
            System.out.println("Confirm your booking by Yes ");
            String s = input.next();
            if (s.equalsIgnoreCase("Yes")) {
                cus.add(c);
                bookedrooms.add(unbookedrooms.get(a));
                unbookedrooms.remove(unbookedrooms.get(a));
                System.out.println("The booking has been booked");
            }


        } catch (Exception e) {
            System.out.println("Unvalid");
            bookRoom();
        }

    }
}
