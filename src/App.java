package src;
// Imports
import java.util.ArrayList;
import java.util.Scanner;

// Class
public class App {
    private static final int TOTAL_STUDENTS = 11;
    private static final int TOTAL_STAFF = 5;

    // Main
    public static void main(String[] args){
        // How to get data from the entity classes
        /* [ INITIALISATION ]
         * Initialisation of Data classes. Make sure you use the .init() method first, 
         * before pulling data from the Data class
         * StudentData class - Holds the entire student list
         * StaffData class - Holds the entire staff list
         */
        StudentData.init();
        StaffData.init();

        /* [ GETTING DATA ]
         * This is how you can get data from the Data classes. Simply use the static method .getStudent(i)
         * or .getStaff(i) 
         */
        StudentData.getStudent(3);  // Returns the Student object at index 3
        StaffData.getStaff(1); // Returns the Staff object at index 1



        // Example of how to print out data using the Data classes
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                    Student Users                                   |");
        System.out.println("--------------------------------------------------------------------------------------");
        for(int i=0;i<TOTAL_STUDENTS;i++){
            System.out.printf("|Name: %-15s|Email: %-20s|UserID: %-10s| Faculty: %-5s|\n", 
                                StudentData.getStudent(i).getName(), 
                                StudentData.getStudent(i).getEmail(), 
                                StudentData.getStudent(i).getID(), 
                                StudentData.getStudent(i).getFaculty());
        }

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                     Staff Users                                    |");
        System.out.println("--------------------------------------------------------------------------------------");
        for(int i=0;i<TOTAL_STAFF;i++){
            System.out.printf("|Name: %-15s|Email: %-20s|UserID: %-10s| Faculty: %-5s|\n", 
                                StaffData.getStaff(i).getName(), 
                                StaffData.getStaff(i).getEmail(), 
                                StaffData.getStaff(i).getID(), 
                                StaffData.getStaff(i).getFaculty());
        }
    }
}
