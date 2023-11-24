package src.camp_management.sorter;
import java.time.LocalDate;

import src.camp_management.CampInfo;

public class CampStartDateSorter extends CampSorter {
    public CampStartDateSorter(){
        choice = 3;
    }

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
