package src;
public abstract class Feedback {
    private String text;
    private User sender; //Student, Staff, CommitteeMember
    private String camp; // Reference to the associated camp
    private boolean processed; //True = processed and cannot be modified
    
    // Constructor
    public Feedback(String text, User sender, String camp) {
        this.text = text;
        this.sender = sender;
        this.camp = camp;
        this.processed = false;
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
    
    //Setter Methods
    // Mark the enquiry as processed
    public void markProcessed() {
        processed = true;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setSender(User sender){
        this.sender = sender;
    }

    public void setCamp (String camp){
        this.camp = camp;
    }

//-----------------------------------------------------------------------------------//
    // Abstract method to be implemented by subclasses

    public abstract void updateText(String newText);
    public abstract void viewDetails();
    // public abstract void reply(User currentUser, String replyText); 


    
//-----------------------------------------------------------------------------------//
    // Additional methods or attributes common to all feedback types can be added 
    //Concrete
    public boolean isUserFeedback(User currentUser) {
        // Check if the sender of the enquiry is the current user
        return getSender().equals(currentUser);
    }
}
