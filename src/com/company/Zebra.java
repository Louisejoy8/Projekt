package com.company;

import java.util.Random;

public class Zebra extends Animal {

    private int speed = 1;
    Location location;
    boolean alive = true;


    Zebra(){
        Random rand = new Random();
        int rX = rand.nextInt(10);  //Behöver hitta ett sätt att koppla denna till gui.getSize
        int rY = rand.nextInt(10);  //Behöver hitta ett sätt att koppla denna till gui.getSize
        location = new Location(rX, rY);
    }


    public boolean getAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    void print(){
        System.out.println("Zebra " + "Location: " + location.getX() + ", " + location.getY());
    }

    @Override
    public void move() {
    super.move(location);
    }
}
