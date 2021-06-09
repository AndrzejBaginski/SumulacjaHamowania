package com.project;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Okno extends JFrame  implements ActionListener, ChangeListener  {

    private JLabel jHamulec;
    private JLabel jOpona;
    private JLabel jTest;
    private JComboBox comboPojazd;
    private JTextField wpiszPredkosc;
    private JSlider sHamulec, sOpona;
    private JCheckBox chAbs;
    private JButton bRand, bOblicz;


    private JLabel jZmeczenie;
    private JRadioButton rbMezczyzna, rbKobieta;
    private JCheckBox chWzrok;
    private JSlider sZmeczenie;
    private JTextField tWiek, tPrawoJazdy,tAlkohol;

    private JLabel jNachylenie;
    private JComboBox comboNawierzchnia, comboStan;
    private JSlider sNachylenie;

    int predkosc, sprawnoscHamulca, stanOpon, masa, wiek, prawoJazdy, zmeczenie, nachylenie, iloscOsi; //Do tych sie przypisuja wartosci
    double iloscAlkoholu; //Do tych sie przypisuja wartosci
    boolean abs,wadaWzroku; //Do tych sie przypisuja wartosci
    String pojazd, plec, typ_Nawierzchni, stan_Nawierzchni; //Do tych sie przypisuja wartosci

    //Wszystkie wartosci przypisuja sie dopiero po kliknieciu przyciusku oblicz.
    //mozesz zmienic plik wyjsciowy csv, bo go nie zaktualizowałem



    List<String> rodzajPojazdu  = new ArrayList<>();

    public void RodzajPojazdu() {
        rodzajPojazdu.add("Samochod osobowy");
        rodzajPojazdu.add("Auto ciezarowe");
        rodzajPojazdu.add("Autobus");
        rodzajPojazdu.add("Tir");
        rodzajPojazdu.add("Traktor");
    }
    List<String> typNawierzchni  = new ArrayList<>();
    public void TypNawierzchni(){
        typNawierzchni.add("Asfalt");
        typNawierzchni.add("Beton");
        typNawierzchni.add("Kostka brukowa");
        typNawierzchni.add("Droga gruntowa");
    }
    List<String> stanNawierzchni  = new ArrayList<>();
    public void StanNawierzchni(){
        stanNawierzchni.add("Sucha");
        stanNawierzchni.add("Mokra");
        stanNawierzchni.add("Piasek");
        stanNawierzchni.add("Lód");
        stanNawierzchni.add("Śnieg");
    }


    public  void okno(){
        RodzajPojazdu();
        TypNawierzchni();
        StanNawierzchni();
        setTitle("Programowanie obiektowe");
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setResizable(false);
        setLayout(null);


        JLabel jnaglowek = new JLabel("Symulacja drogi hamowania pojazdu kołowego");
        jnaglowek.setBounds(10,0,300,20);
        add(jnaglowek);

        bRand = new JButton("Losuj dane");
        bRand.setBounds(500,30,100,20);
        bRand.addActionListener(this);
        add(bRand);

        JLabel jPojazd = new JLabel("Rodzaj pojazdu:");
        jPojazd.setBounds(10,30,90,20);
        add(jPojazd);

        comboPojazd = new JComboBox();
        comboPojazd.setBounds(105,30,150,20);


        for (String value : rodzajPojazdu) {
            comboPojazd.addItem(value);
        }
        add(comboPojazd);

        JLabel jPredkosc = new JLabel("Predkosc:");
        jPredkosc.setBounds(10,60,90,20);
        add(jPredkosc);

        wpiszPredkosc = new JTextField(3);
        wpiszPredkosc.setBounds(80,60,90,20);
        add(wpiszPredkosc);

        jHamulec = new JLabel("Sprawność hamulca: ");
        jHamulec.setBounds(10,90,150,20);
        add(jHamulec);

        sHamulec = new JSlider(0, 100, 0);
        sHamulec.setBounds(0,120,300,50);
        sHamulec.setMajorTickSpacing(20);
        sHamulec.setMinorTickSpacing(5);
        sHamulec.setPaintLabels(true);
        sHamulec.setPaintTicks(true);
        sHamulec.addChangeListener(this);
        add(sHamulec);

        chAbs = new JCheckBox("Posiada ABS");
        chAbs.setBounds(200,90,100,20);
        add(chAbs);

        jOpona = new JLabel("Stan opon: ");
        jOpona.setBounds(330,90,150,20);
        add(jOpona);

        sOpona = new JSlider(0, 100, 0);
        sOpona.setBounds(330,120,300,50);
        sOpona.setMajorTickSpacing(20);
        sOpona.setMinorTickSpacing(5);
        sOpona.setPaintLabels(true);
        sOpona.setPaintTicks(true);
        sOpona.addChangeListener(this);
        add(sOpona);

        JLabel jCzlowiek = new JLabel("com.project.Kierowca:");
        jCzlowiek.setBounds(10,180,70,20);
        add(jCzlowiek);

        ButtonGroup bgPlec = new ButtonGroup();
        rbMezczyzna = new JRadioButton("Mężczyzna", true);
        rbMezczyzna.setBounds(10, 200, 100,20);
        rbKobieta = new JRadioButton("Kobieta", false);
        rbKobieta.setBounds(10, 220, 100,20);
        rbMezczyzna.addActionListener(this);
        rbKobieta.addActionListener(this);
        bgPlec.add(rbMezczyzna);
        bgPlec.add(rbKobieta);
        add(rbMezczyzna);
        add(rbKobieta);

        chWzrok = new JCheckBox("Wada wzroku");
        chWzrok.setBounds(150,210,150,20);
        add(chWzrok);


        jZmeczenie = new JLabel("Zmęczenie: ");
        jZmeczenie.setBounds(330,180,100,20);
        add(jZmeczenie);


        sZmeczenie = new JSlider(0,10,0);
        sZmeczenie.setBounds(330,210,200,50);
        sZmeczenie.setMajorTickSpacing(1);
        sZmeczenie.setPaintTicks(true);
        sZmeczenie.setPaintLabels(true);
        sZmeczenie.addChangeListener(this);
        add(sZmeczenie);

        JLabel jWiek = new JLabel("Wiek: ");
        jWiek.setBounds(10,260,50,20);
        add(jWiek);

        tWiek = new JTextField(2);
        tWiek.setBounds(50,260,50,20);
        add(tWiek);

        JLabel jPrawoJazdy = new JLabel("Prawo jazdy(w miesiącach): ");
        jPrawoJazdy.setBounds(10,285,170,20);
        add(jPrawoJazdy);

        tPrawoJazdy = new JTextField(3);
        tPrawoJazdy.setBounds(175,285,50,20);
        add(tPrawoJazdy);

        JLabel jAlkohol = new JLabel("Ilość alkoholu w organiźmie(promile): ");
        jAlkohol.setBounds(10,310,220,20);
        add(jAlkohol);

        tAlkohol = new JTextField(3);
        tAlkohol.setBounds(225,310,50,20);
        add(tAlkohol);

        JLabel jTypNawierzchni = new JLabel("Typ nawierzchni: ");
        jTypNawierzchni.setBounds(10,340,100,20);
        add(jTypNawierzchni);
        comboNawierzchnia = new JComboBox();
        comboNawierzchnia.setBounds(110,340,110,20);
        for (String item : typNawierzchni) {
            comboNawierzchnia.addItem(item);
        }
        add(comboNawierzchnia);

        JLabel jStanNawierzchni = new JLabel("Stan nawierzchni: ");
        jStanNawierzchni.setBounds(10,365,110,20);
        add(jStanNawierzchni);
        comboStan = new JComboBox();
        comboStan.setBounds(115,365,110,20);
        for (String value : stanNawierzchni) {
            comboStan.addItem(value);
        }
        add(comboStan);

        jNachylenie = new JLabel("Nachylenie [%]: ");
        jNachylenie.setBounds(10,390,100,20);
        add(jNachylenie);

        sNachylenie = new JSlider(-12,12);
        sNachylenie.setBounds(0,410,280, 50);
        sNachylenie.setMajorTickSpacing(2);
        sNachylenie.setPaintTicks(true);
        sNachylenie.setPaintLabels(true);
        sNachylenie.addChangeListener(this);
        add(sNachylenie);







        bOblicz = new JButton("Oblicz");
        bOblicz.setBounds(610,30,100,20);
        bOblicz.addActionListener(this);
        add(bOblicz);


        jTest = new JLabel("Droga hamowania: ");
        jTest.setBounds(500,500,300,20);
        add(jTest);



    }


    @Override
    public void actionPerformed(ActionEvent e)  {
        Random random = new Random();
        Object przycisk = e.getSource();
        if(przycisk == bRand){
            comboPojazd.setSelectedIndex(random.nextInt(rodzajPojazdu.size()));

            if(comboPojazd.getSelectedIndex()==0){
                wpiszPredkosc.setText(String.valueOf(random.nextInt(181)));
            }
            else if(comboPojazd.getSelectedIndex()==1){
                wpiszPredkosc.setText(String.valueOf(random.nextInt(121)));
            }
            else if(comboPojazd.getSelectedIndex()==2){
                wpiszPredkosc.setText(String.valueOf(random.nextInt(101)));
            }
            else if(comboPojazd.getSelectedIndex()==3){
                wpiszPredkosc.setText(String.valueOf(random.nextInt(91)));
            }
            else{
                wpiszPredkosc.setText(String.valueOf(random.nextInt(41)));
            }

            chAbs.setSelected(random.nextBoolean());

            sHamulec.setValue(random.nextInt(101));
            sOpona.setValue(random.nextInt(101));
            int p = random.nextInt(2)-1;
            if(p==0){
                rbMezczyzna.setSelected(true);
                rbKobieta.setSelected(false);
            }
            else{
                rbMezczyzna.setSelected(false);
                rbKobieta.setSelected(true);
            }
            chWzrok.setSelected(random.nextBoolean());
            sZmeczenie.setValue(random.nextInt(11));
            int wiek = random.nextInt(81)+18;
            tWiek.setText(String.valueOf(wiek));
            int granicaPrawoJazdy = wiek*12-18*12;
            tPrawoJazdy.setText(String.valueOf(random.nextInt(granicaPrawoJazdy)));

                int wyznacznik = random.nextInt(11);

            double randomValue;
            if(wyznacznik==10) {
                randomValue = Math.round(3 * random.nextDouble() * 100);
                    randomValue /= 100;
            }
                else{
                randomValue = 0.0;
            }
            tAlkohol.setText(String.valueOf(randomValue));


            comboNawierzchnia.setSelectedIndex(random.nextInt(4));
            comboStan.setSelectedIndex(random.nextInt(5));
            sNachylenie.setValue(random.nextInt(25)-12);

        }
        else if(przycisk == bOblicz){

            pojazd = Objects.requireNonNull(comboPojazd.getSelectedItem()).toString();


            switch (pojazd) {
                case "com.project.Samochod osobowy" -> {
                    SamochodOsobowy samochodOsobowy = new SamochodOsobowy();
                    masa = samochodOsobowy.losujMase();
                }
                case "Auto ciezarowe" -> {
                    AutoCiezarowe AutoCiezarowe = new AutoCiezarowe();
                    masa = AutoCiezarowe.losujMase();
                }
                case "com.project.Autobus" -> {
                    Autobus Autobus = new Autobus();
                    masa = Autobus.losujMase();
                }
                case "com.project.Tir" -> {
                    Tir Tir = new Tir();
                    masa = Tir.losujMase();
                }
                default -> {
                    Traktor Traktor = new Traktor();
                    masa = Traktor.losujMase();
                }
            }


            switch (pojazd) {
                case "Samochód osobowy" -> {
                    SamochodOsobowy samochodOsobowy = new SamochodOsobowy();
                    iloscOsi = samochodOsobowy.liczbaOsi;
                }
                case "Auto ciezarowe" -> {
                    AutoCiezarowe AutoCiezarowe = new AutoCiezarowe();
                    iloscOsi = AutoCiezarowe.liczbaOsi;
                }
                case "com.project.Autobus" -> {
                    Autobus Autobus = new Autobus();
                    iloscOsi = Autobus.liczbaOsi;
                }
                case "com.project.Tir" -> {
                    Tir Tir = new Tir();
                    iloscOsi = Tir.liczbaOsi;
                }
                default -> {
                    Traktor Traktor = new Traktor();
                    iloscOsi = Traktor.liczbaOsi;
                }
            }

            if (wpiszPredkosc.getText().isEmpty()) {
                predkosc = 0;
            } else {
                predkosc = Integer.parseInt(wpiszPredkosc.getText());
            }


            abs = chAbs.isSelected();

            sprawnoscHamulca = sHamulec.getValue();
            stanOpon = sOpona.getValue();


            //
            //

            //


            if(rbMezczyzna.isSelected()){
                plec = "Mezczyzna";
            }
            else{
                plec = "Kobieta";
            }
            wadaWzroku = chWzrok.isSelected();
            if (tWiek.getText().isEmpty()) {
                wiek = 0;
            } else {
                wiek = Integer.parseInt(tWiek.getText());
            }

            if (tPrawoJazdy.getText().isEmpty()) {
                prawoJazdy = 0;
            } else {
                prawoJazdy = Integer.parseInt(tPrawoJazdy.getText());
            }
            if (tAlkohol.getText().isEmpty()) {
                iloscAlkoholu = 0;
            } else {
                iloscAlkoholu = Double.parseDouble(tAlkohol.getText());
            }

            typ_Nawierzchni = Objects.requireNonNull(comboNawierzchnia.getSelectedItem()).toString();
            stan_Nawierzchni = Objects.requireNonNull(comboStan.getSelectedItem()).toString();



            Kierowca kierowca = new Kierowca();
                double czas= kierowca.czasReakcjiKierowcy(wadaWzroku , plec , zmeczenie , wiek , iloscAlkoholu , prawoJazdy );
            Nawierzchnia nawierzchnia = new Nawierzchnia();
                double wspolczynnik = nawierzchnia.wspolczynnikNawierzchni(typ_Nawierzchni , stan_Nawierzchni , nachylenie);
            Samochod samochod = new Samochod();
               // masa = samochod.przypiszMase(pojazd);
                double wspolczynnikSamochod = samochod.wspolczynnikSamochod(sprawnoscHamulca,stanOpon,masa,abs, iloscOsi);

            Wynik wynik = new Wynik();
                double w = wynik.wynik(predkosc,czas,wspolczynnikSamochod,wspolczynnik);


            jTest.setText("Droga hamowania: " + RoundToTwo.roundTo2DecimalPlace(w) + "m");
            //System.out.println(pojazd+ " "+ masa + " "+ predkosc+ " "+czas+ " " + wspolczynnik+ " " + wspolczynnikSamochod+ " " + w);



            try {
                Create_CSV zapisz = new Create_CSV();
                zapisz.print(pojazd, masa, predkosc, czas , wspolczynnik , wspolczynnikSamochod , w);
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        sprawnoscHamulca = sHamulec.getValue();
        jHamulec.setText("Sprawność hamulca: " + sprawnoscHamulca);

        stanOpon = sOpona.getValue();
        jOpona.setText("Stan opon: " + stanOpon);

        zmeczenie = sZmeczenie.getValue();
        jZmeczenie.setText("Zmęczenie: " + zmeczenie);

        nachylenie = sNachylenie.getValue();
        jNachylenie.setText("Nachylenie: " + nachylenie);


    }
}
