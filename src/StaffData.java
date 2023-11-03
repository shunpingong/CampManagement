package src;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class StaffData {
    public static Staff[] staff = new Staff[5];

    public static void init() {
        try{
            File file = new File("data\\staff_list.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row = sheet.getRow(1);

            int i=1;
            while(row!=null){
                // Read row from excel file
                String email = row.getCell(1).getStringCellValue();
                String userID = (String) email.subSequence(0, email.indexOf("@"));
                String name = row.getCell(0).getStringCellValue();
                String facultyValue = row.getCell(2).getStringCellValue();
                Faculty faculty = Faculty.valueOf(facultyValue);

                // Save as a Student Object
                staff[i-1] = new Staff(userID, name, faculty, email);

                // Update row iterator
                i++;
                row = sheet.getRow(i);
            }
            wb.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Staff getStaff(int ID){
        return staff[ID];
    }
}
