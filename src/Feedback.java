package src;
public abstract class Feedback {
    private String text;
    private User sender; //Student, Staff, CommitteeMember
    private CampInfo camp; // Reference to the associated camp
    private String reply; // The reply to the feedback
    private boolean processed; //True = processed and cannot be modified
    
    // Constructor
    public Feedback(String text, User sender, CampInfo camp, String reply) {
        this.text = text;
        this.sender = sender;
        this.camp = camp;
        this.reply = reply;
        this.processed = false;
    }

/*---------------------------------------------------------------ACCESSORS -------------------------------------------------------------------------*/
    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }
    
    public CampInfo getCamp() { 
        return camp;
    }

    public String getReply(){
        return reply;
    }

    public boolean isProcessed() {
        return processed;
    }
    
/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/
    // Mark the enquiry as processed
    public void markProcessed() {
        processed = true;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setReply(String reply){
        this.reply = reply;
    }

    public void setSender(User sender){
        this.sender = sender;
    }

    public void setCamp (CampInfo camp){
        this.camp = camp;
    }

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
    // Abstract method to be implemented by subclasses

    public abstract void updateText(String newText);
    public abstract void viewDetails();
    public abstract void reply(User currentUser, String replyText);
    // public abstract void reply(User currentUser, String replyText); 

    // Additional methods or attributes common to all feedback types can be added 
    //Concrete
    public boolean isUserFeedback(User currentUser) {
        // Check if the sender of the enquiry is the current user
        return getSender().equals(currentUser);
    }
}
