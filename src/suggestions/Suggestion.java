package src.suggestions;

import src.CampCommittee;
import src.CampInfo;
import src.enquiry.Feedback;

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
        // Display the details of the enquiry, including sender, text, camp, and processing status
        System.out.println("Suggestion Status: " + this.getStatus());
        System.out.println("Suggestion Description: " + this.getDescription());
        System.out.println("Sender: " + this.getSender().getName()); // Assuming User has a 'getName' method
        System.out.println("Camp: " + this.getCamp().getCampName()); // Assuming Camp has a 'getCamp' method
        System.out.println("Status: " + this.getStatus());
        System.out.println("--------------------");
    }

}