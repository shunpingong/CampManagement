/**
 * The SuggestionEditor interface provides methods for creating, editing, and managing camp suggestions.
 * It includes functionality for creating suggestions, changing suggestion categories and values,
 * and managing the suggestions made by camp committee members.
 * <p>
 * Implementing classes should provide concrete implementations for the methods defined in this interface.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.suggestions;

import src.camp_management.CampInfo;
import src.camp_management.CampList;
import src.user_data.CampCommittee;
import src.user_data.User;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class SuggestionEditor {

    /**
     * Allows a camp committee member to create a new suggestion for the selected camp.
     *
     * @param selectedCamp   The camp for which the suggestion is made.
     * @param activeUser      The camp committee member making the suggestion.
     * @param suggestionList  The list to which the new suggestion is added.
     */
    public static void suggestionMaker(CampInfo selectedCamp, User activeUser, ArrayList<Suggestion> suggestionList) {
        Scanner sc = new Scanner (System.in);
        ArrayList<String> categoryNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
        "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
        if (activeUser instanceof CampCommittee) {
            System.out.println("Please enter a short description of the suggestion");
            String suggestionDesc = sc.nextLine();
            showSuggestionEditorMenu();
            int choice = sc.nextInt();
            String newline = sc.nextLine();
            if (choice >= 1 && choice <= 6) {
                System.out.println("Please enter the new " + categoryNames.get(choice - 1));
                String change = sc.nextLine();
                suggestionList.add((new Suggestion(suggestionDesc, (CampCommittee) activeUser, selectedCamp,
                change, choice, SuggestionStatus.PENDING)));
                System.out.println("Suggestion is uploaded!");
                int confirm = 0;
                do{
                    System.out.print("Press '1' to Confirm: ");
                    confirm = sc.nextInt();
                }while(confirm != 1);
            }

        }
    }

    /**
     * Allows a camp committee member to change the category and value of a suggestion.
     *
     * @param suggestionList The list of suggestions containing the suggestion to be modified.
     * @param suggestion      The suggestion to be modified.
     */
    public static void changeCategoryValue(ArrayList<Suggestion> suggestionList, Suggestion suggestion) {
        Scanner sc = new Scanner (System.in);
        ArrayList<String> categoryNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
        "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
        showSuggestionEditorMenu();
        int choice = sc.nextInt();
        String newline = sc.nextLine();
        if (choice >= 1 && choice <= 6) {
            System.out.println("Please enter the new " + categoryNames.get(choice - 1));
            String change = sc.nextLine();
            suggestion.setCategory(choice);
            suggestion.setChange(change);
            System.out.println("Suggestion has been modified");
            int confirm = 0;
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
        }
    }

	 public static void showSuggestionEditorMenu() {
        System.out.println("Which category would your suggestion like to be in?");
        System.out.println("[1] Camp Name");
        System.out.println("[2] Camp Description");
        System.out.println("[3] Camp Location");
        System.out.println("[4] Camp Total Slots");
        System.out.println("[5] Camp Committee Slots");
        System.out.println("[6] Faculty opened to");
        System.out.print("Enter choice: ");
}

    /**
     * Displays the edit menu for camp committee members to manage suggestions.
     *
     * @param commUser        The camp committee member accessing the edit menu.
     * @param suggestionList  The list of suggestions to be managed.
     */
    public static void editMenu(CampCommittee commUser , ArrayList<Suggestion> suggestionList ) {
        Scanner sc = new Scanner (System.in);
        while(true) {
            Suggestion selectedSuggestion = null;
            SuggestionOutput.viewModifiableSuggestions(commUser, SuggestionStatus.PENDING);
            selectedSuggestion = SuggestionOutput.selectSuggestion(commUser, SuggestionStatus.PENDING);
            if (selectedSuggestion == null) {
                return;
            }
            System.out.print("1. Edit this Suggestion\n2. Delete this Suggestion\n3. Select a new Suggestion\n4. Exit\n");
            System.out.print("Enter Choice: ");
            int selection = sc.nextInt();
            String newLine = sc.nextLine();
            switch (selection) {
                case 1:
                    SuggestionEditor.editSuggestion(selectedSuggestion, suggestionList);
                    return;
                case 2:
                    SuggestionEditor.deleteSuggestion(commUser, selectedSuggestion, suggestionList);
                    return;
                case 3:
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Exiting");
                    return;
                default:
                    break;
            }
        }
    }

    /**
     * Allows a camp committee member to edit a specific suggestion.
     *
     * @param suggestion      The suggestion to be edited.
     * @param suggestionList  The list of suggestions containing the suggestion to be edited.
     */
    public static void editSuggestion(Suggestion suggestion, ArrayList<Suggestion> SuggestionList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Edit the 1. Description or 2. Suggestion Category/Value?");
        System.out.print("Enter Choice: ");
        int selection = sc.nextInt();
        String newline = sc.nextLine();
        if(selection == 1){
            System.out.println("Enter the new description for suggestion: ");
            String newDescription = sc.nextLine() + "\n**Suggestion has been modified**";
            suggestion.setDescription(newDescription);
            System.out.println("Suggestion has been modified");
            int confirm = 0;
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
        }
        else if(selection == 2 ){
            SuggestionEditor.changeCategoryValue(SuggestionList,suggestion);
        }
        else{
            System.out.println("Wrong selection.");
            int confirm = 0;
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
        }

    }

    /**
     * Allows a camp committee member to delete a specific suggestion.
     *
     * @param commUser        The camp committee member deleting the suggestion.
     * @param suggestion      The suggestion to be deleted.
     * @param suggestionList  The list of suggestions containing the suggestion to be deleted.
     */
    public static void deleteSuggestion(CampCommittee commUser ,Suggestion suggestion, ArrayList<Suggestion> SuggestionList) {
        Scanner sc = new Scanner(System.in);
        CampList.getCampInfo(commUser.getCommitteeOf().getCampName()).getSuggestionForCamp().remove(suggestion);
        SuggestionList.remove(suggestion);
        System.out.println("Suggestion has been deleted");
        int confirm = 0;
        do{
            System.out.print("Press '1' to Confirm: ");
            confirm = sc.nextInt();
        }while(confirm != 1);
        commUser.addPoints(-1);
    }


}