package com.company;


import java.util.Random;

public abstract class Animal implements ifMove {

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

    public void move(Location location) {
        Random rand = new Random();
        int r = rand.nextInt((4));

        int newRight = location.getX() + 1;
        int newUp = location.getY() + 1;
        int newLeft = location.getX() - 1;
        int newDown = location.getY() - 1;
        int plan = 10;
        switch (r) {

            case 0:
                if (newRight < plan) {
                    location.setX(newRight); //newRight
                } else if (newDown >= 0) {
                    location.setY(newDown);
                } else {
                    location.setX(newLeft);
                }
                break;

            case 1:
                if (newUp < plan) {
                    location.setY(newUp);
                } else if (newRight < plan) {
                    location.setX(newRight);
                } else {
                    location.setY(newDown);
                }
                break;

            case 2:
                if (newLeft >= 0) {
                    location.setX(newLeft);
                } else if (newUp < plan) {
                    location.setY(newUp);
                } else {
                    location.setX(newRight);
                }
                break;

            case 3:
                if (newDown >= 0) {
                    location.setY(newDown);
                } else if (newLeft >= 0) {
                    location.setX(newLeft);
                } else {
                    location.setY(newUp);
                }
                break;

            default:
                break;

        }

    }
}





