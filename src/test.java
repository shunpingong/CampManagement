package src;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import src.sorter.CampNameAscendingSorter;
import src.sorter.CampSorter;

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
        CampInfo c2 = new CampInfo("camp2", LocalDate.of(2023, 1, 2), LocalDate.of(2023, 2, 2), LocalDate.of(2023,1,1), Faculty.values()[1], "There", 100, 1, "hi", GetStaff.getStaff(), true);
        CampList.createCamp(c2);
        CampInfo c4 = new CampInfo("camp4", LocalDate.of(2023, 4, 4), LocalDate.of(2023, 5, 5), LocalDate.of(2023,2,2), Faculty.values()[1], "Over here", 100, 1, "hi", GetStaff.getStaff(), true);
        CampList.createCamp(c4);
        CampInfo c3 = new CampInfo("camp3", LocalDate.of(2023, 3, 3), LocalDate.of(2023, 2, 2), LocalDate.of(2023,1,10), Faculty.values()[1], "Over There", 100, 1, "hi", GetStaff.getStaff(), true);
        CampList.createCamp(c3);
        CampList.viewCamps();

        //Arrays.sort(CampList.getCampList(), CampSorter.createCampSorter(UserInput.sortCampMenu()));
        //Arrays.sort(CampList.getCampList(), new CampNameAscendingSorter());
        //CampList.viewCamps();

        /*
        User user = Login.login();


        // user = StudentData.getStudent(0);
        user = new Student("Teemo","AK47",Faculty.ALL, "test@gmail.com");

        // user = new CampCommittee(campDesc, campName, userGroup, campLoc, campDesc, 0);
        //user = StaffData.getStaff(0);

        
        int choice = 0;
        while (choice!=-1){
            choice = user.menu();
            System.out.println("Choice: " + choice);
            user.menuChoice(choice,user);
        }
         */
    }
}    
