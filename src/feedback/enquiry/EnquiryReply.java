
package src.feedback.enquiry;

import src.camp_management.CampInfo;
import src.user_data.CampCommittee;
import src.user_data.User;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The {@code EnquiryReply} class provides methods for managing replies to enquiries related to a specific camp.
 * It includes functionalities such as retrieving unprocessed enquiries for a camp, displaying a menu for replying to
 * enquiries, and handling the process of replying to an enquiry.
 * <p>
 * This class is part of the feedback and enquiry module in the application.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
public class EnquiryReply {

    /**
     * Retrieves a list of unprocessed enquiries for a specific camp.
     *
     * @param camp The camp for which enquiries are to be retrieved.
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
     * Displays a menu for replying to enquiries for a specific camp. Allows the user to select an enquiry,
     * reply to it, and exit the menu.
     *
     * @param camp          The camp for which enquiries are being managed.
     * @param currentUser   The user initiating the replies.
     * @param enquiryList   The list of enquiries related to the camp.
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
            System.out.println("1. Reply to this enquiry\n2. Select a new enquiry\n3. Exit");
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
     * Handles the process of replying to a specific enquiry. If the enquiry is already processed, a message is displayed.
     * Otherwise, the user is prompted to enter a reply, and the necessary updates are made to the enquiry.
     *
     * @param enquiry       The enquiry to which the reply is being made.
     * @param replyAuthor   The user initiating the reply.
     * @param enquiryList   The list of enquiries related to the camp.
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