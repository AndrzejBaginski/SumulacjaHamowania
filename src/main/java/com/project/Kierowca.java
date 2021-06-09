package com.project;

public class Kierowca {
    /**
     *
     * @param wadaWzroku-> +wadaWzroku[T/N] if T -> 0,32
     * @param plec-> +plec[K/M] if K -> 0,027(kobieta=1)
     * @param zmeczenie-> +zmeczenie[0-10]*0,1
     * @param wiek-> +wiek[lata]*0,02
     * @param iloscAlkoholu-> +stanAlkohol[promile]*5
     * @param prawoJazdy-> -prawoJazdy[miesiace]*0,002
     * @return czas-> czasReakcji[sekundy]
     */

    //Obliczenie czasu reakcji kierowcy
    public double czasReakcjiKierowcy(boolean wadaWzroku , String plec , int zmeczenie , int wiek , double iloscAlkoholu , int prawoJazdy){

        double czas;
        czas = (zmeczenie*0.1)+(intwadaWzroku(wadaWzroku)*0.32)+(wiek*0.02)+(intPlec(plec)*0.027)-(prawoJazdy*0.002)+(iloscAlkoholu*5)+0.5;
        return czas; // zwrócenie czasu w sekundach
    }


    public int intwadaWzroku(boolean wadaWzroku){
        if(wadaWzroku)//Zamiana na wartość liczbową
            return 1;
        else
            return 0;
    }
    public int intPlec(String plec){
        if(plec.equals("Kobieta"))//Zamiana na wartość liczbową
            return 1;
        else
            return 0;
    }
}
