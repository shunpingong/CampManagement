package src;
import java.time.LocalDate;
import java.util.Scanner;

public class test {
    public static void main(String[] args){
        StudentData.init();
        StaffData.init();
        LocalDate date = LocalDate.of(2023, 10, 12); //YYYY, MM, DD
        date = LocalDate.of(2023, 12, 2);
        Scanner sc = new Scanner(System.in);

        CampList.initCamps();
        //System.out.println(Login.getCurrentUser().getID());

        //System.out.println(SelectFaculty.chooseFaculty());
        //StaffData.printstaff();
        /*
        System.out.println("Number of camps to create: ");
        int choice = sc.nextInt();
        for(int i=0; i<choice;i++){
            CreateNewCamp.create();
        }
        */
        String campName = "Orientation";
        LocalDate date2 = LocalDate.of(2023,10,10);
        Faculty userGroup = Faculty.values()[0];
        String campLoc = "here";
        String campDesc = "no";
        Staff IC = GetStaff.getStaff();
        boolean visibility = true; 

        CampInfo c1 = new CampInfo("hall", date, date, date, Faculty.values()[1], "Here", 100, 1, "hi", GetStaff.getStaff(), true);
        CampInfo campinfo = new CampInfo(campName, date2, date2, date2, userGroup, campLoc, 12, 3, campDesc, IC, visibility);
        CampList.createCamp(campinfo);
        CampList.createCamp(c1);
        //CampList.viewCamps();
        
        User user = Login.login();

        EnquiryList.initEnquiries();

        user = StudentData.getStudent(0);
        //user = StaffData.getStaff(0);

        
        int choice = 0;
        while (choice!=-1){
            choice = user.menu();
            System.out.println("Choice: " + choice);
            user.menuChoice(choice,user);
        }
        
    }
}    
