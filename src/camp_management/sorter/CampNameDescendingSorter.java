package src.camp_management.sorter;
import src.camp_management.CampInfo;

public class CampNameDescendingSorter extends CampSorter{
    public CampNameDescendingSorter(){
        choice = 2;
    }

    @Override
    public int compare(CampInfo camp1, CampInfo camp2){
        CampNameAscendingSorter nameAscendingSorter = new CampNameAscendingSorter();
        return -1 * nameAscendingSorter.compare(camp1, camp2); 
    }
}