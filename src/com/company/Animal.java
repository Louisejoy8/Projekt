package com.company;

import com.sun.jdi.LocalVariable;

import java.util.Random;

public class Animal {


    int speed;
    Location location;


    Animal() {

    }

    void setLocation(Location location) {
        this.location = new Location();
    }

    Location getLocation() {
        return location;
    }

    void print() {
    }

    void move() {
        Random rand = new Random();
        int r = rand.nextInt((4) + 1);

        int newXUp = location.getX() + 1;
        int newYUp = location.getY() + 1;
        int newXDown = location.getX() - 1;
        int newYDown = location.getY() - 1;
        int plan = 10;
        switch (r) {


            case 1:
                if (plan > newXUp) {
                    location.setX(location.getX() + 1);
                } else if (plan > newYUp) {
                    location.setY(location.getY() - 1);
                } else {
                    location.setX(location.getX() - 1);
                }
                break;

            case 2:
                location.setY(location.getY() + 1);
                break;

            case 3:
                if (plan > newXDown) {
                    location.setX(location.getX() - 1);
                } else if (plan > newYDown) {
                    location.setY(location.getY() + 1);
                } else {
                    location.setX(location.getX() + 1);
                }

                break;

            case 4:
                location.setY(location.getY() - 1);
                break;

            default:
                break;

        }
    }


}
