package at.fh_burgenland.bswe.algo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Die Klasse BinarySearchIterativ implementiert den iterativen Binär-Suchalgorithmus für eine sortierte Liste (aufsteigende Reihenfolge) von Ganzzahlen.
 * Dieser Algorithmus funktioniert, indem er eine Liste schrittweise in zwei Hälften unterteilt und das mittlere Element überprüft. Falls das mittlere Element größer oder kleiner
 * als der gesuchte Wert ist, wird der Suchbereich angepasst.
 */

public class BinarySearchIterativ {

    /**
     * Diese Methode führt die iterative binäre Suche auf einem sortierten Array durch
     * @param arrayList Ein Array von ganzzahligen Werten, das bereits sortiert ist.
     * @param gesuchterWert Der Wert, nach dem im Array gesucht wird.
     * @return Der Index des gesuchten Werts, falls er im Array gefunden wird.
     * Wenn der Wert nicht gefunden wird, gibt diese Methode -1 zurück.
     */

    public int binarySearchIterativ(int[]arrayList,int gesuchterWert){

        if (!isSorted(arrayList)) {
            System.out.println("Das Array ist nicht sortiert. Es wird jetzt sortiert.");
            Arrays.sort(arrayList); // Array sortieren
            System.out.println("Sortiertes Array: " + Arrays.toString(arrayList));
        }

        int low = 0; //Start Suchbereich
        int high = arrayList.length - 1; //Ende Suchbereich

        //Solange das Intervall nicht leer ist
        while (low <= high){
            //Mittlerer Wert berechnen
            int mid = (low + high) /2;


            // Prüfen, ob mittlerer Wert der gesuchte Wert ist
            if (arrayList[mid] == gesuchterWert){
                return mid;
            }

            // Gesuchter Wert kleiner ist, suchen in linker Hälfte
            if (arrayList[mid] > gesuchterWert){
                high = mid - 1;

            }
            // Gesuchter Wert ist größer, suchen in rechter Hälfte
            else{
                low = mid +1;
            }
        }
        //Falls der Welt nicht gefunden Wurde, -1 zurückgeben
        return -1;
    }

    /**
     * Überprüft, ob ein gegebenes Array sortiert ist.
     * @param arrayList Das zu überprüfende Array
     * @return true, wenn das Array sortiert ist, sonst false.
     */

    private boolean isSorted(int[] arrayList) {
        for (int i = 1; i < arrayList.length; i++) {
            if (arrayList[i - 1] > arrayList[i]) {
                return false; // Wenn ein Element größer ist als das nächste, ist das Array nicht sortiert.
            }
        }
        return true; // Das Array ist sortiert.
    }

}
