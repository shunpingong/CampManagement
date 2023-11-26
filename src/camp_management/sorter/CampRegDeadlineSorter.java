package src.camp_management.sorter;

import java.time.LocalDate;

import src.camp_management.CampInfo;

/**
 * The {@code CampRegDeadlineSorter} class is a comparator implementation for sorting camps based on their registration deadlines.
 * It extends the abstract class {@link CampSorter} and overrides the {@link #compare(CampInfo, CampInfo)} method.
 * <p>
 * This class is part of the camp management module in the application.
 *
 * @version 1.0
 * @since 2023-11-26
 * @author Cai Yong
 */
public class CampRegDeadlineSorter extends CampSorter{

    /**
     * Constructs a new instance of {@code CampRegDeadlineSorter}.
     * Sets the sorting choice to 5, representing sorting based on registration deadlines.
     */
    public CampRegDeadlineSorter(){
        choice = 5;
    }

    /**
     * Compares two camp objects based on their registration deadlines.
     *
     * @param camp1 The first camp to compare.
     * @param camp2 The second camp to compare.
     * @return A negative integer if the registration deadline of camp1 is before camp2,
     *         zero if they are equal, and a positive integer if camp1's registration deadline is after camp2.
     */
    @Override
    public int compare(CampInfo camp1, CampInfo camp2){
        LocalDate camp1RegDate = camp1.getRegisterDeadline();
        LocalDate camp2RegDate = camp2.getRegisterDeadline();
        boolean ifAfter = camp1RegDate.isAfter(camp2RegDate);
        boolean isEqual = camp1RegDate.isEqual(camp2RegDate);

        if(ifAfter == true){
            return 1;
        }
        else if(isEqual == true){
            return 0;
        }
        return -1;
    }
}
