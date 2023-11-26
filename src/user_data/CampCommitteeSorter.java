package src.user_data;
import java.util.Comparator;

/**
 * The {@code CampCommitteeSorter} class is an abstract class that provides a base
 * implementation for sorting camp committee members.
 *
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public abstract class CampCommitteeSorter implements Comparator<CampCommittee>{

    /**
     * The sorting choice associated with the sorter.
     */
	protected int choice;

    /**
     * Creates an instance of the appropriate subclass based on the sorting choice.
     *
     * @param choice The sorting choice.
     * @return An instance of the appropriate CampCommitteeSorter subclass.
     */
	public static CampCommitteeSorter createCampCommitteeSorter(int choice) {
		switch (choice) {
        case 5:
            return new CommitteePointsAscendingOrder();
        case 6:
            return new CommitteePointsDescendingOrder();
        default:
            return null;
        }
	}

    /**
     * Gets the sorting choice associated with the sorter.
     *
     * @return The sorting choice.
     */
    public int getSortingChoice(){
        return choice;
    }

}
