package src.user_data.interfaces;

import java.util.ArrayList;

/**
 * The {@code IExcelManager} interface defines methods for reading and updating data in an Excel file.
 * Implementing classes should provide concrete implementations for these methods.
 * <p>
 * The {@link #readXL()} method is responsible for reading data from an Excel file and returning it as an ArrayList.
 * The {@link #updateXL(ArrayList)} method is responsible for updating the Excel file with the provided user data.
 * <p>
 * Implementing classes may interact with specific Excel libraries or APIs to perform these operations.
 * 
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public interface IExcelManager {

    /**
     * Reads data from an Excel file and returns it as an ArrayList of strings.
     *
     * @return An ArrayList containing the data read from the Excel file.
     */
    public ArrayList<String> readXL();

    /**
     * Updates an Excel file with the provided user data.
     *
     * @param userData The data to be written to the Excel file.
     */
    public void updateXL(ArrayList<String> userData);
}
