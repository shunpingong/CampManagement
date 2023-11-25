package src.user_data;

public class NameDescendingOrder extends UserSorter{

	public NameDescendingOrder() {}
	
	public int compare(User user1, User user2){
    	NameAscendingOrder nameAscending = new NameAscendingOrder();
    	return -1 * nameAscending.compare(user1, user2);
	}
}
