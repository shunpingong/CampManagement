package src.user_interface;

import java.util.ArrayList;
import src.camp_management.CampInfo;
import src.user_interface.interfaces.ICampViewer;

/**
 * The {@code CampViewerST} class implements the {@link ICampViewer} interface
 * and is responsible for displaying a list of camps in a user interface.
 *
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public class CampViewerST implements ICampViewer{

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
     * Constructs a new {@code CampViewerST} object with the specified list of camps and prefix.
     *
     * @param camps  The list of camps to be displayed.
     * @param prefix The prefix indicating the type of camps being displayed.
     */
    public CampViewerST(ArrayList<CampInfo> camps, String prefix){
        this.camps = camps;
        this.prefix = prefix;
        this.choice = 0;
    }

    /**
     * Prints the menu, including the title, camp type, and options.
     */
    @Override
    public void printMenu() {
        printMenuTitle();
        printCampType();
        printMenuOptions();
    }

    /**
     * Prints the title of the menu.
     */
    @Override
    public void printMenuTitle() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                    Camp List                                       |");
        System.out.println("--------------------------------------------------------------------------------------");
    }

    /**
     * Prints the options of the menu, including details about each camp.
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
    }

    /**
     * Placeholder method for selecting options (not implemented in this class).
     */
    @Override
    public void selectOptions() {
    }

    /**
     * Prints information about the type of camps being displayed.
     */
    @Override
    public void printCampType() {
        System.out.printf("%s Camps: %d\n",prefix,camps.size());
    }
    
}
