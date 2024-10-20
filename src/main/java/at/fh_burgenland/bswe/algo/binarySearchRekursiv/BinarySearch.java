package at.fh_burgenland.bswe.algo.binarySearchRekursiv;

public interface BinarySearch <T extends Comparable>{
    /**
     * Performs binary search on an array of values to find the position of the specified search object.
     *
     * @param values       the array of values to search in
     * @param searchObject the object to search for within the array
     * @return the index of the searchObject in the values array, or -1 if not found
     */
    int binarySearch(T[] values, T searchObject);
}
