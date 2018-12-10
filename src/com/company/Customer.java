package com.company;

public class Customer {
    private String name;
    private String SSN;
    private String add;
    private String number;

    public void setName(String name) {
        this.name = name;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getSSN() {
        return SSN;
    }

    public String getAdd() {
        return add;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return String.format("%nName: %s%nSSN: %s%nAdress: %s%nNumber: %s%n",name,SSN,add,number);
    }
}
