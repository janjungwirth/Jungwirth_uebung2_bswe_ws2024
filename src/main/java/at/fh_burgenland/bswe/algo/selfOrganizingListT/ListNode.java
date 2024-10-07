package at.fh_burgenland.bswe.algo.selfOrganizingListT;

/**
 * A node in a one way linkedList
 * @param <D> Generic object for Data
 */
public class ListNode<D> {
    D data; //Generic data
    ListNode<D> next; //Pointer to next node in list (Linked one way); null -> no next exists

    public ListNode(D data) {
        this.data = data;
        this.next = null;
    }
}
