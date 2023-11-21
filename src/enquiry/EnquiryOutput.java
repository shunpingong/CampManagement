package src.enquiry;

import java.util.Scanner;

import src.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class EnquiryOutput {
    //Printing of each enquiry
    public static void viewEnquiry(Enquiry enquiry) {
        enquiry.viewDetails();
    }

    //Get list of enquiries process/ not processed
    public static ArrayList<Enquiry> getRequiredEnquiries(Student student, boolean processed){
        ArrayList<Enquiry> requiredEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : student.getEnquiriesMade()){
            if (enquiry.isProcessed() == processed){
                requiredEnquiries.add(enquiry);
            }

        }
        return requiredEnquiries;
    }


    //Print out every single enquiries of processed/ not processed
    public static void viewRequiredEnquiries(ArrayList<Enquiry> enquiryList) {
        if(enquiryList.size()==0){
            System.out.println("No enquiries to show.\n");
            return;
        }
        else{
            Comparator<Enquiry> enquiryComparator = Comparator.comparing(enquiry -> enquiry.getCamp().getCampName());
            enquiryList.sort(enquiryComparator);
            int i = 0;
            for (Enquiry enquiry : enquiryList){
                i++;
                System.out.printf("Enquiry " + i + "\n");
                EnquiryOutput.viewEnquiry(enquiry);
            }
        }

    }

    public static Enquiry selectEnquiry(ArrayList<Enquiry> requiredEnquiries) {
        Scanner sc = new Scanner(System.in);
        // ArrayList<Enquiry> relevantEnquiries = requiredEnquiries;
        if (requiredEnquiries.size() == 0) {
            return null;
        }

        System.out.print("Enter the number of the enquiry to view the edit menu: ");
        while (true) {
            int selection = sc.nextInt();
            if (selection < 1 || selection > requiredEnquiries.size()) {
                System.out.println("Enquiry not found. Please select again.");
            } else {
                return requiredEnquiries.get(selection - 1);
            }

        }

    }
}