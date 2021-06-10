package main.java.hr.java.covidportal.main;

import main.java.hr.java.covidportal.model.Bolest;
import main.java.hr.java.covidportal.model.Osoba;
import main.java.hr.java.covidportal.model.Simptom;
import main.java.hr.java.covidportal.model.Zupanija;

import java.util.Arrays;
import java.util.Scanner;


public class Glavna {

    protected static final int BROJ_ZUPANIJA = 3;
    protected static final int BROJ_SIMPTOMA = 3;
    protected static final int BROJ_BOLESTI = 3;
    protected static final int BROJ_OSOBA = 3;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Zupanija[] zupanije = new Zupanija[BROJ_ZUPANIJA];
        Simptom[] simptomi = new Simptom[BROJ_SIMPTOMA];
        Bolest[] bolesti = new Bolest[BROJ_BOLESTI];
        Osoba[] osobe = new Osoba[BROJ_OSOBA];

        System.out.println("Unesite podatke o " + BROJ_ZUPANIJA + " zupanije!");
        for (int i = 0; i < BROJ_ZUPANIJA; i++) {
            zupanije[i] = MetodeZaUnosPodataka.unosZupanije(scan, i);
        }

        System.out.println("Unesite podatke o " + BROJ_SIMPTOMA + " simptoma!");
        for (int i = 0; i < BROJ_SIMPTOMA; i++) {
            simptomi[i] = MetodeZaUnosPodataka.unosSimptoma(scan, i);
        }

        System.out.println("Unesite podatke o " + BROJ_BOLESTI + " bolesti!");
        for (int i = 0; i < BROJ_BOLESTI; i++) {
            bolesti[i] = MetodeZaUnosPodataka.unosBolesti(scan, simptomi, i);
        }

        System.out.println("Unesite podatke o " + BROJ_OSOBA + " osobe!");
        for (int i = 0; i < BROJ_OSOBA; i++) {
            osobe[i] = MetodeZaUnosPodataka.unosOsobe(scan, zupanije, bolesti, osobe, i);
        }

        System.out.println("Popis osoba foreach: ");
        for (Osoba osoba : osobe) {
            System.out.println(osoba.toString());
        }

        scan.close();

        System.out.println();
        System.out.println("Popis osoba for: ");
        for (int i = 0; i < BROJ_OSOBA; i++) {
            String kontaktiraneOsb = (osobe[i].getKontaktiraneOsobe() != null && osobe[i].getKontaktiraneOsobe().length > 0) ? Arrays.toString(osobe[i].getKontaktiraneOsobe()) : "Nema kontaktiranih osoba.";
            System.out.println("Ime i prezime: " + osobe[i].getIme() + " " + osobe[i].getPrezime() +
                    "\nStarost: " + osobe[i].getStarost() + "\n" + "\nZupanija prebivalista: " + osobe[i].getZupanija().getNazivZupanije() +
                    "\nZarazen bolescu: " + osobe[i].getZarazenBolescu().getNaziv() +
                    "\nKontaktirane osobe: " +
                    "\n" + (i += 1) + ". " + kontaktiraneOsb);
        }
    }
}
