package src.enquiry;

import src.CampInfo;
import src.Student;
import src.User;

public class Enquiry extends Feedback{
    private boolean processed;
    private User replyAuthor; //can be committee or staff
    private String reply;

    //Constructor to create an enquiry
    public Enquiry(String description, Student sender, CampInfo camp,
    User replyAuthor){
        super(description,sender,camp);
        this.processed = false;
        this.replyAuthor = replyAuthor;
        this.reply = "This enquiry has not been replied";

    }

    public boolean isProcessed(){
        return this.processed;
    }

    public void markProcessed(){
        this.processed = true;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public void setReplyAuthor(User author) {
        this.replyAuthor = author;
    }

    public User getReplyAuthor(){
        return replyAuthor;
    }

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
    @Override
    public void updateDescription(String newText) {
        // Check if the enquiry is not processed
        if (!this.isProcessed()) {
            // Update the text of the enquiry
            this.setDescription(newText);
            System.out.println("Enquiry Updated");
        } else {
            System.out.println("Cannot update processed enquiry.");
        }
    }

    public void viewDetails() {
        // Display the details of the enquiry, including sender, text, camp, and processing status
        System.out.println("Enquiry Text: " + this.getDescription());
        System.out.println("Sender: " + this.getSender().getName()); // Assuming User has a 'getName' method
        System.out.println("Camp: " + this.getCamp().getCampName()); // Assuming Camp has a 'getCamp' method
        System.out.println("Processed: " + this.isProcessed());
        System.out.println("Reply: " + this.getReply());
        System.out.println("Replied By: " + this.getReplyAuthor());
        System.out.println("--------------------");
    }
    
}   
    
