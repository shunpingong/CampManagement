package src;
import java.util.ArrayList;

public class Staff extends User {
    // Instances
	private String email;
    private ArrayList<String> campsCreated ;

    // Constructors
    public Staff(String userID, String name, String faculty, String email){
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
        this.campsCreated.clear();
        Object copy = createdCamps.clone();
        if(copy instanceof ArrayList)
            this.campsCreated = (ArrayList)createdCamps.clone();
    }
}