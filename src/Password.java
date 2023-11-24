package src;

import java.util.Scanner;

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
        while (user.getPWD().equals(newPassword)) {
            System.out.println("You have entered the same password. Please enter new password again: ");
            newPassword = sc.nextLine();
        }

        user.setPWD(newPassword);
        System.out.println("Password changed successfully");

    }

}
