package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.login_system.Login;
import src.user_data.CampCommittee;
import src.user_data.Faculty;
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

public class test {
    public static void main(String[] args){
        // Init
        CampList.initCamps();
        loadUsers();
        loadCamps();
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
            else if(loginUser instanceof CampCommittee)
                menu = new CommitteeMenu((CampCommittee) loginUser);
            else if(loginUser instanceof Student)
                menu = new StudentMenu((Student) loginUser);
            else
                menu = new LoginMenu();
            return menu;
    }

    private static void loadCamps(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Staff ic = StaffData.getUser(4);
        
        CampInfo c = (new CampInfo("UOC", LocalDate.parse("27/11/2023", formatter), LocalDate.parse("29/11/2023", formatter), LocalDate.now(), Faculty.ALL, "NS", 10, 5, "Test", ic, true));
        CampInfo c1 = (new CampInfo("Hall", LocalDate.parse("07/12/2023", formatter), LocalDate.parse("09/12/2023", formatter), LocalDate.now(), Faculty.ALL, "Binjai", 5, 2, "Test 2", ic, true));
        CampInfo c2 = (new CampInfo("Freshmen", LocalDate.parse("30/11/2023", formatter), LocalDate.parse("03/12/2023", formatter), LocalDate.now(), Faculty.ALL, "NS", 3, 3, "Test 3", ic, true));
        CampInfo c3 = (new CampInfo("SCSE", LocalDate.parse("27/11/2024", formatter), LocalDate.parse("29/11/2024", formatter), LocalDate.now(), Faculty.SCSE, "NS", 20, 10, "Test 4", ic, true));
        CampInfo c4 = (new CampInfo("NBS", LocalDate.parse("01/01/2024", formatter), LocalDate.parse("02/01/2024", formatter), LocalDate.now(), Faculty.NBS, "SS", 15, 5, "Test 5", ic, true)); 
        CampList.getCampList().add(c);
        CampList.getCampList().add(c1);
        CampList.getCampList().add(c2);
        CampList.getCampList().add(c3);
        CampList.getCampList().add(c4);
        ic.AddCampsOwned(c);
        ic.AddCampsOwned(c1);
        ic.AddCampsOwned(c2);
        ic.AddCampsOwned(c3);
        ic.AddCampsOwned(c4);
        StaffData.setUser(ic);
    }

    private static void loadUsers(){
        StaffData.init();
        StudentData.init();
    }
}
