package src.feedback.enquiry;

import src.camp_management.CampInfo;
import src.user_data.CampCommittee;
import src.user_data.User;

import java.util.Scanner;
import java.util.ArrayList;

public class EnquiryReply {

    public static ArrayList<Enquiry> getCampEnquiries(CampInfo camp){
        ArrayList<Enquiry> notProcessedEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : camp.getEnquiriesForCamp()){
            if(!enquiry.isProcessed()){
                notProcessedEnquiries.add(enquiry);
            }
        }
        return notProcessedEnquiries;
    }

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
                    System.out.println("Exiting");
                    return;
                default:
                    break;
            }
        }
    }

    public static void replyTo(Enquiry enquiry, User replyAuthor, ArrayList<Enquiry> enquiryList) {
        if (enquiry.isProcessed()) {
            System.out.println("Enquiry already processed.");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your reply to this: ");
            String response = sc.nextLine();
            enquiry.setReply(response);
            enquiry.setReplyAuthor(replyAuthor);
            enquiry.markProcessed();
            if(replyAuthor instanceof CampCommittee){
                ((CampCommittee) replyAuthor).addPoints(1);
            }
        }

    }
}