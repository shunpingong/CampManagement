//i edited to add current user -yiheng
package src;

public class Login{
    private static User currentUser = StudentData.getStudent(0);
    private static int currentUserRole = 1; //0 = staff, 1 = student

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