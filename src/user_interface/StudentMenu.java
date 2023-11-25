package src.user_interface;

import java.util.ArrayList;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.feedback.enquiry.EnquiryMenu;
import src.login_system.Login;
import src.login_system.Password;
import src.user_data.CampCommittee;
import src.user_data.ExcelManager;
import src.user_data.Student;
import src.user_data.User;
import src.user_interface.interfaces.IMenu;
import src.user_interface.interfaces.IUserMenu;

public class StudentMenu implements IUserMenu{
    // Instances 
    private Student student;
    protected int choice;

    // Constructor
    public StudentMenu(Student student){
        this.student = student;
		this.choice = 0;
    }
	
	public void printMenu(){
		printMenuTitle();
		printUserStatus();
		printMenuOptions();
		selectOptions();
	}

	public void printUserStatus(){
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("User ID: " + this.student.getID());
		System.out.println("Name: " + this.student.getName());	
		System.out.println("--------------------------------------------------------------------------------------");
	}

	public void printMenuTitle(){
		System.out.println("======================================================================================");
		System.out.println("|                                    Camp Menu (Student)                             |");
		System.out.println("======================================================================================");
		
	}

    public void printMenuOptions(){
        Scanner sc = new Scanner(System.in);
        do{		
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("|1. View All Available Camps                                                         |");
			System.out.println("|2. Register For Camp                                                                |");
			System.out.println("|3. View Registered Camps                                                            |");
			System.out.println("|4. Withdraw From Camp                                                               |");
			System.out.println("|5. View Enquiries Menu For Student                                                  |");
			System.out.println("|6. Change Password                                                                  |");
			System.out.println("|-1. Logout                                                                          |");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("Menu Option: ");
        	choice = sc.nextInt();
        }while(choice>10||choice<-1);
    }

    public void selectOptions(){
        Scanner sc = new Scanner(System.in);
		this.student.setAvailableCamp(this.student.generateAvailableCamps());
		switch(choice)
		{
			case 1: //View All Available Camps
				IMenu menu = new CampViewerST(this.student.getAvailableCamps(),"Available");
				menu.printMenu();
				break;

			case 2: //Register For Camp 
				if (this.student.getAvailableCamps().size() !=0){
					System.out.print("Choose a camp to sign up for (enter the number): ");
					int chosenCampIndex = sc.nextInt();
					if (this.student.getWithdrawnCamps().contains(this.student.getAvailableCamps().get(chosenCampIndex-1)) ||
					this.student.getRegisteredCamps().contains(this.student.getAvailableCamps().get(chosenCampIndex-1))) {
						System.out.println("Cannot register. "+ this.student.getName() + " has already registered/withdrawn from this camp: " + this.student.getAvailableCamps().get(chosenCampIndex-1).getCampName());
					}
					else{
						System.out.println("1. Sign up as member");
						System.out.println("2. Sign up as committee");
						System.out.print("Enter your choice:");
						int signup = sc.nextInt();

						// Find the correct CampInfo
						CampInfo correctCampInfo = this.student.getAvailableCamps().get(chosenCampIndex-1);

						if (signup ==1){
							// Adjust the student attendees for that camp
							correctCampInfo.addStudentAttendees(this.student);
							this.student.addRegisteredCamp(this.student.getAvailableCamps().get(chosenCampIndex-1));
							
						}

						if (signup == 2){
							//if user is already a committee for a camp -> cannot register as committee
							if (this.student.getRole() == "Committee") {
								System.out.println("You are already a committee member for the camp: " + (correctCampInfo.getCampName()));
								break;
							}
							else if(correctCampInfo.getCommitteeSlots()>0){
								CampCommittee comm = convertToCommittee(this.student, correctCampInfo.getCampName());
								comm.addRegisteredCamp(correctCampInfo);
								comm.setCommitteeOf(correctCampInfo.getCampName());
								correctCampInfo.addCampCom(comm);
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
				menu = new CampViewerST(this.student.getRegisteredCamps(),"Registered");
				break;

			case 4:
				// Withdraw from camp
				if (this.student.getRegisteredCamps().size() != 0){
					System.out.print("Choose a camp registered to withdraw (enter the number): ");
					int chosenCampIndex = sc.nextInt();
					
					// Find the correct CampInfo
					CampInfo correctCampInfo = this.student.getRegisteredCamps().get(chosenCampIndex-1);
					CampCommittee comm = null;
					if(this.student.getRole() == "Committee")
						comm = (CampCommittee) this.student;

					if (comm != null && comm.getCommitteeOf().equals(this.student.getRegisteredCamps().get(chosenCampIndex-1))) {
						System.out.println("Cannot withdraw. Student is a committee for camp: "+ comm.getCommitteeOf());
					}
					else{
						//For camp class to keep track of all the students that withdrawn
						correctCampInfo.addWithdrawnStudents(this.student); 
						//For student class to keep track of camp withdrawn
						this.student.addWithdrawnCamp(this.student.getRegisteredCamps().get(chosenCampIndex-1)); 
					}
				}
				break;
			case 5:
				EnquiryMenu.menuChoice(this.student, this.student.getEnquiriesMade());
				break;
			case 6:
				Password.change(this.student);
				break;
            case -1:
                // Exit Menu
                System.out.println("Exiting Student Menu. Goodbye!");
				Login.logout();
                break;
		}
    }

	private CampCommittee convertToCommittee(Student student, String camp){
		CampCommittee comm = new CampCommittee(student.getID(), student.getName(), student.getFaculty(), student.getEmail(), camp);
		ArrayList<String> commData = new ArrayList<>();
		commData.add(comm.getName());
		commData.add(comm.getEmail());
		commData.add(comm.getFaculty().toString());
		commData.add(comm.getPWD());
		commData.add(comm.getRole());
		commData.add(comm.getCommitteeOf());
		ExcelManager xl = new ExcelManager("data\\student_list.xlsx");
		xl.updateXL(commData);
		return comm;
	}
}
