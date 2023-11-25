package src.user_data;
import java.util.Comparator;

public abstract class CampCommitteeSorter implements Comparator<CampCommittee>{

	protected int choice;
	public static UserSorter createUserSorter(int choice) {
		switch (choice) {
        case 1:
            return new NameAscendingOrder();
        case 2:
            return new NameDescendingOrder();
        default:
            return null;
        }
	}

    public int getSortingChoice(){
        return choice;
    }
}
