package src.user_interface;

import java.util.Scanner;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.feedback.enquiry.EnquiryMenu;
import src.feedback.enquiry.EnquiryReply;
import src.feedback.suggestions.SuggestionMenu;
import src.login_system.Login;
import src.login_system.Password;
import src.report.Report;
import src.user_data.CampCommittee;
import src.user_data.StudentData;
import src.user_interface.interfaces.IMenu;

public class CommitteeMenu extends StudentMenu {
    //Instances
    private CampCommittee committee;

    //Constructor
    public CommitteeMenu(CampCommittee committee){
        super(committee);
        this.committee = committee;
    }

    public void printUserStatus(){
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("User ID: " + this.committee.getID());
        System.out.println("Name: " + this.committee.getName());
        System.out.printf("Committee of : %s\n", this.committee.getCommitteeOf().getCampName());
        System.out.printf("Points       : %d\n", this.committee.getPoints());
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void printMenuTitle(){
        System.out.println("======================================================================================");
        System.out.println("|                                    Camp Menu (Committee)                           |");
        System.out.println("======================================================================================");
        
    }

    @Override
    public void printMenuOptions() {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|1. View All Available Camps                                                         |");
			System.out.println("|2. View Registered Camps                                                            |");
			System.out.println("|3. View Enquiries Menu For Student                                                  |");
			System.out.println("|4. Change Password                                                                  |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|                                * Committee Exclusive *                             |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|5. View Details Of Registered Camp                                                  |");
            System.out.println("|6. View Enquiries Menu For Committee                                                |");
            System.out.println("|7. View Suggestion Menu For Committee                                               |");
            System.out.println("|8. Generate Report                                                                  |");
            System.out.println("|-1. LOGOUT                                                                          |");
            System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("Menu Option: ");
            choice = sc.nextInt();
        }while(!(choice == -1 || (choice >= 1 && choice <=8)));
    }

    @Override
    public void selectOptions() {
        Scanner sc = new Scanner(System.in);
		this.committee.setAvailableCamp(this.committee.generateAvailableCamps());
		IMenu menu = null;
		int chosenCampIndex;
		switch(choice)
		{
			case 1: //View Available and Register For Camp 
				if(this.committee.getAvailableCamps().size() == 0){
					int confirm = 0;
					System.out.println("No camps at the moment. Come back later");
					do{
						System.out.print("Press '1' to Confirm: ");
						confirm = sc.nextInt();
					}while(confirm != 1);
					break;
				}
				menu = new CampViewerST(this.committee.getAvailableCamps(), "Available");
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
				if (this.committee.getWithdrawnCamps().contains(this.committee.getAvailableCamps().get(chosenCampIndex-1)) ||
				this.committee.getRegisteredCamps().contains(this.committee.getAvailableCamps().get(chosenCampIndex-1))) {
					System.out.println("Cannot register. "+ this.committee.getName() + " has already registered/withdrawn from this camp: " + this.committee.getAvailableCamps().get(chosenCampIndex-1).getCampName());
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
					CampInfo correctCampInfo = this.committee.getAvailableCamps().get(chosenCampIndex-1);

					if (signup ==1){
						// Adjust the student attendees for that camp
						correctCampInfo.addStudentAttendees(this.committee);
						this.committee.addRegisteredCamp(this.committee.getAvailableCamps().get(chosenCampIndex-1));
						StudentData.setUser(this.committee);
					}

					if (signup == 2){
						//if user is already a committee for a camp -> cannot register as committee
						System.out.println("You are already a committee member for a camp: " + (correctCampInfo.getCampName()));
						do{
							System.out.print("Press '1' to Confirm: ");
							choice = sc.nextInt();
						}while(choice != 1);
						break;
					}
				}	
				break;

			case 2:
				// view registered camp
				if(this.committee.getRegisteredCamps().size() == 0){
					int confirm = 0;
					System.out.println("No camps registered. Go find a camp");
					do{
						System.out.print("Press '1' to Confirm: ");
						confirm = sc.nextInt();
					}while(confirm != 1);
					break;
				}
				menu = new CampViewerST(this.committee.getRegisteredCamps(),"Registered");
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
				CampInfo correctCampInfo = this.committee.getRegisteredCamps().get(chosenCampIndex-1);
				CampCommittee comm = null;
				if(this.committee.getRole().equalsIgnoreCase("Committee"))
					comm = (CampCommittee) this.committee;

				if (comm != null && comm.getCommitteeOf().getCampName().equals(this.committee.getRegisteredCamps().get(chosenCampIndex-1).getCampName())) {
					System.out.println("Cannot withdraw. Student is a committee for camp: "+ comm.getCommitteeOf().getCampName());
					do{
						System.out.print("Press '1' to Confirm: ");
						choice = sc.nextInt();
					}while(choice != 1);
					break;
				}
				else{
					//For camp class to keep track of all the students that withdrawn
					correctCampInfo.addWithdrawnStudents(this.committee); 
					//For student class to keep track of camp withdrawn
					this.committee.addWithdrawnCamp(this.committee.getRegisteredCamps().get(chosenCampIndex-1)); 
					StudentData.setUser(this.committee);
				}
				break;
			case 3:
				EnquiryMenu.menuChoice(this.committee, this.committee.getEnquiriesMade());
				break;
			case 4:
				Password.change(this.committee);
				break;
            case 5: //View Details Of Registered Camp 
                CampList.getCampInfo(this.committee.getCommitteeOf().getCampName()).printCamp();
                break;
            case 6: //View Enquiries Menu For Committee 
                EnquiryReply.replyMenu(CampList.getCampInfo(this.committee.getCommitteeOf().getCampName()), this.committee, this.committee.getEnquiriesMade());
                break;
            case 7: //View Suggestion Menu For Committee
                SuggestionMenu.menuChoice(this.committee, this.committee.getSuggestionsMade());
                break;
            case 8: //Generate Report
                Report report = new Report(this.committee.getCommitteeOf(), "Report For " + this.committee.getID());
				report.export();
				int confirm = 0;
				System.out.println("Report Generated.");
				do{
					System.out.print("Press '1' to Confirm: ");
					confirm = sc.nextInt();
				}while(confirm != 1);
                break;
            case -1:
                // Exit Menu
                System.out.println("Exiting Student Menu. Goodbye!");
				Login.logout();
                break;
		}
    }
    
}
