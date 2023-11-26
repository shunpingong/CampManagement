/**
 * The {@code SuggestionMenu} class provides a menu for camp committee members to interact with suggestions.
 * It allows committee members to create new suggestions for their assigned camp, as well as view, edit, or delete
 * pending suggestions.
 * <p>
 * This class is part of the feedback and suggestion module in the application.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.suggestions;

import java.util.ArrayList;
import java.util.Scanner;

import src.camp_management.CampList;
import src.user_data.CampCommittee;
import src.user_data.User;

public class SuggestionMenu {

     /**
     * Displays a menu for camp committee members to make new suggestions for their assigned camp, view, edit, or delete
     * pending suggestions, or return to the main menu.
     *
     * @param commUser       The camp committee member interacting with the menu.
     * @param suggestionList The list of suggestions to be managed.
     */
    public static void menuChoice(CampCommittee commUser , ArrayList<Suggestion> suggestionList) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nCommittee Suggestions Menu.\n" +
                    "1: Make a new suggestion for the camp: "+ commUser.getCommitteeOf().getCampName() + 
                    "\n2: View, edit or delete pending suggestion\n" +
                    "-1: Go back to main menu.\n" +
                    "Enter choice: ");
            int choice = sc.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    SuggestionEditor.suggestionMaker(CampList.getCampInfo(((CampCommittee) commUser).getCommitteeOf().getCampName()), (User) commUser, suggestionList);
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