package src.user_data;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import src.user_data.interfaces.IExcelManager;

/**
 *  The {@code ExcelManager} class provides methods to read data from and update an Excel file.
 * Implementing the {@link IExcelManager} interface, this class defines two key operations:
 * reading data from an Excel file using {@link #readXL()} and updating the Excel file
 * with provided user data using {@link #updateXL(ArrayList)}.
 * 
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public class ExcelManager implements IExcelManager{

    /**
     * The directory or path to the Excel file.
     */
    private String dir;

    /**
     * Constructs an {@code ExcelManager} instance with the specified Excel file path.
     *
     * @param dir The path to the Excel file.
     */
    public ExcelManager(String dir){
        this.dir = dir;
    }

    /**
     * Reads the content from the Excel file and returns it as a list of strings.
     *
     * @return An ArrayList<String> containing the content read from the Excel file.
     */
    public ArrayList<String> readXL(){
        ArrayList<String> content = new ArrayList<String>();
        try{
            File file = new File(dir);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row = null;
            XSSFCell col = null;
            int i=0;
            row = sheet.getRow(i);
            while(row!=null){
                // Read row from excel file
                int j = 0;
                col = row.getCell(j);
                String rowValue = "";
                
                // Read cell for the current row
                while(col!=null){
                    // If cell content is null
                    if(col.getStringCellValue() == "")
                        break;

                    // Combine all column content into a single row
                    rowValue += col.getStringCellValue().trim();
                    rowValue += " ";

                    // Update column iterator
                    j++;
                    col = row.getCell(j);
                }
                if(rowValue == "")
                    break;
                content.add(rowValue);

                // Update row iterator
                i++;
                row = sheet.getRow(i);
            }
            wb.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return content;
    }

    /**
     * Updates the Excel file with the provided user data.
     *
     * @param userData An ArrayList<String> containing user data to be updated in the Excel file.
     */
    public void updateXL(ArrayList<String> userData){
        try{
            File file = new File(dir);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row = null;
            XSSFCell col = null;
            int i=0;
            row = sheet.getRow(i);
            while(row!=null){
                // Find user
                col = row.getCell(1);

                if(!userData.get(1).equalsIgnoreCase(col.getStringCellValue().trim()) && col.getStringCellValue() != ""){
                    i++;
                    row = sheet.getRow(i);
                    continue;
                }
                
                // Update user data
                for(int j = 0;j<userData.size();j++){
                    col = row.getCell(j);
                    col.setCellValue(userData.get(j));
                }
                break;
            }
            fis.close();
            FileOutputStream fos = new FileOutputStream(file);
            wb.write(fos);
            wb.close();
            fos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
