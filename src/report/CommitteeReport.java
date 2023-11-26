package src.report;

import java.util.ArrayList;
import java.util.List;

import src.camp_management.CampInfo;

/**
 * The {@code CommitteeReport} class represents a committee report for a specific camp.
 * It extends the {@link Report} class and provides methods to set committee-related data and export the report.
 * The committee data includes information about committee members, suggestions made by committee members, and replies to enquiries.
 *
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class CommitteeReport extends Report{
	
	/**
	 * List of string arrays representing the committee-related data for generating a report.
	 * Each string array corresponds to a row in the report, and each element of the array
	 * represents a cell in that row. This data is used to populate a report on Camp Committee
	 * members, including information on points, suggestions made, and enquiries replied.
	 */
	private List<String[]> committeeData = new ArrayList<String[]>();

    /**
     * Constructs a {@code CommitteeReport} object for the specified camp with the given file name.
     *
     * @param camp     The camp for which the committee report is generated.
     * @param fileName The name of the file to export the report.
     */
	public CommitteeReport(CampInfo camp, String fileName){
		super(camp, fileName);
		setCommitteeData();
	}

    /**
     * Sets the committee-related data for the report.
     * This includes information about committee members, suggestions made by committee members, and replies to enquiries.
     */
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

    /**
     * Exports the committee report to a CSV file.
     * Calls the {@link GenerateReport#exportCSV()} method to export the committee data to the specified file.
     */
	public void export() {
		GenerateReport toCSV = new GenerateReport(fileName, committeeData);
		toCSV.exportCSV();
	}
}
