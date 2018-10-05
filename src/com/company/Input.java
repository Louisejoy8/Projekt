package com.company;

import java.util.Scanner;

public class Input {

    Scanner scan = new Scanner(System.in);

    Input() {
    }


    int tryForInt() {
        try {
            String ss = scan.next();
            int i = Integer.parseInt(ss);
            if (i > 0) {
                System.out.println(i);
                return i;

            } else {
                System.out.println("Fel, negativt tal");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Fel");
            return -1;
        }
    }

}
