package src;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateNewCamp {
    public CreateNewCamp(){}; //constructor

    public static void create(){ //String campName, LocalDate startdate, LocalDate enddate, LocalDate registerDeadline, Faculty userGroup, String location, int totalSlots, int committeeSlots, String description, Staff inCharge
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Camp Name: ");
        String campName = sc.nextLine();  //camp name

        System.out.printf("Enter Camp Description: ");
        String campDesc = sc.nextLine();  //camp description
        
        System.out.printf("Enter Camp Location: ");
        String campLoc = sc.nextLine();  //camp location

        System.out.println("Please Enter Camp Start Date");
        LocalDate startdate = GetDate.getDate(); //start date

        System.out.println("Please Enter Camp End Date");
        LocalDate enddate = GetDate.getDate(); //end date
        while(enddate.isBefore(startdate)){
            System.out.println("Error: Please Input End Date After Start Date");
            enddate = GetDate.getDate();
        }

        System.out.println("Please Enter Camp Registration Deadline");
        LocalDate deadline = GetDate.getDate(); //registration deadline
        while(deadline.isAfter(startdate)){
            System.out.println("Error: Please Input Registration Dealine Before Start Date");
            deadline = GetDate.getDate();
        }

        System.out.println("Select Faculty Which The Camp Is Open To:");
        Faculty userGroup = SelectFaculty.chooseFaculty(); //camp faculty
        
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



        Staff IC = GetStaff.getStaff();

        boolean visibility = SetVisibility.setVisibility();

        
        CampInfo campinfo = new CampInfo(campName, startdate, enddate, deadline, userGroup, campLoc, totalSlots, committeeSlots, campDesc, IC, visibility);
        CampList.createCamp(campinfo); //create new camp
        
    }
}
