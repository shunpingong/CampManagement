/**
 * The EnquiryReply interface provides methods for handling replies to camp-related enquiries.
 * It includes functionality for retrieving camp-specific enquiries, displaying reply menus, and replying to individual enquiries.
 * <p>
 * Implementing classes should provide concrete implementations for the methods defined in this interface.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.enquiry;

import src.camp_management.CampInfo;
import src.user_data.CampCommittee;
import src.user_data.User;

import java.util.Scanner;
import java.util.ArrayList;

public interface EnquiryReply {

    /**
     * Retrieves a list of unprocessed enquiries for a specific camp.
     *
     * @param camp The camp for which enquiries are retrieved.
     * @return An ArrayList of unprocessed enquiries for the specified camp.
     */
    public static ArrayList<Enquiry> getCampEnquiries(CampInfo camp){
        ArrayList<Enquiry> notProcessedEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : camp.getEnquiriesForCamp()){
            if(!enquiry.isProcessed()){
                notProcessedEnquiries.add(enquiry);
            }
        }
        return notProcessedEnquiries;
    }

    /**
     * Displays a reply menu for a specific camp, current user, and list of enquiries.
     *
     * @param camp          The camp for which the menu is displayed.
     * @param currentUser   The current user interacting with the menu.
     * @param enquiryList   The list of enquiries to be managed.
     */
    public static void replyMenu(CampInfo camp, User currentUser, ArrayList<Enquiry> enquiryList ) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Enquiry selectedEnquiry = null;
            ArrayList<Enquiry> requiredEnquiries = EnquiryReply.getCampEnquiries(camp);
            EnquiryOutput.viewRequiredEnquiries(requiredEnquiries);
            selectedEnquiry = EnquiryOutput.selectEnquiry(requiredEnquiries);
            if (selectedEnquiry == null) {
                return;
            }
            System.out.println("1. Reply to this enquiry, 2. Select a new enquiry or 3. Exit");
            int selection = sc.nextInt();
            String newLine = sc.nextLine();
            switch (selection) {
                case 1:
                    EnquiryReply.replyTo(selectedEnquiry,currentUser, enquiryList);
                    return;
                case 2:
                    break;
                case 3:
                    System.out.println("Exiting\n");
                    return;
                default:
                    break;
            }
        }
    }

    /**
     * Allows a user to reply to a specific enquiry, marking it as processed and updating the reply content.
     *
     * @param enquiry       The enquiry to which the reply is made.
     * @param replyAuthor   The user replying to the enquiry.
     * @param enquiryList   The list of enquiries to which the updated enquiry is added.
     */
    public static void replyTo(Enquiry enquiry, User replyAuthor, ArrayList<Enquiry> enquiryList) {
        Scanner sc = new Scanner(System.in);
        if (enquiry.isProcessed()) {
            System.out.println("Enquiry already processed.");
            int confirm = 0;
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
        } else {
            System.out.println("Enter the reply to this enquiry: ");
            String response = sc.nextLine();
            enquiry.setReply(response);
            enquiry.setReplyAuthor(replyAuthor);
            enquiry.markProcessed();
            System.out.println("Enquiry replied.");
            if(replyAuthor instanceof CampCommittee){
                ((CampCommittee) replyAuthor).addPoints(1);
                System.out.println("You earned 1 point!");
            }
            int confirm = 0;
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
        }

    }
}