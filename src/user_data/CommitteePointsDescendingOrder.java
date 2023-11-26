package src.user_data;

public class CommitteePointsDescendingOrder extends CampCommitteeSorter{

	public CommitteePointsDescendingOrder(){}
	
	public int compare(CampCommittee user1, CampCommittee user2){
		CommitteePointsAscendingOrder CPAO = new CommitteePointsAscendingOrder();
    	return -1 * CPAO.compare(user1, user2);
	}
}
