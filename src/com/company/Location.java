package com.company;

public class Location {
    int x;
    int y;

    Location(){
        x = 1;
        y = 1;
    }

    Location(int x, int y){
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(x > 0)
            this.x = x;
        else
            this.x = 1;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(y > 0)
            this.y = y;
        else
            this.y = 1;
    }
}
