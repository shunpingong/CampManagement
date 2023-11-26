package src.user_data;

import java.util.ArrayList;

import src.camp_management.CampInfo;
import src.feedback.suggestions.Suggestion;

/**
* The {@code CampCommittee} class represents a camp committee member, extending the
 * base class {@code Student}.
 *
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public class CampCommittee extends Student {
    
    /**
     * The number of points earned by the committee member.
     */
    private int points;

    /**
     * The camp for which the committee member is a committee member.
     */
    private CampInfo committeeOf;

    /**
     * The list of suggestions made by the committee member.
     */
	private ArrayList<Suggestion> suggestionsMade  = new ArrayList<Suggestion>();

    /**
     * Constructs a new CampCommittee object with the specified attributes.
     * 
     * @param userId      The unique identifier for the committee member.
     * @param name        The name of the committee member.
     * @param faculty     The faculty to which the committee member belongs (enum).
     * @param email       The email address of the committee member.
     * @param committeeOf The camp for which the committee member is a committee member.
     */
    public CampCommittee(String userId, String name, Faculty faculty, String email, CampInfo committeeOf){
        super(userId, name, faculty, email);
        super.setRole("Committee");
        this.suggestionsMade = new ArrayList<Suggestion>();
        this.committeeOf = committeeOf;
    }

    /**
     * Gets the points earned by the committee member.
     * 
     * @return The points earned by the committee member.
     */
    public int getPoints(){
        return this.points;
    }

    /**
     * Gets the list of suggestions made by the committee member.
     * 
     * @return The list of suggestions made by the committee member.
     */
    public ArrayList<Suggestion> getSuggestionsMade() {
		return this.suggestionsMade;
    }

    /**
     * Gets the camp for which the committee member is a committee member.
     * 
     * @return The camp for which the committee member is a committee member.
     */
    public CampInfo getCommitteeOf(){
		return this.committeeOf;
	}

    /**
     * Sets the points earned by the committee member.
     * 
     * @param points The points to be set.
     */
    public void setPoints(int points){
        this.points = points;
    }

    /**
     * Adds points to the total points earned by the committee member.
     * 
     * @param point The points to be added.
     */
    public void addPoints(int point){
        this.points += point;
        System.out.println(point + " point for student: " + this.getName());
  
    }

    /**
     * Sets the camp for which the committee member is a committee member.
     * 
     * @param camp The camp to be set.
     */
    public void setCommitteeOf(CampInfo camp){
		this.committeeOf = camp;
	}

}