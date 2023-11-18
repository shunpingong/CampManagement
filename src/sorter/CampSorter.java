package src.sorter;

import java.util.Comparator;
import java.util.Scanner;

import src.CampInfo;

public abstract class CampSorter implements Comparator<CampInfo>{
    protected int choice;

    /**
     * Creates a person sorter object based on the criterion provided.
     * @param criterion the sorting requirement provided.
     * @return a PersonSorter object which satisfies the criterion.
     */
    public static CampSorter createCampSorter(int choice) {
        switch (choice) {
        case 1:
            return new CampNameAscendingSorter();
        case 2:
            return new CampNameDescendingSorter();
        case 3:
            return new CampStartDateSorter();
        case 4:
            return new CampEndDateSorter();
        case 5:
            return new CampRegDeadlineSorter();
        default:
            return null;
        }
    }

    public int getSortingChoice(){
        return choice;
    }

}

