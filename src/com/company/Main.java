package com.company;

import java.util.ArrayList;

public class Main {
    ArrayList<Room> unbookedrooms =new ArrayList<>();
    ArrayList<Room> bookedrooms = new ArrayList<>();
    ArrayList<Customer> cus = new ArrayList<>();

    public static void main(String[] args) {

    }
    protected void allrooms() {

        unbookedrooms.add(new Room("100",900,"Signle bed no balcony"));
        unbookedrooms.add(new Room("101",900,"Signle bed no balcony"));
        unbookedrooms.add(new Room("102",900,"Signle bed no balcony"));
        unbookedrooms.add(new Room("103",900,"Signle bed no balcony"));
        unbookedrooms.add(new Room("200",1200,"Single bed with a balcony"));
        unbookedrooms.add(new Room("201",1200,"Single bed with a balcony"));
        unbookedrooms.add(new Room("202",1200,"Single bed with a balcony"));
        unbookedrooms.add(new Room("203",1200,"Single bed with a balcony"));
        unbookedrooms.add(new Room("300",1500,"Double beds No balcony"));
        unbookedrooms.add(new Room("301",1500,"Double beds No balcony"));
        unbookedrooms.add(new Room("302",1500,"Double beds No balcony"));
        unbookedrooms.add(new Room("303",1500,"Double beds No balcony"));
        unbookedrooms.add(new Room("400",2000,"Double beds with a balcony"));
        unbookedrooms.add(new Room("401",2000,"Double beds with a balcony"));
        unbookedrooms.add(new Room("402",2000,"Double beds with a balcony"));
        unbookedrooms.add(new Room("403",2000,"Double beds with a balcony"));


    }
    public void Menu(){
        System.out.println("-----MENU-----");
        System.out.println("1)  Book a room");
        System.out.println("2)  Unbook a room");
        System.out.println("3)  View booked rooms" );
        System.out.println("4)  View unbooked rooms");
        System.out.println("5)  View bookings");
        System.out.println("6)  Search for booking");
        System.out.println("7)  Edit room");
        System.out.println("8)  Remove a room");


    }

}
