package src.user_data;
import java.util.Comparator;

import src.camp_management.sorter.CampEndDateSorter;
import src.camp_management.sorter.CampNameAscendingSorter;
import src.camp_management.sorter.CampNameDescendingSorter;
import src.camp_management.sorter.CampRegDeadlineSorter;
import src.camp_management.sorter.CampStartDateSorter;

public abstract class UserSorter implements Comparator<User>{

    protected int choice;
	public static UserSorter createUserSorter(int choice) {
		switch (choice) {
        case 1:
            return new NameAscendingOrder();
        case 2:
            return new NameDescendingOrder();
        case 3:
            return new FacultyAscendingOrder();
        case 4:
            return new FacultyDescendingOrder();
        default:
            return null;
        }
	}

    public int getSortingChoice(){
        return choice;
    }
	
}
