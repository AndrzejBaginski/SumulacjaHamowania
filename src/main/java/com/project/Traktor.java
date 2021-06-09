package com.project;

import java.util.Random;

public class Traktor extends Samochod {

    Random rand = new Random();
    int liczbaOsi = 2;
    public int  losujMase(){
        masa = rand.nextInt(2000) + 8000;
        return masa;
    }


}