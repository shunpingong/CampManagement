package src.user_data;

import src.login_system.Login;

public class GetStaff { //gets current staff user
    public GetStaff(){};
    
    public static Staff getStaff() {
        String userID = Login.getCurrentUser().getID();
        int i;
        for (i = 0; i < StaffData.staffCount; i++) {
            if (StaffData.getStaff(i).getID().equals(userID)) {
                break;
            }
        }
        // Check if the loop terminated because of a match or not
        if (i < StaffData.staffCount) {
            return StaffData.getStaff(i);
        } else {
            // Handle the case when the staff with the specified userID is not found
            return null;
        }
    }
}
