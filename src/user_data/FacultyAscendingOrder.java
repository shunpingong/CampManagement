package src.user_data;

public class FacultyAscendingOrder extends UserSorter{

	public FacultyAscendingOrder() {}

    @Override
    public int compare(User user1, User user2){
    	String fa1 = user1.getFaculty().toString();
    	String fa2 = user2.getFaculty().toString();
        return fa1.compareToIgnoreCase(fa2); 
    }
}