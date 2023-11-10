package src;
import java.util.ArrayList;

public class Staff extends User {
    // Instances
	private String email;
    private ArrayList<String> campsCreated ;

    // Constructors
    public Staff(String userID, String name, Faculty faculty, String email){
        super(userID, name, faculty);
        this.email = email;
        this.campsCreated = new ArrayList<String>(); 
    }

	// Accessors
	public String getEmail(){
        return this.email;
    }

    public ArrayList<String> getCampsCreated(){
        return this.campsCreated;
    }

    // Mutators
    public void setEmail(String email){
        this.email = email;
    }

    public void setCampsCreated(ArrayList<String> createdCamps){
        this.campsCreated = createdCamps;
    }
}