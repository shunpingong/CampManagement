package src.camp_management.sorter;
import java.time.LocalDate;

import src.camp_management.CampInfo;

/**
 * The {@code CampEndDateSorter} class is a comparator implementation for sorting camps based on their end dates.
 * It extends the abstract class {@link CampSorter} and overrides the {@link #compare(CampInfo, CampInfo)} method.
 * <p>
 * This class is part of the camp management module in the application.
 *
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class CampEndDateSorter extends CampSorter {

    /**
     * Constructs a new instance of {@code CampEndDateSorter}.
     * Sets the sorting choice to 4, representing sorting based on end dates.
     */
    public CampEndDateSorter(){
        choice = 4;
    }

    /**
     * Compares two camp objects based on their end dates.
     *
     * @param camp1 The first camp to compare.
     * @param camp2 The second camp to compare.
     * @return A negative integer if the end date of camp1 is before camp2,
     *         zero if they are equal, and a positive integer if camp1's end date is after camp2.
     */
    @Override
    public int compare(CampInfo camp1, CampInfo camp2){
        LocalDate camp1EndDate = camp1.getEndDate();
        LocalDate camp2EndDate = camp2.getEndDate();
        boolean ifAfter = camp1EndDate.isAfter(camp2EndDate);
        boolean isEqual = camp1EndDate.isEqual(camp2EndDate);

        if(ifAfter == true){
            return 1;
        }
        else if(isEqual == true){
            return 0;
        }
        return -1;
    }
}
