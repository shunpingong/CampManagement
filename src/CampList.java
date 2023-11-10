package src;
import java.util.ArrayList;

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
			System.out.println(campList.get(i).getCampName());
		}
	}

	public static int getSize(){
		return campList.size();
	}
	
	public static CampInfo getCampInfo(int i){
		return campList.get(i);
	}
}