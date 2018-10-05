package com.company;

import java.util.Random;

public class Zebra extends Animal {

    private int speed = 1;
    private Location location;
    boolean alive = true;

    Zebra(){
        Random rand = new Random();
        int rX = rand.nextInt((10) + 1);
        int rY = rand.nextInt((10) + 1);
        location = new Location(rX, rY);
    }

    @Override
    void print(){
        System.out.println(location.getX() + " " + location.getY());
    }
}
