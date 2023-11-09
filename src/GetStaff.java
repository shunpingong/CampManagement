package src;

public class GetStaff { //gets current staff user
    public GetStaff(){};
    
    public static Staff getStaff(){
        String userID = Login.getCurrentUser().getID();
        int i=0;
        for(i=0; i<StaffData.staffCount; i++){
            if (StaffData.getStaff(i).getID() == userID){
                break;
            }
        }
        return StaffData.getStaff(i);
    }
}
