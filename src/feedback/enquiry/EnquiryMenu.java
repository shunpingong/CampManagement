/**
 * The EnquiryMenu interface provides a menu for managing student enquiries.
 * It includes options for making new enquiries for available camps, viewing, editing, or deleting unprocessed enquiries,
 * and viewing processed enquiries. The menu is designed for user interaction and requires implementations for each choice.
 * <p>
 * Implementing classes should provide concrete implementations for the methods defined in this interface.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.enquiry;

import java.util.ArrayList;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.user_data.Student;


public interface EnquiryMenu {

    /**
     * Displays the menu for managing student enquiries and processes user choices.
     *
     * @param student      The student for whom the menu is displayed.
     * @param enquiryList  The list of enquiries to be managed.
     */
    public static void menuChoice(Student student , ArrayList<Enquiry> enquiryList) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enquiry menu.\n" +
                    "1: Make a new enquiry for available camps\n" +
                    "2: View, Edit or Delete enquiries that are unprocessed\n" +
                    "3: View processed enquiries.\n" +
                    "-1: Go back to main menu.\n" +
                    "Enter choice: ");

            int choice = sc.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    CampList.viewAllCamps(student.getAvailableCamps(), "Available");
                    if (student.getAvailableCamps().size() !=0){
                        System.out.print("Choose a camp to submit enquiry for (enter the number): ");
                        int chosenCampIndex = sc.nextInt();

                        sc.nextLine();

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