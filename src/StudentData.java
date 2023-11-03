package src;

import java.util.ArrayList;

public class StudentData {
    // Instances
    public static int studentCount = 0;
    public static Student[] students;
    
    // Methods
    public static void init() {
        ArrayList<String> data = new ArrayList<String>();
        data = ExcelReader.readExcel("data\\student_list.xlsx");
        studentCount = data.size()-1;   // -1 because the first row in the excel file is the catergories
        students = new Student[studentCount];
        for(int i=0;i<studentCount;i++){
            String[] studentInfo = data.get(i+1).split(" ");
            String userID = studentInfo[1].split("@")[0];
            String name = studentInfo[0];
            Faculty faculty = Faculty.valueOf(studentInfo[2]);
            String email = studentInfo[1];
            
            students[i] = new Student(userID, name, faculty, email);
        }
    }

    public static Student getStudent(int ID){
        return students[ID];
    }
    
}
