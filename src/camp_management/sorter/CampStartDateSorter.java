package src.camp_management.sorter;

import java.time.LocalDate;

import src.camp_management.CampInfo;

/**
 * The {@code CampStartDateSorter} class is a specific implementation of {@link CampSorter} that compares {@link CampInfo} objects based on their start dates.
 * It extends the abstract {@code CampSorter} class and overrides the {@code compare} method to provide custom sorting logic based on camp start dates.
 * <p>
 * This class is part of the camp management module in the application.
 *
 * @author Yi heng
 * @version 1.0
 * @since 2023-11-26
 */
public class CampStartDateSorter extends CampSorter {

    /**
     * Creates a {@code CampStartDateSorter} object, initializing the sorting choice associated with camp start dates.
     */
    public CampStartDateSorter(){
        choice = 3;
    }

    /**
     * Compares two {@code CampInfo} objects based on their start dates.
     *
     * @param camp1 The first camp to compare.
     * @param camp2 The second camp to compare.
     * @return An integer representing the comparison result:
     *         -1 if {@code camp1} start date is before {@code camp2} start date,
     *          0 if both start dates are equal,
     *          1 if {@code camp1} start date is after {@code camp2} start date.
     */
    @Override
    public int compare(CampInfo camp1, CampInfo camp2){
        LocalDate camp1StartDate = camp1.getStartDate();
        LocalDate camp2StartDate = camp2.getStartDate();
        boolean ifAfter = camp1StartDate.isAfter(camp2StartDate);
        boolean isEqual = camp1StartDate.isEqual(camp2StartDate);

        if(ifAfter == true){
            return 1;
        }
        else if(isEqual == true){
            return 0;
        }
        return -1;
    }
}
