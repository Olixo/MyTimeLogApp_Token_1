package com.example.mytimelogapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person("Terra", 830, 01012021, 1730);
    }

    @Test
    public void getName() {
        String name = person.getName();
        assertEquals(name, "Terra");
    }

    @Test
    public void getTime() {
        int time = person.getTime();
        assertEquals(time, 830);
    }

    @Test
    public void getDate() {
        int date = person.getDate();
        assertEquals(date, 01012021);
    }

    @Test
    public void getTimeOut() {
        int timeOut = person.getTimeOut();
        assertEquals(timeOut, 1730);
    }

    @Test
    public void getMessage() {
        String message =
    }
}