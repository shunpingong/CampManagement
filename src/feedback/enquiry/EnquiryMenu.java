package src.feedback.enquiry;

import java.util.ArrayList;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.user_data.Student;


public interface EnquiryMenu {
    public static void menuChoice(Student student , ArrayList<Enquiry> enquiryList) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            final String menu = "Welcome to student enquiry menu.\n" +
                    "1: Make a new enquiry for available camps\n" +
                    "2: View, Edit or Delete enquiries that are unprocessed\n" +
                    "3: View processed enquiries.\n" +
                    "-1: Go back to main menu.\n" +
                    "Enter choice: ";
                    
            System.out.print(menu);
            int choice = sc.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    CampList.viewAllCamps(student.getAvailableCamps(), "Available");
                    if (student.getAvailableCamps().size() !=0){
                        System.out.print("Choose a camp to submit enquiry for (enter the number): ");
                        int chosenCampIndex = sc.nextInt();

                        // Consume the newline character
                        sc.nextLine();

                        // Get the camp Name
                        CampInfo chosenCamp = student.getAvailableCamps().get(chosenCampIndex-1);

                        EnquiryEditor.AddEnquiry(student, chosenCamp, enquiryList);
                    }
                    else{
                        System.out.println("No available camps to submit enquiry");
                    }
                    break;
                case 2:
                    EnquiryEditor.editMenu(student, enquiryList);
                    break;
                case 3:
                    EnquiryOutput.viewRequiredEnquiries(EnquiryOutput.getRequiredEnquiries(student,true));
                    break;
                case -1:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}