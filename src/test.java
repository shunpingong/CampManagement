package src;
import java.time.LocalDate;
import java.util.Scanner;

public class test {
    public static void main(String[] args){
        StudentData.init();
        StaffData.init();
        LocalDate date = LocalDate.of(2023, 10, 12); //YYYY, MM, DD
        date = LocalDate.of(2020, 12, 2);
        Scanner sc = new Scanner(System.in);
        /*
        System.out.println("Type: ");
        String string = sc.nextLine();
        
        System.out.println(string);
         */
        //System.out.println(Login.getCurrentUser().getID());
        //LocalDate datee = GetDate.getDate();
        //System.out.println("Date: "+ datee);

        //System.out.println(SelectFaculty.chooseFaculty());
        //StaffData.printstaff();
        
    }
}    
