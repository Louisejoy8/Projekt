package com.company;

import java.io.Console;
import java.util.*;

public class Application {


    boolean quite = false;
    Input input = new Input();
    GUI gui = new GUI(10);
    Status status = Status.STOP;
    Zebra[] z;
    Cheetah[] c;
    int round = 1;
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

                    if (max < z.length + c.length) {
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

                System.out.println("Round: " + round);

//                gui.fill();
                Scanner hej = new Scanner(System.in);
//                int j=0;
//                int testsped= c[j].getSpeed();
//                System.out.print(testsped);
//                while (j <= c[j].getSpeed()) {
//                    gui.fill();
////                    gui.reset(c[j].getLocation());
//                    moveChita();
//                    j++;
//                }
                for (int j = 0; j < c.length; j++) {
                    if(j < c[j].getSpeed()) {
                        gui.fill();
//                    gui.reset(c[j].getLocation());
                     moveChita();
                        System.out.println(j + "getfullc" + c[j].getFull());
//                        if(c[j].getFull() == true) {
//                            c[j].setTillHungry(c[j].getTillHungry()-1);
//                        }

                    }else {}
                }
                for (int i = 0; i < z.length; i++) {
                    if(i < z[i].getSpeed()) {
//                    gui.reset(z[i].getLocation());
                        moveZebra();
                    }else {}
                }


//kalas på timer

                gui.print();
                hej.nextLine();

                // TODO


//                for (int i = 0; i < z.length; i++) {
//                    for (int j = 0; j < c.length; j++) {
//                        if (z[i].getLocation().getX() == c[j].getLocation().getX() && z[i].getLocation().getY() == c[j].getLocation().getY()) {
//                            //&& c[j].getFull() == false
//                            z[i].setAlive(false);
//                            z[i].setDead();
//                            c[j].setFull(true);
//                            System.out.print("-----------------------------------------C" + j + " äter " + "Z" + i + "\n");
//
//                        }
//
//
//
//                        if(c[j].getFull() == true && round%4 == 0){
//                            c[j].setFull(false);
//                            System.out.print(j + "Hungriga");
//                        }
//
//
//                    }
//                }


//                System.out.println("Efter måltid!");
//                for (int i = 0; i < z.length; i++) {
//
//                    if (z[i].getAlive() == true) {
//                        System.out.print(i + " ");
//                        z[i].print();
//                    }
//                }

                int zebrasAlive = 0;
                for (int i = 0; i < z.length; i++) {    //Går ingom z[] och ser hur många objekt som har värdet alive == true
                    if (z[i].getAlive() == true) {
                        zebrasAlive++;
                    }
                }
                if (zebrasAlive < c.length) {   //Om zebrasAlive < antalet i c
                    status = Status.STOP;       //status ändras till STOP och programmet startar om
                }
                round++;
                System.out.println();
                System.out.println();
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

    public void colition() {
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (z[i].getLocation().getX() == c[j].getLocation().getX() && z[i].getLocation().getY() == c[j].getLocation().getY() && c[j].getFull() == 0) {
                    //&& c[j].getFull() == false
                    z[i].setAlive(false);
                    z[i].setDead();
                    c[j].setFull(5);
                    System.out.print("-----------------------------------------C" + j + " äter " + "Z" + i + "\n");

                }
            }
        }
    }

    public void moveChita() {
        for (int j = 0; j < c.length; j++) {
            c[j].move();
            gui.setCheetah(new Location(c[j].getLocation().getX(), c[j].getLocation().getY()));

            System.out.print(j + " ");
            if(c[j].getFull() > 0) {
                c[j].setFull(c[j].getFull() - 1);
            }
            c[j].print();
            colition();
        }
    }

    public void moveZebra() {
        for (int i = 0; i < z.length; i++) {  //om z.getAlive == true z.move()
            if (z[i].getAlive() == true) {
                z[i].move();
                gui.setZebra(new Location(z[i].getLocation().getX(), z[i].getLocation().getY()));

                 System.out.print(i + " ");
                z[i].print();
                colition();
            }
        }
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
