package src.camp_management.sorter;
import java.time.LocalDate;

import src.camp_management.CampInfo;

public class CampEndDateSorter extends CampSorter {
    public CampEndDateSorter(){
        choice = 4;
    }

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
