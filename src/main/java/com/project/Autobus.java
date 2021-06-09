package com.project;

import java.util.Random;

public class Autobus extends Samochod {
    Random rand = new Random();

    int liczbaOsi = 3;
    public int  losujMase(){
        masa = rand.nextInt(7500) + 7500;
        return masa;
    }

}


