/**
 * The Suggestion class represents a suggestion made by a camp committee member
 * to modify certain details of a camp. It extends the Feedback class and includes
 * specific attributes such as the category of the suggestion, the proposed change, and its status.
 * <p>
 * An instance of this class can be created with the necessary information, and various methods
 * are provided to interact with and retrieve details about the suggestion.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.suggestions;

import java.util.ArrayList;
import java.util.Arrays;

import src.camp_management.CampInfo;
import src.feedback.enquiry.Feedback;
import src.user_data.CampCommittee;

public class Suggestion extends Feedback{

    /**
     * The category of the suggestion, indicating which camp detail to change.
     * Valid values are from 1 to 6, representing different camp details.
     * 1. Camp Name
     * 2. Camp Description
     * 3. Camp Location
     * 4. Camp Total Slots
     * 5. Camp Committee Slots
     * 6. Faculty opened to
     */
    private int category;

    /**
     * The proposed change for the specified category.
     */
    private String change;

    /**
     * The status of the suggestion, which can be Unprocessed, Rejected, or Processed.
     */
    private SuggestionStatus status;

    /**
     * Constructs a Suggestion with the specified description, sender, camp,
     * change, category, and status. The suggestion is associated with the camp.
     * Points are added to the sender based on the status.
     *
     * @param description The description of the suggestion.
     * @param sender      The camp committee member who made the suggestion.
     * @param camp        The camp associated with the suggestion.
     * @param change      The proposed change for the camp detail.
     * @param category    The category of the suggestion.
     * @param status      The status of the suggestion.
     */
    public Suggestion(String description, CampCommittee sender, CampInfo camp, 
    String change, int category, SuggestionStatus status){
        super(description,sender,camp);
        this.status = status;
        this.category = category;
        this.change = change;

        this.getCamp().addSuggestionForCamp(this);
        if(this.status == SuggestionStatus.ACCEPTED){
            ((CampCommittee) this.getSender()).addPoints(2);
        }
        else{
            ((CampCommittee) this.getSender()).addPoints(1);
        }
    }

   /**
     * Gets the proposed change for the suggestion.
     *
     * @return The proposed change for the suggestion.
     */
    public String getChange() {
        return change;
    }

    /**
     * Sets the proposed change for the suggestion.
     *
     * @param change The proposed change to set.
     */
    public void setChange(String change) {
        this.change = change;
    }

    /**
     * Gets the category of the suggestion.
     *
     * @return The category of the suggestion.
     */
    public int getCategory() {
        return this.category;
    }

    /**
     * Sets the category of the suggestion.
     *
     * @param category The category to set.
     */
    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * Gets the status of the suggestion.
     *
     * @return The status of the suggestion.
     */
    public SuggestionStatus getStatus() {
        return this.status;
    }

    /**
     * Rejects the suggestion, setting its status to SuggestionStatus.REJECTED}.
     */
    public void reject() {
        this.status = SuggestionStatus.REJECTED;
    }

    /**
     * Accepts the suggestion, setting its status to SuggestionStatus.ACCEPTED}.
     * Adds points to the sender based on the status.
     */
    public void accept(){
        this.status = SuggestionStatus.ACCEPTED;
        ((CampCommittee) this.getSender()).addPoints(1);
    }
    
    /**
     * Updates the description of the suggestion if it is not processed.
     *
     * @param newText The new description to set.
     */
    @Override
    public void updateDescription(String newText) {
        if (this.status != SuggestionStatus.ACCEPTED) {
            this.setDescription(newText);
            System.out.println("Suggestion Updated");
        } else {
            System.out.println("Cannot update processed suggestion.");
        }
    }

    /**
     * Displays details about the suggestion, including description, category, proposed change, sender, camp, and status.
     */
    @Override
    public void viewDetails() {
        ArrayList<String> fieldNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
            "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
            System.out.println("Suggestion Description: " + getDescription());
            System.out.println("Suggestion Category: " + fieldNames.get(getCategory()-1));
            System.out.println("Suggestion Changes: " + getChange());
            System.out.println("Sender: " + getSender().getName()); 
            System.out.println("Camp: " + getCamp().getCampName()); 
            System.out.println("Status: " + getStatus());
            System.out.println("---------------------------------------------");
    }

}