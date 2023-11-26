package src.user_data;

import java.util.ArrayList;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.feedback.enquiry.EnquiryReply;
import src.feedback.suggestions.Suggestion;
import src.feedback.suggestions.SuggestionMenu;;

public class CampCommittee extends Student {
    // Instances
    private int points;
    private CampInfo committeeOf; //Camp the student is a committee of
	private ArrayList<Suggestion> suggestionsMade  = new ArrayList<Suggestion>(); //List of Suggestions Camp Committee made

    // Constructors
    //ADD CONSTRUCTORS
    public CampCommittee(String userId, String name, Faculty faculty, String email, CampInfo committeeOf){
        super(userId, name, faculty, email);
        super.setRole("Committee");
        this.suggestionsMade = new ArrayList<Suggestion>();
        this.committeeOf = committeeOf;
    }
/*---------------------------------------------------------------ACCESSORS -------------------------------------------------------------------------*/
    public int getPoints(){
        return this.points;
    }

    //Suggestions made by student: Bala
	public ArrayList<Suggestion> getSuggestionsMade() {
		return this.suggestionsMade;
    }

    public CampInfo getCommitteeOf(){
		return this.committeeOf;
	}

/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/
    public void setPoints(int points){
        this.points = points;
    }

    public void addPoints(int point){
        this.points += point;
        System.out.println(point + " point for student: " + this.getName());
  
    }

    public void setCommitteeOf(CampInfo camp){
		this.committeeOf = camp;
	}

/*---------------------------------------------------------------ADDITIONAL METHODS -------------------------------------------------------------------------*/
}