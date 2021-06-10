package main.java.hr.java.covidportal.main;


import java.util.Scanner;
import java.util.regex.Pattern;

public class MetodeZaValidaciju {

    static String provjeraPraznogStringaBroja(Scanner scan) {

        String inputString;
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        do {
            inputString = scan.nextLine().trim();
            if (inputString.isBlank() || pattern.matcher(inputString).matches()) {
                System.out.print("Pokusali ste unijeti prazan string ili broj, ponovite unos: ");
            }
        } while (inputString.isBlank() || pattern.matcher(inputString).matches());

        return inputString;
    }

    static Integer provjeraNegativnogIntegera(Scanner scan) {

        Integer inputInt;

        do {
            inputInt = scan.nextInt();
            scan.nextLine();
            if (inputInt < 0 || inputInt.equals(0)) {
                System.out.print("Pokusali ste unijeti negativan broj, ponovite unos: ");
            }
        } while (inputInt < 0 || inputInt.equals(0));

        return inputInt;
    }

    static Integer provjeraBrojaSaListe(Scanner scan, Integer granica) {

        Integer odabir = 0;
        do {
            odabir = MetodeZaValidaciju.provjeraNegativnogIntegera(scan);
            if (odabir < 0 || odabir > granica)
                System.out.print("Odabir mora biti redni broj sa ponudene liste, ponovite unos: ");
        } while (odabir < 0 || odabir > granica);

        return odabir;
    }
}
