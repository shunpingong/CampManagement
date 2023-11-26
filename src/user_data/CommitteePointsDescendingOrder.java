package src.user_data;

/**
 * The {@code CommitteePointsDescendingOrder} class is a concrete implementation of {@code CampCommitteeSorter}.
 * It provides sorting logic for {@code CampCommittee} objects based on descending order of committee points.
 * <p>
 * Sorting is achieved by utilizing the logic of {@code CommitteePointsAscendingOrder} in reverse order.
 * This class overrides the {@code compare} method to define the specific sorting logic for descending order.
 * <p>
 * Implementing classes should ensure proper initialization of the sorting choice, and this class
 * provides a reverse order comparison using {@code CommitteePointsAscendingOrder}.
 *
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class CommitteePointsDescendingOrder extends CampCommitteeSorter{

    /**
     * Default constructor for CommitteePointsDescendingOrder.
     */
	public CommitteePointsDescendingOrder(){}
	
    /**
     * Compares two {@code CampCommittee} objects based on committee points in descending order.
     *
     * @param committee1 The first {@code CampCommittee} object.
     * @param committee2 The second {@code CampCommittee} object.
     * @return A negative integer, zero, or a positive integer if the first committee's points
     *         are greater than, equal to, or less than the second committee's points, respectively.
     */
    @Override
	public int compare(CampCommittee user1, CampCommittee user2){
		CommitteePointsAscendingOrder CPAO = new CommitteePointsAscendingOrder();
    	return -1 * CPAO.compare(user1, user2);
	}
}
