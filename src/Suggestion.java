package src;
public class Suggestion extends Feedback{
    
    public Suggestion(String text, CampCommittee sender,  String camp){
        super(text,sender,camp);

    }

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
    // Update the suggestion
    @Override
    public void updateText(String newText) {
        // Check if the suggestion is not processed
        if (!this.isProcessed()) {
            // Update the text of the suggestion
            this.setText(newText);
            System.out.println("Suggestion Updated");
        } else {
            System.out.println("Cannot update processed suggestion.");
        }
    }

    @Override
    public void viewDetails() {
        // Display the details of the enquiry, including sender, text, camp, and processing status
        System.out.println("Suggestion text: " + this.getText());
        System.out.println("Sender: " + this.getSender().getName()); // Assuming User has a 'getName' method
        System.out.println("Camp: " + this.getCamp()); // Assuming Camp has a 'getCamp' method
        System.out.println("Processed: " + this.isProcessed());
        System.out.println("--------------------");
    }


}