package src.user_data;
import java.util.ArrayList;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.feedback.enquiry.Enquiry;

public class Student extends User{
	private ArrayList<CampInfo> availableCamps = new ArrayList<CampInfo>(); //List of Camps available to student
	private ArrayList<CampInfo> registeredCamps = new ArrayList<CampInfo>(); //List of Camps Student Registered for
	private ArrayList<CampInfo> withdrawnCamps = new ArrayList<CampInfo>(); //List of Camps Student Withdrawn from
    private ArrayList<Enquiry> enquiriesMade = new ArrayList<Enquiry>(); //List of Enquiries Student made
	private boolean isCommittee;

	// Constructors
	public Student(String userID, String name, Faculty faculty, String email){
		super(userID, name, email, faculty);
		super.setRole("Student");
		this.registeredCamps = new ArrayList<CampInfo>();
		this.withdrawnCamps = new ArrayList<CampInfo>();
		this.enquiriesMade = new ArrayList<Enquiry>();
		this.availableCamps = new ArrayList<CampInfo>();
		this.isCommittee = false;
		
	}

/*--------------------------------------------------------------- ACCESSORS -------------------------------------------------------------------------*/
	public ArrayList<CampInfo> getRegisteredCamps(){
		return this.registeredCamps;
	}

	public ArrayList<CampInfo> getAvailableCamps(){
		return this.availableCamps;
	}

	public ArrayList<CampInfo> getWithdrawnCamps(){
		return this.withdrawnCamps;
	}

	public ArrayList<Enquiry> getEnquiriesMade(){
		return this.enquiriesMade;
	}

	public boolean isCommittee(){
		return this.isCommittee;
	}

/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/
	public void addRegisteredCamp(CampInfo camp) {
        this.getRegisteredCamps().add(camp);
		this.getAvailableCamps().remove(camp);
    }

    public void addWithdrawnCamp(CampInfo camp) {
            this.getRegisteredCamps().remove(camp);
			this.getWithdrawnCamps().add(camp);
			this.getAvailableCamps().remove(camp);
    }

	public void setAvailableCamp(ArrayList<CampInfo> campList){
		this.availableCamps = campList;
	}

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/

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