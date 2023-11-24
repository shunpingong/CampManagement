package src.report;

import java.util.ArrayList;
import java.util.List;

import src.camp_management.CampInfo;

public class CommitteeReport extends Report{
	
	CommitteeReport(CampInfo camp, String fileName){
		super(camp, fileName);
	}


	private List<String[]> committeeData = new ArrayList<String[]>();
	public void setCommitteeData() {

		committeeData.add(new String[] {"List of Camp Committee Members for " + camp.getCampName()});
		for(int i = 0; i<camp.getCampCom().size(); i++) {
			committeeData.add(new String[] {String.valueOf(i), camp.getCampCom().get(i).getName(), "points", 
					String.valueOf(camp.getCampCom().get(i).getPoints())});
			
			
			
			committeeData.add(new String[] {"","List of Suggestions Made"});
			for(int k = 0; i<camp.getCampCom().get(i).getSuggestionsMade().size(); k++) {
				committeeData.add(new String[] {"",String.valueOf(k), 
						camp.getCampCom().get(i).getSuggestionsMade().get(k).getDescription()});
				committeeData.add(new String[] {"","Change", camp.getCampCom().get(i).getSuggestionsMade().get(k).getChange()});
				committeeData.add(new String[] {"","Status", camp.getCampCom().get(i).getSuggestionsMade().get(k).getStatus().toString()});
			}
			
			
			committeeData.add(new String[] {"","List of Enquiries replied"});
			for(int k = 0; i<camp.getEnquiriesForCamp().size(); k++) {
				if(camp.getEnquiriesForCamp().get(i).getReplyAuthor() == camp.getCampCom().get(i)) {
					committeeData.add(new String[] {"",String.valueOf(k), "Enquiry by", 
							camp.getEnquiriesForCamp().get(i).getSender().getName()});
					committeeData.add(new String[] {"","Reply", camp.getEnquiriesForCamp().get(i).getReply()});
				}
			}
			

		}
	}
	public void export() {

		GenerateReport toCSV = new GenerateReport(fileName, committeeData);
		toCSV.exportCSV();
	}
}
