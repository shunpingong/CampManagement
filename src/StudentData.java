package src;

import java.io.File;  
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class StudentData {
    public static Student[] students = new Student[11];
    
    public static void init() {
        try{
            File file = new File("data\\student_list.xlsx");
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
                students[i-1] = new Student(userID, name, faculty, email);

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

    public static Student getStudent(int ID){
        return students[ID];
    }
    
}
