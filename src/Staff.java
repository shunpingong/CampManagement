package src;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends User {
    // Instances
	private String email;
    private ArrayList<String> campsCreated ;

    // Constructors
    public Staff(String userID, String name, Faculty faculty, String email){
        super(userID, name, faculty);
        this.email = email;
        this.campsCreated = new ArrayList<String>(); 
    }

	// Accessors
	public String getEmail(){
        return this.email;
    }

    public ArrayList<String> getCampsCreated(){
        return this.campsCreated;
    }

    // Mutators
    public void setEmail(String email){
        this.email = email;
    }

    public void setCampsCreated(ArrayList<String> createdCamps){
        this.campsCreated = createdCamps;
    }

    @Override
    public int menu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|                                    Camp Menu (Staff)                               |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|1. View All Camps                                                                   |");
            System.out.println("|2. View Camps Created By You                                                        |");
            System.out.println("|3. Create New Camp                                                                  |");
            System.out.println("|4. Edit Camp Detail                                                                 |");
            System.out.println("|5. Delete Camp                                                                      |");
            System.out.println("|6. Toggle Visibility Of Camp                                                        |");
            System.out.println("|7. View Enquiries                                                                   |");
            System.out.println("|8. Reply Enquiries                                                                  |");
            System.out.println("|9. View Suggestions                                                                 |");
            System.out.println("|10. Reply Suggestions                                                               |");
            System.out.println("|11. Generate Report Of Created Camp                                                 |");
            System.out.println("|12. Generate Performance Report Of Camp Committee                                   |");
            System.out.println("|13. Exit Menu                                                                       |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(choice>13||choice<1);
        return choice;
	}

    @Override
	public void menuChoice(int i){
		switch(i)
        {
			case 1:
                CampList.printCampNames();
				break;
/*
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;

            case 8:
                break;

            case 9:
                break;

            case 10:
                break;

            case 11:
                break;

            case 12:
                break;
*/
		}

	}
}