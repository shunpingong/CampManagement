package src.user_data;

import java.util.ArrayList;

public class StaffData {
    // Instances
    public static int staffCount = 0;
    private static Staff[] staff;


    // Methods
    public static void init() {
        ArrayList<String> data = new ArrayList<String>();
        data = ExcelReader.readExcel("data\\staff_list.xlsx");
        staffCount = data.size()-1;   // -1 because the first row in the excel file is the catergories
        staff = new Staff[staffCount];
        for(int i=0;i<staffCount;i++){
            String[] staffInfo = data.get(i+1).split(" ");
            String userID = staffInfo[1].split("@")[0];
            String name = staffInfo[0];
            Faculty faculty = Faculty.valueOf(staffInfo[2]);
            String email = staffInfo[1];
            
            staff[i] = new Staff(userID, name, faculty, email);
        }
    }

    public static Staff getStaff(int ID){
        return staff[ID];
    }
    /*
    public static void printstaff(){
        System.out.println("1. "+ staffCount);
        System.out.println("2. "+ staff.length);
        
    } */
}
