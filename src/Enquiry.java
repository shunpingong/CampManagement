package src;
public class Enquiry{
    private String text;
    private User sender; //Student, Staff, CommitteeMember
    private String camp; // Reference to the associated camp
    private boolean processed; //True = processed and cannot be modified
    

    //Constructor to create an enquiry
    public Enquiry(String text,User sender,String camp){
        this.text = text;
        this.sender = sender;
        this.camp = camp;
        this.processed = false; // Initialize as unprocessed

    }
    // Getter methods
    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }

    //return the name of camp
    public String getCamp() { 
        return camp;
    }

    public boolean isProcessed() {
        return processed;
    }
    
    // Mark the enquiry as processed
    public void markProcessed() {
        processed = true;
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
    
