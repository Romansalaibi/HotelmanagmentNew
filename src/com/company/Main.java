package com.company;

import jdk.jfr.Experimental;

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
        System.out.println("1)    Book a room.");
        System.out.println("2)    Unbook a room.");
        System.out.println("3)    View booked rooms.");
        System.out.println("4)    View unbooked rooms.");
        System.out.println("5)    View bookings.");
        System.out.println("6)    Search for booking.");
        System.out.println("7)    Edit room.");
        System.out.println("8)    Add a new room.");
        System.out.println("9)    Remove room.");
        System.out.println("10)   Add a new customer.");
        System.out.println("11)   to remove customer.");
        System.out.println("12)   Edit customer.");
        System.out.println("13)   View all customers");
        try {

            int a = input.nextInt();
            if (a == 1) {
                bookRoom();
            } else if (a == 2) {
                tabort();
            } else if (a == 3) {
                booked();
            } else if (a == 4) {
                unbookedrooms();
            } else if (a == 5) {
                bookings();
            } else if (a == 6) {
                search();
            } else if (a == 7) {
                edit();
            } else if (a == 8) {
                addRoom();
            } else if (a == 9) {
                removeRoom();
            } else if (a == 10) {
                addcus();
            } else if (a == 11){
                removecus();
            } else if (a == 12){
                editcus();
            } else if (a == 13){
                viewcus();
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
            int a = Integer.parseInt(input.nextLine());
            System.out.println("Enter the name of the customer: ");
            c.setName(input.next());
            input.nextLine();
            System.out.println("Enter SSN of the customer: ");
            c.setSSN(input.next());
            System.out.println("Enter address of the customer: ");
            c.setAdd(input.next());
            input.nextLine();
            System.out.println("Enter phonenumber of the customer");
            c.setNumber(input.next());
            System.out.println("Confirm booking yes");
            String s = input.next();
            if (s.equalsIgnoreCase("yes")) {
                bookedrooms.add(unbookedrooms.get(a));
                unbookedrooms.remove(a);
                cus.add(c);
                System.out.println("The booking has been booked");
            }
        } catch (Exception e) {
            System.out.println("unvalid");
            bookRoom();
        }
    }

    protected void bookings() {
        System.out.println("_______________");
        for (int i = 0; i < cus.size(); i++) {
            System.out.println("Room");
            System.out.println(bookedrooms.get(i));
            System.out.println("Booked by");
            System.out.println(cus.get(i));
            System.out.println("---------------");
        }
        System.out.println("_______________");

    }

    protected void unbookedrooms() {
        System.out.println("_______________");
        for (int i = 0; i < unbookedrooms.size(); i++) {
            System.out.println(unbookedrooms.get(i));
            System.out.println("---------------");
        }
        System.out.println("_______________");
    }

    protected void search() {
        System.out.println("_______________");
        System.out.println("Enter the SSN of the searched customer");
        try {
            String a = input.next();
            for (int i = 0; i < cus.size(); i++) {
                System.out.println("---------------");
                if (a.equalsIgnoreCase(cus.get(i).getSSN())) {
                    System.out.println("Room");
                    System.out.println(bookedrooms.get(i));
                    System.out.println("");
                    System.out.println("Booked by");
                    System.out.println(cus.get(i));
                    System.out.println("---------------");
                }
                System.out.println("_______________");
            }
        } catch (Exception e) {
            System.out.println("Unvalid");
            search();
        }
    }

    protected void booked() {
        System.out.println("_______________");
        for (int i = 0; i < bookedrooms.size(); i++) {
            System.out.println(bookedrooms.get(i));
            System.out.println("---------------");
        }
        System.out.println("_______________");
    }

    protected void tabort() {
        System.out.println("_______________");
        for (int i = 0; i < cus.size(); i++) {
            System.out.println("Room");
            System.out.println("[" + i + "]" + bookedrooms.get(i));
            System.out.println();
            System.out.println("Booked by");
            System.out.println(cus.get(i));
            System.out.println("---------------");
        }
        System.out.println("_______________");
        try {
            System.out.println("Choose the index of the booking");
            int a = input.nextInt();
            System.out.println("Confirm cancelation yes");
            String b = input.next();
            if (b.equalsIgnoreCase("yes")) {
                cus.remove(a);
                unbookedrooms.add(bookedrooms.get(a));
                bookedrooms.remove(a);
            }

        } catch (Exception e) {
            System.out.println("unvalid");
            tabort();
        }

    }

    protected void edit() {
        try {
            System.out.println("What would you like to change?");
            System.out.println("1)  Change the room price.");
            System.out.println("2)  Change the room name.");
            int a = input.nextInt();
            if (a == 1) {
                for (int i = 0; i < unbookedrooms.size(); i++) {
                    System.out.println("[" + i + "]" + unbookedrooms.get(i));
                    System.out.println("---------------");
                }
                System.out.println("Enter the room index: ");
                int b = input.nextInt();
                System.out.println("Enter the new room price: ");
                unbookedrooms.get(b).setPrice(input.nextInt());
            } else if (a == 2) {
                for (int i = 0; i < unbookedrooms.size(); i++) {
                    System.out.println("[" + i + "]" + unbookedrooms.get(i));
                    System.out.println("---------------");
                }
                System.out.println("Enter the room index: ");
                int c = input.nextInt();
                System.out.println("Enter the new room name: ");
                unbookedrooms.get(c).setRoomname(input.next());
            }

        } catch (Exception e) {
            System.out.println("Unvalid");
        }

    }

    protected void addRoom() {
        try {
            System.out.println("Enter new room name");
            String name = input.next();
            System.out.println("Enter new room price");
            int price = input.nextInt();
            System.out.println("How many beds");
            String beds = input.next();
            System.out.println("How many Balconies");
            String balcony = input.next();
            System.out.println("Additional things?");
            String addit = input.next();
            String type = beds + " Beds " + balcony + " balconies " + addit;
            unbookedrooms.add(new Room(name, price, type));
            System.out.println("The new room has been added");


        } catch (Exception e) {
            System.out.println("unvalid");
            addRoom();
        }

    }

    protected void removeRoom() {
        try {

            for (int i = 0; i < unbookedrooms.size(); i++) {
                System.out.println("[" + i + "]" + unbookedrooms.get(i));
                System.out.println("---------------");
            }
            System.out.println("Enter the room you would like to remove by index: ");
            int a = input.nextInt();

            unbookedrooms.remove(a);
            System.out.println("The room has now been removed!");
            System.out.println("_______________");

        } catch (Exception e) {
            System.out.println("Unvalid");
        }
    }

    protected void addcus() {
        Customer c = new Customer();
        try {
            int a = Integer.parseInt(input.nextLine());
            System.out.println("Enter the name of the customer: ");
            c.setName(input.next());
            input.nextLine();
            System.out.println("Enter SSN of the customer: ");
            c.setSSN(input.next());
            System.out.println("Enter address of the customer: ");
            c.setAdd(input.next());
            input.nextLine();
            System.out.println("Enter phonenumber of the customer");
            c.setNumber(input.next());
            System.out.println("Confirm by yes");
            String s = input.next();
            if (s.equalsIgnoreCase("yes")) {
                cus.add(c);
                System.out.println("The Customer has been added");
            }
        } catch (Exception e) {
            System.out.println("unvalid");
        }
    }

    protected void removecus() {
        Customer c= new Customer();

        for (int a=0; a < cus.size(); a++){
            System.out.println("[" + a + "[" + cus.get(a));
            System.out.println("----------------");
        }

        System.out.println("Choose the index of the Customer");
        int a = input.nextInt();
        System.out.println("do you want to remove customer? \n Confirm yes");
        String b = input.next();
        if (b.equalsIgnoreCase("yes")) {
            cus.remove(a);

        }


    }
    protected void editcus(){

        try {
            System.out.println("What would you like to change?");
            System.out.println("1)  Change the SSN.");
            System.out.println("2)  Change the name.") ;
            System.out.println("3)  Change the address.");
            int a = input.nextInt();
            input.nextLine();
            if (a == 1) {
                for (int i = 0; i < cus.size(); i++) {
                    System.out.println("[" + i + "]" + cus.get(i));
                    System.out.println("---------------");
                }
                System.out.println("Enter the name index: ");
                int b = Integer.parseInt(input.nextLine());
                System.out.println("Enter the new SSN: ");
                cus.get(b).setSSN(input.nextLine());
            } else if (a == 2) {
                for (int i = 0; i < cus.size(); i++) {
                    System.out.println("[" + i + "]" + cus.get(i));
                    System.out.println("---------------");
                }
                System.out.println("Enter the name index: ");
                int q = Integer.parseInt(input.nextLine());
                System.out.println("Enter the new name: ");
                cus.get(q).setName(input.nextLine());
            } else if (a == 3){
                for (int i = 0; i<cus.size(); i++){
                    System.out.println("[" + i + "]" + cus.get(i));
                    System.out.println("----------------");
                }
                System.out.println("Enter the name index: ");
                int b = Integer.parseInt(input.nextLine());
                System.out.println("Enter the new address: ");
                cus.get(b).setAdd(input.nextLine());
            }
            bookRoom();
        }catch (Exception e){
            System.out.println("Unvalid");
        }
    }

    protected void bookings() {
        System.out.println("_______________");
        for (int i = 0; i < cus.size(); i++) {
            System.out.println("Room");
            System.out.println(bookedrooms.get(i));
            System.out.println("Booked by");
            System.out.println(cus.get(i));
            System.out.println("---------------");
        }
        System.out.println("_______________");

    }

    protected void unbookedrooms() {
        System.out.println("_______________");
        for (int i = 0; i < unbookedrooms.size(); i++) {
            System.out.println(unbookedrooms.get(i));
            System.out.println("---------------");
        }
        System.out.println("_______________");
    }

    protected void search(){
        System.out.println("_______________");
        System.out.println("Enter the SSN of the searched customer");
        try {
            String a=input.next();
            for (int i=0;i<cus.size();i++){
                System.out.println("---------------");
                if(a.equalsIgnoreCase(cus.get(i).getSSN())){
                    System.out.println("Room");
                    System.out.println(bookedrooms.get(i));
                    System.out.println("");
                    System.out.println("Booked by");
                    System.out.println(cus.get(i));
                    System.out.println("---------------");
                }
                System.out.println("_______________");
            }
        }catch (Exception e){
            System.out.println("Unvalid");
            search();
        }
    }
    protected void booked(){
        System.out.println("_______________");
        for (int i=0;i<bookedrooms.size();i++){
            System.out.println(bookedrooms.get(i));
            System.out.println("---------------");
        }
        System.out.println("_______________");
    }
    protected void tabort(){
        System.out.println("_______________");
        for (int i = 0; i < cus.size(); i++) {
            System.out.println("Room");
            System.out.println("["+i+"]"+bookedrooms.get(i));
            System.out.println();
            System.out.println("Booked by");
            System.out.println(cus.get(i));
            System.out.println("---------------");
        }
        System.out.println("_______________");
        try {
            System.out.println("Choose the index of the booking");
            int a=input.nextInt();
            System.out.println("Confirm cancelation yes");
            String b=input.next();
            if(b.equalsIgnoreCase("yes")){
                cus.remove(a);
                unbookedrooms.add(bookedrooms.get(a));
                bookedrooms.remove(a);
            }

        }catch (Exception e){
            System.out.println("unvalid");
            tabort();
        }
        System.out.println("_______________");

    }

    protected void viewcus() {
        for (int i = 0; i < cus.size(); i++) {
            int q = i + 1;
            System.out.println("Number: " + q + cus.get(i));
            System.out.println("--------------");
        }
    }


    protected void edit(){
        try {
            boolean cont=true;
            System.out.println("What would you like to change?");
            System.out.println("1)  Change the room price.");
            System.out.println("2)  Change the room name.");
            int a = input.nextInt();
            if (a==1){
                for (int i = 0; i < unbookedrooms.size(); i++) {
                    System.out.println("[" + i + "]" +  unbookedrooms.get(i));
                    System.out.println("---------------");
                }
                System.out.println("Enter the room index: ");
                int b = input.nextInt();
                System.out.println("Enter the new room price: ");
                unbookedrooms.get(b).setPrice(input.nextInt());
            } else if (a == 2){
                for (int i = 0; i < unbookedrooms.size(); i++) {
                    System.out.println("[" + i + "]" +  unbookedrooms.get(i));
                    System.out.println("---------------");
                }
                System.out.println("Enter the room index: ");
                int c = input.nextInt();
                System.out.println("Enter the new room name: ");
                String d=input.next();
                int i=0;
                while (cont){
                    if (unbookedrooms.get(i).getRoomname().equalsIgnoreCase(d)){
                        System.out.println("the name can't be added");
                        cont=false;
                    }else if(unbookedrooms.size()-1==i&&!unbookedrooms.get(i).getRoomname().equalsIgnoreCase(d)){
                        unbookedrooms.get(c).setRoomname(d);
                        System.out.println("added");
                        cont=false;
                    }
                    i+=1;
                }

            }

        }catch (Exception e){
            System.out.println("Unvalid");
        }

    }
    protected void addRoom() {
        try {
            boolean cont=true;
            System.out.println("Enter new room name");
            String name = input.next();
            System.out.println("Enter new room price");
            int price = input.nextInt();
            System.out.println("How many beds");
            String beds=input.next();
            System.out.println("How many Balconies");
            String balcony=input.next();
            System.out.println("Additional things?");
            String addit=input.next();
            String type=beds+" Beds "+balcony+" balconies "+addit;
            int i=0;
            while (cont){
                if (unbookedrooms.get(i).getRoomname().equalsIgnoreCase(name)){
                    System.out.println("the name can't be added");
                    cont=false;
                }else if(unbookedrooms.size()-1==i&&!unbookedrooms.get(i).getRoomname().equalsIgnoreCase(name)){
                    unbookedrooms.add(new Room(name,price,type));
                    System.out.println("added");
                    cont=false;
                }
                i+=1;
            }
        } catch (Exception e){
            System.out.println("unvalid");
            Menu();
        }

    }
    protected void removeRoom(){
        try {

            for (int i = 0; i < unbookedrooms.size(); i++) {
                System.out.println("[" + i + "]" + unbookedrooms.get(i));
                System.out.println("---------------");
            }
            System.out.println("Enter the room you would like to remove by index: ");
            int a = input.nextInt();

            unbookedrooms.remove(a);
            System.out.println("The room has now been removed!");
            System.out.println("_______________");

        }catch (Exception e){
            System.out.println("Unvalid");
        }
    }
}

