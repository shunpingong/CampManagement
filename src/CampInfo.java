package src;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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

	//private ArrayList<Student> studentAttendees; //only accessible by staff & camp com
	//private ArrayList<CampCommittee> campCom; //only accessible by staff & camp com

	//made it static -OSP
	private static ArrayList<Student> studentAttendees; //only accessible by staff & camp com
	private static ArrayList<CampCommittee> campCom; //only accessible by staff & camp com
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
		return CampInfo.studentAttendees;
	}
	public ArrayList<CampCommittee> getCampCom(){ //staff & camo com
		return CampInfo.campCom;
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

	public void addStudentAttendees(Student student){
		CampInfo.studentAttendees.add(student);
		//no need to -1 from total slot because getTotalSlot does it
		System.out.println("Signed up as a member for camp");
	}

	public void addCampCom(CampCommittee campCom){
		CampInfo.campCom.add(campCom);
		//We assume that the number of camp committee is counted into total slots. - Rubrics
		this.totalSlots-=1;
		System.out.println("Signed up as a committee member for camp");
	}

	public void printCamp(){ 
        System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Currently Viewing: " + this.campName);
        System.out.println("Description: " + this.description);
        System.out.println("Location: " + this.location);
        System.out.println("Start Date(YYYY-MM-DD): " + this.startDate);
        System.out.println("End Date(YYYY-MM-DD): " + this.endDate);
        System.out.println("Registration Deadline(YYYY-MM-DD): " + this.registerDeadline);
        System.out.println("Faculty: " + this.userGroup);
        System.out.println("Total Slots: " + (this.totalSlots - studentAttendees.size()));
        System.out.println("Committee Slots: " + (this.committeeSlots-campCom.size()));
        System.out.println("Staff In Charge: " + this.inCharge.getName());
		System.out.println("------------------------------------------------------------------------------------");
    }

	public void editCampInfo(){
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do{
			System.out.printf("Select Which Parameter To Edit: ");
			System.out.printf("1. Camp Name");
			System.out.printf("2. Camp Description");
			System.out.printf("3. Camp Location");
			System.out.printf("4. Camp Start Date");
			System.out.printf("5. Camp End Date");
			System.out.printf("6. Camp Registration Deadline");
			System.out.printf("7. Camp Faculty");
			System.out.printf("8. Total Slots Available");
			System.out.printf("9. Total Committee Slots Available");
		}while(choice<1 || choice>9);
		
		switch(choice){
			case 1:
				System.out.println("Current Name: "+this.campName);
				System.out.printf("Enter New Camp Name: ");
				String string = sc.nextLine();
				this.campName = string;
				break;
			case 2:
				System.out.println("Current Description: "+ this.description);
				System.out.printf("Enter New Camp Description: ");
				string = sc.nextLine();
				this.description = string;
			case 3:
				System.out.println("Current Camp Location: "+ this.location);
				System.out.printf("Enter New Camp Location: ");
				string = sc.nextLine();
				this.location = string;
			case 4:
				System.out.println("Current Camp Start Date: "+ this.startDate);
				System.out.printf("Enter New Start Date: ");
				LocalDate startdate = UserInput.getDate();
				this.startDate = startdate;
		}
	}
    
}