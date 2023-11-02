package src;
import java.util.ArrayList;
public class Camp {
	// Instances
	private CampInfo info;
	private ArrayList<String> attendees;
	private ArrayList<String> committee;
	private boolean visibility;

	// Constructors
	public Camp(CampInfo info, boolean visibility){
		this.info = info;
		this.visibility = visibility;
		this.attendees = new ArrayList<>();
		this.attendees = new ArrayList<>();
	}

	// Accessors
	public CampInfo getInfo(){
		return this.info;
	}
	public boolean getVisibility(){
		return this.visibility;
	}

	// Mutators
	public void setInfo(CampInfo info){
		this.info = info;
	}
	public void setVisibility(boolean visibility){
		this.visibility = visibility;
	}
	public void setAttendees(ArrayList<String> attendees){
		this.attendees.clear();
		Object copy = attendees.clone();
		if(copy instanceof ArrayList)
			this.attendees = (ArrayList)copy;
	}
	public void setCommittee(ArrayList<String> committee){
		this.committee.clear();
		Object copy = committee.clone();
		if(copy instanceof ArrayList)
			this.committee = (ArrayList)copy;
	}
}