package src.user_data;

import java.util.ArrayList;

import src.user_data.interfaces.IUserData;

public class StudentData implements IUserData{
    // Instances
    private int studentCount;
    private ArrayList<Student> students;
    private ExcelManager xl;
    
    // Constructor
    public StudentData(){
        xl = new ExcelManager("data\\student_list.xlsx");
        ArrayList<String> data = new ArrayList<String>();
        data = xl.readXL();
        studentCount = data.size()-1;   // -1 because the first row in the excel file is the catergories
        students = new ArrayList<>();
        for(int i=0;i<studentCount;i++){
            String[] studentInfo = data.get(i+1).split(" ");
            String userID = studentInfo[1].split("@")[0];
            String name = studentInfo[0];
            String password = studentInfo[3];
            String role = studentInfo[4];
            Faculty faculty = Faculty.valueOf(studentInfo[2]);
            String email = studentInfo[1];
            
            Student student = null;
            if(role.equalsIgnoreCase("Student"))
                student = new Student(userID, name, faculty, email);
            else if(role.equalsIgnoreCase("Committee"))
                student = new CampCommittee(userID, name, faculty, email, studentInfo[5]);
                
            student.setPWD(password);
            students.add(student);
        }
    }

    //Methods
    public User getUser(int ID){
        return students.get(ID);
    }

    public int getCount(){
        return studentCount;
    }
    
    public void setUser(User user){
        
    }
    
}
