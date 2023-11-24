package src.login_system;

import java.util.Scanner;

import src.user_data.User;

public class Password {
    
    public static void change(User user) {

        String curPassword, newPassword;
        
        System.out.println("Please enter current password: ");
        Scanner sc = new Scanner(System.in);
        curPassword = sc.nextLine();
        while (!user.getPWD().equals(curPassword)) {
            System.out.println("Incorrect password. Please enter current password again: ");
            curPassword = sc.nextLine();
        }
        System.out.println("Please enter new password: ");
        newPassword = sc.nextLine();
        while (newPassword.equals(user.getPWD()) || newPassword.equals("password")) {
            if (newPassword.equals(user.getPWD())) {
                System.out.println("You have entered the same password. Please enter new password again: ");
            }
            else if (newPassword.equals("password")) {
                System.out.println("You cannot use the default password. Please enter new password again: ");
            }
            newPassword = sc.nextLine();
        }
        user.setPWD(newPassword);
        System.out.println("Password changed successfully");

    }

}
