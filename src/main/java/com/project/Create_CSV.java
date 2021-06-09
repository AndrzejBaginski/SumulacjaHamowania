package com.project;

import java.io.*;

public class Create_CSV {
    public void print(String  pojazd, int  masa, int predkosc, double czas, double wspolczynnik, double wspolczynnikSamochod , double w) throws IOException {
        File file = new File("dane.csv");
        if (!file.exists()) {
            FileWriter fw = new FileWriter("dane.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println("Rodzaj pojazdu ; Masa pojazdu [kg] ; Predkosc [km/h] ; Czas reakcji [s] ; Wspolczynnik nawierzchni ; Wspolczynnik pojazdu ; Droga zatrzymania [m] ");
            out.println(pojazd + "; " + masa + "; " + predkosc + "; "  + RoundToTwo.roundTo2DecimalPlace(czas) + "; " + RoundToTwo.roundTo2DecimalPlace(wspolczynnik)+ "; "+ RoundToTwo.roundTo2DecimalPlace(wspolczynnikSamochod)+ "; "+ RoundToTwo.roundTo2DecimalPlace(w));
            out.flush();
            out.close();
        }
        else{
        FileWriter fw = new FileWriter("dane.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);

        out.println(pojazd + "; " + masa + "; " + predkosc + "; "  + RoundToTwo.roundTo2DecimalPlace(czas) + "; " + RoundToTwo.roundTo2DecimalPlace(wspolczynnik)+ "; "+ RoundToTwo.roundTo2DecimalPlace(wspolczynnikSamochod)+ "; "+ RoundToTwo.roundTo2DecimalPlace(w));
        out.flush();
        out.close();
    }
    }
}

