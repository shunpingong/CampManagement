/**
 * The SuggestionMenu interface provides methods for interacting with the committee suggestions menu.
 * It includes functionality for making new suggestions for a camp and managing pending suggestions made by camp committee members.
 * <p>
 * Implementing classes should provide concrete implementations for the methods defined in this interface.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.suggestions;

import java.util.ArrayList;
import java.util.Scanner;

import src.user_data.CampCommittee;
import src.user_data.User;

public interface SuggestionMenu {

    /**
     * Displays the menu for camp committee members to interact with suggestions.
     *
     * @param commUser       The camp committee member accessing the suggestion menu.
     * @param suggestionList The list of suggestions to be managed.
     */
    public static void menuChoice(CampCommittee commUser , ArrayList<Suggestion> suggestionList) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            final String menu = "Welcome to Committee Suggestions Menu.\n" +
                    "1: Make a new suggestion for the camp: "+ commUser.getCommitteeOf().getCampName() + 
                    "\n2: View, edit or delete pending suggestion\n" +
                    "-1: Go back to main menu.\n" +
                    "Enter choice: ";

            System.out.print(menu);
            int choice = sc.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    SuggestionEditor.suggestionMaker(((CampCommittee) commUser).getCommitteeOf(), (User) commUser, suggestionList);
                    break;
                case 2:
                    SuggestionEditor.editMenu((CampCommittee) commUser, suggestionList);
                    break;
                case -1:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}