package src.user_interface;

import java.util.Scanner;

import src.camp_management.CampList;
import src.feedback.enquiry.EnquiryReply;
import src.feedback.suggestions.SuggestionMenu;
import src.user_data.CampCommittee;

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
        System.out.printf("Committee of : %s\n", this.committee.getCommitteeOf());
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
			System.out.println("|2. Register For Camp                                                                |");
			System.out.println("|3. View Registered Camps                                                            |");
			System.out.println("|4. Withdraw From Camp                                                               |");
			System.out.println("|5. View Enquiries Menu For Student                                                  |");
			System.out.println("|6. Change Password                                                                  |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|                                * Committee Exclusive *                             |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|7. View Details Of Registered Camp                                                  |");
            System.out.println("|8. View Enquiries Menu For Committee                                                |");
            System.out.println("|9. View Suggestion Menu For Committee                                               |");
            System.out.println("|10. Generate Report                                                                 |");
            System.out.println("|-1. LOGOUT                                                                          |");
            System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("Menu Option: ");
            choice = sc.nextInt();
        }while(choice>16||choice<-1);
    }

    @Override
    public void selectOptions() {
        super.selectOptions();
		switch(choice)
        {
            case 7: //View Details Of Registered Camp 
                CampList.getCampInfo(this.committee.getCommitteeOf()).printCamp();
                break;
            case 8: //View Enquiries Menu For Committee 
                EnquiryReply.replyMenu(CampList.getCampInfo(this.committee.getCommitteeOf()), this.committee, this.committee.getEnquiriesMade());
                break;
            case 9: //View Suggestion Menu For Committee
                SuggestionMenu.menuChoice(this.committee, this.committee.getSuggestionsMade());
                break;
            case 10: //Generate Report
                
                break;
            case -1:
                // Exit Menu
                System.out.println("Exiting Committee Menu. Goodbye!");
                System.exit(0);
            break;
        }
    }
    
}
