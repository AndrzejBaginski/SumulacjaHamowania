package com.project;

import java.util.Random;

public class Tir extends Samochod {

    Random rand = new Random();

    int liczbaOsi = 6;
    public int losujMase() {
        masa = rand.nextInt(17500) + 32500;
        return masa;
    }
}
