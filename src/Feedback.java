package src;
public abstract class Feedback {
    private String text;
    private User sender; //Student, Staff, CommitteeMember
    private boolean processed; //True = processed and cannot be modified


    
    // Constructor
    public Feedback(String text, User sender) {
        this.text = text;
        this.sender = sender;
        this.processed = false;
    }

    // Getter methods
    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setSender(User sender){
        this.sender = sender;
    }
    // Abstract method to be implemented by subclasses


    // Additional methods or attributes common to all feedback types can be added here
}
