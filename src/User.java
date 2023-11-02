package src;
public class User {

	// Instances
	private String userID;
	private String name;
	private String password;
	private String faculty;

	// Constructors
	public User(String userID, String name, String faculty){
		this.userID = userID;
		this.name = name;
		this.password = "password";
		this.faculty = faculty;
	}

	// Accessors
	public String getID(){
		return this.userID;
	}

	public String getPWD(){
		return this.password;
	}

	public String getName(){
		return this.name;
	}

	public String getFaculty(){
		return this.faculty;
	}

	// Mutators
	public void setID(String userID){
		this.userID = userID;
	}

	public void setPWD(String password){
		this.password = password;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setFaculty(String faculty){
		this.faculty = faculty;
	}
}