package src.user_data;

/**
 * The {@code NameAscendingOrder} class represents a comparator for sorting users
 * in ascending order based on their names.
 * 
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class NameAscendingOrder extends UserSorter{

    /**
     * Default constructor for the NameAscendingOrder class.
     */
	public NameAscendingOrder() {}

    /**
     * Compares two users based on their names in ascending order.
     *
     * @param user1 The first user to compare.
     * @param user2 The second user to compare.
     * @return A negative integer, zero, or a positive integer if the name of the
     *         first user is less than, equal to, or greater than the name of the
     *         second user, ignoring case considerations.
     */
    @Override
    public int compare(User user1, User user2){
    	String name1 = user1.getName();
    	String name2 = user2.getName();
        return name1.compareToIgnoreCase(name2); 
    }
}
