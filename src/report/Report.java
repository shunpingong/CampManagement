package src.report;
import java.util.ArrayList;
import java.util.*;

import src.CampInfo;

public class Report {
	
	

	protected CampInfo camp;
	protected String fileName;
	private List<String[]> data = new ArrayList<String[]>();
	
	Report(CampInfo camp, String fileName){
		this.camp = camp;
		this.fileName = fileName;
		setData();
	}
	
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

			data.add(new String[] {String.valueOf(i), camp.getStudentAttendees().get(i).getName()});
		}
		
		data.add(new String[] {"List of Camp Committee Members"});
		for(int i = 0; i<camp.getCampCom().size(); i++) {

			data.add(new String[] {String.valueOf(i), camp.getCampCom().get(i).getName()});
		}
		
		data.add(new String[] {"List of Withdrawn Students"});
		for(int i = 0; i<camp.getWithdrawStudents().size(); i++) {

			data.add(new String[] {String.valueOf(i), camp.getWithdrawStudents().get(i).getName()});
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
			data.add(new String[] {"Student:", camp.getSuggestionForCamp().get(i).getSender().getName(), 
					"Status: ", camp.getSuggestionForCamp().get(i).getStatus().toString()});
		}
	}
	public void export() {
		GenerateReport toCSV = new GenerateReport(fileName, data);
		toCSV.exportCSV();
	}
	
}
