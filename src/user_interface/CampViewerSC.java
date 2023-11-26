package src.user_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.camp_management.UserInput;
import src.camp_management.sorter.CampSorter;
import src.user_interface.interfaces.ICampViewer;

/**
 * The {@code CampViewerSC} class implements the {@code ICampViewer} interface
 * to display and interact with a list of camps in the user interface.
 * It provides options for sorting and viewing camp details.
 *
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public class CampViewerSC implements ICampViewer{

    /**
     * The list of camps to be displayed.
     */
    private ArrayList<CampInfo> camps;

    /**
     * The prefix indicating the type of camps being displayed.
     */
    private String prefix;

    /**
     * The user's choice.
     */
    private int choice;


    /**
     * Constructs a new {@code CampViewerSC} instance with the given list of camps
     * and a prefix for identifying the type of camps.
     * 
     * @param camps  The list of camps to be displayed.
     * @param prefix The prefix indicating the type of camps.
     */
    public CampViewerSC(ArrayList<CampInfo> camps, String prefix){
        this.camps = camps;
        this.prefix = prefix;
        this.choice = 0;
    }

    /**
     * Displays the camp list menu, allowing users to view camp details and return to the main menu.
     */
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

    /**
     * Prints the title of the camp list menu.
     */
    @Override
    public void printMenuTitle() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                    Camp List                                       |");
        System.out.println("--------------------------------------------------------------------------------------");
    }

    /**
     * Prints the available camp options in the menu.
     */
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

    /**
     * Handles user input and performs actions based on the selected options.
     */
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

    /**
     * Prints the type and count of camps.
     */
    @Override
    public void printCampType() {
        System.out.printf("%s Camps: %d\n",prefix,camps.size());
    }
    
}
