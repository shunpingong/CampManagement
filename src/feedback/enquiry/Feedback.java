/**
 * The Feedback abstract class represents a generic feedback entity associated with a camp.
 * It includes attributes such as description, sender (student or committee member), and a reference to the associated camp.
 * <p>
 * Subclasses are expected to provide concrete implementations for abstract methods, such as updating the description
 * and viewing details of the feedback.
 * Extended by concrete feedback types like Enquiry, Suggestion etc.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.enquiry;

import src.camp_management.CampInfo;
import src.user_data.Student;

public abstract class Feedback {

    /**
     * The description of the feedback.
     */
    private String description;

    /**
     * The sender of the feedback, which can be a student or committee member.
     */
    private Student sender;

    /**
     * The camp associated with the feedback.
     */
    private CampInfo camp; 
    
    /**
     * Constructs a {@code Feedback} with the specified description, sender, and associated camp.
     *
     * @param text   The description of the feedback.
     * @param sender The sender of the feedback.
     * @param camp   The camp associated with the feedback.
     */
    public Feedback(String text, Student sender, CampInfo camp) {
        this.description = text;
        this.sender = sender;
        this.camp = camp;
    }

    /**
     * Gets the description of the feedback.
     *
     * @return The description of the feedback.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the sender of the feedback.
     *
     * @return The sender of the feedback.
     */
    public Student getSender() {
        return sender;
    }
    
    /**
     * Gets the camp associated with the feedback.
     *
     * @return The camp associated with the feedback.
     */
    public CampInfo getCamp() { 
        return camp;
    }

     /**
     * Sets the description of the feedback.
     *
     * @param description The new description to set.
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Sets the sender of the feedback.
     *
     * @param sender The new sender to set.
     */
    public void setSender(Student sender){
        this.sender = sender;
    }

    /**
     * Sets the camp associated with the feedback.
     *
     * @param camp The new camp to set.
     */
    public void setCamp (CampInfo camp){
        this.camp = camp;
    }

    /**
     * Abstract method to be implemented by subclasses for updating the description of the feedback.
     *
     * @param newText The new description to set.
     */
    public abstract void updateDescription(String newText);

    /**
     * Abstract method to be implemented by subclasses for viewing details of the feedback.
     */
    public abstract void viewDetails();

}
