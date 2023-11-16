package src;
import java.util.ArrayList;

public class EnquiryList {
    private static ArrayList<Enquiry> enquiries = new ArrayList<>();

    public EnquiryList() {}
    
    public static void initEnquiries(){
        enquiries = new ArrayList<Enquiry>();
    }

    public static void addEnquiry(Enquiry enquiry) {
        enquiries.add(enquiry);
        System.out.println("Enquiry for camp " + enquiry.getCamp() + " submitted.");
    }

    //delete enquiry
    public static void deleteEnquiry(String campName, User currentUser) {
        for (Enquiry enquiry : enquiries) {
            if (!enquiry.isProcessed() && enquiry.getSender().equals(currentUser) && enquiry.getCamp().equals(campName)) {
                enquiries.remove(enquiry);
                System.out.println("Enquiry Deleted");
                return;  // Assuming there is at most one matching enquiry
            }
        }
        System.out.println("Enquiry not found or already processed.");
    }

    public static Enquiry getEnquiry(int index){
		return enquiries.get(index-1);
	}
    
    //Display enquiries by the currentUser
    public static void displayEnquiriesForCamp(String campName, User currentUser) {
        System.out.println("Enquiries for Camp: " + campName);
    
        int count = 1;  // Initialize a counter variable
    
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getCamp().equals(campName) && enquiry.getSender().equals(currentUser)) {
                System.out.println("Enquiry " + count + ":");
                enquiry.viewDetails();
                count++;  // Increment the counter after printing an enquiry
            }
        }
    
        // Check if no enquiries were displayed
        if (count == 1) {
            System.out.println("None");
        }
    }
    
    // //Display out the unprocessed enquiries for students to choose and delete
    // public static  void displayUnprocessedEnquiries(ArrayList<Enquiry> enquiries) {
    //     for (Enquiry enquiry : enquiries) {
    //         if (!enquiry.isProcessed()) {
    //             System.out.println("Unprocessed Enquiry:");
    //             enquiry.viewDetails();
    //             System.out.println("--------------------");
    //         }
    //     }
    // }
    
    //To check whether camp have enquiries or not
    public static ArrayList<Enquiry> getEnquiriesForCamp(String campName, User currentUser) {
        ArrayList<Enquiry> campEnquiries = new ArrayList<>();
    
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getCamp().equals(campName) && enquiry.getSender().equals(currentUser)) {
                campEnquiries.add(enquiry);
            }
        }
    
        return campEnquiries;
    }
    
    // You can implement additional methods for managing and retrieving enquiries as needed.
}
