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
import src.user_data.StudentData;
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
			System.out.println("|2. View Registered Camps                                                            |");
			System.out.println("|3. View Enquiries Menu For Student                                                  |");
			System.out.println("|4. Change Password                                                                  |");
			System.out.println("|-1. Logout                                                                          |");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("Menu Option: ");
        	choice = sc.nextInt();
        }while(!(choice == -1 || (choice >= 1 && choice <=4)));
    }

    public void selectOptions(){
        Scanner sc = new Scanner(System.in);
		this.student.setAvailableCamp(this.student.generateAvailableCamps());
		IMenu menu = null;
		int chosenCampIndex;
		switch(choice)
		{
			case 1: //View Available and Register For Camp 
				if(this.student.getAvailableCamps().size() == 0){
					int confirm = 0;
					System.out.println("No camps at the moment. Come back later");
					do{
						System.out.print("Press '1' to Confirm: ");
						confirm = sc.nextInt();
					}while(confirm != 1);
					break;
				}
				menu = new CampViewerST(this.student.getAvailableCamps(), "Available");
				menu.printMenu();
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println("|1. Register for Camps                                                               |");
				System.out.println("|2. Return                                                                           |");
				System.out.println("--------------------------------------------------------------------------------------");
				do{
					System.out.printf("Menu Option: ");
					choice = sc.nextInt();
				}while(!(choice == 1 || choice == 2));
				if(choice == 2)
					break;
				System.out.print("Choose a camp to sign up for (enter the number): ");
				chosenCampIndex = sc.nextInt();
				if (this.student.getWithdrawnCamps().contains(this.student.getAvailableCamps().get(chosenCampIndex-1)) ||
				this.student.getRegisteredCamps().contains(this.student.getAvailableCamps().get(chosenCampIndex-1))) {
					System.out.println("Cannot register. "+ this.student.getName() + " has already registered/withdrawn from this camp: " + this.student.getAvailableCamps().get(chosenCampIndex-1).getCampName());
					do{
						System.out.print("Press '1' to Confirm: ");
						choice = sc.nextInt();
					}while(choice != 1);
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
						StudentData.setUser(this.student);
					}

					if (signup == 2){
						//if user is already a committee for a camp -> cannot register as committee
						if (this.student.getRole().equalsIgnoreCase("Committee")) {
							System.out.println("You are already a committee member for the camp: " + (correctCampInfo.getCampName()));
							do{
								System.out.print("Press '1' to Confirm: ");
								choice = sc.nextInt();
							}while(choice != 1);
							break;
						}
						else if(correctCampInfo.getCommitteeSlots()>0){
							CampCommittee comm = convertToCommittee(this.student, correctCampInfo);
							comm.addRegisteredCamp(correctCampInfo);
							comm.setCommitteeOf(correctCampInfo);
							correctCampInfo.addCampCom(comm);
							CampList.setCampInfo(correctCampInfo);
							StudentData.setUser(comm);
							Login.setCurrentUser(comm);
						}
						else{
							System.out.println("No more committee slots availalble");
							do{
								System.out.print("Press '1' to Confirm: ");
								choice = sc.nextInt();
							}while(choice != 1);
							break;
						}
					}
				}	
				break;

			case 2:
				// view registered camp
				if(this.student.getRegisteredCamps().size() == 0){
					int confirm = 0;
					System.out.println("No camps registered. Go find a camp");
					do{
						System.out.print("Press '1' to Confirm: ");
						confirm = sc.nextInt();
					}while(confirm != 1);
					break;
				}
				menu = new CampViewerST(this.student.getRegisteredCamps(),"Registered");
				menu.printMenu();
				// Withdraw from camp
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.println("|1. Withdraw from Camps                                                              |");
				System.out.println("|2. Return                                                                           |");
				System.out.println("--------------------------------------------------------------------------------------");
				do{
					System.out.printf("Menu Option: ");
					choice = sc.nextInt();
				}while(!(choice == 1 || choice == 2));
				if(choice == 2)
					break;
				System.out.print("Choose a camp registered to withdraw (enter the number): ");
				chosenCampIndex = sc.nextInt();
				
				// Find the correct CampInfo
				CampInfo correctCampInfo = this.student.getRegisteredCamps().get(chosenCampIndex-1);
				CampCommittee comm = null;
				if(this.student.getRole().equalsIgnoreCase("Committee"))
					comm = (CampCommittee) this.student;

				if (comm != null && comm.getCommitteeOf().equals(this.student.getRegisteredCamps().get(chosenCampIndex-1))) {
					System.out.println("Cannot withdraw. Student is a committee for camp: "+ comm.getCommitteeOf());
					do{
						System.out.print("Press '1' to Confirm: ");
						choice = sc.nextInt();
					}while(choice != 1);
					break;
				}
				else{
					//For camp class to keep track of all the students that withdrawn
					correctCampInfo.addWithdrawnStudents(this.student); 
					//For student class to keep track of camp withdrawn
					this.student.addWithdrawnCamp(this.student.getRegisteredCamps().get(chosenCampIndex-1)); 
					StudentData.setUser(this.student);
				}
				break;
			case 3:
				EnquiryMenu.menuChoice(this.student, this.student.getEnquiriesMade());
				break;
			case 4:
				Password.change(this.student);
				break;
            case -1:
                // Exit Menu
                System.out.println("Exiting Student Menu. Goodbye!");
				Login.logout();
                break;
		}
    }

	private CampCommittee convertToCommittee(Student student, CampInfo camp){
		CampCommittee comm = new CampCommittee(student.getID(), student.getName(), student.getFaculty(), student.getEmail(), camp);
		comm.setPWD(student.getPWD());
		ArrayList<String> commData = new ArrayList<>();
		commData.add(comm.getName());
		commData.add(comm.getEmail());
		commData.add(comm.getFaculty().toString());
		commData.add(comm.getPWD());
		commData.add(comm.getRole());
		commData.add(comm.getCommitteeOf().getCampName());
		ExcelManager xl = new ExcelManager("data\\student_list.xlsx");
		xl.updateXL(commData);
		return comm;
	}
}
