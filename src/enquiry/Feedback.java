package src.enquiry;

import src.CampInfo;
import src.Student;

public abstract class Feedback {
    private String description;
    private Student sender; //Student, CommitteeMember
    private CampInfo camp; // Reference to the associated camp
    
    // Constructor
    public Feedback(String text, Student sender, CampInfo camp) {
        this.description = text;
        this.sender = sender;
        this.camp = camp;
    }

/*---------------------------------------------------------------ACCESSORS -------------------------------------------------------------------------*/
    public String getDescription() {
        return this.description;
    }

    public Student getSender() {
        return sender;
    }
    
    public CampInfo getCamp() { 
        return camp;
    }

/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/

    public void setDescription(String description){
        this.description = description;
    }

    public void setSender(Student sender){
        this.sender = sender;
    }

    public void setCamp (CampInfo camp){
        this.camp = camp;
    }

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
    // Abstract method to be implemented by subclasses

    public abstract void updateDescription(String newText);
    public abstract void viewDetails();
    // public abstract void reply(User currentUser, String replyText);
    // public abstract void reply(User currentUser, String replyText); 

    // Additional methods or attributes common to all feedback types can be added 
    //Concrete
    public boolean isUserFeedback(Student currentUser) {
        // Check if the sender of the enquiry is the current user
        return getSender().equals(currentUser);
    }
}
