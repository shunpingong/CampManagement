package src.user_data;

/**
 * The {@code CommitteePointsDescendingOrder} class represents a comparator for sorting
 * camp committee members in descending order based on their points.
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
