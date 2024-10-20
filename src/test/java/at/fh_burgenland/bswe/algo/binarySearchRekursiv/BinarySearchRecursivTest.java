package at.fh_burgenland.bswe.algo.binarySearchRekursiv;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchRecursivTest {

    Integer even[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer odd[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    @DisplayName("Happy Path")
    void binarySearch() {
        assertEquals(new BinarySearchRecursiv().binarySearch(even, 5),5);
        assertEquals(new BinarySearchRecursiv().binarySearch(odd, 5),5);
    }

    @Test
    @DisplayName("Element not found")
    void binarySearchElementNotFound() {
        assertEquals(new BinarySearchRecursiv().binarySearch(even, 100), -1);
    }



}