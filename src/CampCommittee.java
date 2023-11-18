package src;

import java.util.Scanner;

public class CampCommittee extends Student {
    // Instances
    private int points;
	private static SuggestionList suggestionsMade  = new SuggestionList(); //List of Suggestions Camp Committee made


    // Constructors
    public CampCommittee(String userID, String name, Faculty faculty, String email, String status, int points){
        super(userID, name, faculty, email);
        //this.setStatus("Camp Committee");
        this.points = points;
    }

    // Accessors
    public int getPoints(){
        return this.points;
    }

    // Mutators
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

    
	@Override
    public int menu() {
		Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|                                    Camp Menu (Committee)                           |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|1. View Details Of Registered Camp                                                  |");
            System.out.println("|2. View All Enquiries Of Oversee Camp                                               |");
            System.out.println("|3. Reply To Enquiries Of Oversee Camp                                               |");
            System.out.println("|4. Submit Camp Suggestions                                                          |");
            System.out.println("|5. View Submitted Suggestions                                                       |");
            System.out.println("|6. Edit Submitted Suggestions                                                       |");
            System.out.println("|7. Delete Submitted Suggestions                                                     |");
            System.out.println("|8. Generate Report                                                                  |");
            System.out.println("|-1. Exit Menu                                                                       |");
            System.out.println("--------------------------------------------------------------------------------------");
			System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(choice>8||choice<-1);
        return choice;
	}

    @Override
    public void menuChoice(int i, User currentUser){
		switch(i)
        {
			case 1:
                //View Details Of Registered Camp 
				break;

            case 2:
                //View All Enquiries Of Oversee Camp
                break;

            case 3:
                //Reply To Enquiries Of Oversee Camp
                break;

            case 4:
                //Submit Camp Suggestions
                break;

            case 5:
                //View Submitted Suggestions
                break;

            case 6:
                //Edit Submitted Suggestions
                break;

            case 7:
                //Delete Submitted Suggestions
                break;

            case 8:
                //Generate Report
                break;

            case -1:
                // Exit Menu
                System.out.println("Exiting Camp Menu. Goodbye!");
                System.exit(0);
            break;
        }
    }
}