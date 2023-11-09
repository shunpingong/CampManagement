package src;
import java.util.ArrayList;

public class CampList { //element in campList in App
	// Instances
	private static ArrayList<CampInfo> campList;


	// Constructors
	public CampList(){
		campList = new ArrayList<CampInfo>();
	};
	public static void createCamp(CampInfo campinfo){
		campList.add(campinfo);
	}
	/*
	// Accessors
	public CampInfo getInfo(){
		return this.info;
	}
	public boolean getVisibility(){
		return this.visibility;
	}

	// Mutators
	public void setInfo(CampInfo info){
		this.info = info;
	}
	public void setVisibility(boolean visibility){
		this.visibility = visibility;
	}*/
}