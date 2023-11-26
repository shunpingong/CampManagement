package src.user_data;

import java.util.ArrayList;

/**
 * The {@code StaffData} class provides methods to manage staff user data.
 *
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public class StaffData {

    /**
     * The count of staff members in the system.
     */
    private static int staffCount = 0;

    /**
     * The list of staff members.
     */
    private static ArrayList<Staff> staffList = new ArrayList<>();;

    /**
     * The Excel manager for reading staff data from a file.
     */
    private static ExcelManager xl;

    /**
     * Gets a staff member based on their ID.
     *
     * @param ID The ID of the staff member.
     * @return The staff member with the specified ID.
     */
    public static Staff getUser(int ID){
        return staffList.get(ID);
    }

    /**
     * Gets the count of staff members in the system.
     *
     * @return The count of staff members.
     */
    public static int getCount(){
        return staffCount;
    }

    /**
     * Initializes the staff data by reading from an Excel file.
     */
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

    /**
     * Sets the information of a staff member in the system.
     *
     * @param user The staff member with updated information.
     */
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
