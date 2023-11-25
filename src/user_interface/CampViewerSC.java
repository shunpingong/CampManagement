package src.user_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.camp_management.UserInput;
import src.camp_management.sorter.CampSorter;
import src.login_system.Login;
import src.user_interface.interfaces.ICampViewer;

public class CampViewerSC implements ICampViewer{
    // Instances
    private ArrayList<CampInfo> camps;
    private String prefix;
    private int choice;

    // Constructor
    public CampViewerSC(ArrayList<CampInfo> camps, String prefix){
        this.camps = camps;
        this.prefix = prefix;
        this.choice = 0;
    }

    @Override
    public void printMenu() {
        if(camps.size() == 0){
            Scanner sc = new Scanner(System.in);
            int confirm = 0;
            System.out.println("No camps at the moment. Come back later");
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
            return;
        }
        CampSorter sorter = CampSorter.createCampSorter(UserInput.sortCampMenu());
        Collections.sort(CampList.getCampList(), sorter);
        printMenuTitle();
        printCampType();
        printMenuOptions();
        selectOptions();
    }

    @Override
    public void printMenuTitle() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                    Camp List                                       |");
        System.out.println("--------------------------------------------------------------------------------------");
    }

    @Override
    public void printMenuOptions() {
        for (int i=0;i< camps.size(); i++){
            System.out.printf("|%-3s|Name: %-13s|Date: %-5s to %-15s|Available Slots: %-5s  |\n", 
                                i+1,
                                camps.get(i).getCampName(), 
                                camps.get(i).getStartDate(), 
                                camps.get(i).getEndDate(), 
                                camps.get(i).getTotalSlots());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|1. Print Camp Details                                                               |");
        System.out.println("|-1. Return                                                                          |");
        System.out.println("--------------------------------------------------------------------------------------");
        do{
            System.out.printf("Menu Option: ");
            choice = sc.nextInt();
        }while(!(choice == 1 || choice == 2 || choice == -1));
    }

    @Override
    public void selectOptions() {
        switch(choice){
            case 1:
                CampList.printCampDetails();
                break;
            case -1:
                break;
        }
    }

    @Override
    public void printCampType() {
        System.out.printf("%s Camps: %d\n",prefix,camps.size());
    }
    
}
