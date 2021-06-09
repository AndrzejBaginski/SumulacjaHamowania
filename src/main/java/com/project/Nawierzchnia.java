package com.project;

public class Nawierzchnia {



    /**
     * @param typNawierzchni-> +Asfalt = 1, Beton=Asfalt*1.1 , Kostka brukowa=Asfalt*1.3 , Gruntowa=Asfalt*1.6
     */
    public double doubleTypNawierzchni(String typNawierzchni) {

        return switch (typNawierzchni) {
            case "Asfalt" -> 1;
            case "Beton" -> 1.1;
            case "Kostka brukowa" -> 1.3;
            case "Droga gruntowa" -> 1.6;
            default -> 1;
        };
    }

    /**
     *
     * @param stanNawierzchni+Sucha = 1, Mokra = Sucha*1.4 , Lód = Sucha*3 , Snieg = Sucha*2
     */
    public double doubleStanNawierzchni(String stanNawierzchni) {
        return switch (stanNawierzchni) {
            case "Sucha" -> 1;
            case "Piasek" -> 1.2;
            case "Mokra" -> 1.4;
            case "Lód" -> 3;
            case "Śnieg" -> 2;
            default -> 1;
        };

    }

    /**
     * @param nachylenie->[-12,12]
     * @return wspolczynnikNawierzchni-> typNawierzchni*stanNawierzchni+nachylenie
     */
    public double wspolczynnikNawierzchni(String typNawierzchni , String stanNawierzchni , int nachylenie){
        double wspolczynnik;
        wspolczynnik = 1/((doubleTypNawierzchni(typNawierzchni)*doubleStanNawierzchni(stanNawierzchni)+nachylenie*-0.05));
        return wspolczynnik;

    }





}
