package src.feedback.enquiry;

import src.camp_management.CampInfo;
import src.user_data.Student;

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
    // Additional methods or attributes common to all feedback types can be added 

}
