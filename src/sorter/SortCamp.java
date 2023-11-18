package src.sorter;
import java.util.ArrayList;

import src.CampInfo;

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
