package src;
public class Enquiry extends Feedback{

    //Constructor to create an enquiry
    public Enquiry(String text,User sender,String camp){
        super(text,sender,camp);
    }

    //NON MUTATOR/GETTER FUNCTION

    // public void viewDetails(User currentUser) {
    //     // Check if the currentUser is a Staff or CampCommittee in charge of the camp
    //     if (currentUser instanceof Staff || 
    //         (currentUser instanceof CampCommittee && ((CampCommittee) currentUser).isInChargeOfCamp(this.getCamp()))) {
    //         // Display the details of the enquiry
    //         System.out.println("Enquiry Text: " + this.getText());
    //         System.out.println("Sender: " + this.getSender().getName());
    //         System.out.println("Camp: " + this.getCamp());
    //         System.out.println("Processed: " + this.isProcessed());
    //         System.out.println("--------------------");
    //     } else {
    //         // If the currentUser doesn't have the appropriate permissions
    //         System.out.println("You do not have permission to view this enquiry.");
    //     }
    // }

    // Update the enquiry
    @Override
    public void updateText(String newText) {
        // Check if the enquiry is not processed
        if (!this.isProcessed()) {
            // Update the text of the enquiry
            this.setText(newText);
            System.out.println("Enquiry Updated");
        } else {
            System.out.println("Cannot update processed enquiry.");
        }
    }

    public void reply(User currentUser, String replyText) {
        this.markProcessed();
        //If replied by camp committee, they will get 1 point
        if (currentUser instanceof CampCommittee){
            ((CampCommittee) currentUser).addPoints();
        }
    }

    public void viewDetails() {
        // Display the details of the enquiry, including sender, text, camp, and processing status
        System.out.println("Enquiry Text: " + this.getText());
        System.out.println("Sender: " + this.getSender().getName()); // Assuming User has a 'getName' method
        System.out.println("Camp: " + this.getCamp()); // Assuming Camp has a 'getCamp' method
        System.out.println("Processed: " + this.isProcessed());
        System.out.println("--------------------");
    }
    
}   
    
