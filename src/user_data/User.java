package src.user_data;

public abstract class User {
	// Instances
	private String userID;
	private String name;
	private String password;
	private String email;
	private String role;
	private Faculty faculty;

	// Constructors
	public User(String userID, String name, String email, Faculty faculty){
		this.userID = userID;
		this.name = name;
		this.password = "password";
		this.email = email;
		this.faculty = faculty;
		this.role = "";
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

	public String getEmail(){
		return this.email;
	}

	public String getRole(){
		return this.role;
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

	public void setRole(String role){
		this.role = role;
	}
}