package src;
import java.util.ArrayList;
import java.util.Scanner;

public class CampList { //element in campList in App
	// Instances
	private static ArrayList<CampInfo> campList;


	// Constructors
	public CampList(){};

	public static void initCamps(){
		campList = new ArrayList<CampInfo>();
	}

	public static void createCamp(CampInfo campinfo){
		campList.add(campinfo);
	}

	public static void viewCamps(){
		for(int i=0; i<campList.size(); i++){
			System.out.println(i+1 +": "+ campList.get(i).getCampName());
		}
	}

	public static int getSize(){
		return campList.size();
	}
	
	public static void printCampNames(){ //take in int for filter
		System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                                    Camp List                                     |");
        System.out.println("------------------------------------------------------------------------------------");
        int i;
        for(i=0;i<CampList.getSize();i++){
            System.out.printf("|%-3s|Name: %-13s|Date: %-5s to %-15s|Available Slots: %-5s|\n", 
                                i+1,
                                campList.get(i).getCampName(), 
                                campList.get(i).getStartDate(), 
                                campList.get(i).getEndDate(), 
                                campList.get(i).getTotalSlots());
        }

        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do{
            System.out.println("Options:");
            System.out.println("1. View Camp Details");
            System.out.println("2. Return");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
        }while(choice<1 || choice>2);
        if (choice == 1) {
            do{
                System.out.printf("Which Camp To View: ");
                choice = sc.nextInt();
            }while(choice > i || choice <= 0);
            campList.get(choice-1).printCamp();
        }
        else if (choice == 2){
            return;
        }
        // sc.close(); //will have error if uncommented
	}

	
}