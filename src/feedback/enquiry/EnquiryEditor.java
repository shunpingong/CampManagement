/**
 * The EnquiryEditor interface provides methods for editing and managing enquiries.
 * It includes functionality for editing, deleting, and adding enquiries, as well as displaying menus for user interaction.
 * <p>
 * Implementing classes should provide concrete implementations for the methods defined in this interface.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */

package src.feedback.enquiry;

import java.util.Scanner;

import src.camp_management.CampInfo;
import src.user_data.Student;

import java.util.ArrayList;

public interface EnquiryEditor {
    
    /**
     * Displays the edit menu for a given student and list of enquiries.
     *
     * @param student       The student for whom the menu is displayed.
     * @param enquiryList   The list of enquiries to be managed.
     */
    public static void editMenu(Student student, ArrayList<Enquiry> enquiryList ) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Enquiry selectedEnquiry = null;
            ArrayList<Enquiry> requiredEnquiries = EnquiryOutput.getRequiredEnquiries(student,false);
            EnquiryOutput.viewRequiredEnquiries(requiredEnquiries);
            selectedEnquiry = EnquiryOutput.selectEnquiry(requiredEnquiries);
            if (selectedEnquiry == null) {
                return;
            }
            System.out.println("1. Edit this enquiry, 2. Delete this enquiry, 3. Select a new enquiry or 4. Exit\n");
            int selection = sc.nextInt();
            String newLine = sc.nextLine();
            switch (selection) {
                case 1:
                    EnquiryEditor.editEnquiry(selectedEnquiry);
                    return;
                case 2:
                    EnquiryEditor.deleteEnquiry(student, selectedEnquiry, enquiryList);
                    return;
                case 3:
                    break;
                case 4:
                    System.out.println("Exiting");
                    return;
                default:
                    break;
            }
        }
    }

    /**
     * Adds a new enquiry for a given student and camp.
     *
     * @param student       The student submitting the enquiry.
     * @param camp          The camp related to the enquiry.
     * @param enquiryList   The list of enquiries to which the new enquiry is added.
     */
    public static void AddEnquiry(Student student, CampInfo camp, ArrayList<Enquiry> enquiryList){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your enquiry: ");
        String response = sc.nextLine();
        Enquiry newEnquiry = new Enquiry(response, student, camp, null);
        enquiryList.add(newEnquiry);
        camp.addEnquiriesForCamp(newEnquiry);
        System.out.printf("Enquiry Submitted for camp: %s\n\n", camp.getCampName());
    }

    /**
     * Edits the description of a given enquiry.
     *
     * @param e The enquiry to be edited.
     */
    public static void editEnquiry(Enquiry e) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new enquiry description: ");
        String newDescription = sc.nextLine();
        e.setDescription(newDescription + "\n**This enquiry has been edited**");
        System.out.println("Your enquiry has been edited\n");
    }

   /**
     * Deletes a given enquiry from the list of enquiries.
     *
     * @param student       The student who submitted the enquiry.
     * @param e             The enquiry to be deleted.
     * @param enquiryList   The list of enquiries from which the enquiry is deleted.
     */
    public static void deleteEnquiry(Student student, Enquiry e, ArrayList<Enquiry> enquiryList) {
        e.getCamp().getEnquiriesForCamp().remove(e);
        enquiryList.remove(e);
        System.out.println("Your enquiry has been deleted\n");
    }
}