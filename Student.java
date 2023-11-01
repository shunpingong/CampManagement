public class Student extends User {
	// Instances
	private String email;
	private String status;

	// Constructors
	public Student(String userID, String name, Faculty faculty, String email){
		super(userID, name, faculty);
		this.email = email;
		this.status = "";
	}

	// Accessors
	public String getEmail(){
		return this.email;
	}

	public String getStatus(){
		return this.status;
	}

	// Mutators
	public void setEmail(String email){
		this.email = email;
	}

	public void setStatus(String status){
		this.status = status;
	}
}