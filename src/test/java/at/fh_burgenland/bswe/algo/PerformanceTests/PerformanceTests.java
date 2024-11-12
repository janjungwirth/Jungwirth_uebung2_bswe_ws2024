package at.fh_burgenland.bswe.algo.PerformanceTests;

import at.fh_burgenland.bswe.algo.binarySearchIterativ.BinarySearchIterativ;
import at.fh_burgenland.bswe.algo.binarySearchRekursiv.BinarySearchRecursiv;
import at.fh_burgenland.bswe.algo.selfOrganizingListT.SelfOrganizingListT;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Random;

@Log4j2
public class PerformanceTests {

    private final static int NUM_ITERATIONS_SMALL = 500;
    private final static int NUM_ITERATIONS_LARGE = 50000;

    private final static int SMALL_DATA_SIZE = 10;
    private final static int LARGE_DATA_SIZE = 10000;

    private final static int MAX_ELEMENT_SMALL = 10;
    private final static int MAX_ELEMENT_LARGE = 10000;

    private final static int REPEAT_SEARCH_ELEMENT = 500;

    Integer[] smallArrayData;
    int[] smallArrayDataPrimitive;
    SelfOrganizingListT<Integer> smallList;

    Integer[] largeArrayData;
    int[] largeArrayDataPrimitive;
    SelfOrganizingListT<Integer> largeList;

    @BeforeAll
    static void setup() {
        log.info("*****New Benchmark at " + LocalDateTime.now() + " on " + System.getenv().get("COMPUTERNAME") + "*****");
    }

    public PerformanceTests() {
        // Initialize small dataset
        smallArrayData = new Integer[SMALL_DATA_SIZE];
        smallArrayDataPrimitive = new int[SMALL_DATA_SIZE];
        smallList = new SelfOrganizingListT<>();

        for (int i = 0; i < SMALL_DATA_SIZE; i++) {
            smallArrayData[i] = i;
            smallArrayDataPrimitive[i] = i;
            smallList.insert(i);
        }

        // Initialize large dataset
        largeArrayData = new Integer[LARGE_DATA_SIZE];
        largeArrayDataPrimitive = new int[LARGE_DATA_SIZE];
        largeList = new SelfOrganizingListT<>();

        for (int i = 0; i < LARGE_DATA_SIZE; i++) {
            largeArrayData[i] = i;
            largeArrayDataPrimitive[i] = i;
            largeList.insert(i);
        }
    }

    @Test
    @DisplayName("Performance Test - Small Dataset Random Searches")
    void smallDatasetRandomSearches() {
        Random random = new Random();

        // SelfOrganizingSearchTranspose
        long totalTimeSOST = 0;
        for (int i = 0; i < NUM_ITERATIONS_SMALL; i++) {
            int num = random.nextInt(MAX_ELEMENT_SMALL);
            long time = System.nanoTime();
            smallList.searchTranspose(num);
            totalTimeSOST += (System.nanoTime() - time);
        }
        log.info(NUM_ITERATIONS_SMALL + " random iterations of SelfOrganizingSearchTranspose on a small dataset (size " + SMALL_DATA_SIZE + ") took: " + totalTimeSOST + " for an average of " + (totalTimeSOST / NUM_ITERATIONS_SMALL));

        // BinarySearchIterative
        BinarySearchIterativ binarySearchIterativ = new BinarySearchIterativ();
        long totalTimeBSI = 0;
        for (int i = 0; i < NUM_ITERATIONS_SMALL; i++) {
            int num = random.nextInt(MAX_ELEMENT_SMALL);
            long time = System.nanoTime();
            binarySearchIterativ.binarySearchIterativ(smallArrayDataPrimitive, num);
            totalTimeBSI += (System.nanoTime() - time);
        }
        log.info(NUM_ITERATIONS_SMALL + " random iterations of BinarySearchIterative on a small dataset (size " + SMALL_DATA_SIZE + ") took: " + totalTimeBSI + " for an average of " + (totalTimeBSI / NUM_ITERATIONS_SMALL));

        // BinarySearchRecursive
        BinarySearchRecursiv<Integer> binarySearchRecursiv = new BinarySearchRecursiv<>();
        long totalTimeBSR = 0;
        for (int i = 0; i < NUM_ITERATIONS_SMALL; i++) {
            int num = random.nextInt(MAX_ELEMENT_SMALL);
            long time = System.nanoTime();
            binarySearchRecursiv.binarySearch(smallArrayData, num);
            totalTimeBSR += (System.nanoTime() - time);
        }
        log.info(NUM_ITERATIONS_SMALL + " random iterations of binarySearchRecursive on a small dataset (size " + SMALL_DATA_SIZE + ") took: " + totalTimeBSR + " for an average of " + (totalTimeBSR / NUM_ITERATIONS_SMALL));
    }

