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

public class Password {
    
    public static void change(User user) {

        String curPassword, newPassword;
        
        System.out.print("Please enter current password: ");
        Scanner sc = new Scanner(System.in);
        curPassword = sc.nextLine();
        while (!user.getPWD().equals(curPassword)) {
            System.out.print("Incorrect password. Please enter current password again: ");
            curPassword = sc.nextLine();
        }
        System.out.print("Please enter new password: ");
        newPassword = sc.nextLine();
        while (newPassword.equals(user.getPWD()) || newPassword.equals("password")) {
            if (newPassword.equals(user.getPWD())) {
                System.out.print("You have entered the same password. Please enter new password again: ");
            }
            else if (newPassword.equals("password")) {
                System.out.print("You cannot use the default password. Please enter new password again: ");
            }
            newPassword = sc.nextLine();
        }
        user.setPWD(newPassword);
        ArrayList<String> updateData = new ArrayList<>();
        updateData.add(user.getName());
        updateData.add(user.getEmail());
        updateData.add(user.getFaculty().toString());
        updateData.add(user.getPWD());
        updateData.add(user.getRole());
        ExcelManager xl = null;
        if(user instanceof Staff){
            xl = new ExcelManager("data\\staff_list.xlsx");
            StaffData.setUser((Staff)user);
        }
        else{
            xl = new ExcelManager("data\\student_list.xlsx");
            if(user instanceof CampCommittee)
                StudentData.setUser((CampCommittee)user);
            else
                StudentData.setUser((Student)user);
        }
        xl.updateXL(updateData);
        System.out.println("Password changed successfully");
    }

}
