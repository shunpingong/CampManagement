package src.sorter;
import src.CampInfo;

public class CampNameAscendingSorter extends CampSorter{
    public CampNameAscendingSorter(){
        choice = 1;
    }

    @Override
    public int compare(CampInfo camp1, CampInfo camp2){
        String camp1name = camp1.getCampName();
        String camp2name = camp2.getCampName();
        return camp1name.compareToIgnoreCase(camp2name);
    }
}
