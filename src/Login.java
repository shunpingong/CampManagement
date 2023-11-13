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

    public static User login(){
        //log in and return Staff or Student object of the current user
        return StaffData.getStaff(0);
    }
    
}