package com.company;

import java.util.Random;

public class Cheetah extends Animal{

        private int speed = 2;
        private Location location;
        boolean alive = true;
        boolean full = false;

        Cheetah(){
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


