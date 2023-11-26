/**
 * The {@code SuggestionOutput} class provides methods for displaying and selecting modifiable suggestions for camp committee members.
 * It includes functionalities such as viewing suggestions, getting modifiable suggestions based on status, and selecting a suggestion
 * for further actions.
 * <p>
 * This class is part of the feedback and suggestion module in the application.
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


public class SuggestionOutput{
    
    /**
     * Displays the details of a specific suggestion.
     *
     * @param suggestion The suggestion to be viewed.
     */
    public static void viewSuggestion(Suggestion suggestion) {
        suggestion.viewDetails();
    }

    /**
     * Gets a list of modifiable suggestions for a camp committee member based on the specified status.
     *
     * @param commUser The camp committee member for whom suggestions are retrieved.
     * @param status   The status of the suggestions to be retrieved.
     * @return An {@code ArrayList} of modifiable suggestions.
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
     * Displays modifiable suggestions for a camp committee member based on the specified status.
     * If no suggestions are available, prompts the user to confirm.
     *
     * @param commUser The camp committee member for whom suggestions are displayed.
     * @param status   The status of the suggestions to be displayed.
     */
    public static void viewModifiableSuggestions(CampCommittee commUser, SuggestionStatus status) {
        ArrayList<Suggestion> suggestionList = SuggestionOutput.getModifiableSuggestions(commUser,status);
        if(suggestionList.size()==0){
            Scanner sc = new Scanner(System.in);
            System.out.println("No suggestions to show");
            int confirm = 0;
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
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
     * Selects a modifiable suggestion for further actions. The user is prompted to enter the number of the
     * suggestion to view the edit menu.
     *
     * @param commUser The camp committee member making the selection.
     * @param status   The status of the suggestions from which to select.
     * @return The selected suggestion.
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
                System.out.println("Not Found. Please choose a valid suggestion.");
                int confirm = 0;
                do{
                    System.out.print("Press '1' to Confirm: ");
                    confirm = sc.nextInt();
                }while(confirm != 1);
            } else {
                return requiredSuggestions.get(selection - 1);
            }

        }
    }
}