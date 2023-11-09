package src;
import java.time.LocalDate;
import java.util.Scanner;

public class CreateNewCamp {
    public CreateNewCamp(){}; //constructor

    public static void create(){ //String campName, LocalDate startdate, LocalDate enddate, LocalDate registerDeadline, Faculty userGroup, String location, int totalSlots, int committeeSlots, String description, Staff inCharge
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Camp Name: ");
        String campName = sc.nextLine();  //camp name
        
        System.out.println("Please Enter Camp Start Date");
        LocalDate startdate = GetDate.getDate(); //start date

        System.out.println("Please Enter Camp End Date");
        LocalDate enddate = GetDate.getDate(); //start date

        System.out.println("Please Enter Camp Registration Deadline");
        LocalDate deadline = GetDate.getDate(); //start date

        Faculty userGroup = SelectFaculty.chooseFaculty(); //camp faculty
        
        System.out.printf("Enter Camp Location: ");
        String campLoc = sc.nextLine();  //camp location

        System.out.printf("Enter Total Number of Slots (Not Including Committee): ");
        int totalSlots = sc.nextInt();  //attnedeeSlots
        
        System.out.printf("Enter Total Number of Committee Slots: ");
        int committeeSlots = sc.nextInt();  //committeeSlots

        System.out.printf("Enter Camp Description: ");
        String campDesc = sc.nextLine();  //camp description

        Staff IC = GetStaff.getStaff();

        boolean visibility = SetVisibility.setVisibility();

        
        CampInfo campinfo = new CampInfo(campName, startdate, enddate, deadline, userGroup, campLoc, totalSlots, committeeSlots, campDesc, IC, visibility);
        CampList.createCamp(campinfo); //create new camp
        
    }
}
