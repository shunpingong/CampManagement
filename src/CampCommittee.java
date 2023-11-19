package src;

import java.util.Scanner;

public class CampCommittee extends Student {
    // Instances
    private int points;
	private CampInfo committeeOf; //to store the camp that student is a committee of
	private static SuggestionList suggestionsMade  = new SuggestionList(); //List of Suggestions Camp Committee made


    // Constructors
    public CampCommittee(String userID, String name, Faculty faculty, String email, CampInfo committeeOf, int points){
        super(userID, name, faculty, email);
        //this.setStatus("Camp Committee");
        this.committeeOf = committeeOf;
        this.points = points;
    }

    // Accessors
    public int getPoints(){
        return this.points;
    }

	public CampInfo getCommitteeOf(){
		return this.committeeOf;
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
            super.showStudentMenu();
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|                                    Camp Menu (Committee)                           |");
            System.out.println("--------------------------------------------------------------------------------------");
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
            case 9:
                System.out.println("AK47 case 9");

            case -1:
                // Exit Menu
                System.out.println("Exiting Camp Menu. Goodbye!");
                System.exit(0);
            break;
        }
    }
}