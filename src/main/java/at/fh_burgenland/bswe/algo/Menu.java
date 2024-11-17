package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.binarySearchIterativ.BinarySearchIterativ;
import at.fh_burgenland.bswe.algo.binarySearchRekursiv.BinarySearchRecursiv;
import at.fh_burgenland.bswe.algo.selfOrganizingListT.SelfOrganizingListT;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Provides a console-based menu for selecting and executing different search algorithms.
 */
public class Menu {
    final static Scanner scanner = new Scanner(System.in);
    /** Array used for iterative binary search. */
    final static int[] intList = {1, 2, 5, 7, 9, 11, 13, 15, 17, 19};
    /** Array used for recursive binary search. */
    final static Integer[] intList2 = {1, 2, 5, 7, 9, 11, 13, 15, 17, 19};
    /** Self-organizing list for transpose operations. */
    final static SelfOrganizingListT<Integer> listST = new SelfOrganizingListT<>();
    /**
     * Displays the main menu and handles user selections.
     */
    public void mainMenu() {
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
                    submenuBinaryRec();
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

    private static void submenuBinaryRec() {
        while (true) {
            System.out.print("Geben Sie den zu suchenden Wert ein, oder X um zu beenden: ");
            System.out.println(Arrays.toString(intList2));
            String input = scanner.next();
            int gesuchterWert;
            if (input.equalsIgnoreCase("x")) break;
            try {
                gesuchterWert = Integer.parseInt(input);
            } catch (Exception ignored) {
                continue;
            }

            BinarySearchRecursiv searchRecursiv = new BinarySearchRecursiv();
            int resultRecursive = searchRecursiv.binarySearch(intList2, gesuchterWert);
            if (resultRecursive != -1) {
                System.out.println("Gefunden an Index: " + resultRecursive);
            } else {
                System.out.println("Nicht gefunden");
            }
        }
    }
}
