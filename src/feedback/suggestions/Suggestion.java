package src.feedback.suggestions;

import java.util.ArrayList;
import java.util.Arrays;

import src.camp_management.CampInfo;
import src.feedback.enquiry.Feedback;
import src.user_data.CampCommittee;

public class Suggestion extends Feedback{

     //camp detailfields to change
     //1. Camp Name
     //2. Camp Description
     //3. Camp Location
     //4. Camp Total Slots
     //5. Camp Committee Slots
     //6. Faculty opened to
    private int category;

    //What to change for that category
    private String change;

    //Unprocessed, Rejected, Processed
    private SuggestionStatus status;
    
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

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public SuggestionStatus getStatus() {
        return this.status;
    }

    public void reject() {
        this.status = SuggestionStatus.REJECTED;
    }

    public void accept(){
        this.status = SuggestionStatus.ACCEPTED;
        ((CampCommittee) this.getSender()).addPoints(1);
    }
    

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
    // Update the suggestion
    @Override
    public void updateDescription(String newText) {
        // Check if the suggestion is not processed
        if (this.status != SuggestionStatus.ACCEPTED) {
            // Update the text of the suggestion
            this.setDescription(newText);
            System.out.println("Suggestion Updated");
        } else {
            System.out.println("Cannot update processed suggestion.");
        }
    }

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