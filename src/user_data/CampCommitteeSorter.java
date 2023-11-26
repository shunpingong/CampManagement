package src.user_data;
import java.util.Comparator;

public abstract class CampCommitteeSorter implements Comparator<CampCommittee>{

	protected int choice;
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

    public int getSortingChoice(){
        return choice;
    }
}
