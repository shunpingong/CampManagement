package src;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends User {
    // Instances
	private String email;
    private ArrayList<CampInfo> campsCreated;

    // Constructors
    public Staff(String userID, String name, Faculty faculty, String email){
        super(userID, name, faculty);
        this.email = email;
        this.campsCreated = new ArrayList<CampInfo>(); 
        //1 staff in charge of 1 camp, unique
    }

/*---------------------------------------------------------------ACCESSORS -------------------------------------------------------------------------*/
	public String getEmail(){
        return this.email;
    }

    public void getCampsCreated(){
        if(campsCreated.size() == 0){
                    System.out.println("No Camps Created");
                    return;
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                   Created Camps                                    |");
        System.out.println("--------------------------------------------------------------------------------------");
        for(int j=0; j<campsCreated.size();j++){
            System.out.printf("|%-3s|Name: %-13s|Date: %-5s to %-15s|Available Slots: %-5s  |\n", 
                            j+1,
                            campsCreated.get(j).getCampName(), 
                            campsCreated.get(j).getStartDate(), 
                            campsCreated.get(j).getEndDate(), 
                            campsCreated.get(j).getTotalSlots());
        }
    }

/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/
    public void setEmail(String email){
        this.email = email;
    }

    public void AddCampsOwned(CampInfo camp){
        this.campsCreated.add(camp);
    }


/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
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
            System.out.println("|-1. Exit Menu                                                                       |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(choice>12||choice<-1);
        return choice;
	}

    @Override
    //public void menuChoice(int i)
	public void menuChoice(int i){
		switch(i)
        {
			case 1: //view all camps
                System.out.println("OK");
                CampList.viewAllAvailableCamps(this);
                CampList.printCampDetails();
				break;

            case 2: //view created camps
                this.getCampsCreated();
                break;

            case 3: //create new camp
                CampInfo camp = CreateNewCamp.create();
                CampList.createCamp(camp);
                this.campsCreated.add(camp);
                break;

            case 4: //edit camp detail
                Scanner sc = new Scanner(System.in);
                this.getCampsCreated();
                int choice = 0;
                do{
                    System.out.printf("Which Camp To Edit?");
                    choice = sc.nextInt();
                }while(choice<1 || choice>campsCreated.size());
                for(int k=0;k<CampList.getCampList().size();k++){
                    if (campsCreated.get(choice).getCampName().equals(CampList.getCampList().get(k).getCampName()) == true){
                        CampList.getCampList().get(k).editCampInfo();
                    }
                }
                
                break;
/*
            case 5:
                break;

            case 6:
                break;

            case 7:
                //Create enquiry
                //Check enquiry for given camp
                
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
            case -1:
                // Exit Menu
                System.out.println("Exiting Camp Menu. Goodbye!");
                System.exit(0);
                break;
		}

	}

    private Object CreateNewCamp() {
        return null;
    }
}