package at.fh_burgenland.bswe.algo.selfOrganizingListT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelfOrganizingListTTest {

    SelfOrganizingListT<Integer> list = new SelfOrganizingListT<>();
    SelfOrganizingListT<Integer> listE = new SelfOrganizingListT<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 11; i++) {
            list.insert(i);
        }
    }

    @Test
    @DisplayName("Get data correctly")
    void getDataAtIndexCorrectly() {
        assertEquals(list.getDataAtIndex(0),0);
        assertEquals(list.getDataAtIndex(1),1);
        assertEquals(list.getDataAtIndex(10),10);
    }

    @Test
    @DisplayName("Get null at invalid index")
    void getDataAtIndexNull() {
        assertNull(list.getDataAtIndex(-1));
        assertNull(list.getDataAtIndex(11));
    }

    @Test
    @DisplayName("Find Successfully")
    void searchTransposeFindSuccessfull() {
        assertEquals(list.searchTranspose(1),1); //Start
        assertEquals(list.searchTranspose(2),2); //Second
        assertEquals(list.searchTranspose(10),10); // End
        assertEquals(list.searchTranspose(7),7);
    }

    @Test
    @DisplayName("Reorder Correctly")
    void searchTransposeReorderCorrectly() {
        //Second Element moved forward once
        assertEquals(list.getDataAtIndex(0),0);
        list.searchTranspose(1);
        assertEquals(list.getDataAtIndex(0),1);
        //Fourth element moved forward trice
        assertEquals(list.getDataAtIndex(0),1);
        list.searchTranspose(3);
        list.searchTranspose(3);
        list.searchTranspose(3);
        assertEquals(list.getDataAtIndex(0),3);
        //First element unchanged
        assertEquals(list.getDataAtIndex(0),3);
        list.searchTranspose(3);
        assertEquals(list.getDataAtIndex(0),3);
    }
    @Test
    @DisplayName("Empty List")
    void searchTransposeEmptyList() {
        //Should return null when empty
        assertNull(listE.searchTranspose(7));
    }
    @Test
    @DisplayName("Not found")
    void searchTransposeNotFound() {
        //Should return null when not found
        assertNull(list.searchTranspose(12));
        assertNull(list.searchTranspose(-1));
    }
    @Test
    @DisplayName("Null Pointer Ex")
    void searchTransposeNullPointerEception() {
        //Should return Throw NullPointerException on search for null
        assertThrows(NullPointerException.class, () -> list.searchTranspose(null));
    }
}