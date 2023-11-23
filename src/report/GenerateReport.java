package src.report;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class GenerateReport {
	
	GenerateReport(String fileName, List<String[]> data){
		this.fileName = fileName;
		this.data = data;
		
	}

	private List<String[]> data = new ArrayList<String[]>();
	private String fileName;
	
	public void exportCSV() {
		String location = "E:\\CampManagement\\reports\\" + fileName + ".csv";
		File file = new File(location);
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			writer.writeAll(data);
			
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
//