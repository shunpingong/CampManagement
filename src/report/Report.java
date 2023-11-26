package src.report;
import src.camp_management.CampInfo;

import java.util.*;

/**
 * The {@code Report} class is responsible for generating and exporting camp-related reports to a CSV file.
 * It provides methods to set the report data, which includes camp details, attendees, committee members,
 * withdrawn students, enquirers, and suggestions. The generated report can be exported to a CSV file.
 * <p>
 * Subclasses can extend this class to provide additional data specific to their reports.
 *
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class Report {
	
    /**
     * The camp information for which the report is generated.
     */
	protected CampInfo camp;

    /**
     * The desired file name for the generated report.
     */
	protected String fileName;

    /**
     * The list of string arrays representing the data for the report.
     * Each string array corresponds to a row in the report, and each element
     * of the array represents a cell in that row.
     */
	private List<String[]> data = new ArrayList<String[]>();
	
    /**
     * Constructs a new Report object for the given camp and file name.
     *
     * @param camp      The camp information for which the report is generated.
     * @param fileName  The desired file name for the generated report.
     */
	public Report(CampInfo camp, String fileName){
		this.camp = camp;
		this.fileName = fileName;
		setData();
	}
	
    /**
     * Sets the data for the report. Subclasses should override this method
     * to provide camp-specific data for their reports.
     */
	public void setData() {
		data.add(new String[] {"Camp Name", camp.getCampName()});
		data.add(new String[] {"Start Date", camp.getStartDate().toString()});
		data.add(new String[] {"End Date", camp.getEndDate().toString()});
		data.add(new String[] {"Registration Deadline", camp.getRegisterDeadline().toString()});
		data.add(new String[] {"Available to: ", camp.getUserGroup().toString()});
		data.add(new String[] {"Location: ", camp.getLocation()});
		data.add(new String[] {"Total Slots", String.valueOf(camp.getTotalSlots())});
		data.add(new String[] {"Committee Slots", String.valueOf(camp.getCommitteeSlots())});
		data.add(new String[] {"Description", camp.getDescription()});
		data.add(new String[] {"Staff-in-Charge:", camp.getInCharge().getName()});
		
		data.add(new String[] {"List of Attendees"});
		for(int i = 0; i<camp.getStudentAttendees().size(); i++) {
			data.add(new String[] {String.valueOf(i), camp.getStudentAttendees().get(i).getName(), camp.getStudentAttendees().get(i).getFaculty().toString()});
		}
		
		
		data.add(new String[] {"List of Camp Committee Members"});
		for(int i = 0; i<camp.getCampCom().size(); i++) {
			data.add(new String[] {String.valueOf(i), camp.getCampCom().get(i).getName(), camp.getCampCom().get(i).getFaculty().toString()});
		}
		
		
		data.add(new String[] {"List of Withdrawn Students"});
		for(int i = 0; i<camp.getWithdrawStudents().size(); i++) {
			data.add(new String[] {String.valueOf(i), camp.getWithdrawStudents().get(i).getName(), camp.getWithdrawStudents().get(i).getFaculty().toString()});
		}
		
		
		data.add(new String[] {"List of Enquirees"});
		for(int i = 0; i<camp.getEnquiriesForCamp().size(); i++) {
			data.add(new String[] {String.valueOf(i)}); 
			data.add(new String[] {"Asked By;", camp.getEnquiriesForCamp().get(i).getSender().getName()}); 
			data.add(new String[] {"Desription: ", camp.getEnquiriesForCamp().get(i).getDescription()}); 
			if(camp.getEnquiriesForCamp().get(i).isProcessed())
			{
				data.add(new String[] {"Reply: ", camp.getEnquiriesForCamp().get(i).getReply()});
				data.add(new String[] {"Reply by: ", camp.getEnquiriesForCamp().get(i).getReplyAuthor().getName()}); 
			}
			else{
				data.add(new String[] {"Reply: ", "null"}); 
				data.add(new String[] {"Reply By: ", "null"}); 
			}
		}

		
		data.add(new String[] {"List of Suggestions"});
		for(int i = 0; i<camp.getSuggestionForCamp().size(); i++) {
			data.add(new String[] {String.valueOf(i), camp.getSuggestionForCamp().get(i).getDescription()});
			data.add(new String[] {"Student:", camp.getSuggestionForCamp().get(i).getSender().getName()});
			data.add(new String[] {"Change", camp.getSuggestionForCamp().get(i).getChange()});
			data.add(new String[] {"Status", camp.getSuggestionForCamp().get(i).getStatus().toString()});
		}
	}

    /**
     * Exports the report data to a CSV file.
     */
	public void export() {
		GenerateReport toCSV = new GenerateReport(fileName, data);
		toCSV.exportCSV();
	}
	
}
