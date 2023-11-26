package src.user_interface;

import java.util.Collections;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.report.CommitteeReport;
import src.report.Report;
import src.user_data.CampCommitteeSorter;
import src.user_data.Staff;
import src.user_data.UserSorter;
import src.user_interface.interfaces.IMenu;

public class CampManagerMenu implements IMenu{
    //Instances
    private Staff ic;
    private int choice;

    // Constructor
    public CampManagerMenu(Staff staff){
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
            System.out.println("|4. Generate Camp Report                                                             |");
            System.out.println("|5. Generate Performance Report                                                      |");
            System.out.println("|-1. Return                                                                          |");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(choice != -1 && (choice > 5 || choice < 1));
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
                        if (ic.getCampsCreated().get(choice-1).getCampName().equalsIgnoreCase(CampList.getCampList().get(k).getCampName())){
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
                    if (ic.getCampsCreated().get(delete-1).getCampName().equalsIgnoreCase(CampList.getCampList().get(k).getCampName())){
                        if(CampList.getCampList().get(k).getStudentAttendees().size() == 0 && CampList.getCampList().get(k).getCampCom().size()==0){
                            CampList.getCampList().remove(k);
                        }
                        else{
                            System.out.println("Unable To Delete, There Are Participants Signed Up");
                            int confirm = 0;
                            do{
                                System.out.print("Press '1' to Confirm: ");
                                confirm = sc.nextInt();
                            }while(confirm != 1);
                            return;
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
                    if (ic.getCampsCreated().get(vis-1).getCampName().equalsIgnoreCase(CampList.getCampList().get(k).getCampName())){
                        CampInfo camp = CampList.getCampList().get(k);
                        CampList.getCampList().get(k).setVisibility(!camp.getVisibility());
                    }
                }
                int confirm = 0;
                System.out.println("Visibility toggled.");
                do{
                    System.out.print("Press '1' to Confirm: ");
                    confirm = sc.nextInt();
                }while(confirm != 1);
                break;

            case 4: //Camp Report
                do{
                    System.out.printf("Which Camp? (Enter index, 0 to exit) ");
                    choice = sc.nextInt();
                }while(choice<0 || choice>ic.getCampsCreated().size());
                if (choice ==0) return;
                else{
                    CampInfo c = null;
                    for(int k=0;k<CampList.getCampList().size();k++){
                        if (ic.getCampsCreated().get(choice-1).getCampName().equalsIgnoreCase(CampList.getCampList().get(k).getCampName())){
                            c = CampList.getCampList().get(k);
                            break;
                        }
                    }
                    while(true) {
                    	System.out.println("How do you want to sort the Attendees & Committee?");
                        System.out.println("1. Name (Ascending)");
                        System.out.println("2. Name (Descending)");
                        System.out.println("3. Faculty (Ascending)");
                        System.out.println("4. Faculty (Descending)");
                        System.out.println("0. exit");
                        int sortChoice = sc.nextInt();
                        if ((sortChoice <= 0) || (sortChoice > 4)) {break;}
                        else {
                        	UserSorter usersort = UserSorter.createUserSorter(sortChoice);
                        	Collections.sort(c.getStudentAttendees(), usersort);
                        	Collections.sort(c.getCampCom(), usersort);
                        }
                    }
                    Report report = new Report(c, "CampReport_" + c.getCampName());
                    report.export();
                    confirm = 0;
                    System.out.println("Report Generated.");
                    do{
                        System.out.print("Press '1' to Confirm: ");
                        confirm = sc.nextInt();
                    }while(confirm != 1);
                }
                break;
            case 5: //Committee Report
                do{
                    System.out.printf("Which Camp? (Enter index, 0 to exit) ");
                    choice = sc.nextInt();
                }while(choice<0 || choice>ic.getCampsCreated().size());
                if (choice ==0) return;
                else{
                    CampInfo c = null;
                    for(int k=0;k<CampList.getCampList().size();k++){
                        if (ic.getCampsCreated().get(choice-1).getCampName().equalsIgnoreCase(CampList.getCampList().get(k).getCampName())){
                            c = CampList.getCampList().get(k);
                            break;
                        }
                    }while(true) {
                    	System.out.println("How do you want to sort the Committee?");
                        System.out.println("1. Name (Ascending)");
                        System.out.println("2. Name (Descending)");
                        System.out.println("3. Faculty (Ascending)");
                        System.out.println("4. Faculty (Descending)");
                        System.out.println("5. Points (Ascending)");
                        System.out.println("6. Points (Descending)");
                        System.out.println("0. exit");
                        int sortChoice = sc.nextInt();
                        if ((sortChoice <= 0) || (sortChoice > 6)) {break;}
                        else if(sortChoice >=1 && sortChoice < 5){
                        	UserSorter usersort = UserSorter.createUserSorter(sortChoice);
                        	Collections.sort(c.getCampCom(), usersort);
                        }
                        else {
                        	CampCommitteeSorter committeeSort = CampCommitteeSorter.createCampCommitteeSorter(sortChoice);
                        	Collections.sort(c.getCampCom(),committeeSort);
                        }
                    }
                    CommitteeReport cReport = new CommitteeReport(c, "PerformanceReport_" + c.getCampName());
                    cReport.export();
                    confirm = 0;
                    System.out.println("Report Generated.");
                    do{
                        System.out.print("Press '1' to Confirm: ");
                        confirm = sc.nextInt();
                    }while(confirm != 1);
                }
                break;
            case -1:
                break;
        }
    }    
}
