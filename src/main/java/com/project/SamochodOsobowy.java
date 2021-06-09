package com.project;

import java.util.Random;


public class SamochodOsobowy extends Samochod {
    Random rand = new Random();

    int liczbaOsi = 2;

    public int losujMase(){
        masa = rand.nextInt(850) + 2650;
        //System.out.println(masa);
        return masa;
    }


}
