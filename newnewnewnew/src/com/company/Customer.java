package com.company;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
public class Customer {
    private String name;
    private String SSN;
    private String add;
    private String number;
    private Date start;
    private Date end;

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

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStart() {
        return start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getEnd() {
        return end;
    }

    public String toString() {
        return String.format("%nName: %s%nSSN: %s%nAdress: %s%nNumber: %s%nCheck-in date %s%nCheck-out date %s%n",name,SSN,add,number,start,end);
    }
}