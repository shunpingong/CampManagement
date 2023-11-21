//i edited to add current user -yiheng
package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Login{
    private static User currentUser;
    private static int currentUserRole = 0; //0 = staff, 1 = student
    private static String userID;
    private static String password;

    public static User getCurrentUser(){
        return currentUser;
    }
    public static int getCurrentUserRole(){
        return currentUserRole;
    } 

    public static User login(){
        //log in and return Staff or Student object of the current user

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter UserID: ");
        userID = sc.nextLine();
        StaffData.init();
        int totalStaff = StaffData.staffCount;
        StudentData.init();
        int totalStudents = StudentData.studentCount;

        for (int i=0; i<totalStaff; i++) {
            if (StaffData.getStaff(i).getID().equals(userID)) {
                System.out.println("Enter password: ");
                password = sc.nextLine();
                while (!StaffData.getStaff(i).getPWD().equals(password)) {
                    System.out.println("Incorrect password. Enter password: ");
                    password = sc.nextLine();
                }
                currentUser = StaffData.getStaff(i);
                return StaffData.getStaff(i);
            }
        }

        
        for (int i=0; i<totalStudents; i++) {
            if (StudentData.getStudent(i).getID().equals(userID)) {
                System.out.println("Enter password: ");
                password = sc.nextLine();
                while (!StudentData.getStudent(i).getPWD().equals(password)) {
                    System.out.println("Incorrect password. Enter password: ");
                    password = sc.nextLine();
                }
                currentUser = StudentData.getStudent(i);
                return StudentData.getStudent(i);
            }
        }

        return null;
    }
    
}