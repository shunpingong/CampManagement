package src.feedback.enquiry;

import src.user_data.Student;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The {@code EnquiryOutput} class provides methods for viewing and managing enquiries made by a specific student.
 * It includes functionalities such as viewing individual enquiries, obtaining a list of required enquiries based on
 * their processing status, and displaying relevant enquiries in a sorted manner.
 * <p>
 * This class is part of the feedback and enquiry module in the application.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
public class EnquiryOutput {

    /**
     * Displays the details of a specific enquiry.
     *
     * @param enquiry The enquiry to be viewed.
     */
    public static void viewEnquiry(Enquiry enquiry) {
        enquiry.viewDetails();
    }

    /**
     * Retrieves a list of enquiries made by a specific student based on their processing status.
     *
     * @param student   The student associated with the enquiries.
     * @param processed A boolean indicating whether to retrieve processed or unprocessed enquiries.
     * @return An ArrayList of enquiries based on the specified processing status.
     */
    public static ArrayList<Enquiry> getRequiredEnquiries(Student student, boolean processed){
        ArrayList<Enquiry> requiredEnquiries = new ArrayList<Enquiry>();
        for (Enquiry enquiry : student.getEnquiriesMade()){
            if (enquiry.isProcessed() == processed){
                requiredEnquiries.add(enquiry);
            }

        }
        return requiredEnquiries;
    }

    /**
     * Displays a list of relevant enquiries in a sorted manner. If the list is empty, prompts the user
     * and awaits confirmation to continue.
     *
     * @param enquiryList The list of enquiries to be displayed.
     */
    public static void viewRequiredEnquiries(ArrayList<Enquiry> enquiryList) {
        if(enquiryList.size()==0){
            Scanner sc = new Scanner(System.in);
            System.out.println("No enquiries to show");
            int confirm = 0;
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
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

    /**
     * Prompts the user to select an enquiry from a list for further actions.
     *
     * @param requiredEnquiries The list of enquiries from which the user can select.
     * @return The selected enquiry or  null if no enquiries are available.
     */
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