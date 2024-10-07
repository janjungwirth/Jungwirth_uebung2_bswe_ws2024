package at.fh_burgenland.bswe.algo.selfOrganizingListT;

/**
 * A simple self organizing list (transpose)
 * Consists of ListNode elements and is searched and reordered as described here:
 * <a href="https://www.geeksforgeeks.org/self-organizing-list-transpose-method/">geeksforgeeks.org</a>
 * @param <D> Generic Object for data
 */
public class SelfOrganizingListT<D> {
    ListNode<D> start; //First node in List; null -> empty list

    public SelfOrganizingListT() {
        start = null;
    }

    /**
     * Insert data at end of list
     * @param data object to be inserted as data
     */
    public void insert(D data) {
        ListNode<D> newNode = new ListNode<>(data);
        if (start == null) {
            //-> list is empty
            start = newNode;
            return;
        }

        ListNode<D> current = start;
        while (current.next != null) {
            //traverse until last node
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Search list using the transpose method.
     * Searches linearly and moves target element one towards the top of list if found.
     * @param data data to be searched for (requires equals to be true)
     * @return found Data or null
     */
    public D SearchTranspose(D data) {
        if(start == null) return null;

        if(data.equals(start.data)) {
            return start.data;
        }

        ListNode<D> twoBack = null;
        ListNode<D> oneBack = start;
        ListNode<D> current = start.next;

        while (current != null) {
            if(data.equals(current.data)) {
                //Data found
                if(twoBack == null) {
                    //second node in list - replace start + Swap
                    oneBack.next = current.next;
                    current.next = oneBack;
                    start = current;
                } else {
                    //Swap current node with the one before
                    twoBack.next = current;
                    oneBack.next = current.next;
                    current.next = oneBack;
                }
                return current.data;
            }
            //Advance in list
            twoBack = oneBack;
            oneBack = current;
            current = current.next;
        }
        return null; //Nothing found
    }

    /**
     * Prints list to console in order in a single line.
     */
    public void printToConsole() {
        ListNode<D> current = start;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
