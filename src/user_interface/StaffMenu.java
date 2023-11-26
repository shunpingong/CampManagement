package src.user_interface;

import java.util.Scanner;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.camp_management.CreateNewCamp;
import src.feedback.enquiry.EnquiryReply;
import src.feedback.suggestions.SuggestionProcessor;
import src.login_system.Login;
import src.login_system.Password;
import src.user_data.Staff;
import src.user_data.StaffData;
import src.user_interface.interfaces.IMenu;
import src.user_interface.interfaces.IUserMenu;


/**
 * The {@code StaffMenu} class represents a menu for staff members.
 * It implements the {@link IUserMenu} interface, providing
 * functionality for managing staff-related actions and operations.
 * 
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public class StaffMenu implements IUserMenu{

    /**
     * The menu choice selected by the staff member.
     */
    private int choice;

    /**
     * The staff member associated with the menu.
     */
    private Staff staff;

    /**
     * Constructs a new {@code StaffMenu} object for the given staff member.
     *
     * @param staff The staff member for whom the menu is created.
     */
    public StaffMenu(Staff staff){
        this.staff = staff;
    }

    /**
     * Prints the menu options for user login.
     */
    public void printMenu(){
        printMenuTitle();
        printMenuOptions();
        selectOptions();
    }
    
    /**
     * Prints the status of the staff member, including user ID and name.
     */
    public void printUserStatus(){
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("User ID: " + this.staff.getID());
        System.out.println("Name: " + this.staff.getName());
        System.out.println("--------------------------------------------------------------------------------------");
    }

    /**
     * Prints the title of the menu.
     */
    public void printMenuTitle(){
        System.out.println("======================================================================================");
        System.out.println("|                                    Camp Menu (Staff)                               |");
        System.out.println("======================================================================================");
        
    }

    /**
     * Prints the menu options for the staff member.
     */
    public void printMenuOptions(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|1. View All Camps                                                                   |");
            System.out.println("|2. View Camps Created By You                                                        |");
            System.out.println("|3. Create New Camp                                                                  |");
            System.out.println("|4. View Enquiries Menu For Staff                                                    |");
            System.out.println("|5. View Suggestion Menu For Staff                                                   |");
            System.out.println("|6. Change Password                                                                  |");
            System.out.println("|-1. Logout                                                                          |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(choice != -1 && (choice < 1 || choice > 8));
    }

    /**
     * Selects and executes the chosen menu option.
     */
    public void selectOptions(){
        IMenu menu = null;
        switch(choice)
        {
			case 1: //view all camps
                menu = new CampViewerSC(CampList.getCampList(), "All");
                menu.printMenu();
				break;
            case 2: //view created camps
                menu = new CampManagerMenu(this.staff);
                menu.printMenu();
                break;

            case 3: //create new camp
                Scanner sc = new Scanner(System.in);
                System.out.println("1. Confirm choice. 2. Exit camp creation.");
                System.out.print("Choice: ");
                int choice = sc.nextInt();
                if (choice == 1){
                    CampInfo camp = CreateNewCamp.create();
                    CampList.createCamp(camp);
                    this.staff.getCampsCreated().add(camp);
                    StaffData.setUser(this.staff);
                }
                else if (choice == 2) return;
                else System.out.println("Invalid choice");
                break;

            case 4: //View Enquiry Menu For Staff
                //Display enquiry menu for every single camps owned
                if (this.staff.getCampsCreated().size() == 0){
                    System.out.println("No Camps Created");
                    return;
                } 
                for (CampInfo c1 : this.staff.getCampsCreated()){
                        System.out.println("Camp "+ c1.getCampName());
                        EnquiryReply.replyMenu(c1, this.staff, EnquiryReply.getCampEnquiries(c1));
                }
                break;

            case 5: //View Suggestion Menu For Staff
                SuggestionProcessor.processMenu(this.staff.getCampsCreated(), this.staff);
                break;

            case 6:
                Password.change(this.staff);
                break;
            case -1:
                // Exit Menu
                System.out.println("Logging Out... Goodbye!");
                Login.logout();
                break;
		}
    }
}
