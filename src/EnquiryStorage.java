package src;
import java.util.ArrayList;
import java.util.List;

public class EnquiryStorage {
    private List<Enquiry> enquiries;

    public EnquiryStorage() {
        enquiries = new ArrayList<>();
    }

    public void addEnquiry(Enquiry enquiry) {
        enquiries.add(enquiry);
    }

    public List<Enquiry> getAllEnquiries() {
        return enquiries;
    }

    //Delete enquiry 
    public void deleteEnquiry(Enquiry enquiry) {
        if (!enquiry.isProcessed()) {
            enquiries.remove(enquiry);
        }
        else{
            System.out.println("Enquiry is already processed and cannot be deleted.");
        }
    }

    public void updateEnquiry(Enquiry updatedEnquiry) {
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
    
    //Display out the unprocessed enquiries for students to choose and delete
    public void displayUnprocessedEnquiries(List<Enquiry> enquiries) {
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
