package src.camp_management.sorter;

import java.util.Comparator;

import src.camp_management.CampInfo;

/**
 * The {@code CampSorter} abstract class is a comparator implementation for sorting {@link CampInfo} objects based on various criteria.
 * It extends the {@link Comparator} interface and provides a method to create specific camp sorter objects based on the sorting choice.
 * <p>
 * This class is part of the camp management module in the application.
 *
 * @author Yi heng
 * @version 1.0
 * @since 2023-11-26
 */
public abstract class CampSorter implements Comparator<CampInfo>{
    protected int choice;

    /**
     * Creates a camp sorter object based on the given sorting choice.
     *
     * @param choice The sorting choice indicating the criterion for sorting.
     * @return A specific camp sorter object based on the sorting choice.
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

    /**
     * Gets the sorting choice associated with this camp sorter.
     *
     * @return The sorting choice representing the criterion for sorting.
     */
    public int getSortingChoice(){
        return choice;
    }

}

