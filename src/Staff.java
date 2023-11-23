package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import src.enquiry.EnquiryReply;
import src.sorter.CampSorter;
import src.sorter.SortCamp;
import src.suggestions.SuggestionProcessor;

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
    public ArrayList<CampInfo> getCampsCreated(){
        return this.campsCreated;
    }
    public void printCampsCreated(){
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
            System.out.println("User ID: " + this.getID());
            System.out.println("Name: " + this.getName());
            System.out.println("|1. View All Camps                                                                   |");
            System.out.println("|2. View Camps Created By You                                                        |");
            System.out.println("|3. Create New Camp                                                                  |");
            System.out.println("|4. Edit Camp Detail                                                                 |");
            System.out.println("|5. Delete Camp                                                                      |");
            System.out.println("|6. Toggle Visibility Of Camp                                                        |");
            System.out.println("|7. View Enquiries Menu For Staff                                                    |");
            // System.out.println("|10. View All Unprocessed Enquiries Of Oversee Camp                                  |");
            // System.out.println("|11. Reply To Unprocessed Enquiries Of Oversee Camp                                  |");
            System.out.println("|8. View Suggestion Menu For Staff                                                   |");
            // System.out.println("|9. View Suggestions                                                                 |");
            // System.out.println("|10. Reply Suggestions                                                               |");
            System.out.println("|9. Generate Report Of Created Camp                                                  |");
            System.out.println("|10. Generate Performance Report Of Camp Committee                                   |");
            System.out.println("|-1. Logout                                                                          |");
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
                CampSorter sorter = CampSorter.createCampSorter(UserInput.sortCampMenu());
                Collections.sort(CampList.getCampList(), sorter);
                CampList.viewAllCamps(CampList.getCampList(), "All");
                CampList.printCampDetails();
				break;

            case 2: //view created camps
                this.printCampsCreated();
                break;

            case 3: //create new camp
                CampInfo camp = CreateNewCamp.create();
                CampList.createCamp(camp);
                this.campsCreated.add(camp);
                break;

            case 4: //edit camp detail
                Scanner sc = new Scanner(System.in);
                this.printCampsCreated();
                if (this.getCampsCreated().size() == 0){
                    System.out.println("No Camps Created");
                    return;
                } 
                int choice = 0;
                do{
                    System.out.printf("Which Camp To Edit?");
                    choice = sc.nextInt();
                }while(choice<1 || choice>campsCreated.size());
                for(int k=0;k<CampList.getCampList().size();k++){
                    if (campsCreated.get(choice-1).getCampName().equals(CampList.getCampList().get(k).getCampName()) == true){
                        CampList.getCampList().get(k).editCampInfo();
                    }
                }
                
                break;

            case 5: //delete camp
                sc = new Scanner(System.in);
                this.printCampsCreated();
                if (this.getCampsCreated().size() == 0){
                    System.out.println("No Camps Created");
                    return;
                } 
                int delete = 0;
                do{
                    System.out.printf("Which Camp To Delete?");
                    delete = sc.nextInt();
                }while(delete<1 || delete>campsCreated.size());
                for(int k=0;k<CampList.getCampList().size();k++){
                    if (campsCreated.get(delete-1).getCampName().equals(CampList.getCampList().get(k).getCampName()) == true){
                        if(CampList.getCampList().get(k).getStudentAttendees().size() == 0 && CampList.getCampList().get(k).getCampCom().size()==0){
                            CampList.getCampList().remove(k);
                        }
                        else{
                            System.out.println("Unable To Delete, There Are Participants Signed Up");
                        }
                        
                    }
                }
                break;
            case 6: //toggle visibility
                break;


            case 7: //View Enquiry Menu For Staff
                for (CampInfo c1 : this.getCampsCreated()){
                        System.out.println("Camp "+ c1.getCampName());
                        EnquiryReply.replyMenu(c1, this, EnquiryReply.getCampEnquiries(c1));
                }
                break;

            case 8: //View Suggestion Menu For Staff
                SuggestionProcessor.processMenu(this.getCampsCreated(), this);
                // for (CampInfo camps : this.getCampsCreated()){
                //     System.out.println("CAMP: "+ camps.getCampName());
                //     camps.getEnquiriesForCamp().displayEnquiries();
                // }

                break;
                /* 
            case 9: //Generate Report Of Created Camp
                break;

            case 10: //Generate Performance Report Of Camp Committee
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