package src.user_data;

/**
 * The {@code CommitteePointsAscendingOrder} class represents a comparator for sorting
 * camp committee members in ascending order based on their points.
 *
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class CommitteePointsAscendingOrder extends CampCommitteeSorter{

    /**
     * Default constructor for CommitteePointsAscendingOrder.
     */
	public CommitteePointsAscendingOrder(){}
	
    /**
     * Compares two {@code CampCommittee} objects based on committee points in ascending order.
     *
     * @param committee1 The first {@code CampCommittee} object.
     * @param committee2 The second {@code CampCommittee} object.
     * @return A negative integer, zero, or a positive integer if the first committee's points
     *         are less than, equal to, or greater than the second committee's points, respectively.
     */
	@Override
    public int compare(CampCommittee user1, CampCommittee user2){
    	Integer points1 = user1.getPoints();
    	Integer points2 = user2.getPoints();
        return points1.compareTo(points2); 
    }
}
