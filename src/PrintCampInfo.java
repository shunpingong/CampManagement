package src;

public class PrintCampInfo {
    public PrintCampInfo(){};

    public static void printAll(){
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                     Camp List                                      |");
        System.out.println("--------------------------------------------------------------------------------------");
        for(int i=0;i<CampList.getSize();i++){
            CampInfo camp = CampList.getCampInfo(i);
            System.out.printf("|%-3s|Name: %-13s|Date: %-5s to %-15s|Available Slots: %-5s|\n", 
                                i+1,
                                camp.getCampName(), 
                                camp.getStartDate(), 
                                camp.getEndDate(), 
                                camp.getTotalSlots());
        }
    
    }
}

