package src.user_data;

import java.util.ArrayList;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.feedback.enquiry.EnquiryReply;
import src.feedback.suggestions.Suggestion;
import src.feedback.suggestions.SuggestionMenu;;


public class CampCommittee extends Student {
    // Instances
    private int points;

	private ArrayList<Suggestion> suggestionsMade  = new ArrayList<Suggestion>(); //List of Suggestions Camp Committee made

    // Constructors
    //ADD CONSTRUCTORS
    public CampCommittee(String userId, String name, Faculty faculty, String email, CampInfo committeeOf){
        super(userId, name, faculty, email);
        this.suggestionsMade = new ArrayList<Suggestion>();
    }
/*---------------------------------------------------------------ACCESSORS -------------------------------------------------------------------------*/
    public int getPoints(){
        return this.points;
    }

    //Suggestions made by student: Bala
	public ArrayList<Suggestion> getSuggestionsMade() {
		return this.suggestionsMade;
    }

/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/
    public void setPoints(int points){
        this.points = points;
    }

    public void addPoints(int point){
        this.points += point;
        System.out.println(point + " point for student: " + this.getName() + "\n");
  
    }

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/

	@Override
    public int menu() {
		Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("--------------------------------------------------------------------------------------");
            if (this.getCommitteeOf()!= null){
                System.out.println("|                                    Camp Menu (Committee)                           |");
            }
            else{
                System.out.println("|                                    Camp Menu (Student)                             |");
            }
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("User ID: " + this.getID());
            System.out.println("Name: " + this.getName());
            if (this.getCommitteeOf() != null){
                System.out.printf("Committee of : %s\n", this.getCommitteeOf().getCampName());
                System.out.printf("Points       : %d\n", this.getPoints());
            }
            else{
                System.out.printf("Committee of : No Committee Assigned\n");
            }
            super.showStudentMenu();
            if (this.getCommitteeOf() != null){
                System.out.println("|7. View Details Of Registered Camp                                                  |");
                System.out.println("|8. View Enquiries Menu For Committee                                                |");
                // System.out.println("|10. View All Unprocessed Enquiries Of Oversee Camp                                  |");
                // System.out.println("|11. Reply To Unprocessed Enquiries Of Oversee Camp                                  |");
                System.out.println("|9. View Suggestion Menu For Committee                                               |");
                System.out.println("|10. Generate Report                                                                 |");
            }
                System.out.println("|-1. LOGOUT                                                                          |");
            System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("Menu Option: ");
            choice = sc.nextInt();
        }while(choice>16||choice<-1);
        sc.close();
        return choice;
	}

    @Override
    public void menuChoice(int i){
        Scanner sc = new Scanner(System.in);
		switch(i)
        {
			case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                super.menuChoice(i);
                break;
            
            case 7: //View Details Of Registered Camp 
                if (this.getCommitteeOf()!= null){
                    this.getCommitteeOf().printCamp();
                }
                break;
            case 8: //View Enquiries Menu For Committee 
                if (this.getCommitteeOf() != null){
                    EnquiryReply.replyMenu(this.getCommitteeOf(), this, this.getEnquiriesMade());
                }
                break;
            case 9: //View Suggestion Menu For Committee
                if (this.getCommitteeOf() != null){
                    SuggestionMenu.menuChoice(this, suggestionsMade);
                }
                break;
            case 10: //Generate Report
                
                break;

            case -1:
                // Exit Menu
                System.out.println("Exiting Camp Menu. Goodbye!");
                System.exit(0);
            break;
        }
        sc.close();
    }
}