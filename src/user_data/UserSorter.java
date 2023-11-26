package src.user_data;
import java.util.Comparator;

import src.camp_management.sorter.CampEndDateSorter;
import src.camp_management.sorter.CampNameAscendingSorter;
import src.camp_management.sorter.CampNameDescendingSorter;
import src.camp_management.sorter.CampRegDeadlineSorter;
import src.camp_management.sorter.CampStartDateSorter;

/**
 * The {@code UserSorter} class is an abstract class that implements the Comparator interface.
 * It provides a framework for sorting User objects based on different criteria.
 * 
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public abstract class UserSorter implements Comparator<User>{

	/**
	 * The sorting choice representing the specific sorting logic.
	 */
    protected int choice;
    
	/**
	 * Creates an instance of the appropriate UserSorter based on the provided choice.
	 *
	 * @param choice The sorting choice.
	 * @return An instance of the UserSorter subclass corresponding to the choice.
	 */
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

	/**
	 * Gets the sorting choice representing the specific sorting logic.
	 *
	 * @return The sorting choice.
	 */
    public int getSortingChoice(){
        return choice;
    }
	
}
