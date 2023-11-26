package src.camp_management;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import src.camp_management.sorter.CampSorter;

/**
 * The {@code CampList} class represents a list of camps and provides methods for managing and interacting with the camp data.
 * It includes functionality for initializing, adding, deleting, sorting, and retrieving information about camps.
 *
 * <p>
 * This class utilizes the {@code CampInfo} class to represent individual camps and the {@code CampSorter} class for sorting the camps.
 * The camp list can be manipulated, and various details about camps can be accessed through the provided methods.
 *
 * @author Yi heng
 * @version 1.0
 * @since 2023-11-26
 */
public class CampList {

    /**
     * The list that stores instances of {@code CampInfo}, representing the collection of camps.
     * This ArrayList serves as the data structure for managing and organizing information about different camps.
     */
    private static ArrayList<CampInfo> campList;

    /**
     * Initializes the camp list.
     */
	public CampList(){};

    /**
     * Returns the list of camps.
     *
     * @return The ArrayList of CampInfo objects representing the camps.
     */
    public static ArrayList<CampInfo> getCampList(){
        return campList;
    }

    /**
     * Initializes the camp list.
     */
	public static void initCamps(){
		campList = new ArrayList<CampInfo>();
	}

    /**
     * Adds a new camp to the camp list.
     *
     * @param campInfo The CampInfo object representing the new camp.
     */
	public static void createCamp(CampInfo campinfo){
		campList.add(campinfo);
	}

    /**
     * Deletes a camp from the camp list.
     *
     * @param campInfo The CampInfo object representing the camp to be deleted.
     */
    public static void deleteCamp(CampInfo campinfo){
        campList.remove(campinfo);
    }

    /**
     * Displays a sorted list of camps to the console.
     */
	public static void viewCamps(){
		CampSorter campSorter = CampSorter.createCampSorter(UserInput.sortCampMenu());
        Collections.sort(CampList.getCampList(), campSorter);
        for(int i=0; i<campList.size(); i++){
			System.out.println(i+1 +": "+ campList.get(i).getCampName());
		}
	}

    /**
     * Returns the size of the camp list.
     *
     * @return The number of camps in the list.
     */
	public static int getSize(){
		return campList.size();
	}

    /**
     * Returns the CampInfo object at the specified index.
     *
     * @param index The index of the camp in the camp list.
     * @return The CampInfo object at the specified index.
     */
    public static CampInfo getCampInfo(int index){
		return campList.get(index);
	}

    /**
     * Returns the CampInfo object with the specified camp name.
     *
     * @param campName The name of the camp to retrieve.
     * @return The CampInfo object with the specified camp name, or null if not found.
     */
    public static CampInfo getCampInfo(String campName){
        for(int i=0;i<campList.size();i++){
            if(campList.get(i).getCampName() == campName)
                return campList.get(i);
        }
        return null;
    }

    /**
     * Prints details of a specific camp based on user input.
     */
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

    /**
     * Sets the information of a specific camp in the camp list.
     *
     * @param campInfo The CampInfo object with updated information.
     */
    public static void setCampInfo(CampInfo campInfo){
        for(int i=0;i<campList.size();i++){
            if(campList.get(i).getCampName() != campInfo.getCampName())
                continue;
            campList.remove(i);
            campList.add(i, campInfo);
        }
    }
	
}