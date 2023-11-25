//i edited to add current user -yiheng
package src.login_system;

import java.util.ArrayList;
import java.util.Scanner;

import src.user_data.CampCommittee;
import src.user_data.ExcelManager;
import src.user_data.Staff;
import src.user_data.StaffData;
import src.user_data.Student;
import src.user_data.StudentData;
import src.user_data.User;
import src.user_data.interfaces.IUserData;

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
            loginUser = passwordCheck(new StaffData(), sc);  
            if(loginUser != null)
                return loginUser;
            loginUser = passwordCheck(new StudentData(), sc);
        }while(loginUser == null);
        
        return loginUser;
    }

    public static void logout(){
        currentUser = null;
    }

    private static User passwordCheck(IUserData userData, Scanner sc){
        for (int i=0; i<userData.getCount(); i++) {
            User u = userData.getUser(i);
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
                if(u instanceof Staff)
                    return (Staff) u;
                else if(u instanceof Student)
                    return (Student) u;
                else if(u instanceof CampCommittee)
                    return (CampCommittee) u;
                else
                    return u;
            }
        }
        return null;
    }
    
}