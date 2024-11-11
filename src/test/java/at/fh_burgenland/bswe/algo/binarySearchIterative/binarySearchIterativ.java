package at.fh_burgenland.bswe.algo.binarySearchIterative;
import at.fh_burgenland.bswe.algo.binarySearchIterativ.BinarySearchIterativ;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für die BinarySearchIterativ-Klasse, die verschiedene Szenarien zur Überprüfung
 * der Korrektheit des binären Suchalgorithmus abdeckt.
 */
public class binarySearchIterativ {

    /**
     * Dieser Test beschreibt die positive Suche in einem Array.
     * D.h. Dieser Test prüft, ob der Algorithmus das gesuchte Element korrekt findet,
     * wenn es im Array vorhanden ist.
     */
    @Test
    void testPositiveSearch() {
        BinarySearchIterativ search = new BinarySearchIterativ();
        int[] array = {1, 2, 5, 7, 9, 11, 13, 15, 17, 19};

        // Gesuchtes Element ist vorhanden
        int result = search.binarySearchIterativ(array, 7);
        assertEquals(3, result, "Der Wert 7 sollte an Index 3 gefunden werden");

        result = search.binarySearchIterativ(array, 15);
        assertEquals(7, result, "Der Wert 15 sollte an Index 7 gefunden werden");
    }

    /**
     * Test führt die negative Suche in einem Array durch.
     * Dieser Test prüft, ob der Algorithmus korrekt -1 zurückgibt, wenn das gesuchte Element
     * nicht im Array vorhanden ist.
     */
    @Test
    void testNegativeSearch() {
        BinarySearchIterativ search = new BinarySearchIterativ();
        int[] array = {1, 2, 5, 7, 9, 11, 13, 15, 17, 19};

        // Gesuchtes Element ist nicht vorhanden
        int result = search.binarySearchIterativ(array, 6);
        assertEquals(-1, result, "Der Wert 6 sollte nicht gefunden werden und -1 zurückgeben");

        result = search.binarySearchIterativ(array, 20);
        assertEquals(-1, result, "Der Wert 20 sollte nicht gefunden werden und -1 zurückgeben");
    }

    /**
     * Test für sogenannte Randfälle, die besondere Szenarien wie ein leeres Array, ein Array mit
     * einem Element und die Suche nach dem kleinsten und größten Element im Array abdeckt.
     */
    @Test
    void testEdgeCases() {
        BinarySearchIterativ search = new BinarySearchIterativ();

        // Testen eines leeren Arrays
        int[] emptyArray = {};
        int result = search.binarySearchIterativ(emptyArray, 5);
        assertEquals(-1, result, "Ein leeres Array sollte immer -1 zurückgeben");

        // Testen eines Arrays mit einem Element (positiver Fall)
        int[] singleElementArray = {10};
        result = search.binarySearchIterativ(singleElementArray, 10);
        assertEquals(0, result, "Der Wert 10 sollte in einem Array mit einem Element an Index 0 gefunden werden");

        // Testen eines Arrays mit einem Element (negativer Fall); Array von vorherigem Test
        result = search.binarySearchIterativ(singleElementArray, 5);
        assertEquals(-1, result, "Der Wert 5 sollte in einem Array mit einem Element nicht gefunden werden");

        // Testen des kleinsten Elements im Array
        int[] array = {1, 2, 5, 7, 9, 11, 13, 15, 17, 19};
        result = search.binarySearchIterativ(array, 1);
        assertEquals(0, result, "Das kleinste Element 1 sollte an Index 0 gefunden werden");

        // Testen des größten Elements im Array
        result = search.binarySearchIterativ(array, 19);
        assertEquals(9, result, "Das größte Element 19 sollte an Index 9 gefunden werden");
    }
}

