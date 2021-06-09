package com.project;

public class Samochod{
    /**
     *
     * @param masa-> +masa[kg]-> 1/(masa*0,001)
     * @param sprawnoscHamulca-> +sprawnoscHamulca[0-100]*0,01
     * @param stanOpon-> *stanOpon[0-100]*0,01
     * @param abs> +abs[boolean]
     * @param iloscOsi-> +iloscOsi[int]0,01
     * @return wspolczynnik-> wspolczynnikUdzialuSamochodu
     */


    int masa;



        public int intAbs(boolean abs){
            if(abs)//Zamiana na wartość liczbową
                return 1;
            else
                return 0;
        }

    public double wspolczynnikSamochod(int sprawnoscHamulca , int stanOpon , int masa , boolean abs, int iloscOsi ){
        double wspolczynnik;
        wspolczynnik=1/((masa*0.001)+sprawnoscHamulca*0.01*stanOpon*0.01+intAbs(abs)+(iloscOsi*0.01));//Obliczenie wspolczynnika udzialu stanu pojazdu w drodze hamowania
        return wspolczynnik;


    }


}
