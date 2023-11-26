package src.feedback.enquiry;

import src.camp_management.CampInfo;
import src.user_data.Student;
import src.user_data.User;

/**
 * The Enquiry class represents an enquiry regarding a camp.
 * It extends the {@code Feedback} class and includes additional attributes specific to enquiries
 * such as whether the enquiry has been processed, who replied to the enquiry, and the reply content.
 * <p>
 * An instance of this class can be created with the necessary information, and various methods are provided to interact
 * with and retrieve details about the enquiry.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
public class Enquiry extends Feedback {

    /**
     * Indicates whether the enquiry has been processed.
     */
    private boolean processed;

    /**
     * The user who authored the reply, which can be a committee member or staff.
     */
    private User replyAuthor;

    /**
     * The content of the reply to the enquiry.
     */
    private String reply;

    /**
     * Constructs an Enquiry object with the specified description, sender, camp information, and reply author.
     * The processed status is set to false, and the default reply is provided.
     *
     * @param description The description of the enquiry.
     * @param sender      The student who sent the enquiry.
     * @param camp        The camp information related to the enquiry.
     * @param replyAuthor The user (committee or staff) who authored the reply.
     */
    public Enquiry(String description, Student sender, CampInfo camp, User replyAuthor) {
        super(description, sender, camp);
        this.processed = false;
        this.replyAuthor = replyAuthor;
        this.reply = "This enquiry has not been replied";
    }

    /**
     * Checks if the enquiry has been processed.
     *
     * @return true if the enquiry has been processed, false otherwise.
     */
    public boolean isProcessed() {
        return this.processed;
    }

    /**
     * Marks the enquiry as processed.
     */
    public void markProcessed() {
        this.processed = true;
    }

    /**
     * Gets the reply content to the enquiry.
     *
     * @return The reply content.
     */
    public String getReply() {
        return reply;
    }

    /**
     * Sets the reply content for the enquiry.
     *
     * @param reply The reply content to set.
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    /**
     * Sets the author of the reply.
     *
     * @param author The user (committee or staff) who authored the reply.
     */
    public void setReplyAuthor(User author) {
        this.replyAuthor = author;
    }

    /**
     * Gets the author of the reply.
     *
     * @return The user (committee or staff) who authored the reply.
     */
    public User getReplyAuthor() {
        return replyAuthor;
    }

    /**
     * Updates the description of the enquiry if it is not processed.
     *
     * @param newText The new description to set.
     */
    @Override
    public void updateDescription(String newText) {
        if (!this.isProcessed()) {
            this.setDescription(newText);
            System.out.println("Enquiry Updated");
        } else {
            System.out.println("Cannot update processed enquiry.");
        }
    }

    /**
     * Displays details about the enquiry, including description,
     * sender, camp, processed status, reply, and reply author.
     */
    @Override
    public void viewDetails() {
        System.out.println("Enquiry Description: " + getDescription());
        System.out.println("Sender: " + getSender().getName());
        System.out.println("Camp: " + getCamp().getCampName());
        System.out.println("Processed: " + isProcessed());
        System.out.println("Reply: " + getReply());
        if (getReplyAuthor() != null) {
            System.out.println("Replied by: " + getReplyAuthor().getName());
        } else {
            System.out.println("Replied by: This enquiry has not been replied");
        }
        System.out.println("---------------------------------------------");
    }
}

