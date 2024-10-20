package at.fh_burgenland.bswe.algo.binarySearchRekursiv;


import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * BinarySearchRecursiv class that implements the BinarySearch interface for performing binary search on a sorted array.
 * @param <T> the type of elements in the array, must extend Comparable
 *           Inspiration: https://www.geeksforgeeks.org/binary-search/
 *           Author: Jan Jungwirth
 */
public class BinarySearchRecursiv<T extends Comparable> implements BinarySearch<T> {

    /**
     * Performs binary search on a sorted array to find the position of the specified search object.
     *
     * @param values       the array of values to search in
     * @param searchObject the object to search for within the array
     * @param low          the lowest index in the range to search
     * @param high         the highest index in the range to search
     * @return the index of the searchObject in the values array, or -1 if not found
     */
    private int binarySearch(T[] values, T searchObject, int low, int high) {

        int pointer = low + (high - low) / 2;
        if (low > high || low < 0 || high > values.length||pointer>values.length-1) {
            return -1;
        }

        if (values[pointer].compareTo(searchObject) == 0) {
            return pointer;
        }

        if (values[pointer].compareTo(searchObject) > 0) {
            return binarySearch(values, searchObject, low, pointer - 1);
        } else {
            return binarySearch(values, searchObject, pointer + 1, high);
        }
    }

    /**
     * Performs binary search on an array of values to find the position of the specified search object.
     *
     * @param values       the array of values to search in
     * @param searchObject the object to search for within the array
     * @return the index of the searchObject in the values array, or -1 if not found
     */
    @Override
    public int binarySearch(T[] values, T searchObject) {
        return binarySearch(values, searchObject, 0, values.length);
    }
}