    @Test
    @DisplayName("Performance Test - Large Dataset Random and Repeated Searches")
    void largeDatasetSearches() {
        Random random = new Random();

        // SelfOrganizingSearchTranspose - Random Searches
        long totalTimeSOSTRandom = 0;
        for (int i = 0; i < NUM_ITERATIONS_LARGE; i++) {
            int num = random.nextInt(MAX_ELEMENT_LARGE);
            long time = System.nanoTime();
            largeList.searchTranspose(num);
            totalTimeSOSTRandom += (System.nanoTime() - time);
        }
        log.info(NUM_ITERATIONS_LARGE + " random iterations of SelfOrganizingSearchTranspose on a larger dataset (size " + LARGE_DATA_SIZE + ") took: " + totalTimeSOSTRandom + " for an average of " + (totalTimeSOSTRandom / NUM_ITERATIONS_LARGE));

        // SelfOrganizingSearchTranspose - Repeated Searches
        long totalTimeSOSTRepeated = 0;
        for (int i = 0; i < NUM_ITERATIONS_LARGE; i++) {
            long time = System.nanoTime();
            largeList.searchTranspose(REPEAT_SEARCH_ELEMENT);
            totalTimeSOSTRepeated += (System.nanoTime() - time);
        }
        log.info(NUM_ITERATIONS_LARGE + " repeated iterations of SelfOrganizingSearchTranspose on a larger dataset (size " + LARGE_DATA_SIZE + ") took: " + totalTimeSOSTRepeated + " for an average of " + (totalTimeSOSTRepeated / NUM_ITERATIONS_LARGE));

        // BinarySearchIterative - Random Searches
        BinarySearchIterativ binarySearchIterativ = new BinarySearchIterativ();
        long totalTimeBSIRandom = 0;
        for (int i = 0; i < NUM_ITERATIONS_LARGE; i++) {
            int num = random.nextInt(MAX_ELEMENT_LARGE);
            long time = System.nanoTime();
            binarySearchIterativ.binarySearchIterativ(largeArrayDataPrimitive, num);
            totalTimeBSIRandom += (System.nanoTime() - time);
        }
        log.info(NUM_ITERATIONS_LARGE + " random iterations of BinarySearchIterative on a larger dataset (size " + LARGE_DATA_SIZE + ") took: " + totalTimeBSIRandom + " for an average of " + (totalTimeBSIRandom / NUM_ITERATIONS_LARGE));

        // BinarySearchIterative - Repeated Searches
        long totalTimeBSIRepeated = 0;
        for (int i = 0; i < NUM_ITERATIONS_LARGE; i++) {
            long time = System.nanoTime();
            binarySearchIterativ.binarySearchIterativ(largeArrayDataPrimitive, REPEAT_SEARCH_ELEMENT);
            totalTimeBSIRepeated += (System.nanoTime() - time);
        }
        log.info(NUM_ITERATIONS_LARGE + " repeated iterations of BinarySearchIterative on a larger dataset (size " + LARGE_DATA_SIZE + ") took: " + totalTimeBSIRepeated + " for an average of " + (totalTimeBSIRepeated / NUM_ITERATIONS_LARGE));

        // BinarySearchRecursive - Random Searches
        BinarySearchRecursiv<Integer> binarySearchRecursiv = new BinarySearchRecursiv<>();
        long totalTimeBSRRandom = 0;
        for (int i = 0; i < NUM_ITERATIONS_LARGE; i++) {
            int num = random.nextInt(MAX_ELEMENT_LARGE);
            long time = System.nanoTime();
            binarySearchRecursiv.binarySearch(largeArrayData, num);
            totalTimeBSRRandom += (System.nanoTime() - time);
        }
        log.info(NUM_ITERATIONS_LARGE + " random iterations of binarySearchRecursive on a larger dataset (size " + LARGE_DATA_SIZE + ") took: " + totalTimeBSRRandom + " for an average of " + (totalTimeBSRRandom / NUM_ITERATIONS_LARGE));

        // BinarySearchRecursive - Repeated Searches
        long totalTimeBSRRepeated = 0;
        for (int i = 0; i < NUM_ITERATIONS_LARGE; i++) {
            long time = System.nanoTime();
            binarySearchRecursiv.binarySearch(largeArrayData, REPEAT_SEARCH_ELEMENT);
            totalTimeBSRRepeated += (System.nanoTime() - time);
        }
        log.info(NUM_ITERATIONS_LARGE + " repeated iterations of binarySearchRecursive on a larger dataset (size " + LARGE_DATA_SIZE + ") took: " + totalTimeBSRRepeated + " for an average of " + (totalTimeBSRRepeated / NUM_ITERATIONS_LARGE));
    }
}
