package src.user_data;
import java.util.ArrayList;

import src.camp_management.CampInfo;
import src.feedback.enquiry.EnquiryReply;
import src.feedback.suggestions.SuggestionProcessor;

public class Staff extends User implements SuggestionProcessor, EnquiryReply {
    // Instances
    private ArrayList<CampInfo> campsCreated;

    // Constructors
    public Staff(String userID, String name, Faculty faculty, String email){
        super(userID, name, email, faculty);
        super.setRole("Staff");
        this.campsCreated = new ArrayList<CampInfo>(); 
        //1 staff in charge of 1 camp, unique
    }

/*---------------------------------------------------------------ACCESSORS -------------------------------------------------------------------------*/
    public ArrayList<CampInfo> getCampsCreated(){
        return this.campsCreated;
    }

/*---------------------------------------------------------------MUTATORS -------------------------------------------------------------------------*/
    public void AddCampsOwned(CampInfo camp){
        this.campsCreated.add(camp);
    }


}