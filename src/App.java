package src;


import java.util.Scanner;

import src.camp_management.CampList;
import src.login_system.Login;
import src.user_data.CampCommittee;
import src.user_data.Staff;
import src.user_data.Student;
import src.user_data.User;
import src.user_interface.CommitteeMenu;
import src.user_interface.LoginMenu;
import src.user_interface.StaffMenu;
import src.user_interface.StudentMenu;
import src.user_interface.interfaces.IMenu;

// Class
public class App {
    
    // Main
    public static void main(String[] args){
        // Init
        CampList.initCamps();
        IMenu menu = null;
        while(true){
            // Set the menu
            menu = chooseUserMenu();
                
            // User Menu
            menu.printMenu();           
        }
    }

    private static IMenu chooseUserMenu(){
        // Deciding which menu
            User loginUser = Login.getCurrentUser();
            IMenu menu = null;
            if(loginUser instanceof Staff)
                menu = new StaffMenu((Staff) loginUser);
            else if(loginUser instanceof Student)
                menu = new StudentMenu((Student) loginUser);
            else if(loginUser instanceof CampCommittee)
                menu = new CommitteeMenu((CampCommittee) loginUser);
            else
                menu = new LoginMenu();
            return menu;
    }
}
