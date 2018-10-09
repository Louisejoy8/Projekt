package com.company;

import java.util.Random;

public class Cheetah extends Animal{

        private int speed = 2;
        private Location location;
        private int full = 0;


        Cheetah(){
            Random rand = new Random();
            int rX = rand.nextInt(10);  //Behöver hitta ett sätt att koppla denna till gui.getSize
            int rY = rand.nextInt(10);  //Behöver hitta ett sätt att koppla denna till gui.getSize
            location = new Location(rX, rY);
        }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    public void setFull(int full){
            this.full = full;
    }

    public int getFull(){
            return full;
    }

    public int getSpeed() {
        return speed;
    }




    @Override
        void print(){
            System.out.println("Cheetah " + "Location: " + location.getX() + ", " + location.getY());
        }

    @Override
    public void move(){
            super.move(location);
    }

    }


