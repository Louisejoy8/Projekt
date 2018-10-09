package com.company;


public class GUI{

    Input input = new Input();
    int maxGbSize = 50;
    int minGbSize = 10;

    int size;
    String[][] gui;



    GUI(){
        size = 10;
        gui = new String[size][size];
    }

    GUI(int size){
        gui = new String[size][size];
    }

    public int getSize() {
        return size;
    }

    public String[][] getGui() {
        return gui;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setZebra(Location location){
        gui[location.getX()][location.getY()] = "Z";
    }

    public void setCheetah(Location location){
       gui[location.getX()][location.getY()] = "C";
    }

    public void reset(Location location){
        gui[location.getX()][location.getY()] = "-";
    }

    void print() {
        for(String[] x : gui){
            for(String y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    void fill(){
        for(int x = 0; x < gui.length; x++){
            for(int y = 0; y < gui[x].length; y++){
                gui[x][y] = "-";
            }
        }
    }
     int gameboardSize(){
        int i;
        int size = -1;
        do {
            System.out.println("How big do you want the gameboard? Number between 10-50");
            i = input.tryForInt();
            if(i < minGbSize || i > maxGbSize ){
                System.out.println("Try again");
            } else {
                size = i;
            }
        }while(size == -1);
        System.out.println(size);
        return size;
//        setSize(size);
    }
}
