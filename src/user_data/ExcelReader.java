package src.user_data;

import java.io.File;  
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class ExcelReader {
    // Methods
    public static ArrayList<String> readExcel(String dir){
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
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return content;
    }
}
