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

public interface SuggestionProcessor {

    /**
     * Displays the menu for processing suggestions made for camps in charge.
     *
     * @param campList    The list of camps for which the user is in charge.
     * @param activeUser  The user processing the suggestions.
     */
    public static void processMenu(ArrayList<CampInfo> campList, User activeUser){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> fieldNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
        "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
        ArrayList<CampInfo> inchargeCamps = ((Staff) activeUser).getCampsCreated();
        ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
        for (CampInfo camp : inchargeCamps) {
            for (Suggestion suggestion : camp.getSuggestionForCamp()) {
                suggestionList.add(suggestion);
            }
        }
        if (suggestionList.size() ==0){
            System.out.println("No suggestions");
            return;
        }
        int i = 0;
        System.out.print("Choose a Suggestion: ");
        for (Suggestion suggestion : suggestionList) {
            i++;
            System.out.println(i+ ": " + suggestion.getDescription());
        }
        int choice = sc.nextInt();
        Suggestion activeSuggestion = suggestionList.get(choice - 1);
        System.out.println("Modifying: " + fieldNames.get(activeSuggestion.getCategory()));
        System.out.println("to: " + activeSuggestion.getChange());
        System.out.println("Accept? 1) Yes  2) No  3) Cancel.");
        int decision = sc.nextInt();
        if (decision == 1){
            System.out.println("Suggestion accepted");
            activeSuggestion.accept();
        }
        else if(decision == 2){
            System.out.println("Suggestion rejected");
            activeSuggestion.reject();
        }
        else{
            System.out.println("Suggestion status did not change.");
            }

    }
}