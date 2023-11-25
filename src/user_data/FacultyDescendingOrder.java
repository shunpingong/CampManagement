package src.user_data;

public class FacultyDescendingOrder extends UserSorter{
	public FacultyDescendingOrder() {}
	
	public int compare(User user1, User user2){
		FacultyAscendingOrder FacultyAscending = new FacultyAscendingOrder();
    	return -1 * FacultyAscending.compare(user1, user2);
	}

}
