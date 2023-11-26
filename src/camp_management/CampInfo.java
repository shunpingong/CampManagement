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

/**
 * The CampInfo class represents information about a specific camp,
 * including details about the camp, attendees, committees, suggestions, etc.
 * 
 * @author Yi heng
 * @version 1.0
 * @since 2023-11-26
 */
public class CampInfo {
	
    /**
     * The name of the camp.
     */
	private String campName;

    /**
     * The start date of the camp.
     * Date format: DDMMYYYY
     */
	private LocalDate startDate;

    /**
     * The end date of the camp.
     */
	private LocalDate endDate;

    /**
     * The registration deadline for the camp.
     */
	private LocalDate registerDeadline; 

    /**
     * The faculty group associated with the camp.
     */
	private Faculty userGroup;

    /**
     * The location of the camp.
     */
	private String location;

    /**
     * The total available slots for attendees in the camp.
     */
	private int totalSlots;

    /**
     * The total available committee slots in the camp.
     */
	private int committeeSlots;

    /**
     * The description of the camp.
     */
	private String description;

    /**
     * The staff member in charge of the camp.
     */
	private Staff inCharge;

   /**
     * The list of students signed up for this camp (accessible by staff and camp).
     */
	private ArrayList<Student> studentAttendees;

    /**
     * The list of students who signed up as committee members for this camp
     * (accessible by staff and camp committee).
     */
	private ArrayList<CampCommittee> campCom;

    /**
     * The list of students who have withdrawn from this camp once.
     */
	private ArrayList<Student> withdrawnStudents;

    /**
     * The list of enquiries made for this specific camp.
     */
    private ArrayList<Enquiry> enquiriesForCamp;

    /**
     * The list of suggestions made for this specific camp.
     */
	private ArrayList<Suggestion> suggestionForCamp;

    /**
     * The visibility status of the camp (only seen by staff).
     */
	private boolean visibility;

	/**
	 * Constructs a new CampInfo object with the provided parameters.
	 *
	 * @param campName         The name of the camp.
	 * @param startdate        The start date of the camp.
	 * @param enddate          The end date of the camp.
	 * @param registerDeadline The registration deadline for the camp.
	 * @param userGroup        The faculty group associated with the camp.
	 * @param location         The location of the camp.
	 * @param totalSlots       The total number of slots available for the camp.
	 * @param committeeSlots   The number of slots reserved for committee members.
	 * @param description      A description of the camp.
	 * @param inCharge         The staff member in charge of the camp.
	 * @param visibility       The visibility status of the camp (true if visible to staff, false otherwise).
	 */
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

    /**
     * Retrieves the name of the camp.
     * @return The name of the camp.
     */
	public String getCampName(){
		return this.campName;
	}

    /**
     * Retrieves the start date of the camp.
     * @return The start date of the camp.
     */
	public LocalDate getStartDate(){
		return this.startDate;
	}

    /**
     * Retrieves the end date of the camp.
     * @return The end date of the camp.
     */
	public LocalDate getEndDate(){
		return this.endDate;
	}

    /**
     * Retrieves the registration deadline of the camp.
     * @return The registration deadline of the camp.
     */
	public LocalDate getRegisterDeadline(){
		return this.registerDeadline;
	}

    /**
     * Retrieves the faculty group associated with the camp.
     * @return The faculty group of the camp.
     */
	public Faculty getUserGroup(){
		return this.userGroup;
	}

    /**
     * Retrieves the location of the camp.
     * @return The location of the camp.
     */
	public String getLocation(){
		return this.location;
	}

    /**
     * Retrieves the available total slots for attendees in the camp.
     * @return The available total slots for attendees.
     */
	public int getTotalSlots(){
		return (this.totalSlots - studentAttendees.size());
	}

    /**
     * Retrieves the available committee slots in the camp.
     * @return The available committee slots.
     */
	public int getCommitteeSlots(){
		return (this.committeeSlots-campCom.size());
	}

    /**
     * Retrieves the description of the camp.
     * @return The description of the camp.
     */
	public String getDescription(){
		return this.description;
	}

    /**
     * Retrieves the staff member in charge of the camp.
     * @return The staff member in charge of the camp.
     */
	public Staff getInCharge(){
		return this.inCharge;
	}
	
    /**
     * Retrieves the list of student attendees for the camp.
     * @return The list of student attendees.
     */
	public ArrayList<Student> getStudentAttendees(){ //staff & camp com
		return this.studentAttendees;
	}

    /**
     * Retrieves the list of camp committee members for the camp.
     * @return The list of camp committee members.
     */
	public ArrayList<CampCommittee> getCampCom(){ //staff & camo com
		return this.campCom;
	}

    /**
     * Retrieves the visibility status of the camp (visible to staff or not).
     * @return The visibility status of the camp.
     */
	public boolean getVisibility(){ //staff
		return this.visibility;
	}

