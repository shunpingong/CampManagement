package src.user_data;

import java.util.ArrayList;

/**
 * The {@code StudentData} class manages student data, including a count of students,
 * a list of student instances, and methods for accessing and initializing student data.
 * It uses an {@link ExcelManager} to read data from an Excel file and populate student information.
 * 
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public class StudentData {

    /**
     * The count of students in the system.
     */
    private static int studentCount = 0;

    /**
     * The list of student instances.
     */
    private static ArrayList<Student> students = new ArrayList<>();

    /**
     * The ExcelManager instance for handling Excel file operations.
     */
    private static ExcelManager xl;

    /**
     * Retrieves a student by their ID.
     *
     * @param ID The ID of the student to retrieve.
     * @return The student with the specified ID.
     */
    public static Student getUser(int ID){
        return students.get(ID);
    }

    /**
     * Retrieves the count of students in the system.
     *
     * @return The count of students.
     */
    public static int getCount(){
        return studentCount;
    }

    /**
     * Initializes the StudentData class by reading data from an Excel file and populating student information.
     * The first row in the Excel file is considered as categories and is not counted in the student count.
     */
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

    /**
     * Sets the information for a specific student in the system.
     *
     * @param user The updated student information.
     */
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
