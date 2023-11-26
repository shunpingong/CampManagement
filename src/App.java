package src;

import src.camp_management.CampList;
import src.login_system.Login;
import src.user_data.CampCommittee;
import src.user_data.Staff;
import src.user_data.StaffData;
import src.user_data.Student;
import src.user_data.StudentData;
import src.user_data.User;
import src.user_interface.CommitteeMenu;
import src.user_interface.LoginMenu;
import src.user_interface.StaffMenu;
import src.user_interface.StudentMenu;
import src.user_interface.interfaces.IMenu;


/**
 * The {@code App} class represents the main application for the CAMs.
 * It initializes necessary components, loads user data, and manages user interactions through menus.
 * The main method continuously prompts users with appropriate menus based on their roles.
 *
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public class App {
    
    /**
     * The main method serves as the entry point for the CAMs.
     * It initializes necessary components, loads user data, and continuously prompts users
     * with appropriate menus based on their roles.
     *
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args){
        // Init
        CampList.initCamps();
        loadUsers();
        IMenu menu = null;
        while(true){
            // Set the menu
            menu = chooseUserMenu();
                
            // User Menu
            menu.printMenu();           
        }
    }

  /**
     * Chooses the appropriate menu based on the currently logged-in user's role.
     * It checks the role of the user and returns an instance of the corresponding menu.
     *
     * @return An instance of the {@link IMenu} interface representing the user's menu.
     */
    private static IMenu chooseUserMenu(){
        // Deciding which menu
            User loginUser = Login.getCurrentUser();
            IMenu menu = null;
            if(loginUser instanceof Staff)
                menu = new StaffMenu((Staff) loginUser);
            else if(loginUser instanceof CampCommittee)
                menu = new CommitteeMenu((CampCommittee) loginUser);
            else if(loginUser instanceof Student)
                menu = new StudentMenu((Student) loginUser);

            else
                menu = new LoginMenu();
            return menu;
    }

    /**
     * Loads initial user data, including staff and student information, into the system.
     * It initializes the staff and student data sets for use within the application.
     */
    private static void loadUsers(){
        StaffData.init();
        StudentData.init();
    }
}
