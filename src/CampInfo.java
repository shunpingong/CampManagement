package src;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class CampInfo {
	// Instances
	private String campName;
	private String[] date;
	private String registerDeadline;
	private Faculty userGroup;
	private String location;
	private int totalSlots;
	private ArrayList<String> committeeSlots;
	private String description;
	private String inCharge;

	// Constructors
	public CampInfo(String campName, String[] date, String registerDeadline, Faculty userGroup, String location, int totalSlots, ArrayList<String> committeeSlots, String description, String inCharge){
		this.campName = campName;
		this.date = date;
		this.registerDeadline = registerDeadline;
		this.userGroup = userGroup;
		this.location = location;
		this.totalSlots = totalSlots;
		this.committeeSlots = committeeSlots;
		this.description = description;
		this.inCharge = inCharge;
	}

	// Accessors 
	public String getCampName(){
		return this.campName;
	}
	public String[] getDate(){
		return this.date;
	}
	public String getRegisterDeadline(){
		return this.registerDeadline;
	}
	public Faculty getUserGroup(){
		return this.userGroup;
	}
	public String getLocation(){
		return this.location;
	}
	public int getTotalSlots(){
		return this.totalSlots;
	}
	public ArrayList<String> getCommitteeSlots(){
		return this.committeeSlots;
	}
	public String getDescription(){
		return this.description;
	}
	public String getInCharge(){
		return this.inCharge;
	}

	// Mutators
	public void getCampName(String campName){
		this.campName = campName;
	}
	public void getDate(String[] date){
		this.date = date;
	}
	public void getRegisterDeadline(String registerDeadline){
		this.registerDeadline = registerDeadline;
	}
	public void getUserGroup(Faculty faculty){
		this.userGroup = faculty;
	}
	public void getLocation(String location){
		this.location = location;
	}
	public void getTotalSlots(int totalSlots){
		this.totalSlots = totalSlots;
	}
	public void getCommitteeSlots(ArrayList<String> committeeSlots){
		this.committeeSlots = committeeSlots;
	}
	public void getDescription(String description){
		this.description = description;
	}
	public void getInCharge(String inCharge){
		this.inCharge = inCharge;
	}

}