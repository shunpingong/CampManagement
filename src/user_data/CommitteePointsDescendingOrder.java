package src.user_data;

public class CommitteePointsDescendingOrder extends UserSorter{

	public CommitteePointsDescendingOrder(){}
	
	public int compare(User user1, User user2){
		CommitteePointsDescendingOrder CPDO = new CommitteePointsDescendingOrder();
    	return -1 * CPDO.compare(user1, user2);
	}
}
