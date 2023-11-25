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


public class ExcelManager implements IExcelManager{
    //Instances
    private String dir;

    // Constructor
    public ExcelManager(String dir){
        this.dir = dir;
    }

    // Methods
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
