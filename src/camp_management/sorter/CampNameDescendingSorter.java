package src.camp_management.sorter;

import src.camp_management.CampInfo;

/**
 * The {@code CampNameDescendingSorter} class is a comparator implementation for sorting camps in descending order based on their names.
 * It extends the abstract class {@link CampSorter} and overrides the {@link #compare(CampInfo, CampInfo)} method by utilizing the {@link CampNameAscendingSorter}.
 * <p>
 * This class is part of the camp management module in the application.
 *
 * @version 1.0
 * @since 2023-11-26
 * @author Cai Yong
 */
public class CampNameDescendingSorter extends CampSorter{

    /**
     * Constructs a new instance of {@code CampNameDescendingSorter}.
     * Sets the sorting choice to 2, representing sorting based on camp names in descending order.
     */
    public CampNameDescendingSorter(){
        choice = 2;
    }

    /**
     * Compares two camp objects based on their names in descending order.
     *
     * @param camp1 The first camp to compare.
     * @param camp2 The second camp to compare.
     * @return A positive integer if the name of camp1 comes before camp2 alphabetically in descending order,
     *         zero if they are equal, and a negative integer if camp1's name comes after camp2.
     */
    @Override
    public int compare(CampInfo camp1, CampInfo camp2){
        CampNameAscendingSorter nameAscendingSorter = new CampNameAscendingSorter();
        return -1 * nameAscendingSorter.compare(camp1, camp2); 
    }
}