    /**
     * Retrieves the list of withdrawn students from the camp.
     * @return The list of withdrawn students.
     */
	public ArrayList<Student> getWithdrawStudents(){
		return this.withdrawnStudents;
	}

    /**
     * Retrieves the list of enquiries made for this specific camp.
     * @return The list of enquiries for the camp.
     */
	public ArrayList<Enquiry> getEnquiriesForCamp(){
		return this.enquiriesForCamp;
	}

    /**
     * Retrieves the list of suggestions made for this specific camp.
     * @return The list of suggestions for the camp.
     */
	public ArrayList<Suggestion> getSuggestionForCamp(){
		return this.suggestionForCamp;
	}

    /**
     * Sets the name of the camp.
     * @param campName The new name of the camp.
     */
	public void setCampName(String campName){
		this.campName = campName;
	}

    /**
     * Sets the start date of the camp.
     * @param startdate The new start date of the camp.
     */
	public void setStartDate(LocalDate startdate){
		this.startDate = startdate;
	}

    /**
     * Sets the end date of the camp.
     * @param enddate The new end date of the camp.
     */
	public void setEndDate(LocalDate enddate){
		this.endDate = enddate;
	}

    /**
     * Sets the registration deadline of the camp.
     * @param registerDeadline The new registration deadline of the camp.
     */
	public void setRegisterDeadline(LocalDate registerDeadline){
		this.registerDeadline = registerDeadline;
	}

    /**
     * Sets the faculty group of the camp.
     * @param faculty The new faculty group of the camp.
     */
	public void setUserGroup(Faculty faculty){
		this.userGroup = faculty;
	}

    /**
     * Sets the location of the camp.
     * @param location The new location of the camp.
     */
	public void setLocation(String location){
		this.location = location;
	}

    /**
     * Sets the total slots available for attendees in the camp.
     * @param totalSlots The new total slots available for attendees.
     */
	public void setTotalSlots(int totalSlots){
		this.totalSlots = totalSlots;
	}

    /**
     * Sets the committee slots available in the camp.
     * @param committeeSlots The new committee slots available in the camp.
     */
	public void setCommitteeSlots(int committeeSlots){
		this.committeeSlots = committeeSlots;
	}

    /**
     * Sets the description of the camp.
     * @param description The new description of the camp.
     */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * Sets the staff member in charge of the camp.
	 *
	 * @param inCharge The staff member to be set in charge.
	 */
	public void setInCharge(Staff inCharge){
		this.inCharge = inCharge;
	}

	/**
	 * Adds a student to the list of attendees for this camp.
	 * Prints a message indicating that the student has signed up.
	 *
	 * @param student The student to be added to the list of attendees.
	 */
	public void addStudentAttendees(Student student){
		this.studentAttendees.add(student);
		System.out.println("Signed up as a member for camp: "+ campName);
	}

	/**
	 * Withdraws a student from the list of attendees for this camp
	 * and adds them to the list of withdrawn students.
	 * Prints a message indicating that the student has withdrawn.
	 *
	 * @param student The student to be withdrawn from the camp.
	 */
	public void addWithdrawnStudents(Student student){
		this.studentAttendees.remove(student);
		this.withdrawnStudents.add(student); 
		System.out.println("Withdrawn from camp: " + campName);
	}
	
	/**
	 * Adds a camp committee member to the list of committee members for this camp.
	 * Assumes that the number of committee members is counted into total slots.
	 * Prints a message indicating that the student has signed up as a committee member.
	 *
	 * @param campCom The camp committee member to be added.
	 */
	public void addCampCom(CampCommittee campCom){
		this.campCom.add(campCom);
		this.totalSlots-=1;
		System.out.println("Signed up as a committee member for camp: "+ campName);
	}

	/**
	 * Adds a suggestion to the list of suggestions for this camp.
	 *
	 * @param suggestion The suggestion to be added.
	 */
	public void addSuggestionForCamp(Suggestion suggestion){
		this.suggestionForCamp.add(suggestion);
	}

	/**
	 * Adds an enquiry to the list of enquiries for this camp.
	 *
	 * @param enquiry The enquiry to be added.
	 */
	public void addEnquiriesForCamp(Enquiry enquiry){
		this.enquiriesForCamp.add(enquiry);
	}

	/**
	 * Sets the visibility status of the camp (only seen by staff).
	 *
	 * @param choice The visibility status to be set.
	 */
	public void setVisibility(Boolean choice){
		this.visibility = choice;
	}

	/**
	 * Prints details of the camp, including its name, description, location,
	 * start and end dates, registration deadline, faculty group, total slots,
	 * committee slots, and staff in charge.
	 */
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

	/**
	 * Edits the information of the camp based on user input.
	 * Uses a menu system to allow the user to choose which information to edit.
	 */
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
	}
    
}