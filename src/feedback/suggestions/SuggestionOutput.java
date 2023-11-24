/**
 * The SuggestionOutput interface provides methods for viewing and selecting modifiable suggestions
 * made by camp committee members. It includes functionality for displaying suggestions, obtaining a list
 * of modifiable suggestions based on their status, and selecting a specific suggestion for further action.
 * <p>
 * Implementing classes should provide concrete implementations for the methods defined in this interface.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.suggestions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import src.user_data.CampCommittee;


public interface SuggestionOutput{
    
    /**
     * Displays the details of a specific suggestion.
     *
     * @param suggestion The suggestion to be viewed.
     */
    public static void viewSuggestion(Suggestion suggestion) {
        suggestion.viewDetails();
    }

    /**
     * Retrieves a list of modifiable suggestions based on their status.
     *
     * @param commUser The camp committee member for whom suggestions are retrieved.
     * @param status   The status of the suggestions to be retrieved.
     * @return An ArrayList of modifiable suggestions.
     */
    public static ArrayList<Suggestion> getModifiableSuggestions(CampCommittee commUser, SuggestionStatus status){
        ArrayList<Suggestion> requiredSuggestions = new ArrayList<Suggestion>();
        for (Suggestion suggestion : commUser.getSuggestionsMade()){
            if (suggestion.getStatus()== status){
                requiredSuggestions.add(suggestion);
            }
        }
        return  requiredSuggestions;
    }

    /**
     * Displays all modifiable suggestions made by a camp committee member.
     *
     * @param commUser The camp committee member for whom suggestions are displayed.
     * @param status   The status of the suggestions to be displayed.
     */
    public static void viewModifiableSuggestions(CampCommittee commUser, SuggestionStatus status) {
        ArrayList<Suggestion> suggestionList = SuggestionOutput.getModifiableSuggestions(commUser,status);
        if(suggestionList.size()==0){
            System.out.println("No suggestions to show.\n");
            return;
        }
        else{
            Comparator<Suggestion> suggestionComparator = Comparator.comparing(suggestion -> suggestion.getCamp().getCampName());
            suggestionList.sort(suggestionComparator);
            int i = 0;
            for (Suggestion suggestion : suggestionList){
                i++;
                System.out.printf("Suggestion " + i + "\n");
                SuggestionOutput.viewSuggestion(suggestion);
            }
        }
    }

    /**
     * Allows the camp committee member to select a modifiable suggestion for further action.
     *
     * @param commUser The camp committee member making the selection.
     * @param status   The status of the suggestions to be considered for selection.
     * @return The selected suggestion or null if no suggestion is selected.
     */
    public static Suggestion selectSuggestion(CampCommittee commUser, SuggestionStatus status) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Suggestion> requiredSuggestions = SuggestionOutput.getModifiableSuggestions(commUser, status);
        if (requiredSuggestions.size() == 0) {
            return null;
        }

        System.out.println("Enter the number of the suggestion to view the edit menu: ");
        while (true) {
            int selection = sc.nextInt();
            if (selection < 1 || selection > requiredSuggestions.size()) {
                System.out.println("Suggestion not found. Please select again.");
            } else {
                return requiredSuggestions.get(selection - 1);
            }

        }
    }
}