package src.feedback.enquiry;

import src.camp_management.CampInfo;
import src.user_data.Student;
import src.user_data.User;

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

    @Override
    public void viewDetails() {
        System.out.println("Enquiry Description: " + getDescription());
        System.out.println("Sender: " + getSender().getName());
        System.out.println("Camp: " + getCamp().getCampName()); 
        System.out.println("Processed: " + isProcessed());
        System.out.println("Reply: " + getReply());
        if (getReplyAuthor()!= null){
            System.out.println("Replied by: " + getReplyAuthor().getName());
        }
        else{
            System.out.println("Replied by: This enquiry has not been replied");
            }
            System.out.println("---------------------------------------------");
    }
}   
    
