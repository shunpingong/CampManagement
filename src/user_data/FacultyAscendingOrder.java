package src.user_data;

/**
 * The {@code FacultyAscendingOrder} class represents a comparator for sorting users
 * in ascending order based on their faculty.
 * 
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class FacultyAscendingOrder extends UserSorter{

    /**
     * Default constructor for the FacultyAscendingOrder class.
     */
	public FacultyAscendingOrder() {}

    /**
     * Compares two users based on their faculty in ascending order.
     *
     * @param user1 The first user to compare.
     * @param user2 The second user to compare.
     * @return A negative integer, zero, or a positive integer if the faculty of the
     *         first user is less than, equal to, or greater than the faculty of the
     *         second user, ignoring case considerations.
     */
    @Override
    public int compare(User user1, User user2){
    	String fa1 = user1.getFaculty().toString();
    	String fa2 = user2.getFaculty().toString();
        return fa1.compareToIgnoreCase(fa2); 
    }
}