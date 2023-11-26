package src.camp_management.sorter;

import src.camp_management.CampInfo;

/**
 * The {@code CampNameAscendingSorter} class is a comparator implementation for sorting camps in ascending order based on their names.
 * It extends the abstract class {@link CampSorter} and overrides the {@link #compare(CampInfo, CampInfo)} method.
 * <p>
 * This class is part of the camp management module in the application.
 *
 * @version 1.0
 * @since 2023-11-26
 * @author Cai Yong
 */
public class CampNameAscendingSorter extends CampSorter{

    /**
     * Constructs a new instance of {@code CampNameAscendingSorter}.
     * Sets the sorting choice to 1, representing sorting based on camp names in ascending order.
     */
    public CampNameAscendingSorter(){
        choice = 1;
    }

    /**
     * Compares two camp objects based on their names in ascending order.
     *
     * @param camp1 The first camp to compare.
     * @param camp2 The second camp to compare.
     * @return A negative integer if the name of camp1 comes before camp2 alphabetically,
     *         zero if they are equal, and a positive integer if camp1's name comes after camp2.
     */
    @Override
    public int compare(CampInfo camp1, CampInfo camp2){
        String camp1name = camp1.getCampName();
        String camp2name = camp2.getCampName();
        return camp1name.compareToIgnoreCase(camp2name);
    }
}
