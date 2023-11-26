package src.user_data;
import java.util.ArrayList;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.feedback.enquiry.Enquiry;

/**
 * The {@code Student} class represents a student user in the system, extending the base {@code User} class.
 * It includes information about camps the student is registered for, available camps, withdrawn camps,
 * enquiries made, and committee status.
 * 
 * @author Your Name
 * @version 1.0
 * @since 2023-11-26
 */
public class Student extends User{

    /**
     * List of camps available to the student.
     */
	private ArrayList<CampInfo> availableCamps = new ArrayList<CampInfo>();

    /**
     * List of camps the student is registered for.
     */
	private ArrayList<CampInfo> registeredCamps = new ArrayList<CampInfo>();

    /**
     * List of camps from which the student has withdrawn.
     */
	private ArrayList<CampInfo> withdrawnCamps = new ArrayList<CampInfo>();

    /**
     * List of enquiries made by the student.
     */
    private ArrayList<Enquiry> enquiriesMade = new ArrayList<Enquiry>();

    /**
     * Indicates whether the student is part of a committee.
     */
	private boolean isCommittee;

    /**
     * Constructs a new Student object with the specified user information.
     *
     * @param userID   The unique identifier for the student.
     * @param name     The name of the student.
     * @param faculty  The faculty to which the student belongs.
     * @param email    The email address of the student.
     */
	public Student(String userID, String name, Faculty faculty, String email){
		super(userID, name, email, faculty);
		super.setRole("Student");
		this.registeredCamps = new ArrayList<CampInfo>();
		this.withdrawnCamps = new ArrayList<CampInfo>();
		this.enquiriesMade = new ArrayList<Enquiry>();
		this.availableCamps = new ArrayList<CampInfo>();
		this.isCommittee = false;
		
	}

    /**
     * Retrieves the list of camps the student is registered for.
     *
     * @return The list of registered camps.
     */
	public ArrayList<CampInfo> getRegisteredCamps(){
		return this.registeredCamps;
	}

    /**
     * Retrieves the list of camps available to the student.
     *
     * @return The list of available camps.
     */
	public ArrayList<CampInfo> getAvailableCamps(){
		return this.availableCamps;
	}

    /**
     * Retrieves the list of camps from which the student has withdrawn.
     *
     * @return The list of withdrawn camps.
     */
	public ArrayList<CampInfo> getWithdrawnCamps(){
		return this.withdrawnCamps;
	}

    /**
     * Retrieves the list of enquiries made by the student.
     *
     * @return The list of enquiries.
     */
	public ArrayList<Enquiry> getEnquiriesMade(){
		return this.enquiriesMade;
	}

    /**
     * Checks if the student is part of a committee.
     *
     * @return true if the student is part of a committee, false otherwise.
     */
	public boolean isCommittee(){
		return this.isCommittee;
	}

    /**
     * Adds a camp to the list of registered camps, removing it from the list of available camps.
     *
     * @param camp The camp to be registered.
     */
	public void addRegisteredCamp(CampInfo camp) {
        this.getRegisteredCamps().add(camp);
		this.getAvailableCamps().remove(camp);
    }

    /**
     * Removes a camp from the list of registered camps and available camps,
     * adding it to the list of withdrawn camps.
     *
     * @param camp The camp to be withdrawn.
     */
    public void addWithdrawnCamp(CampInfo camp) {
            this.getRegisteredCamps().remove(camp);
			this.getWithdrawnCamps().add(camp);
			this.getAvailableCamps().remove(camp);
    }

    /**
     * Sets the list of available camps for the student.
     *
     * @param campList The list of available camps.
     */
	public void setAvailableCamp(ArrayList<CampInfo> campList){
		this.availableCamps = campList;
	}

    /**
     * Generates a list of available camps for the student based on certain conditions.
     *
     * @return The list of available camps for the student.
     */
	public ArrayList<CampInfo> generateAvailableCamps(){
		ArrayList<CampInfo> availableCamps = new ArrayList<CampInfo>();
		//For each camp in camp list
        for (CampInfo eachCamp : CampList.getCampList()){
            if ((eachCamp.getUserGroup() == Faculty.ALL || this.getFaculty() == eachCamp.getUserGroup()) && eachCamp.getVisibility() == true 
			&& !this.getRegisteredCamps().contains(eachCamp) && !this.getWithdrawnCamps().contains(eachCamp)){ 
                availableCamps.add(eachCamp);
            }
		}
		return availableCamps;
	}
}