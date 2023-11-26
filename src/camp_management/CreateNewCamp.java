package src.camp_management;
import java.time.LocalDate;
import java.util.Scanner;

import src.login_system.Login;
import src.user_data.Faculty;
import src.user_data.Staff;

/**
 * The {@code CreateNewCamp} class is responsible for facilitating the creation of new camps.
 * It prompts the user for necessary information such as camp name, description, dates,
 * location, and other details, and then constructs a CampInfo object with the provided data.
 *
 * @author Yi heng
 * @version 1.0
 * @since 2023-11-26
 */
public class CreateNewCamp {

    /**
     * Default constructor for the CreateNewCamp class.
     */
    public CreateNewCamp(){};

    /**
     * Facilitates the creation of a new camp by prompting the user for necessary information.
     *
     * @return The CampInfo object representing the newly created camp.
     */
    public static CampInfo create(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Camp Name: ");
        String campName = sc.nextLine();  //camp name

        System.out.printf("Enter Camp Description: ");
        String campDesc = sc.nextLine();  //camp description
        
        System.out.printf("Enter Camp Location: ");
        String campLoc = sc.nextLine();  //camp location

        System.out.println("Please Enter Camp Start Date");
        LocalDate startdate = UserInput.getDate(); //start date
        while(startdate.isBefore(LocalDate.now())){
            System.out.println("Error: Please Input Start Date After Today's Date: " + LocalDate.now());
            startdate = UserInput.getDate();
        }

        System.out.println("Please Enter Camp End Date");
        LocalDate enddate = UserInput.getDate(); //end date
        while(enddate.isBefore(startdate)){
            System.out.println("Error: Please Input End Date After Start Date");
            enddate = UserInput.getDate();
        }

        System.out.println("Please Enter Camp Registration Deadline");
        LocalDate deadline = UserInput.getDate(); //registration deadline
        while(deadline.isAfter(startdate)){
            System.out.println("Error: Please Input Registration Dealine Before Start Date");
            deadline = UserInput.getDate();
        }

        System.out.println("Select Faculty Which The Camp Is Open To:");
        Faculty userGroup = UserInput.chooseFaculty(); //camp faculty
        
        int totalSlots = -1;
        do{
            System.out.printf("Enter Total Number of Slots (Not Including Committee): ");
            totalSlots = sc.nextInt();  //attendeeSlots
        } while (totalSlots<1);
        
        int committeeSlots = -1;  //committeeSlots
        do{
            System.out.printf("Enter Total Number of Committee Slots: ");
            committeeSlots = sc.nextInt();  //committeeSlots
        } while (committeeSlots<0);

        Staff IC = null;
        if(Login.getCurrentUser() instanceof Staff){
            IC = (Staff) Login.getCurrentUser();
        }

        boolean visibility = UserInput.setVisibility();

        CampInfo campinfo = new CampInfo(campName, startdate, enddate, deadline, userGroup, campLoc, totalSlots, committeeSlots, campDesc, IC, visibility);
        return campinfo;
    }
}
