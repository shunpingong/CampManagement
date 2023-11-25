package src.user_data;


public class NameAscendingOrder extends UserSorter{

	public NameAscendingOrder() {}

    @Override
    public int compare(User user1, User user2){
    	String name1 = user1.getName();
    	String name2 = user2.getName();
        return name1.compareToIgnoreCase(name2); 
    }
}
