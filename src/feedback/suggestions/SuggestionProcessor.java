/**
 * The SuggestionProcessor interface provides methods for processing suggestions made by camp committee members.
 * It includes functionality for displaying a list of suggestions, selecting a suggestion for processing, and modifying
 * the status of the selected suggestion (accept, reject, or cancel).
 * <p>
 * Implementing classes should provide concrete implementations for the methods defined in this interface.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.suggestions;

import src.camp_management.CampInfo;
import src.user_data.Staff;
import src.user_data.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SuggestionProcessor {

    /**
     * Displays the menu for processing suggestions made for camps in charge.
     *
     * @param campList    The list of camps for which the user is in charge.
     * @param activeUser  The user processing the suggestions.
     */
    public static void processMenu(ArrayList<CampInfo> campList, User activeUser){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> categoryNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
        "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
        ArrayList<CampInfo> requiredCamps = ((Staff) activeUser).getCampsCreated();
        ArrayList<Suggestion> requiredSuggestionList = new ArrayList<Suggestion>();
        for (CampInfo camp : requiredCamps) {
            for (Suggestion suggestion : camp.getSuggestionForCamp()) {
                requiredSuggestionList.add(suggestion);
            }
        }
        if (requiredSuggestionList.size() ==0){
            System.out.println("No suggestions to show.");
            int confirm = 0;
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
            return;
        }
        int i = 0;
        System.out.print("Choose a Suggestion: \n");
        for (Suggestion suggestion : requiredSuggestionList) {
            i++;
            System.out.println(i+ ": " + suggestion.getDescription());
        }
        int choice = sc.nextInt();
        Suggestion requiredSuggestion = requiredSuggestionList.get(choice - 1);
        System.out.println("Modifying: " + categoryNames.get(requiredSuggestion.getCategory()));
        System.out.println("to: " + requiredSuggestion.getChange());
        System.out.println("Accept? 1) Yes  2) No  3) Cancel.");
        System.out.print("Enter choice: ");
        choice = sc.nextInt();
        if (choice == 1){
            System.out.println("Suggestion accepted");
            requiredSuggestion.accept();
        }
        else if(choice == 2){
            System.out.println("Suggestion rejected");
            requiredSuggestion.reject();
        }
        else{
            System.out.println("Suggestion pending.");
        }
        int confirm = 0;
        do{
            System.out.print("Press '1' to Confirm: ");
            confirm = sc.nextInt();
        }while(confirm != 1);
    }
}