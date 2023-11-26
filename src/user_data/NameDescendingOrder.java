package src.user_data;

/**
 * The {@code NameDescendingOrder} class represents a comparator for sorting users
 * in descending order based on their names.
 *
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class NameDescendingOrder extends UserSorter{

	public NameDescendingOrder() {}
	
    /**
     * Compares two users based on their names in descending order.
     *
     * @param user1 The first user to compare.
     * @param user2 The second user to compare.
     * @return A negative integer, zero, or a positive integer if the name of the
     *         first user is greater than, equal to, or less than the name of the
     *         second user, ignoring case considerations.
     */
    @Override
	public int compare(User user1, User user2){
    	NameAscendingOrder nameAscending = new NameAscendingOrder();
    	return -1 * nameAscending.compare(user1, user2);
	}
}
