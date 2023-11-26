//i edited to add current user -yiheng
package src.login_system;

import java.util.Scanner;

import src.user_data.Staff;
import src.user_data.StaffData;
import src.user_data.Student;
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

    public static void setCurrentUser(User user){
        currentUser = user;
    }

    public static User login(){
        //log in and return Staff or Student object of the current user
        Scanner sc = new Scanner(System.in);
        User loginUser = null;
        do{
            System.out.print("Enter UserID: ");
            userID = sc.nextLine().toUpperCase();
            loginUser = passwordCheck();  
        }while(loginUser == null);
        
        return loginUser;
    }

    public static void logout(){
        currentUser = null;
    }

    private static User passwordCheck(){
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<StaffData.getCount(); i++) {
            Staff u = StaffData.getUser(i);
            if (u.getID().equals(userID)) {
                System.out.print("Enter password: ");
                password = sc.nextLine();
                while (!u.getPWD().equals(password)) {
                    System.out.print("Incorrect password. Enter password: ");
                    password = sc.nextLine();
                }
                currentUser = u;
                if (password.equals("password")) {
                    System.out.println("You need to reset your password.");
                    Password.change(currentUser);
                }
                System.out.println("Login successful.");
                return u;
            }
        }

        for (int i=0; i<StudentData.getCount(); i++) {
            Student u = StudentData.getUser(i);
            if (u.getID().equals(userID)) {
                System.out.print("Enter password: ");
                password = sc.nextLine();
                while (!u.getPWD().equals(password)) {
                    System.out.print("Incorrect password. Enter password: ");
                    password = sc.nextLine();
                }
                currentUser = u;
                if (password.equals("password")) {
                    System.out.println("You need to reset your password.");
                    Password.change(currentUser);
                }
                System.out.println("Login successful.");
                return u;
            }
        }
        return null;
    }
    
}