package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.binarySearchIterativ.BinarySearchIterativ;
import at.fh_burgenland.bswe.algo.binarySearchRekursiv.BinarySearchRecursiv;
import at.fh_burgenland.bswe.algo.selfOrganizingListT.SelfOrganizingListT;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Scanner;

@Log4j2
public class Driver {

    public static void main(String[] args) {
        Menu m = new Menu();
        m.mainMenu();
    }

}
