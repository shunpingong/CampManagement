package src.camp_management;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import src.camp_management.sorter.CampSorter;

public class CampList { //element in campList in App
	// Instances
	private static ArrayList<CampInfo> campList;

	// Constructors
	public CampList(){};

    public static ArrayList<CampInfo> getCampList(){
        return campList;
    }

	public static void initCamps(){
		campList = new ArrayList<CampInfo>();
	}

	public static void createCamp(CampInfo campinfo){
		campList.add(campinfo);
	}

    public static void deleteCamp(CampInfo campinfo){
        campList.remove(campinfo);
    }

	public static void viewCamps(){
		CampSorter campSorter = CampSorter.createCampSorter(UserInput.sortCampMenu());
        Collections.sort(CampList.getCampList(), campSorter);
        for(int i=0; i<campList.size(); i++){
			System.out.println(i+1 +": "+ campList.get(i).getCampName());
		}
	}

	public static int getSize(){
		return campList.size();
	}

    //added method to get the respective campInfo for student menu 2. Register for camp - OSP
    public static CampInfo getCampInfo(int index){
		return campList.get(index);
	}

    public static CampInfo getCampInfo(String campName){
        for(int i=0;i<campList.size();i++){
            if(campList.get(i).getCampName() == campName)
                return campList.get(i);
        }
        return null;
    }

    //For staff and committee
	public static void printCampDetails(){ //take in int for filter
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do{
            System.out.printf("Which Camp To View: ");
            choice = sc.nextInt();
        }while(choice > CampList.getSize() || choice <= 0);
        campList.get(choice-1).printCamp();
        do{
            System.out.print("Press '1' to Return: ");
            choice = sc.nextInt();
        }while(choice != 1);
        return;
	}

    public static void setCampInfo(CampInfo campInfo){
        for(int i=0;i<campList.size();i++){
            if(campList.get(i).getCampName() != campInfo.getCampName())
                continue;
            campList.remove(i);
            campList.add(i, campInfo);
        }
    }
	
}