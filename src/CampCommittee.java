package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.enquiry.Enquiry;
import src.enquiry.EnquiryReply;
import src.suggestions.Suggestion;
import src.suggestions.SuggestionMenu;;

public class CampCommittee extends Student {
    // Instances
    private int points;

	private ArrayList<Suggestion> suggestionsMade  = new ArrayList<Suggestion>(); //List of Suggestions Camp Committee made

    // Constructors
    //ADD CONSTRUCTORS
        
    public CampCommittee(String userID, String name, Faculty faculty, String email, CampInfo committeeOf,
    ArrayList<CampInfo> registeredCamps, ArrayList<CampInfo> withdrawnCamps,  ArrayList<Enquiry> enquiriesMade, ArrayList<CampInfo> availableCamps, int points){

        super(userID, name, faculty, email);
        this.points = points;
        super.registeredCamps = registeredCamps;
        super.withdrawnCamps = withdrawnCamps;
        super.enquiriesMade = enquiriesMade;
        super.committeeOf = committeeOf;
        super.availableCamps = availableCamps;
        this.suggestionsMade = new ArrayList<Suggestion>();
        
    }


/*---------------------------------------------------------------ACCESSORS -------------------------------------------------------------------------*/
    public int getPoints(){
        return this.points;
    }

	public CampInfo getCommitteeOf(){
		return this.committeeOf;
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
        System.out.println(point + " point for student: " + this.getName());
  
    }

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/

	@Override
    public int menu() {
		Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|                                    Camp Menu (Committee)                           |");
            System.out.println("--------------------------------------------------------------------------------------");
            super.showStudentMenu();
            System.out.println("|6. View Details Of Registered Camp                                                  |");
            System.out.println("|7. View Enquiries Menu For Committee                                                |");
            // System.out.println("|10. View All Unprocessed Enquiries Of Oversee Camp                                  |");
            // System.out.println("|11. Reply To Unprocessed Enquiries Of Oversee Camp                                  |");
            System.out.println("|8. View Suggestion Menu For Committee                                                |");
            System.out.println("|9. Generate Report                                                                   |");

            // System.out.println("|12. Submit Camp Suggestions                                                         |");
            // System.out.println("|13. View Submitted Suggestions                                                      |");
            // System.out.println("|14. Edit Submitted Suggestions                                                      |");
            // System.out.println("|15. Delete Submitted Suggestions                                                    |");
            System.out.println("|16. Generate Report                                                                 |");
            System.out.println("|-1. Exit Menu                                                                       |");
            System.out.println("--------------------------------------------------------------------------------------");
			System.out.print("Menu Option: ");
            choice = sc.nextInt();
        }while(choice>16||choice<-1);
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
                super.menuChoice(i);
                break;
            case 6: //View Details Of Registered Camp 
                this.getCommitteeOf().printCamp();
                break;
            case 7:
                EnquiryReply.replyMenu(this.getCommitteeOf(), this, this.getEnquiriesMade());
            case 8:
                SuggestionMenu.menuChoice(this, suggestionsMade);
                break;
            //  case 12: //Submit Camp Suggestions
            //     System.out.print("Choose a camp to submit enquiry for (enter the number): ");
            //     int chosenCampIndex = sc.nextInt();

            //     // Consume the newline character
            //     sc.nextLine();

            //     // Get the camp Name
            //     CampInfo chosenCamp = CampList.getCampInfo(chosenCampIndex-1);
                
            //     //Enter suggestion
            //     System.out.print("Enter suggestion: ");
            //     String text = sc.nextLine();
                
            //     // Create an suggestion object and add it to the suggestion list
            //     Suggestion newSuggestion = new Suggestion(text, this, chosenCamp, "");
            //     suggestionsMade.addSuggestion(newSuggestion);

            //     break;

            // case 13: //View Submitted Suggestions
			// 		//Output suggestions made by this student committee instance
			// 		this.viewSuggestionsMade();
            //     break;

            // case 14: //Edit Submitted Suggestions
			// 	if (suggestionsMade.getSize() == 0){
			// 		System.out.println("No suggestions to update.");
			// 	}
			// 	else 
			// 	{
			// 		this.viewSuggestionsMade();
			// 		int chosenSuggestionIndex=0;

			// 		while (chosenSuggestionIndex==0 || chosenSuggestionIndex >suggestionsMade.getSize()){
			// 			System.out.print("Choose a suggestion to update (enter the number): ");
			// 			chosenSuggestionIndex = sc.nextInt();
			// 		}
					
			// 		// Consume the newline character
			// 		sc.nextLine();

			// 		System.out.print("Enter new suggestion: ");
			// 		text = sc.nextLine();
			// 		suggestionsMade.getSuggestion(chosenSuggestionIndex-1).updateText(text);
			// 	}
            //     break;

			// case 15: //Delete Submitted Suggestions
			// 	if (suggestionsMade.getSize() == 0){
			// 		System.out.println("No suggestions to delete.");
			// 	}

			// 	else {
			// 		this.viewSuggestionsMade();

			// 		int chosenSuggestionIndex = 0;
			// 		while (chosenSuggestionIndex ==0 || chosenSuggestionIndex > suggestionsMade.getSize()){
			// 			System.out.print("Choose a suggestion to delete (enter the number): ");
			// 			chosenSuggestionIndex = sc.nextInt();
			// 		}
					
			// 		chosenCamp = suggestionsMade.getSuggestion(chosenSuggestionIndex-1).getCamp();

			// 		// Consume the newline character
			// 		sc.nextLine();

			// 		suggestionsMade.deleteSuggestion(chosenCamp, this);
			// 	}
			// 	break;

            case 16: //Generate Report
                
                break;

            case -1:
                // Exit Menu
                System.out.println("Exiting Camp Menu. Goodbye!");
                System.exit(0);
            break;
        }
    }
}