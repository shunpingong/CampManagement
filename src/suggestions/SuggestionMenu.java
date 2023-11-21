package src.suggestions;

import java.util.ArrayList;
import java.util.Scanner;

import src.CampCommittee;
import src.User;

public interface SuggestionMenu {
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