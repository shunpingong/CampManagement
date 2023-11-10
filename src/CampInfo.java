package src;
import java.time.LocalDate;
import java.util.ArrayList;

public class CampInfo {
	// Instances
	private String campName;
	private LocalDate startDate; //date in DDMMYYYY
	private LocalDate endDate;
	private LocalDate registerDeadline; 
	private Faculty userGroup;
	private String location;
	private int totalSlots;
	private int committeeSlots;
	private String description;
	private Staff inCharge;
	private ArrayList<Student> studentAttendees; //only accessible by staff & camp com
	private ArrayList<CampCommittee> campCom; //only accessible by staff & camp com
	private boolean visibility; //only seen by staff 

	// Constructors
	public CampInfo(String campName, LocalDate startdate, LocalDate enddate, LocalDate registerDeadline, Faculty userGroup, String location, int totalSlots, int committeeSlots, String description, Staff inCharge, boolean visibility){
		this.campName = campName;
		this.startDate = startdate;
		this.endDate = enddate;
		this.registerDeadline = registerDeadline;
		this.userGroup = userGroup;
		this.location = location;
		this.totalSlots = totalSlots;
		this.committeeSlots = committeeSlots;
		this.description = description;
		this.inCharge = inCharge;
		studentAttendees = new ArrayList<Student>();
		campCom = new ArrayList<CampCommittee>();
		this.visibility = visibility;
	}

	// Accessors 
	public String getCampName(){
		return this.campName;
	}
	public LocalDate getStartDate(){
		return this.startDate;
	}
	public LocalDate getEndDate(){
		return this.endDate;
	}
	public LocalDate getRegisterDeadline(){
		return this.registerDeadline;
	}
	public Faculty getUserGroup(){
		return this.userGroup;
	}
	public String getLocation(){
		return this.location;
	}
	public int getTotalSlots(){
		return (this.totalSlots - studentAttendees.size());
	}
	public int getCommitteeSlots(){
		return (this.committeeSlots-campCom.size());
	}
	public String getDescription(){
		return this.description;
	}
	public Staff getInCharge(){
		return this.inCharge;
	}
	public ArrayList<Student> getStudentAttendees(){ //staff & camp com
		return this.studentAttendees;
	}
	public ArrayList<CampCommittee> getCampCom(){ //staff & camo com
		return this.campCom;
	}
	public boolean getVisibility(){ //staff
		return this.visibility;
	}

	// Mutators
	public void setCampName(String campName){
		this.campName = campName;
	}
	public void setStartDate(LocalDate startdate){
		this.startDate = startdate;
	}
	public void setEndDate(LocalDate enddate){
		this.endDate = enddate;
	}
	public void setRegisterDeadline(LocalDate registerDeadline){
		this.registerDeadline = registerDeadline;
	}
	public void setUserGroup(Faculty faculty){
		this.userGroup = faculty;
	}
	public void setLocation(String location){
		this.location = location;
	}
	public void setTotalSlots(int totalSlots){
		this.totalSlots = totalSlots;
	}
	public void setCommitteeSlots(int committeeSlots){
		this.committeeSlots = committeeSlots;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setInCharge(Staff inCharge){
		this.inCharge = inCharge;
	}

}