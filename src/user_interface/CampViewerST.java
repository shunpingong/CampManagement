package src.user_interface;

import java.util.ArrayList;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.user_interface.interfaces.ICampViewer;

public class CampViewerST implements ICampViewer{
    // Instances
    private ArrayList<CampInfo> camps;
    private String prefix;
    private int choice;

    // Constructor
    public CampViewerST(ArrayList<CampInfo> camps, String prefix){
        this.camps = camps;
        this.prefix = prefix;
        this.choice = 0;
    }

    @Override
    public void printMenu() {
        printMenuTitle();
        printCampType();
        printMenuOptions();
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
    }

    @Override
    public void selectOptions() {
    }

    @Override
    public void printCampType() {
        System.out.printf("%s Camps: %d\n",prefix,camps.size());
    }
    
}
