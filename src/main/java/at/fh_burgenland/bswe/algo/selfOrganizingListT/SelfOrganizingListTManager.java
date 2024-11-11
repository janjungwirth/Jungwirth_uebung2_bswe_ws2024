package at.fh_burgenland.bswe.algo.selfOrganizingListT;

/**
 * Manager class to perform example actions with SelfOrganizingListT
 */
public class SelfOrganizingListTManager {

    /**
     * Basic example showing how the reordering in the Self Organizing List (Transpose) works.
     * Prints to console.
     */
    public static void SelfOrganizingListTExample() {
        SelfOrganizingListT<String> list = new SelfOrganizingListT<>();
        list.insert("A");
        list.insert("B");
        list.insert("C");
        list.insert("D");
        list.insert("E");
        list.insert("F");

        System.out.println("List:");
        list.printToConsole();
        System.out.println("Search for 'D':");
        System.out.println(list.searchTranspose("D"));
        System.out.println("New List:");
        list.printToConsole();
    }
}
