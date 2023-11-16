package src;
public class Suggestion extends Feedback{
    private String camp; // Reference to the associated camp
    private boolean processed; //True = processed and cannot be modified
    
    public Suggestion(String text, CampCommittee sender,  String camp){
        super(text,sender);
        this.camp = camp;
        this.processed = false; // Initialize as unprocessed

    }
}