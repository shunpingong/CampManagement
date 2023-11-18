package src.sorter;

import java.time.LocalDate;

import src.CampInfo;

public class CampRegDeadlineSorter extends CampSorter{
    public CampRegDeadlineSorter(){
        choice = 5;
    }

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
