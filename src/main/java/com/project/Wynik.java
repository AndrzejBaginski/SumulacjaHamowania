package com.project;

public class Wynik {
    public double wynik(int predkosc, double czas, double wspolczynnikSamochod , double wspolczynnik){
        double wynik;
        if(predkosc==0){
            wynik=0;
        } else {
            wynik = predkosc*(czas/3.6)+(wspolczynnikSamochod*(predkosc*predkosc)/(135*wspolczynnik))+5 ;
        }


    return wynik;
    }



}
