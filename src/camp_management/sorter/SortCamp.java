package src.camp_management.sorter;

import java.util.ArrayList;

import src.camp_management.CampInfo;

/**
 * The {@code SortCamp} class represents a utility for sorting a list of {@link CampInfo} objects based on a specified {@link CampSorter} criteria.
 * It stores the original unsorted list of camps and the sorting criteria in the form of a {@code CampSorter} instance.
 * <p>
 * This class is part of the camp management module in the application.
 *
 * @version 1.0
 * @since 2023-11-26
 * @author Cai Yong
 */
public class SortCamp {

    /**
     * The {@code CampSorter} instance used for sorting the camp list.
     */
    private CampSorter sorter;

    /**
     * The original unsorted list of {@code CampInfo} objects.
     */
    private ArrayList<CampInfo> original;

    /**
     * Constructs a {@code SortCamp} object with the specified list of camps and sorting criteria.
     *
     * @param campList The original list of camps to be sorted.
     * @param sorter   The sorting criteria provided by a {@code CampSorter} instance.
     */
    public SortCamp(ArrayList<CampInfo> campList, CampSorter sorter){
        this.sorter = sorter;
        this.original = campList;
    }

    /**
     * Gets the original unsorted list of camps.
     *
     * @return The original list of {@code CampInfo} objects.
     */
    public ArrayList<CampInfo> getOriginal(){
        return original;
    }
}
