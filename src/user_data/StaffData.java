package src.user_data;

import java.util.ArrayList;


public class StaffData {
    // Instances
    private static int staffCount = 0;
    private static ArrayList<Staff> staffList = new ArrayList<>();;
    private static ExcelManager xl;

    // Methods
    public static Staff getUser(int ID){
        return staffList.get(ID);
    }

    public static int getCount(){
        return staffCount;
    }

    public static void init() {
        xl = new ExcelManager("data\\staff_list.xlsx");
        ArrayList<String> data = new ArrayList<String>();
        data = xl.readXL();
        staffCount = data.size()-1;   // -1 because the first row in the excel file is the catergories
        for(int i=0;i<staffCount;i++){
            String[] staffInfo = data.get(i+1).split(" ");
            String userID = staffInfo[1].split("@")[0];
            String name = staffInfo[0];
            Faculty faculty = Faculty.valueOf(staffInfo[2]);
            String password = staffInfo[3];
            String email = staffInfo[1];

            Staff staff = new Staff(userID, name, faculty, email);
            staff.setPWD(password);
            
            staffList.add(staff);
        }
    }

    public static void setUser(Staff user) {
        for(int i=0;i<staffList.size();i++){
            Staff currentStaff = staffList.get(i);
            if(currentStaff.getID() == user.getID()){
                staffList.remove(i);
                staffList.add(i, user);
            }
        }
    }
}
