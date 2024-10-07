package at.fh_burgenland.bswe.algo;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Scanner;

@Log4j2
public class Driver {

    public static void main(String[] args) {


        int[] Array = {1, 2, 5, 7, 9, 11, 13, 15, 17, 19};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen im Suchalgorithmus-Menü!");
        System.out.println("Bitte wählen Sie eine der folgenden Optionen:");
        System.out.println("1: Iterative Binäre Suche");
        System.out.println("2: Rekursive Binäre Suche");
        System.out.println("3. Selbstanordnende lineare Liste Transpose");
        System.out.println("0: Beenden");

        int userInput = scanner.nextInt();

        while (userInput != 0) {
            System.out.print("Geben Sie den zu suchenden Wert ein: ");
            System.out.println(Arrays.toString(Array));
            int gesuchterWert = scanner.nextInt();

            // Erstelle Instanzen der Suchklassen
            BinarySearchIterativ iterativeSearch = new BinarySearchIterativ();
            //TODO: Die anderen Klassen instanzieren



            // Auswahl der Suchmethode
            switch (userInput) {
                case 1:
                    int resultIterative = iterativeSearch.binarySearchIterativ(Array, gesuchterWert);
                    if (resultIterative != -1) {
                        System.out.println("Gefunden an Index: " + resultIterative);
                    } else {
                        System.out.println("Nicht gefunden");
                    }
                    break;

                case 2:
                    //TODO: Rekursive binäre Suche
                    break;
                case 3:
                    //TODO: Selbstanordnende lineare Liste Transpose
                    break;
                default:
                    System.out.println("Ungültige Auswahl, bitte versuch es nochmals.");
                    break;
            }
        }
        System.out.println("Programm beendet.");
    }
}
