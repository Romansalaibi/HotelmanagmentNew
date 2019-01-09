package com.company;

public class Room extends Customer{
    private String roomname;
    private int price;
    private String type;
    public Room(String roomname , int price, String type) {
        this.roomname=roomname;
        this.price=price;
        this.type=type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getRoomname() {
        return roomname;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return String.format("Room: %s%nPrice: %d%nType: %s%nCheck-in date %s%nCheck-out date %s%nChecked in %s%nChecked out %s%n",roomname,price,type,getStart(),getEnd(),getChecked(),getOut());
    }
}