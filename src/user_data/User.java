package src.user_data;

/**
 * The {@code User} class is an abstract class representing a user in the system.
 * <p>
 * A user has a unique identifier, name, password, email, role, and belongs to a specific faculty.
 * This class serves as the base class for more specific user types, such as Staff, Student, and CampCommittee.
 * 
 * @author Yi heng
 * @version 1.0
 * @since 2023-11-26
 */
public abstract class User {

	/**
	 * The unique identifier for the user.
	 */
	private String userID;

	/**
	 * The name of the user.
	 */
	private String name;

	/**
	 * The password of the user.
	 */
	private String password;

	/**
	 * The email address of the user.
	 */
	private String email;

	/**
	 * The role of the user.
	 */
	private String role;

	/**
	 * The faculty to which the user belongs.
	 */
	private Faculty faculty;

	/**
	 * Constructs a new {@code User} object with the specified attributes.
	 *
	 * @param userID   The unique identifier for the user.
	 * @param name     The name of the user.
	 * @param email    The email address of the user.
	 * @param faculty  The faculty to which the user belongs.
	 */
	public User(String userID, String name, String email, Faculty faculty){
		this.userID = userID;
		this.name = name;
		this.password = "password";
		this.email = email;
		this.faculty = faculty;
		this.role = "";
	}

	/**
	 * Gets the unique identifier of the user.
	 *
	 * @return The unique identifier.
	 */
	public String getID(){
		return this.userID;
	}

	/**
	 * Gets the password of the user.
	 *
	 * @return The password.
	 */
	public String getPWD(){
		return this.password;
	}

	/**
	 * Gets the name of the user.
	 *
	 * @return The name.
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * Gets the email address of the user.
	 *
	 * @return The email address.
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 * Gets the role of the user.
	 *
	 * @return The role.
	 */
	public String getRole(){
		return this.role;
	}

	/**
	 * Gets the faculty to which the user belongs.
	 *
	 * @return The faculty.
	 */
	public Faculty getFaculty(){
		return this.faculty;
	}

	/**
	 * Sets the unique identifier of the user.
	 *
	 * @param userID The unique identifier.
	 */
	public void setID(String userID){
		this.userID = userID;
	}

	/**
	 * Sets the password of the user.
	 *
	 * @param password The password.
	 */
	public void setPWD(String password){
		this.password = password;
	}

	/**
	 * Sets the name of the user.
	 *
	 * @param name The name.
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Sets the faculty to which the user belongs.
	 *
	 * @param faculty The faculty.
	 */
	public void setFaculty(Faculty faculty){
		this.faculty = faculty;
	}

	/**
	 * Sets the role of the user.
	 *
	 * @param role The role.
	 */
	public void setRole(String role){
		this.role = role;
	}
}