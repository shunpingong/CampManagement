/**
 * The {@code EnquiryMenu} class provides a menu for managing enquiries related to camp information
 * for a specific student. It allows the user to make new enquiries, view, edit, or delete unprocessed enquiries,
 * and view processed enquiries.
 * <p>
 * This class is part of the feedback and enquiry module in the application.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.enquiry;

import java.util.ArrayList;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.user_data.Student;
import src.user_interface.CampViewerST;
import src.user_interface.interfaces.IMenu;


public class EnquiryMenu {

    /**
     * Displays the main menu for managing enquiries. The user can choose to make a new enquiry for available camps,
     * view, edit, or delete unprocessed enquiries, view processed enquiries, or go back to the main menu.
     *
     * @param student       The student associated with the enquiries.
     * @param enquiryList   The list of enquiries to be managed.
     */
    public static void menuChoice(Student student , ArrayList<Enquiry> enquiryList) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnquiry menu\n" +
                    "1: Make a new enquiry for available camps\n" +
                    "2: View, Edit or Delete enquiries that are unprocessed\n" +
                    "3: View processed enquiries.\n" +
                    "-1: Go back to main menu.\n" +
                    "Enter choice: ");

            int choice = sc.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    IMenu menu = new CampViewerST(student.getAvailableCamps(),"Available");
                    menu.printMenu();
                    if (student.getAvailableCamps().size() !=0){
                        System.out.print("Choose a camp to submit enquiry for (enter the number): ");
                        int chosenCampIndex = sc.nextInt();

                        sc.nextLine();

                        CampInfo chosenCamp = student.getAvailableCamps().get(chosenCampIndex-1);

                        EnquiryEditor.addEnquiry(student, chosenCamp, enquiryList);
                    }
                    else{
                        System.out.println("No available camps to submit enquiry");
                        int confirm = 0;
                        do{
                            System.out.print("Press '1' to Confirm: ");
                            confirm = sc.nextInt();
                        }while(confirm != 1);
                        break;
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