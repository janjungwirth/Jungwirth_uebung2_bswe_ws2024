package at.fh_burgenland.bswe.algo.PerformanceTests;

import at.fh_burgenland.bswe.algo.binarySearchIterativ.BinarySearchIterativ;
import at.fh_burgenland.bswe.algo.binarySearchRekursiv.BinarySearchRecursiv;
import at.fh_burgenland.bswe.algo.selfOrganizingListT.SelfOrganizingListT;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Log4j2
public class PerformanceTests {

    private final static int NUM_ITTERATIONS = 500;
    Integer even[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int even2[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    SelfOrganizingListT<Integer> list = new SelfOrganizingListT<>();

    @BeforeAll
    static void setup() {
        log.atInfo().log("*****New Benchmark at " + LocalDateTime.now()
                + " on " + System.getenv().get("COMPUTERNAME")
                + "*****");
    }

    @Test
    @DisplayName("Performance Test binarySearch")
    void binarySearch() {
        long totalTime = 0;

        for (int i = 0; i < NUM_ITTERATIONS; i++) {
            int num = (int)Math.random()*10;
            long time = System.nanoTime();
            new BinarySearchRecursiv().binarySearch(even, num);
            time = System.nanoTime() - time;
            totalTime += time;
        }

        log.atTrace().log(NUM_ITTERATIONS + " iterations of binarySearchRecursive took: " + totalTime + " nanoseconds for an average of " + (totalTime / NUM_ITTERATIONS)) ;
    }

    @Test
    @DisplayName("Performance Test SearchTranspose")
    void binarySearchIterative() {

        long totalTime = 0;

        for (int i = 0; i < NUM_ITTERATIONS; i++) {
            int num = (int)Math.random()*10;
            long time = System.nanoTime();

            new BinarySearchIterativ().binarySearchIterativ(even2, num);

            time = System.nanoTime() - time;
            totalTime += time;
        }

        log.atTrace().log(NUM_ITTERATIONS + " iterations of binarySearchIterative took: " + totalTime + " nanoseconds for an average of " + (totalTime / NUM_ITTERATIONS)) ;
    }


    @Test
    @DisplayName("Performance Test SearchTranspose")
    void searchTranspose() {
        for (int i = 0; i < 11; i++) {
            list.insert(i);
        }

        long totalTime = 0;

        for (int i = 0; i < NUM_ITTERATIONS; i++) {
            int num = (int)Math.random()*10;
            long time = System.nanoTime();

            list.SearchTranspose(num);

            time = System.nanoTime() - time;
            totalTime += time;
        }

        log.atTrace().log(NUM_ITTERATIONS + " iterations of SelfOrganizingSearchTranspose took: " + totalTime + " nanoseconds for an average of " + (totalTime / NUM_ITTERATIONS)) ;
    }

}
