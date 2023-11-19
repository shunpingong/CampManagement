package src;

import java.util.ArrayList;
import java.util.Scanner;

public class CampCommittee extends Student {
    // Instances
    private int points;
	private CampInfo committeeOf; //to store the camp that student is a committee of
	private static SuggestionList suggestionsMade  = new SuggestionList(); //List of Suggestions Camp Committee made

    // Constructors
    //ADD CONSTRUCTORS
    public CampCommittee(String userID, String name, Faculty faculty, String email, CampInfo committeeOf,
    ArrayList<CampInfo> registeredCamps, ArrayList<CampInfo> withdrawnCamps,  EnquiryList enquiriesMade, int points){

        super(userID, name, faculty, email);
        //this.setStatus("Camp Committee");
        this.committeeOf = committeeOf;
        this.points = points;
        super.registeredCamps = registeredCamps;
        super.withdrawnCamps = withdrawnCamps;
        super.enquiriesMade = enquiriesMade;
        this.suggestionsMade = new SuggestionList();
        
    }

/*---------------------------------------------------------------ACCESSORS -------------------------------------------------------------------------*/
    public int getPoints(){
        return this.points;
    }

	public CampInfo getCommitteeOf(){
		return this.committeeOf;
	}

    //Suggestions made by student: Bala
	public void viewSuggestionsMade() {
		suggestionsMade.displaySuggestions();
    }

/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/
    public void setPoints(int points){
        this.points = points;
    }

    public void addPoints(){
        this.points++;
        System.out.println("Added 1 point for student: " + this.getName());
    }

    public boolean isInChargeOfCamp(String camp) {
        // Check if the CampCommittee is in charge of the specified camp
        return (this.getCommitteeOf().equals(camp));
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
            System.out.println("|9. View Details Of Registered Camp                                                  |");
            System.out.println("|10. View All Enquiries Of Oversee Camp                                              |");
            System.out.println("|11. Reply To Enquiries Of Oversee Camp                                              |");
            System.out.println("|12. Submit Camp Suggestions                                                         |");
            System.out.println("|13. View Submitted Suggestions                                                      |");
            System.out.println("|14. Edit Submitted Suggestions                                                      |");
            System.out.println("|15. Delete Submitted Suggestions                                                    |");
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
            case 6:
            case 7:
            case 8:
                super.menuChoice(i);
                break;
            case 9: //View Details Of Registered Camp 
                this.getCommitteeOf().printCamp();
                break;

             case 10: //View All Enquiries Of Oversee Camp
                
                this.getCommitteeOf().getEnquiriesForCamp().displayEnquiries();
                break; 

            case 11: //Reply To Enquiries Of Oversee Camp
                //NEED TO KEEP TRACK OF COUNT
                this.getCommitteeOf().getEnquiriesForCamp().displayEnquiries();

                //If no enquiries output
                if(this.getCommitteeOf().getEnquiriesForCamp().getSize() == 0){
                    System.out.println("No enquiries were made for camp: "+ this.getCommitteeOf().getCampName() );
                }
                else{
                    this.getCommitteeOf().getEnquiriesForCamp().displayEnquiries();

                	int chosenEnquiryIndex=0;

					while (chosenEnquiryIndex==0 || chosenEnquiryIndex > this.getCommitteeOf().getEnquiriesForCamp().getSize()){
						System.out.print("Choose a enquiry not processed to reply (enter the number): ");
						chosenEnquiryIndex = sc.nextInt();
					}

                     // Consume the newline character
                    sc.nextLine();

                    if(this.getCommitteeOf().getEnquiriesForCamp().getEnquiry(chosenEnquiryIndex).isProcessed()){
                        System.out.println("Enquiry already processed and cannot be replied");
                    }

                    else{
                        System.out.print("Enter reply to the enquiry: ");
                        String text = sc.nextLine();
                        this.getCommitteeOf().getEnquiriesForCamp().getEnquiry(chosenEnquiryIndex).reply(this, text);
                    }
                }
                
                break;

            case 12: //Submit Camp Suggestions
                System.out.print("Choose a camp to submit enquiry for (enter the number): ");
                int chosenCampIndex = sc.nextInt();

                // Consume the newline character
                sc.nextLine();

                // Get the camp Name
                CampInfo chosenCamp = CampList.getCampInfo(chosenCampIndex-1);
                
                //Enter suggestion
                System.out.print("Enter suggestion: ");
                String text = sc.nextLine();
                
                // Create an suggestion object and add it to the suggestion list
                Suggestion newSuggestion = new Suggestion(text, this, chosenCamp, "");
                suggestionsMade.addSuggestion(newSuggestion);

                break;

            case 13: //View Submitted Suggestions
					//Output suggestions made by this student committee instance
					this.viewSuggestionsMade();
                break;

            case 14: //Edit Submitted Suggestions
				if (suggestionsMade.getSize() == 0){
					System.out.println("No suggestions to update.");
				}
				else 
				{
					this.viewSuggestionsMade();
					int chosenSuggestionIndex=0;

					while (chosenSuggestionIndex==0 || chosenSuggestionIndex >suggestionsMade.getSize()){
						System.out.print("Choose a suggestion to update (enter the number): ");
						chosenSuggestionIndex = sc.nextInt();
					}
					
					// Consume the newline character
					sc.nextLine();

					System.out.print("Enter new suggestion: ");
					text = sc.nextLine();
					suggestionsMade.getSuggestion(chosenSuggestionIndex-1).updateText(text);
				}
                break;

			case 15: //Delete Submitted Suggestions
				if (suggestionsMade.getSize() == 0){
					System.out.println("No suggestions to delete.");
				}

				else {
					this.viewSuggestionsMade();

					int chosenSuggestionIndex = 0;
					while (chosenSuggestionIndex ==0 || chosenSuggestionIndex > suggestionsMade.getSize()){
						System.out.print("Choose a suggestion to delete (enter the number): ");
						chosenSuggestionIndex = sc.nextInt();
					}
					
					chosenCamp = suggestionsMade.getSuggestion(chosenSuggestionIndex-1).getCamp();

					// Consume the newline character
					sc.nextLine();

					suggestionsMade.deleteSuggestion(chosenCamp, this);
				}
				break;

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