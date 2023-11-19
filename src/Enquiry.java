package src;
public class Enquiry extends Feedback{
    

    //Constructor to create an enquiry
    public Enquiry(String text,User sender,CampInfo camp, String reply){
        super(text,sender,camp,reply);

    }

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
    @Override
    public void updateText(String newText) {
        // Check if the enquiry is not processed
        if (!this.isProcessed()) {
            // Update the text of the enquiry
            this.setText(newText);
            System.out.println("Enquiry Updated");
        } else {
            System.out.println("Cannot update processed enquiry.");
        }
    }

    @Override
    public void reply(User currentUser, String replyText) {
        this.markProcessed();
        //If replied by camp committee, they will get 1 point
        if (currentUser instanceof CampCommittee){
            ((CampCommittee) currentUser).addPoints();
        }
        this.setReply(replyText);
    }

    public void viewDetails() {
        // Display the details of the enquiry, including sender, text, camp, and processing status
        System.out.println("Enquiry Text: " + this.getText());
        System.out.println("Sender: " + this.getSender().getName()); // Assuming User has a 'getName' method
        System.out.println("Camp: " + this.getCamp().getCampName()); // Assuming Camp has a 'getCamp' method
        System.out.println("Processed: " + this.isProcessed());
        System.out.println("Reply: " + this.getReply());
        System.out.println("--------------------");
    }
    
}   
    
