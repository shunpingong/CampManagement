package src;
import java.util.ArrayList;
import java.util.Scanner;

import src.enquiry.EnquiryMenu;
import src.enquiry.Enquiry;

public class Student extends User {
	private String email;
	protected ArrayList<CampInfo> availableCamps = new ArrayList<CampInfo>(); //List of Camps available for student
	protected ArrayList<CampInfo> registeredCamps = new ArrayList<CampInfo>(); //List of Camps Student Registered for
	protected ArrayList<CampInfo> withdrawnCamps = new ArrayList<CampInfo>(); //List of Camps Student Withdrawn from
    protected ArrayList<Enquiry> enquiriesMade = new ArrayList<Enquiry>(); //List of Enquiries Student made
	protected CampCommittee committeeUser; //null if current student is not committee
	protected CampInfo committeeOf; //Camp the student is a committee of

	// Constructors
	public Student(String userID, String name, Faculty faculty, String email){
		super(userID, name, faculty);
		this.email = email;
		this.registeredCamps = new ArrayList<CampInfo>();
		this.withdrawnCamps = new ArrayList<CampInfo>();
		this.enquiriesMade = new ArrayList<Enquiry>();
		this.availableCamps = this.generateAvailableCamps();
		this.committeeUser = null;
		this.committeeOf = null;

	}

/*--------------------------------------------------------------- ACCESSORS -------------------------------------------------------------------------*/
	public String getEmail(){
		return this.email;
	}

	public CampCommittee getCommitteeUser(){
		return this.committeeUser;
	}

	public CampInfo getCommitteeOf(){
		return this.committeeOf;
	}
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

/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/
	public void setEmail(String email){
		this.email = email;
	}

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

	public void setCommitteeOf(CampInfo camp){
		this.committeeOf = camp;
	}

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
	@Override
	public User getIfCommittee() {
		if (this.committeeUser == null){
			return this;
		}
		else{
			return committeeUser;
		}
		// return committeeUser == null ? this : committeeUser;
	}

	@Override
    public int menu() {
		Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
		    System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|                                    Camp Menu (Student)                             |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("User ID: " + this.getID());
            System.out.println("Name: " + this.getName());			
			showStudentMenu();
			System.out.println("|-1. Exit Menu                                                                       |");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("Menu Option: ");
        	choice = sc.nextInt();
        }while(choice>9||choice<-1);
        return choice;
	}

	protected void showStudentMenu() {
		System.out.println("|1. View All Available Camps                                                         |");
		System.out.println("|2. Register For Camp                                                                |");
		System.out.println("|3. View Registered Camps                                                            |");
		System.out.println("|4. Withdraw From Camp                                                               |");
		System.out.println("|5. View Enquiries Menu For Student                                                  |");

}

	public ArrayList<CampInfo> generateAvailableCamps(){
		ArrayList<CampInfo> availableCamps = new ArrayList<>();
		//For each camp in camp list
        for (CampInfo eachCamp : CampList.getCampList()){
            if ((eachCamp.getUserGroup() == Faculty.ALL || this.getFaculty() == eachCamp.getUserGroup()) && eachCamp.getVisibility()){ 
                availableCamps.add(eachCamp);
            }
		}
		return availableCamps;
	}

	@Override
	public void menuChoice(int i){
		Scanner sc = new Scanner(System.in);
		switch(i)
		{
			case 1: //View All Available Camps
				CampList.viewAllCamps(this.getAvailableCamps(),"Available");
				break;

			case 2: //Register For Camp 
				CampList.viewAllCamps(this.getAvailableCamps(),"Available");
				if (this.getAvailableCamps().size() !=0){
					System.out.print("Choose a camp to sign up for (enter the number): ");
					int chosenCampIndex = sc.nextInt();
					if (this.getWithdrawnCamps().contains(this.getAvailableCamps().get(chosenCampIndex-1))) {
						System.out.println("Cannot register. "+ this.getName() + " has already withdrawn from this camp: " + CampList.getCampInfo(chosenCampIndex-1).getCampName());
					}
					else{
						System.out.println("1. Sign up as member");
						System.out.println("2. Sign up as committee");
						System.out.print("Enter your choice:");
						int choice = sc.nextInt();

						// Find the correct CampInfo
						CampInfo correctCampInfo = this.getAvailableCamps().get(chosenCampIndex-1);

						if (choice ==1){

							// Adjust the student attendees for that camp
							correctCampInfo.addStudentAttendees(this);
							this.addRegisteredCamp(this.getAvailableCamps().get(chosenCampIndex-1));
							
						}

						if (choice == 2){
							//if user is already a committee for a camp -> cannot register as committee
							if (this.getCommitteeOf() != null) {
								System.out.println("You are already a committee member for the camp: " + (this.getCommitteeOf().getCampName()));
								break;
							}
							else if(correctCampInfo.getCommitteeSlots()>0){
								this.addRegisteredCamp(correctCampInfo);
								this.setCommitteeOf(correctCampInfo); 
								this.committeeUser = new CampCommittee(this.getID(), this.getName(), this.getFaculty(), this.getEmail(), correctCampInfo,
								this.getRegisteredCamps(), this.getWithdrawnCamps(), this.getEnquiriesMade(), this.getAvailableCamps(), 0);
								correctCampInfo.addCampCom(committeeUser);
							}
							else{
								System.out.println("No more committee slots availalble");
							}
						}
					}	
				}
					break;

			case 3:
				// view registered camp
				CampList.viewAllCamps(this.getRegisteredCamps(),"Registered");
				break;

			case 4:
				// Withdraw from camp
				CampList.viewAllCamps(this.getRegisteredCamps(),"Registered");
				if (this.getRegisteredCamps().size() != 0){
					System.out.print("Choose a camp registered to withdraw (enter the number): ");
					int chosenCampIndex = sc.nextInt();
					
					// Find the correct CampInfo
					CampInfo correctCampInfo = this.getRegisteredCamps().get(chosenCampIndex-1);

					if (this.getCommitteeOf()!=null && this.getCommitteeOf().equals(this.getRegisteredCamps().get(chosenCampIndex-1))) {
						System.out.println("Cannot withdraw. Student is a committee for camp: "+ this.getCommitteeOf().getCampName());
					}
					else{
						//For camp class to keep track of all the students that withdrawn
						correctCampInfo.addWithdrawnStudents(this); 
						//For student class to keep track of camp withdrawn
						this.addWithdrawnCamp(this.getRegisteredCamps().get(chosenCampIndex-1)); 
					}
				}
				break;
			case 5:
				EnquiryMenu.menuChoice(this, enquiriesMade);
				break;
            case -1:
                // Exit Menu
                System.out.println("Exiting Camp Menu. Goodbye!");
                System.exit(0);
                break;
		}

	}

}