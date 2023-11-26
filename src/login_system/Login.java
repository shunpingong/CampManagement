package src.login_system;

import java.util.Scanner;

import src.user_data.Staff;
import src.user_data.StaffData;
import src.user_data.Student;
import src.user_data.StudentData;
import src.user_data.User;

/**
 * The {@code Login} class provides functionality for user authentication and login.
 * It includes methods for logging in, logging out, and checking user credentials.
 * <p>
 * The class stores information about the current user and their role (staff or student).
 * It also includes a method to reset the user's password if it is set to the default value.
 *
 * @author Aaron
 * @version 1.0
 * @since 2023-11-26
 */
public class Login{

    /**
     * The currently logged-in user.
     */
    private static User currentUser;

    /**
     * The role of the currently logged-in user (0 for staff, 1 for student).
     */
    private static int currentUserRole = 0;

   /**
     * The user ID entered during the login process.
     */
    private static String userID;

    /**
     * The password entered during the login process.
     */
    private static String password;

    /**
     * Retrieves the currently logged-in user.
     *
     * @return The currently logged-in user.
     */
    public static User getCurrentUser(){
        return currentUser;
    }

    /**
     * Retrieves the role of the currently logged-in user.
     *
     * @return The role of the currently logged-in user (0 for staff, 1 for student).
     */
    public static int getCurrentUserRole(){
        return currentUserRole;
    } 

    /**
     * Sets the currently logged-in user.
     *
     * @param user The user to set as the currently logged-in user.
     */
    public static void setCurrentUser(User user){
        currentUser = user;
    }

    /**
     * Authenticates and logs in a user.
     *
     * @return The logged-in user (either a Staff or Student object).
     */
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

    /**
     * Logs out the current user.
     */
    public static void logout(){
        currentUser = null;
    }

    /**
     * Checks the entered password against the stored password for the given user ID.
     * If the credentials are valid, logs in the user and returns the corresponding user object.
     *
     * @return The logged-in user or {@code null} if authentication fails.
     */
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