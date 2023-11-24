//i edited to add current user -yiheng
package src.login_system;

import java.util.Scanner;

import src.user_data.StaffData;
import src.user_data.StudentData;
import src.user_data.User;

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

        for (int i=0; i<StaffData.staffCount; i++) {
            if (StaffData.getStaff(i).getID().equals(userID)) {
                System.out.println("Enter password: ");
                password = sc.nextLine();
                while (!StaffData.getStaff(i).getPWD().equals(password)) {
                    System.out.println("Incorrect password. Enter password: ");
                    password = sc.nextLine();
                }
                currentUser = StaffData.getStaff(i);
                sc.close();
                return StaffData.getStaff(i);
            }
        }

        
        for (int i=0; i<StudentData.studentCount; i++) {
            if (StudentData.getStudent(i).getID().equals(userID)) {
                System.out.println("Enter password: ");
                password = sc.nextLine();
                while (!StudentData.getStudent(i).getPWD().equals(password)) {
                    System.out.println("Incorrect password. Enter password: ");
                    password = sc.nextLine();
                }
                currentUser = StudentData.getStudent(i);
                sc.close();
                return StudentData.getStudent(i);
            }
        }
        sc.close();
        return null;
    }
    
}