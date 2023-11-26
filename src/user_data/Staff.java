package src.user_data;
import java.util.ArrayList;

import src.camp_management.CampInfo;

/**
 * The {@code Staff} class represents a staff member in the system.
 * It extends the {@code User} class and includes additional functionality related to staff members,
 * such as managing a list of camps created by the staff
 * 
 * @author Yi heng
 * @version 1.0
 * @since 2023-11-26
 */
public class Staff extends User {

    /** 
     * The list of camps created by the staff member
     */
    private ArrayList<CampInfo> campsCreated;

    /**
     * Constructor for the Staff class.
     *
     * @param userID   The unique identifier for the staff member.
     * @param name     The name of the staff member.
     * @param faculty  The faculty to which the staff member belongs.
     * @param email    The email address of the staff member.
     */
    public Staff(String userID, String name, Faculty faculty, String email){
        super(userID, name, email, faculty);
        super.setRole("Staff");
        this.campsCreated = new ArrayList<CampInfo>(); 
    }

    /**
     * Gets the list of camps created by the staff member.
     *
     * @return The list of camps created.
     */
    public ArrayList<CampInfo> getCampsCreated(){
        return this.campsCreated;
    }

    /**
     * Adds a camp to the list of camps owned by the staff member.
     *
     * @param camp The camp to be added.
     */
    public void AddCampsOwned(CampInfo camp){
        this.campsCreated.add(camp);
    }
}