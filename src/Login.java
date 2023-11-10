//i edited to add current user -yiheng
package src;

public class Login{
    private static User currentUser = StaffData.getStaff(0);
    private static int currentUserRole = 0; //0 = staff, 1 = student

    public static User getCurrentUser(){
        return currentUser;
    }
    public static int getCurrentUserRole(){
        return currentUserRole;
    } 
    public static void run(){
        if(currentUserRole == 1){
            CampMenu.staffMenu();
        }
        else{
            CampMenu.studentMenu();
        }
    }
}