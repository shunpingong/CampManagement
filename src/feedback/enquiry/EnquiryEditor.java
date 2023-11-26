/**
 * The {@code EnquiryEditor} class provides methods for editing and managing
 * enquiries related to camp information for a specific student.
 * <p>
 * This class includes functionalities such as editing, deleting, and adding
 * enquiries. It is part of the feedback and enquiry module in the application.
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

public class EnquiryEditor {
    
    /**
     * Displays the edit menu for a selected enquiry, allowing the user to edit,
     * delete, or select a new enquiry.
     *
     * @param student       The student associated with the enquiries.
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
            System.out.print("1. Edit this enquiry\n2. Delete this enquiry\n3. Select a new enquiry\n4. Exit\n");
            System.out.print("Enter Choice: ");
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
                    System.out.println("");
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
     * Adds a new enquiry for a specific student and camp.
     *
     * @param student       The student submitting the enquiry.
     * @param camp          The camp associated with the enquiry.
     * @param enquiryList   The list of enquiries to which the new enquiry will be added.
     */
    public static void addEnquiry(Student student, CampInfo camp, ArrayList<Enquiry> enquiryList){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your enquiry: ");
        String response = sc.nextLine();
        Enquiry newEnquiry = new Enquiry(response, student, camp, null);
        enquiryList.add(newEnquiry);
        camp.addEnquiriesForCamp(newEnquiry);
        System.out.printf("Enquiry Submitted for camp: %s\n", camp.getCampName());
        int confirm = 0;
        do{
            System.out.print("Press '1' to Confirm: ");
            confirm = sc.nextInt();
        }while(confirm != 1);
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
        e.setDescription(newDescription + "\n**Enquiry has been edited**");
        System.out.println("Enquiry has been edited");
        int confirm = 0;
        do{
            System.out.print("Press '1' to Confirm: ");
            confirm = sc.nextInt();
        }while(confirm != 1);
    }

    /**
     * Deletes a specified enquiry for a given student.
     *
     * @param student       The student associated with the enquiry.
     * @param e             The enquiry to be deleted.
     * @param enquiryList   The list of enquiries from which the enquiry will be removed.
     */
    public static void deleteEnquiry(Student student, Enquiry e, ArrayList<Enquiry> enquiryList) {
        Scanner sc = new Scanner(System.in);
        e.getCamp().getEnquiriesForCamp().remove(e);
        enquiryList.remove(e);
        System.out.println("Enquiry has been deleted");
        int confirm = 0;
        do{
            System.out.print("Press '1' to Confirm: ");
            confirm = sc.nextInt();
        }while(confirm != 1);
    }
}