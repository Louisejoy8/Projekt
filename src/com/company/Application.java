package com.company;
import java.util.Arrays;

public class Application {

    Input input = new Input();

    Application() {

//        numbersZebra();
//        numbersCheetah();
        int max = 100;
        boolean check = false;
        while(check == false){

            int valueZ = numbersZebra();
            Zebra[] z = new Zebra[valueZ];
            for (int i = 0; i < valueZ; i++) {
                z[i] = new Zebra();
            }

            for (Zebra zebra : z) {
                zebra.print();
            }

            int valueC = numbersCheetah();
            Cheetah[] c = new Cheetah[valueC];
            for (int i = 0; i < valueC; i++) {
                c[i] = new Cheetah();
            }

            for (Cheetah cheetah : c) {
                cheetah.print();
            }

            if (max <= z.length + c.length) {
                System.out.println("För många djur. Max 100");
            } else if (z.length < c.length) {
                System.out.println("För många geparder");
            } else
                check = true;
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
        System.out.println(zebra);
        return zebra;

    }

    int numbersCheetah() {
        int cheetah;
        do {
            System.out.println("How many cheetahs?");
            cheetah = input.tryForInt();
        } while (cheetah == -1);
        System.out.println(cheetah);
        return cheetah;

    }


}
