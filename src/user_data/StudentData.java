package src.user_data;

import java.util.ArrayList;

import src.camp_management.CampList;


public class StudentData {
    // Instances
    private static int studentCount = 0;
    private static ArrayList<Student> students = new ArrayList<>();
    private static ExcelManager xl;

    //Methods
    public static Student getUser(int ID){
        return students.get(ID);
    }

    public static int getCount(){
        return studentCount;
    }

    public static void init() {
        xl = new ExcelManager("data\\student_list.xlsx");
        ArrayList<String> data = new ArrayList<String>();
        data = xl.readXL();
        studentCount = data.size()-1;   // -1 because the first row in the excel file is the catergories
        
        for(int i=0;i<studentCount;i++){
            String[] studentInfo = data.get(i+1).split(" ");
            String userID = studentInfo[1].split("@")[0];
            String name = studentInfo[0];
            String password = studentInfo[3];
            Faculty faculty = Faculty.valueOf(studentInfo[2]);
            String email = studentInfo[1];
            Student student = null;
            student = new Student(userID, name, faculty, email);
            student.setPWD(password);
            students.add(student);
        }
    }

    public static void setUser(Student user) {
        for(int i=0;i<students.size();i++){
            Student currentStaff = students.get(i);
            if(currentStaff.getID() == user.getID()){
                students.remove(i);
                students.add(i, user);
            }
        }
    }    
}
