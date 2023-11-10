package src;


public class ViewSpecificCamp { //String campName, LocalDate startdate, LocalDate enddate, LocalDate registerDeadline, Faculty userGroup, String location, int totalSlots, int committeeSlots, String description, Staff inCharge, boolean visibility
    public ViewSpecificCamp(){};

    public static void printCamp(int i){ 
        CampInfo camp = CampList.getCampInfo(i-1);
        System.out.println("Currently Viewing: " + camp.getCampName());
        System.out.println("Description: " + camp.getDescription());
        System.out.println("Location: " + camp.getLocation());
        System.out.println("Start Date(YYYY-MM-DD): " + camp.getStartDate());
        System.out.println("End Date(YYYY-MM-DD): " + camp.getCampName());
        System.out.println("Registration Deadline(YYYY-MM-DD): " + camp.getRegisterDeadline());
        System.out.println("Faculty: " + camp.getUserGroup());
        System.out.println("Total Slots: " + camp.getTotalSlots());
        System.out.println("Committee Slots: " + camp.getCommitteeSlots());
        System.out.println("Staff In Charge: " + camp.getInCharge().getName());

    }
    
}
