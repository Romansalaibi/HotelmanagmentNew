package com.company;

import jdk.jfr.Experimental;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    ArrayList<Room> unbookedrooms = new ArrayList<>();
    ArrayList<Room> bookedrooms = new ArrayList<>();
    ArrayList<Customer> cus = new ArrayList<>();
    ArrayList<Customer> history = new ArrayList<>();



    public static void main(String[] args) {
        int password = 0000;
        Scanner input=new Scanner(System.in);
        boolean cont = true;
        boolean zeft=true;
        Main myApp = new Main();
        System.out.println("------------MENU-----------");
        System.out.println("| Employee or Customer?   |");
        System.out.println("| 1) Employee.            |");
        System.out.println("| 2) Customer.            |");
        System.out.println("---------------------------");
        int a=input.nextInt();
        myApp.allrooms();
        myApp.heart();
        if(a==1) {
            System.out.println("Enter the password: ");
            int p = input.nextInt();
            if (p == password) {
            while (cont) {
                myApp.Menu();
            }
            }
        }else if(a==2){
            while (zeft){
                myApp.heart();
                myApp.cusMenu();
            }
        }
        myApp.writetxt();
    }

    private void heart() {
        Customer b = new Customer();
        b.setName("name");
        b.setSSN("9805");
        b.setAdd("kulladal");
        b.setNumber("07341");
        history.add(b);
    }

    protected void allrooms() {

        unbookedrooms.add(new Room("100", 900, "Single bed no balcony"));
        unbookedrooms.add(new Room("101", 900, "Single bed no balcony"));
        unbookedrooms.add(new Room("102", 900, "Single bed no balcony"));
        unbookedrooms.add(new Room("103", 900, "Single bed no balcony"));
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

                    System.out.println("---------------------Menu----------------------");
                    System.out.println("| 1)    Book a room.                          |");
                    System.out.println("| 2)    Unbook a room.                        |");
                    System.out.println("| 3)    View booked rooms.                    |");
                    System.out.println("| 4)    View unbooked rooms.                  |");
                    System.out.println("| 5)    View bookings.                        |");
                    System.out.println("| 6)    Search for booking.                   |");
                    System.out.println("| 7)    Edit room.                            |");
                    System.out.println("| 8)    Add a new room.                       |");
                    System.out.println("| 9)    Remove room.                          |");
                    System.out.println("| 10)   Add a new customer.                   |");
                    System.out.println("| 11)   to remove customer.                   |");
                    System.out.println("| 12)   Edit customer.                        |");
                    System.out.println("| 13)   View all customers                    |");
                    System.out.println("| 14)   Book a room through customer/room list|");
                    System.out.println("| 15)   Edit a booking                        |");
                    System.out.println("| 16)   View saved text file                  |");
                    System.out.println("-----------------------------------------------");

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
                        } else if (a == 11) {
                            removecus();
                        } else if (a == 12) {
                            editcus();
                        } else if (a == 13) {
                            printcus();
                        } else if (a == 14) {
                            genomlist();
                        } else if (a == 15) {
                            editbook();
                        } else if (a == 16){
                            readtxt();
                        }


                }



    protected void bookRoom() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm");
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
            c.setName(input.nextLine());
            System.out.println("Enter SSN of the customer: ");
            c.setSSN(input.nextLine());
            System.out.println("Enter address of the customer: ");
            c.setAdd(input.nextLine());
            System.out.println("Enter phone number of the customer: ");
            c.setNumber(input.nextLine());
            System.out.println("Check in date");
           c.setStart(sdf.parse(input.nextLine()));
            System.out.println("Check out date");
            c.setEnd(sdf.parse(input.nextLine()));
            System.out.println("Confirm booking yes: ");
            String s = input.next();
            if (s.equalsIgnoreCase("yes")) {
                bookedrooms.add(unbookedrooms.get(a));
                unbookedrooms.remove(a);
                cus.add(c);
                history.add(c);
                System.out.println("The booking has been made!");
            }
        } catch (Exception e) {
            System.out.println("Unvalid");
            bookRoom();
        }
    }

    protected void bookings() {
        System.out.println("_______________");
        for (int i = 0; i < cus.size(); i++) {
            System.out.println("Room");
            System.out.println(bookedrooms.get(i));
            System.out.println();
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
            input.nextLine();
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
            System.out.println("Choose the index of the booking: ");
            int a = input.nextInt();
            System.out.println("Confirm cancelation by writing yes: ");
            String b = input.next();
            if (b.equalsIgnoreCase("yes")) {
                cus.remove(a);
                unbookedrooms.add(bookedrooms.get(a));
                bookedrooms.remove(a);
            }

        } catch (Exception e) {
            System.out.println("Unvalid");
            tabort();
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
                        System.out.println("The name can't be added");
                        cont=false;
                    }else if(unbookedrooms.size()-1==i&&!unbookedrooms.get(i).getRoomname().equalsIgnoreCase(d)){
                        unbookedrooms.get(c).setRoomname(d);
                        System.out.println("Added");
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
            System.out.println("Enter new room name: ");
            String name = input.next();
            System.out.println("Enter new room price: ");
            int price = input.nextInt();
            System.out.println("Enter the number of beds: ");
            String beds=input.next();
            System.out.println("Enter the number of balconies: ");
            String balcony=input.next();
            System.out.println("Additional things?");
            String addit=input.next();
            String type=beds+" Beds "+balcony+" balconies "+addit;
            int i=0;
            while (cont){
                if (unbookedrooms.get(i).getRoomname().equalsIgnoreCase(name)){
                    System.out.println("The name can't be added");
                    cont=false;
                }else if(unbookedrooms.size()-1==i&&!unbookedrooms.get(i).getRoomname().equalsIgnoreCase(name)){
                    unbookedrooms.add(new Room(name,price,type));
                    System.out.println("Added");
                    cont=false;
                }
                i+=1;
            }
        } catch (Exception e){
            System.out.println("Unvalid");
            Menu();
        }

    }

    protected void removeRoom() {
        try {

            for (int i = 0; i < unbookedrooms.size(); i++) {
                System.out.println("[" + i + "]" + unbookedrooms.get(i));
                System.out.println("---------------");
            }
            System.out.println("Enter the room you would like to remove through index: ");
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
            System.out.println("Enter the name of the customer: ");
            c.setName(input.next());
            input.nextLine();
            System.out.println("Enter SSN of the customer: ");
            c.setSSN(input.next());
            input.nextLine();
            System.out.println("Enter address of the customer: ");
            c.setAdd(input.next());
            input.nextLine();
            System.out.println("Enter phone number of the customer: ");
            c.setNumber(input.next());
            input.nextLine();
            System.out.println("Confirm by yes: ");
            String s = input.nextLine();
            if (s.equalsIgnoreCase("yes")) {
                history.add(c);
                System.out.println("The Customer has been added!");
            }
        } catch (Exception e) {
            System.out.println("Unvalid");
        }
    }

    protected void removecus() {
        for (int a = 0; a < cus.size(); a++) {
            System.out.println("[" + a + "[" + cus.get(a));
            System.out.println("----------------");
        }

        System.out.println("Choose the index of the Customer: ");
        int a = input.nextInt();
        System.out.println("Do you want to remove customer? \n Confirm yes: ");
        String b = input.next();
        if (b.equalsIgnoreCase("yes")) {
            cus.remove(a);

        }


    }

    protected void editcus() {

        try {
            System.out.println("What would you like to change?");
            System.out.println("1)  Change the SSN.");
            System.out.println("2)  Change the name.");
            System.out.println("3)  Change the address.");
            System.out.println("4)  Change the phone number.");
            int a = input.nextInt();
            input.nextLine();
            if (a == 1) {
                for (int i = 0; i < history.size(); i++) {
                    System.out.println("[" + i + "]" + history.get(i));
                    System.out.println("---------------");
                }
                System.out.println("Enter the name index: ");
                int b = Integer.parseInt(input.nextLine());
                System.out.println("Enter the new SSN: ");
                history.get(b).setSSN(input.nextLine());
                System.out.println("The SSN has been changed!");

            } else if (a == 2) {
                for (int i = 0; i < history.size(); i++) {
                    System.out.println("[" + i + "]" + history.get(i));
                    System.out.println("---------------");
                }
                System.out.println("Enter the index: ");
                int q = Integer.parseInt(input.nextLine());
                System.out.println("Enter the new name: ");
                history.get(q).setName(input.nextLine());
                System.out.println("The name has been changed!");

            } else if (a == 3) {
                for (int i = 0; i < history.size(); i++) {
                    System.out.println("[" + i + "]" + history.get(i));
                    System.out.println("----------------");
                }
                System.out.println("Enter the index: ");
                int b = Integer.parseInt(input.nextLine());
                System.out.println("Enter the new address: ");
                history.get(b).setAdd(input.nextLine());
                System.out.println("The address has been changed!");
            } else if (a == 4) {
                for (int i = 0; i < history.size(); i++) {
                    System.out.println("[" + i + "]" + history.get(i));
                    System.out.println("----------------");
                }
                System.out.println("Enter the index: ");
                int u = Integer.parseInt(input.nextLine());
                System.out.println("Enter the new phone number: ");
                history.get(u).setNumber(input.nextLine());
                System.out.println("The phone number has been changed!");
            }

        } catch (Exception e) {
            System.out.println("Unvalid");
        }
    }

    protected void printcus() {

        for (int a = 0; a < history.size(); a++) {
            System.out.println("[" + (a + 1) + "]" + history.get(a));
            System.out.println("----------------");
        }
    }

    protected void genomlist() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm");
        for (int a = 0; a < history.size(); a++) {
            System.out.println("[" + a + "]" + history.get(a));
            System.out.println("----------------");
        }
        try {
            System.out.println("Choose a customer from the list by index: ");
            int a = input.nextInt();
            System.out.println("Enter the check-in date");
            history.get(a).setStart(sdf.parse(input.nextLine()));
            System.out.println("Enter check-out date");
            history.get(a).setEnd(sdf.parse(input.nextLine()));
            for (int i = 0; i < unbookedrooms.size(); i++) {
                System.out.println("---------------");
                System.out.println("[" + i + "]" + unbookedrooms.get(i));
            }
            System.out.println("Choose a room by index: ");
            int b = input.nextInt();
            System.out.println("Confirm by yes: ");
            String s = input.next();
            if (s.equalsIgnoreCase("yes")) {
                cus.add(history.get(a));
                bookedrooms.add(unbookedrooms.get(b));
                unbookedrooms.remove(b);
            }
        } catch (Exception e) {
            System.out.println("Unvalid");
            genomlist();
        }


    }

    private void editbook() {
        System.out.println("_______________");
        for (int i = 0; i < cus.size(); i++) {
            System.out.println("[" + i + "]");
            System.out.println("Room");
            System.out.println(bookedrooms.get(i));
            System.out.println();
            System.out.println("Booked by ");
            System.out.println(cus.get(i));
            System.out.println("---------------");
        }
        System.out.println("_______________");
        System.out.println("Choose index: ");
        int a = input.nextInt();
        System.out.println("1: Change room.");
        System.out.println("2: Change customer.");
        int b = input.nextInt();
        if (b == 1) {
            for (int i = 0; i < unbookedrooms.size(); i++) {
                System.out.println("[" + i + "]" + unbookedrooms.get(i));
                System.out.println("---------------");
            }
            System.out.println("Enter the room index: ");
            int c = input.nextInt();
            bookedrooms.add(unbookedrooms.get(c));
            unbookedrooms.add(bookedrooms.get(a));
            unbookedrooms.remove(c);
            cus.add(cus.get(a));
            cus.remove(a);
            bookedrooms.remove(a);


        } else if (b == 2) {
            System.out.println("1 Name.");
            System.out.println("2 SSN.");
            System.out.println("3 Address.");
            System.out.println("4 Number.");
            int d = input.nextInt();
            if (d == 1) {
                System.out.println("Enter new name: ");
                cus.get(a).setName(input.next());
                input.nextLine();
                for (int i = 0; i < history.size(); i++) {
                    if (history.get(i).getSSN().equalsIgnoreCase(cus.get(a).getSSN())) {
                        history.get(i).setName(cus.get(a).getName());
                    }
                }

                bookedrooms.add(bookedrooms.get(a));
                bookedrooms.remove(a);
                cus.add(cus.get(a));
                cus.remove(a);

            } else if (d == 2) {
                System.out.println("Enter new SSN: ");
                cus.get(a).setSSN(input.next());
                input.nextLine();
                for (int i = 0; i < history.size(); i++) {
                    if (history.get(i).getSSN().equalsIgnoreCase(cus.get(a).getSSN())) {
                        history.get(i).setSSN(cus.get(a).getSSN());
                    }
                    bookedrooms.add(bookedrooms.get(a));
                    bookedrooms.remove(a);
                    cus.add(cus.get(a));
                    cus.remove(a);
                }
            } else if (d == 3) {
                System.out.println("Add new adress: ");
                cus.get(a).setAdd(input.next());
                input.nextLine();
                for (int i = 0; i < history.size(); i++) {
                    if (history.get(i).getSSN().equalsIgnoreCase(cus.get(a).getSSN())) {
                        history.get(i).setAdd(cus.get(a).getAdd());
                    }
                    bookedrooms.add(bookedrooms.get(a));
                    bookedrooms.remove(a);
                    cus.add(cus.get(a));
                    cus.remove(a);
                }
            } else if (d == 4) {
                System.out.println("Add new number: ");
                cus.get(a).setNumber(input.next());
                input.nextLine();
                for (int i = 0; i < history.size(); i++) {
                    if (history.get(i).getSSN().equalsIgnoreCase(cus.get(a).getSSN())) {
                        history.get(i).setNumber(cus.get(a).getNumber());
                    }
                    bookedrooms.add(bookedrooms.get(a));
                    bookedrooms.remove(a);
                    cus.add(cus.get(a));
                    cus.remove(a);
                }


            }
        }
    } private void cuseditcus(){
        System.out.println("Enter you SSN: ");
        String s = input.nextLine();
        for (int i = 0; i<history.size(); i++) {
            if (history.get(i).getSSN().equalsIgnoreCase(s)) {
                System.out.println(history.get(i));
                try {
                    System.out.println("What would you like to change?");
                    System.out.println("1)  Change the SSN.");
                    System.out.println("2)  Change the name.");
                    System.out.println("3)  Change the address.");
                    System.out.println("4)  Change the phone number.");
                    System.out.println("5:  Return to menu.");
                    int a = Integer.parseInt(input.nextLine());

                    if (a == 1){
                        System.out.println("Enter the new SSN: ");
                        String b=input.nextLine();
                        for (int f=0;f<history.size();f++) {
                            if (history.get(f).getSSN().equalsIgnoreCase(s)) {
                                history.get(f).setSSN(b);
                            }
                        }
                        System.out.println("The SSN has been Changed!");
                        cusMenu();

                    }else if (a == 2){
                        System.out.println("Enter the new name: ");
                        String b = input.nextLine();
                        for(int f = 0; f<history.size();f++){
                            if (history.get(f).getSSN().equalsIgnoreCase(s)){
                                history.get(f).setName(b);
                            }
                            cusMenu();
                        }
                    }else if (a == 3){
                        System.out.println("Enter the new address: ");
                        String b = input.nextLine();
                        for (int f=0;f<history.size();f++){
                            if (history.get(f).getSSN().equalsIgnoreCase(s)){
                                history.get(f).setAdd(b);
                            }
                            cusMenu();
                        }
                    }else if (a == 4){
                        System.out.println("Enter the new phonenumber!");
                        String b = input.nextLine();
                        for (int f=0;f<history.size();f++){
                            if (history.get(f).getSSN().equalsIgnoreCase(s)){
                                history.get(f).setNumber(b);
                            }
                        }
                        cusMenu();
                    }else if(a==5){
                        cusMenu();
                    }
                }catch (Exception e) {
                    System.out.println("Unvalid");
                    Menu();
                }
            }
        }


            } private void cusMenu() {
        System.out.println("--------------MENU---------------");
        System.out.println("| 1)    Book a room.            |");
        System.out.println("| 2)    view your booking.      |");
        System.out.println("| 3)    Edit your information.  |");
        System.out.println("---------------------------------");
        int b = Integer.parseInt(input.nextLine());
        if (b == 1){
            bookascus();
        }else if (b == 2){
            viewbookcus();
        }else if (b == 3){
            cuseditcus();
        }
    }protected  void writetxt () {
        try {
            Path path = Paths.get("c:/Users/Romans Alaibi/Desktop/GitProjekt/Booking.txt");

            ArrayList<String> txtfile = new ArrayList<>();
            for (int i = 0; i < bookedrooms.size(); i++) {
                txtfile.add(i, "Booking number" + i);
                txtfile.add(i, String.valueOf(bookedrooms.get(i)));
            }

            Files.write(path, txtfile, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unvalid");
        }
    } protected void readtxt (){
        try {
            Path path = Paths.get("c:/Users/Romans Alaibi/Desktop/GitProjekt/Booking.txt");

            List<String> txtfile  = Files.readAllLines(path);
            for (int i=0;i<txtfile.size();i++ ){
                System.out.println(txtfile.get(i));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }private void bookascus() {
        System.out.println("Enter you SSN: ");
        String s = input.nextLine();
        int i;
        for (i = 0; i < history.size(); i++) {
            if (history.get(i).getSSN().equalsIgnoreCase(s)) {
                System.out.println(history.get(i));
            }
        }
        System.out.println("_______________");
        for (int z = 0; z < unbookedrooms.size(); z++) {
            System.out.println("[" + z + "]" + unbookedrooms.get(z));
            System.out.println("---------------");
        }
        System.out.println("Select the room you would like too book by index: ");
        int a = Integer.parseInt(input.nextLine());

        System.out.println("Confirm by yes: ");
        String y = input.next();

        if (y.equalsIgnoreCase("yes")) {
            cus.add(history.get(i));
            bookedrooms.add(unbookedrooms.get(a));
            unbookedrooms.remove(a);
        }


    }private void viewbookcus() {
        System.out.println("Enter you SSN: ");
        String s = input.nextLine();
        for (int i = 0; i < history.size(); i++) {
            if (history.get(i).getSSN().equalsIgnoreCase(s)) {
                System.out.println(history.get(i));
                System.out.println("Bookings: " + cus.get(i));
            }

        }
        System.out.println("Enter '00' to go to meny");
        int h = input.nextInt();
        if (h == 00){
            cusMenu();
        }
    }

}