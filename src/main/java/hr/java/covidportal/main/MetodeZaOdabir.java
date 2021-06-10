package main.java.hr.java.covidportal.main;

import main.java.hr.java.covidportal.model.Bolest;
import main.java.hr.java.covidportal.model.Osoba;
import main.java.hr.java.covidportal.model.Simptom;
import main.java.hr.java.covidportal.model.Zupanija;

import java.util.Scanner;

import static main.java.hr.java.covidportal.main.Glavna.*;

public class MetodeZaOdabir {

     static String odabirVrijednosti(Scanner scan) {

        String inputString;

        do {
            inputString = scan.nextLine().toUpperCase();
            if ("RIJETKO".equals(inputString) || "SREDNJE".equals(inputString) || "CESTO".equals(inputString)) {
                return inputString;
            } else {
                System.out.print("Unesite jedan od ponudenih odgovora (RIJETKO, SREDNJE ILI CESTO), ponovite unos: ");
            }
        } while (true);

    }

     static Simptom odabirSimptoma(Scanner scan, Simptom[] simptomi) {

        Integer odabir = 0;
        int i = 0;

        for (Simptom simptom : simptomi) {
            System.out.println((i += 1) + ". " + simptom.getNaziv() + " - " + simptom.getVrijednost());
        }
        System.out.print("Odabir: ");
        odabir = MetodeZaValidaciju.provjeraBrojaSaListe(scan, BROJ_SIMPTOMA);

         return simptomi[odabir - 1];
    }

    static Zupanija odabirZupanije(Scanner scan, Zupanija[] zupanije) {

        Integer odabir = 0;
        int i = 0;

        for (Zupanija zupanija : zupanije) {
            System.out.println((i += 1) + ". " + zupanija.getNazivZupanije());
        }
        System.out.print("Odabir: ");
        odabir = MetodeZaValidaciju.provjeraBrojaSaListe(scan, BROJ_ZUPANIJA);

        return zupanije[odabir - 1];
    }

    static Bolest odabirBolesti(Scanner scan, Bolest[] bolesti) {

        Integer odabir = 0;
        int i = 0;

        for (Bolest bolest : bolesti) {
            System.out.println((i += 1) + ". " + bolest.getNaziv());
        }
        System.out.print("Odabir: ");
        odabir = MetodeZaValidaciju.provjeraBrojaSaListe(scan, BROJ_BOLESTI);

        return bolesti[odabir - 1];
    }

    static Osoba odabirOsobe(Scanner scan, Osoba[] osobe) {

        Integer odabir = 0;
        int i = 0;

        for (Osoba osoba : osobe) {
            if (osoba != null) {
                System.out.println((i += 1) + ". " + osoba.getIme() + " " + osoba.getPrezime());
            }
        }
        System.out.print("Odabir: ");
        odabir = MetodeZaValidaciju.provjeraBrojaSaListe(scan, brojKontaktiranihOsoba(osobe));

        return osobe[odabir - 1];
    }

    static Integer brojKontaktiranihOsoba(Osoba[] osobe) {

        Integer brojac = 0;
        for (Osoba osoba : osobe) {
            if (osoba != null) {
                brojac++;
            }
        }
        return brojac;
    }
}
