package src;

public abstract class User {
	// Instances
	private String userID;
	private String name;
	private String password;
	private Faculty faculty;

	// Constructors
	public User(String userID, String name, Faculty faculty){
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

	public Faculty getFaculty(){
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

	public void setFaculty(Faculty faculty){
		this.faculty = faculty;
	}

	public abstract int menu();
	public abstract void menuChoice(int i, User currentUser); //to set who made the enquiry/suggestion
	// public abstract void menuChoice(int i);
}