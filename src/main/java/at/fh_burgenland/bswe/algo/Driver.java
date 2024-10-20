package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.binarySearchIterativ.BinarySearchIterativ;
import at.fh_burgenland.bswe.algo.selfOrganizingListT.SelfOrganizingListT;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Scanner;

@Log4j2
public class Driver {

    final static Scanner scanner = new Scanner(System.in);
    final static int[] intList = {1, 2, 5, 7, 9, 11, 13, 15, 17, 19};
    final static SelfOrganizingListT<Integer> listST = new SelfOrganizingListT<>();

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            listST.insert(i);
        }

        while (true) {
            System.out.println("Willkommen im Suchalgorithmus-Menü!");
            System.out.println("Bitte wählen Sie eine der folgenden Optionen:");
            System.out.println("1: Iterative Binäre Suche");
            System.out.println("2: Rekursive Binäre Suche");
            System.out.println("3. Selbstanordnende lineare Liste Transpose");
            System.out.println("0: Beenden");

            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    submenuBinaryItt();
                case 2:
                    //TODO: Rekursive binäre Suche
                    break;
                case 3:
                    SubmenuSelfOrganizeT();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Ungültige Auswahl, bitte versuch es nochmals.");
                    break;
            }
        }

    }

    private static void SubmenuSelfOrganizeT() {
        while (true) {
            System.out.print("Geben Sie den zu suchenden Wert ein, oder X um zu beenden: ");
            listST.printToConsole();
            String input = scanner.next();
            int gesuchterWert;
            if (input.equalsIgnoreCase("x")) break;
            try {
                gesuchterWert = Integer.parseInt(input);
            } catch (Exception ignored) {
                continue;
            }
            Integer wert = listST.searchTranspose(gesuchterWert);
            if (wert != null) {
                System.out.println(wert + " gefunden und ggf. um ein Element nach vorne verschoben:");
                listST.printToConsole();
            } else {
                System.out.println("Kein ergebniss.");
            }
        }

    }

    private static void submenuBinaryItt() {
        while (true) {
            System.out.print("Geben Sie den zu suchenden Wert ein, oder X um zu beenden: ");
            System.out.println(Arrays.toString(intList));
            String input = scanner.next();
            int gesuchterWert;
            if (input.equalsIgnoreCase("x")) break;
            try {
                gesuchterWert = Integer.parseInt(input);
            } catch (Exception ignored) {
                continue;
            }

            BinarySearchIterativ iterativeSearch = new BinarySearchIterativ();
            int resultIterative = iterativeSearch.binarySearchIterativ(intList, gesuchterWert);
            if (resultIterative != -1) {
                System.out.println("Gefunden an Index: " + resultIterative);
            } else {
                System.out.println("Nicht gefunden");
            }
        }
    }
}
