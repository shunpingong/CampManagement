import java.util.ArrayList;
import java.util.List;

public class EnquiryList {
    private static ArrayList<Enquiry> enquiries;

    public EnquiryList() {}
    
    public static void initEnquiries(){
        enquiries = new ArrayList<Enquiry>();
    }

    public static void addEnquiry(Enquiry enquiry) {
        enquiries.add(enquiry);
    }

    //Delete enquiry 
    public static void deleteEnquiry(Enquiry enquiry) {
        if (!enquiry.isProcessed()) {
            enquiries.remove(enquiry);
        }
        else{
            System.out.println("Enquiry is already processed and cannot be deleted.");
        }
    }

    public static void updateEnquiry(Enquiry updatedEnquiry) {
        for (int i = 0; i < enquiries.size(); i++) {
            Enquiry existingEnquiry = enquiries.get(i);
            if (existingEnquiry.getSender().equals(updatedEnquiry.getSender()) &&
                existingEnquiry.getCamp().equals(updatedEnquiry.getCamp())) {
                // Replace the existing enquiry with the updated one
                enquiries.set(i, updatedEnquiry);
                return;
            }
        }
        // If the enquiry is not found, you can handle it as needed (e.g., raise an error or log it).
    }
    
    public static void displayEnquiriesForCamp(String campName, User currentUser) {
        System.out.println("Enquiries for Camp: " + campName);
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getCamp().equals(campName) && enquiry.getSender().equals(currentUser)) {
                enquiry.viewDetails();
                System.out.println("--------------------");
            }
        }
    }
    
    //Display out the unprocessed enquiries for students to choose and delete
    public static  void displayUnprocessedEnquiries(List<Enquiry> enquiries) {
        for (Enquiry enquiry : enquiries) {
            if (!enquiry.isProcessed()) {
                System.out.println("Unprocessed Enquiry:");
                enquiry.viewDetails();
                System.out.println("--------------------");
            }
        }
    }
    

    // You can implement additional methods for managing and retrieving enquiries as needed.
}
