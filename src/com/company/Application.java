package com.company;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {


    boolean quite = false;
    Input input = new Input();
    GUI gui = new GUI(10);
    Status status = Status.STOP;
    Zebra[] z;
    Cheetah[] c;
    int m = 1;
//    status = Status.STOP;


    Application() {

        while (quite == false) {
            while (status == Status.STOP) {
                gui.fill();     //Nytt
//        gui.print();    //Nytt


                int max = 100;
                boolean check = false;

                while (check == false) {

                    int valueZ = numbersZebra();
                    z = new Zebra[valueZ];
                    for (int i = 0; i < valueZ; i++) {

                        z[i] = new Zebra();
                        gui.setZebra(new Location(z[i].getLocation().getX(), z[i].getLocation().getY())); //Nytt
                    }

                    for (Zebra zebra : z) {
                        zebra.print();
                    }




                    int valueC = numbersCheetah();
                    c = new Cheetah[valueC];
                    for (int i = 0; i < valueC; i++) {
                        c[i] = new Cheetah();
                        gui.setCheetah(new Location(c[i].getLocation().getX(), c[i].getLocation().getY())); //Nytt
                    }

                    for (Cheetah cheetah : c) {
                        cheetah.print();
                    }

                    if (max <= z.length + c.length) {
                        System.out.println("Too many animals. Max 100.");
                    } else if (z.length < c.length) {
                        System.out.println("Too many cheethas.");
                    } else
                        check = true;
                }

                gui.print();
                status = Status.START;
            }
//        numbersZebra();
//        numbersCheetah();
//
//        gui.gameboardSize();
//        gui.gameboardSize();


            while (status == Status.START) {
                //Kolla på lösning för utskift
//                z[1] = null;
//                if(z[1] == null) {
//                    System.out.println("HEJASJHDHASD");
//                }
                for (int i = 0; i < z.length; i++) {
                    if (z[i].getAlive() == true) {
                        z[i].move();
                        System.out.print(i);
                        z[i].print();
                    }
                }

                for (int i = 0; i < c.length; i++) {
                    c[i].move();
                    c[i].print();
                }

                for (int i = 0; i < z.length; i++) {
                    for (int j = 0; j < c.length; j++) {
                        if (z[i].getLocation().getX() == c[j].getLocation().getX() && z[i].getLocation().getY() == c[j].getLocation().getY()) {
                            //&& c[j].getFull() == false
                            z[i].setAlive(false);
                            z[i].setLocation(new Location(99,99));
                            c[j].setFull(true);
                            System.out.print("C: " + j + "Äter" + "Z " + i + "\n");

                        }

                        /*


                        if(c[j].getFull() == true && m%4 == 0){
                            c[j].setFull(false);
                            System.out.print(j + "Hungriga");
                        }
                        */

                    }
                }

                int a = 0;
                for (int i = 0; i < z.length; i++) {
                    if(z[i].getAlive() == true) {
                        a++;
                    }
                }


                for (int i = 0; i < z.length; i++) {
                    if (z[i].getAlive() == true) {
                        System.out.println();
                        System.out.print(i);
                        z[i].print();
                    }
                }

                if (a < c.length) {
                    status = Status.STOP;
                }
                m++;
                System.out.print(m);
                for (int i = 0; i < 1; ++i) System.out.println();
            }

            status = Status.STOP;
        }
    }


    //reprint ej mer än 100 djur
//


    int numbersZebra() {
        int zebra;
        do {
            System.out.println("How many zebras?");
            zebra = input.tryForInt();
        } while (zebra == -1);
        System.out.println("Zebras: " + zebra);
        return zebra;

    }

    int numbersCheetah() {
        int cheetah;
        do {
            System.out.println("How many cheetahs?");
            cheetah = input.tryForInt();
        } while (cheetah == -1);
        System.out.println("Cheetahs: " + cheetah);
        return cheetah;

    }

//    int gameboardSize(){
//
//        int test;
//        int gbSize = -1;
//        do {
//            System.out.println("How big do you want the gameboard? Number between 10-50");
//            test = input.tryForInt();
//            if(test < 10 || test > 50 ){
//                System.out.println("Try again");
//            } else {
//                gbSize = test;
//            }
//        }while(gbSize == -1);
//        System.out.println(gbSize);
//        return gbSize;
//
//    }


}
