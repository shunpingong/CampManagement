package src.report;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

/**
 * The {@code GenerateReport} class is responsible for exporting data to a CSV file.
 * It takes a file name and a list of data as parameters, and exports the data to the specified CSV file.
 * <p>
 * The class uses the OpenCSV library to write data to the CSV file.
 * <p>
 * Implementing classes should create an instance of this class with the appropriate file name and data, 
 * then call the {@link #exportCSV()} method to export the data to the CSV file.
 *
 * @author Cai yong
 * @version 1.0
 * @since 2023-11-26
 */
public class GenerateReport {

	/**
	 * List of string arrays representing the data to be exported to the CSV file.
	 * Each string array corresponds to a row in the CSV file, and each element
	 * of the array represents a cell in that row.
	 */
	private List<String[]> data = new ArrayList<String[]>();

	/**
	 * The name of the CSV file to be generated. The actual CSV file will be created
	 * in the "reports" directory, and the ".csv" extension will be added during the
	 * export process.
	 */
	private String fileName;

    /**
     * Constructs a {@code GenerateReport} object with the specified file name and data.
     *
     * @param fileName The name of the CSV file to export the data.
     * @param data     The list of string arrays representing the data to be exported.
     */
	GenerateReport(String fileName, List<String[]> data){
		this.fileName = fileName;
		this.data = data;
	}
	
    /**
     * Exports the data to a CSV file with the specified file name.
     * The CSV file is created in the "reports" directory.
     * Uses OpenCSV to write the data to the CSV file.
     */
	public void exportCSV() {
		String location = "reports\\" + fileName + ".csv";
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