package main.java.hr.java.covidportal.main;

import main.java.hr.java.covidportal.model.Bolest;
import main.java.hr.java.covidportal.model.Osoba;
import main.java.hr.java.covidportal.model.Simptom;
import main.java.hr.java.covidportal.model.Zupanija;

import java.util.Scanner;

public class MetodeZaUnosPodataka {

    static Zupanija unosZupanije(Scanner scan, int i){

        System.out.print("Unesite naziv " + (i + 1) + ". zupanije: ");
        String nazivZupanije = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite broj stanovnika za " + (i + 1) + ". zupaniju: ");
        Integer brojStanovnika = MetodeZaValidaciju.provjeraNegativnogIntegera(scan);

        return new Zupanija(nazivZupanije,brojStanovnika);
    }

    static Simptom unosSimptoma(Scanner scan, int i){

        System.out.print("Unesite naziv " + (i + 1) + ". simptoma: ");
        String nazivSimptoma = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite vrijednost " + (i + 1) + ". simptoma (RIJETKO, SREDNJE ILI CESTO): ");
        String vrijednostSimptoma = MetodeZaOdabir.odabirVrijednosti(scan);

        return new Simptom(nazivSimptoma, vrijednostSimptoma);
    }

    static Bolest unosBolesti(Scanner scan, Simptom[] simptomi, int i){

        System.out.print("Unesite naziv " + (i + 1) + ". bolesti: ");
        String nazivBolesti = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite broj simptoma: ");
        Integer brojSimptoma = MetodeZaValidaciju.provjeraNegativnogIntegera(scan);
        Simptom[] simptomBolesti = new Simptom[brojSimptoma];
        for (int j = 0; j < brojSimptoma; j++){
            System.out.println("Odaberite " + (j + 1) + ". simptom: ");
            simptomBolesti[j] = MetodeZaOdabir.odabirSimptoma(scan, simptomi);
        }
        return new Bolest(nazivBolesti, simptomBolesti);
    }

    static Osoba unosOsobe(Scanner scan, Zupanija[] zupanije, Bolest[] bolesti,Osoba[] osobe, int i){

        System.out.print("Unesite ime " + (i + 1) + ". osobe: ");
        String imeOsobe = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite prezime " + (i + 1) + ". osobe: ");
        String prezimeOsobe = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite starost " + (i + 1) + ". osobe: ");
        Integer starostOsobe = MetodeZaValidaciju.provjeraNegativnogIntegera(scan);
        System.out.println("Odaberite zupaniju prebivalista " + (i + 1) + " osobe: ");
        Zupanija prebivalisteOsobe = MetodeZaOdabir.odabirZupanije(scan, zupanije);
        System.out.println("Odaberite bolest " + (i + 1) + " osobe :");
        Bolest bolestOsobe = MetodeZaOdabir.odabirBolesti(scan, bolesti);
        Osoba osoba = new Osoba(imeOsobe, prezimeOsobe, starostOsobe, prebivalisteOsobe, bolestOsobe);
        if(i>0) {
            return unosKontaktiraneOsobe(scan, zupanije, bolesti, osobe, osoba);
        }
        return osoba;
    }

    static Osoba unosKontaktiraneOsobe(Scanner scan, Zupanija[] zupanije, Bolest[] bolesti, Osoba[] osobe, Osoba osoba){

        System.out.print("Unesite broj osoba koje su bile u kontaktu s tom osobom: ");
        Integer kontaktBrojOsobaSaPrvimZarazenim = MetodeZaValidaciju.provjeraNegativnogIntegera(scan);
        Osoba[] kontaktiranaOsoba = new Osoba[kontaktBrojOsobaSaPrvimZarazenim];
        System.out.println("Odaberite osobe koje su bile u kontaktu  s tom osobom :");
        for (int i = 0; i < kontaktBrojOsobaSaPrvimZarazenim; i++){
            kontaktiranaOsoba[i] = MetodeZaOdabir.odabirOsobe(scan, osobe);
        }
        return  new Osoba(osoba.getIme(), osoba.getPrezime(), osoba.getStarost(), osoba.getZupanija(), osoba.getZarazenBolescu(), kontaktiranaOsoba);
    }
}
