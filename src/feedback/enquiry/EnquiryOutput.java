/**
 * The {@code EnquiryOutput} interface provides methods for viewing and managing student enquiries.
 * It includes functionality for printing individual enquiries, obtaining lists of required enquiries (processed or not),
 * displaying lists of enquiries, and selecting a specific enquiry for further actions.
 * <p>
 * Implementing classes should provide concrete implementations for the methods defined in this interface.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.enquiry;

import java.util.Scanner;

import src.user_data.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class EnquiryOutput {

    /**
     * Displays the details of a given enquiry.
     *
     * @param enquiry The enquiry to be viewed.
     */
    public static void viewEnquiry(Enquiry enquiry) {
        enquiry.viewDetails();
    }

    /**
     * Retrieves a list of enquiries based on the processed status for a given student.
     *
     * @param student    The student for whom the enquiries are retrieved.
     * @param processed  A flag indicating whether to retrieve processed or unprocessed enquiries.
     * @return An ArrayList of enquiries based on the processed status.
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
     * Displays a list of enquiries with details based on the provided ArrayList.
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