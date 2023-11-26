package src.user_data;

/**
 * The {@code FacultyDescendingOrder} class represents a comparator for sorting users
 * in descending order based on their faculty.
 *
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class FacultyDescendingOrder extends UserSorter{

    /**
     * Default constructor for the FacultyDescendingOrder class.
     */
	public FacultyDescendingOrder() {}
	
    /**
     * Compares two users based on their faculty in descending order.
     *
     * @param user1 The first user to compare.
     * @param user2 The second user to compare.
     * @return A negative integer, zero, or a positive integer if the faculty of the
     *         first user is greater than, equal to, or less than the faculty of the
     *         second user, ignoring case considerations.
     */
    @Override
	public int compare(User user1, User user2){
		FacultyAscendingOrder FacultyAscending = new FacultyAscendingOrder();
    	return -1 * FacultyAscending.compare(user1, user2);
	}

}
