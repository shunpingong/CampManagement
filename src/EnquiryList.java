package src;
import java.util.ArrayList;

// public class EnquiryList {
//     private static ArrayList<Enquiry> enquiries = new ArrayList<>();

//     public EnquiryList() {}
    
//     public static void initEnquiries(){
//         enquiries = new ArrayList<Enquiry>();
//     }

//     public int getSize(){
//         return enquiries.size();
//     }
//     public static void addEnquiry(Enquiry enquiry) {
//         enquiries.add(enquiry);
//         System.out.println("Enquiry for camp " + enquiry.getCamp() + " submitted.");
//     }

public class EnquiryList {
    private final static ArrayList<Enquiry> totalEnquiries = new ArrayList<Enquiry>(); //Keep track of all enquiries by all students
    private ArrayList<Enquiry> enquiries = new ArrayList<Enquiry>(); //Keep track of enquiries by specific student

    public EnquiryList() {
      enquiries = new ArrayList<Enquiry>();
    }

    public int getSize(){
        return enquiries.size();
    }

    public void addEnquiry(Enquiry enquiry) {
        enquiries.add(enquiry);
        totalEnquiries.add(enquiry);
        System.out.println("Enquiry for camp " + enquiry.getCamp() + " submitted.");
    }

    //delete enquiry
    public void deleteEnquiry(String campName, User currentUser) {
        for (Enquiry enquiry : enquiries) {
            if (!enquiry.isProcessed() && enquiry.getSender().equals(currentUser) && enquiry.getCamp().equals(campName)) {
                totalEnquiries.remove(enquiry);
                enquiries.remove(enquiry);
                System.out.println("Enquiry Deleted");
                return;  // Assuming there is at most one matching enquiry
            }
        }
        System.out.println("Enquiry not found or already processed.");
    }

    public Enquiry getEnquiry(int index){
		return enquiries.get(index);
	}
    
    //Display enquiries by the currentUser
    public void displayEnquiriesForCamp(String campName, User currentUser) {
        System.out.println("Enquiries for Camp: " + campName);
    
        int count = 1;  // Initialize a counter variable
    
        for (Enquiry enquiry : totalEnquiries) {
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

    public void displayEnquiriesByUser(User currentUser) {    
        int count = 1;  // Initialize a counter variable
    
        for (Enquiry enquiry : totalEnquiries) {
            if (enquiry.getSender().equals(currentUser)) {
                System.out.println("Enquiry " + count + ":");
                enquiry.viewDetails();
                count++;  // Increment the counter after printing an enquiry
            }
        }
        // Check if no enquiries were displayed
        if (count == 1) {
            System.out.println("No enquiries");
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
    public ArrayList<Enquiry> getEnquiriesForCamp(String campName, User currentUser) {
        ArrayList<Enquiry> campEnquiries = new ArrayList<>();
    
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getCamp().equals(campName) && enquiry.getSender().equals(currentUser)) {
                campEnquiries.add(enquiry);
            }
        }
    
        return campEnquiries;
    }

    public ArrayList<Enquiry> getEnquiriesByUser(User currentUser) {
        ArrayList<Enquiry> campEnquiries = new ArrayList<>();
    
        for (Enquiry enquiry : enquiries) {
            if (enquiry.getSender().equals(currentUser)) {
                campEnquiries.add(enquiry);
            }
        }
    
        return campEnquiries;
    }

    // You can implement additional methods for managing and retrieving enquiries as needed.
}
