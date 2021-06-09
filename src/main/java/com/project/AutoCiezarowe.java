package com.project;

import java.util.Random;

public class AutoCiezarowe extends Samochod {
    Random rand = new Random();

    int liczbaOsi = 4;
    public int losujMase(){
        masa = rand.nextInt(3500) + 4000;
        return masa;
    }

}
