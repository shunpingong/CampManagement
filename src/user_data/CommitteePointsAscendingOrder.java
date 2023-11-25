package src.user_data;

public class CommitteePointsAscendingOrder extends CampCommitteeSorter{

	public CommitteePointsAscendingOrder(){}
	
	@Override
    public int compare(CampCommittee user1, CampCommittee user2){
    	Integer points1 = user1.getPoints();
    	Integer points2 = user2.getPoints();
        return points1.compareTo(points2); 
    }
}
