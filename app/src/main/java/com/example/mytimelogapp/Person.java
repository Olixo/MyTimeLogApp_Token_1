package com.example.mytimelogapp;

import java.io.Serializable;

public class Person implements Serializable {
    // attributes
    private String name;
    private int time;
    private int date;
    private int timeOut;
    private String message;

    public Person() { //default constructor
        this.name = "NoName";
        this.time = 2358;
        this.date = 01012021;
        this. timeOut = 2359;
        this.message = "Dafault parameters initiated: Name: " + name + ", Time: " + time + ", Date: " + date + ", TimeOut: " + timeOut;
    }

    public Person(String name) {
        this.name = name;
        this.time = 830;
        this.date = 01012021;
        this.timeOut = 1630; // give default time, date and timeOut
        this.message = "Name has been given: " + name + "Time, Date and Timeout will use default values. Time : " + time + ", Date: " + date + ", Timeout: " + timeOut;
    }


    public Person(String name, int time, int date, int timeOut) {
        this.name = name;
        this.time = time;
        this.date = date;
        this.timeOut = timeOut;
        this.message = "LOGGED. Your name: " + name + ", has checked in at: " + time + ", on the day: " + date + "and checked out at: " + timeOut;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getDate() {
        return date;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
