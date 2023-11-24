package src.camp_management;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import src.feedback.enquiry.Enquiry;
import src.feedback.suggestions.Suggestion;
import src.user_data.CampCommittee;
import src.user_data.Faculty;
import src.user_data.Staff;
import src.user_data.Student;

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
	private ArrayList<Student> studentAttendees; //only accessible by staff & camp //List of students signed up for this camp
	private ArrayList<CampCommittee> campCom; //only accessible by staff & camp com //List of students who signed up as committee for this camp
	private ArrayList<Student> withdrawnStudents; //List of students who withdrawn from this camp once
    private ArrayList<Enquiry> enquiriesForCamp; //Enquiries made for this specific camp
	private ArrayList<Suggestion> suggestionForCamp;  //Suggestions made for this specific camp
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
		withdrawnStudents = new ArrayList<Student>(); 
		enquiriesForCamp = new ArrayList<Enquiry>();
		suggestionForCamp = new ArrayList<Suggestion>();
		this.visibility = visibility;
	}


/*---------------------------------------------------------------Accessors -------------------------------------------------------------------------*/
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

	public ArrayList<Student> getWithdrawStudents(){
		return this.withdrawnStudents;
	}

	public ArrayList<Enquiry> getEnquiriesForCamp(){
		return this.enquiriesForCamp;
	}

	public ArrayList<Suggestion> getSuggestionForCamp(){
		return this.suggestionForCamp;
	}


/*--------------------------------------------------------------- Mutators -------------------------------------------------------------------------*/
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
		this.studentAttendees.add(student);
		//no need to -1 from total slot because getTotalSlot does it
		System.out.println("Signed up as a member for camp: "+ campName);
	}

	//withdraw from camp
	public void addWithdrawnStudents(Student student){
		this.studentAttendees.remove(student);
		this.withdrawnStudents.add(student); 
		//no need to +1 from total slot because getTotalSlot does it
		System.out.println("Withdrawn from camp: " + campName);
	}
	
	public void addCampCom(CampCommittee campCom){
		this.campCom.add(campCom);
		//We assume that the number of camp committee is counted into total slots. - Rubrics
		this.totalSlots-=1;
		System.out.println("Signed up as a committee member for camp: "+ campName);
	}

	public void addSuggestionForCamp(Suggestion suggestion){
		this.suggestionForCamp.add(suggestion);
	}
	public void addEnquiriesForCamp(Enquiry enquiry){
		this.enquiriesForCamp.add(enquiry);
	}

	public void setVisibility(Boolean choice){
		this.visibility = choice;
	}

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
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
		int choice = UserInput.editCampMenu();

		switch(choice){
			case 1: //name
				System.out.println("Current Name: "+this.campName);
				System.out.printf("Enter New Camp Name: ");
				String string = sc.nextLine();
				this.campName = string;
				break;
			case 2: //location
				System.out.println("Current Camp Location: "+ this.location);
				System.out.printf("Enter New Camp Location: ");
				string = sc.nextLine();
				this.location = string;
				break;
			case 3: //desc
				System.out.println("Current Description: "+ this.description);
				System.out.printf("Enter New Camp Description: ");
				string = sc.nextLine();
				this.description = string;
				break;
			case 4: //start date
				System.out.println("Current Camp Start Date: "+ this.startDate);
				LocalDate date =UserInput.getDate();
				while(date.isBefore(LocalDate.now())){
					System.out.println("Error: Please Input Start Date After Today's Date: " + LocalDate.now());
					date = UserInput.getDate();
				}
				this.startDate = date;
				break;
			case 5: //end date
				System.out.println("Current Camp End Date: "+ this.endDate);
				LocalDate endDate = UserInput.getDate();
				while(endDate.isBefore(this.startDate)){
					System.out.println("Error: Please Input End Date After Start Date: " + this.startDate);
					endDate = UserInput.getDate();
				}
				this.endDate = endDate;
				break;
			case 6: //reg deadline
				System.out.println("Current Registration Deadline: "+ this.registerDeadline);
				LocalDate regDate = UserInput.getDate();
				while(regDate.isAfter(this.startDate)){
					System.out.println("Error: Please Input Registration Deadline Before Start Date: " + this.startDate);
					regDate = UserInput.getDate();
				}
				this.registerDeadline = regDate;
				break;
			case 7: //Faculty Group
				System.out.println("Current Faculty Group" + this.userGroup);
				Faculty userGroup = UserInput.chooseFaculty();
				this.userGroup = userGroup;
			case 8: //total Slots
				System.out.println("Current Total Slots" + this.totalSlots);
				int totalSlots = 0;
				do{
					totalSlots = sc.nextInt();
				}while(totalSlots<1 || totalSlots<this.studentAttendees.size());
				this.totalSlots = totalSlots;
			case 9: //committee slots
				System.out.println("Current Committee Slots" + this.committeeSlots);
				int comSlots = 0;
				do{
					comSlots = sc.nextInt();
				}while(comSlots<1 || comSlots<this.campCom.size());
				this.committeeSlots = comSlots;
		}
		sc.close();
	}
    
}