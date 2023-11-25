package src.user_data;

import java.util.ArrayList;

import src.user_data.interfaces.IUserData;

public class StaffData implements IUserData{
    // Instances
    private int staffCount;
    private ArrayList<Staff> staffList;
    private ExcelManager xl;


    // Constructor
    public StaffData() {
        xl = new ExcelManager("data\\staff_list.xlsx");
        ArrayList<String> data = new ArrayList<String>();
        data = xl.readXL();
        staffCount = data.size()-1;   // -1 because the first row in the excel file is the catergories
        staffList = new ArrayList<>();
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

    // Methods
    public User getUser(int ID){
        return staffList.get(ID);
    }

    public int getCount(){
        return this.staffCount;
    }

    public void setUser(User user){

    }
}
