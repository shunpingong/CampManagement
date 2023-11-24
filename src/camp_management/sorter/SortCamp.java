package src.camp_management.sorter;
import java.util.ArrayList;

import src.camp_management.CampInfo;

public class SortCamp {
    private CampSorter sorter;
    private ArrayList<CampInfo> original;

    public SortCamp(ArrayList<CampInfo> campList, CampSorter sorter){
        this.sorter = sorter;
        this.original = campList;
    }

    public ArrayList<CampInfo> getOriginal(){
        return original;
    }
    


}
