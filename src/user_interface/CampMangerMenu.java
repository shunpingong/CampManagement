package src.user_interface;

import java.util.Scanner;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.user_data.Staff;
import src.user_interface.interfaces.IMenu;
import src.user_interface.interfaces.IUserMenu;

public class CampMangerMenu implements IMenu{
    //Instances
    private Staff ic;
    private int choice;

    // Constructor
    public CampMangerMenu(Staff staff){
        this.choice = 0;
        this.ic = staff;
    }

    @Override
    public void printMenu() {
        if(ic.getCampsCreated().size() == 0){
            Scanner sc = new Scanner(System.in);
            int confirm = 0;
            System.out.println("No camps created.");
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
            return;
        }
        printMenuTitle();
        printMenuOptions();
        selectOptions();
    }

    @Override
    public void printMenuTitle() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                   Created Camps                                    |");
        System.out.println("--------------------------------------------------------------------------------------");
        
    }

    @Override
    public void printMenuOptions() {
        Scanner sc = new Scanner(System.in);
        do{
            for(int j=0; j<ic.getCampsCreated().size();j++){
                System.out.printf("|%-3s|Name: %-13s|Date: %-5s to %-15s|Available Slots: %-5s  |\n", 
                                j+1,
                                ic.getCampsCreated().get(j).getCampName(), 
                                ic.getCampsCreated().get(j).getStartDate(), 
                                ic.getCampsCreated().get(j).getEndDate(), 
                                ic.getCampsCreated().get(j).getTotalSlots());
            }
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("|1. Edit Camp Detail                                                                 |");
            System.out.println("|2. Delete Camp                                                                      |");
            System.out.println("|3. Toggle Visibility Of Camp                                                        |");
            System.out.println("|-1. Return                                                                          |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(choice != -1 && (choice > 4 || choice < 1));
    }

    @Override
    public void selectOptions() {
        Scanner sc = new Scanner(System.in);
        switch(choice){
            //edit camp detail
            case 1:
                do{
                    System.out.printf("Which Camp To Edit? (Enter index, 0 to exit) ");
                    choice = sc.nextInt();
                }while(choice<0 || choice>ic.getCampsCreated().size());
                if (choice ==0) return;
                else{
                    for(int k=0;k<CampList.getCampList().size();k++){
                        if (ic.getCampsCreated().get(choice-1).getCampName().equals(CampList.getCampList().get(k).getCampName()) == true){
                            CampList.getCampList().get(k).editCampInfo();
                        }
                    }
                }
                break;

            case 2: //delete camp
                int delete = 0;
                do{
                    System.out.printf("Which Camp To Delete? (Enter index, 0 to exit) ");
                    delete = sc.nextInt();
                }while(delete<0 || delete>ic.getCampsCreated().size());
                if (delete ==0) return;
                for(int k=0;k<CampList.getCampList().size();k++){
                    if (ic.getCampsCreated().get(delete-1).getCampName().equals(CampList.getCampList().get(k).getCampName()) == true){
                        if(CampList.getCampList().get(k).getStudentAttendees().size() == 0 && CampList.getCampList().get(k).getCampCom().size()==0){
                            CampList.getCampList().remove(k);
                        }
                        else{
                            System.out.println("Unable To Delete, There Are Participants Signed Up");
                        }
                    }
                }
                break;
            case 3: //toggle visibility
                int vis = 0;
                do{
                    System.out.printf("Which Camp To Toggle Visibility? (Enter index, 0 to exit) ");
                    vis = sc.nextInt();
                }while(vis<0 || vis>ic.getCampsCreated().size());
                if (vis ==0) return;
                for(int k=0;k<CampList.getCampList().size();k++){
                    if (ic.getCampsCreated().get(vis-1).getCampName().equals(CampList.getCampList().get(k).getCampName()) == true){
                        CampInfo camp = CampList.getCampList().get(k);
                        CampList.getCampList().get(k).setVisibility(!camp.getVisibility());
                    }
                }
                break;

            case -1:
                break;
        }
    }    
}
