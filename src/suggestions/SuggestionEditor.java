package src.suggestions;

import src.CampCommittee;
import src.CampInfo;
import src.User;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public interface SuggestionEditor {
    Scanner sc = new Scanner (System.in);
    static void suggestionMaker(CampInfo selectedCamp, User activeUser, ArrayList<Suggestion> suggestionList) {

        ArrayList<String> fieldNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
        "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
        if (activeUser instanceof CampCommittee) {
            System.out.println("Please enter a short description of your suggestion");
            String suggestionDesc = sc.nextLine();
            System.out.println("Which category would your suggestion like to be in?");
            System.out.println("[1] Camp Name");
            System.out.println("[2] Camp Description");
            System.out.println("[3] Camp Location");
            System.out.println("[4] Camp Total Slots");
            System.out.println("[5] Camp Committee Slots");
            System.out.println("[6] Faculty opened to");
            int choice = sc.nextInt();
            String newline = sc.nextLine();
            if (choice >= 1 && choice <= 6) {
                System.out.println("Please enter the new " + fieldNames.get(choice - 1));
                String change = sc.nextLine();
                System.out.println("Your suggestion has been posted!");
                suggestionList.add((new Suggestion(suggestionDesc, (CampCommittee) activeUser, selectedCamp,
                change, choice, SuggestionStatus.PENDING)));
            }

        }
    }

    static void changeCategoryValue(ArrayList<Suggestion> suggestiost, Suggestion suggestion) {
        ArrayList<String> fieldNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
        "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
            System.out.println("Which category would your suggestion like to be in?");
            System.out.println("[1] Camp Name");
            System.out.println("[2] Camp Description");
            System.out.println("[3] Camp Location");
            System.out.println("[4] Camp Total Slots");
            System.out.println("[5] Camp Committee Slots");
            System.out.println("[6] Faculty opened to");
        int choice = sc.nextInt();
        if (choice >= 1 && choice <= 6) {
            System.out.println("Please enter the new " + fieldNames.get(choice - 1));
            String change = sc.nextLine();
            System.out.println("Your suggestion has been edited!");
            suggestion.setCategory(choice);
            suggestion.setChange(change);
        }
    }

    public static void editMenu(CampCommittee commUser , ArrayList<Suggestion> suggestionList ) {
        while(true) {
            Suggestion selectedSuggestion = null;
            SuggestionOutput.viewModifiableSuggestions(commUser, SuggestionStatus.PENDING);
            selectedSuggestion = SuggestionOutput.selectSuggestion(commUser, SuggestionStatus.PENDING);
            if (selectedSuggestion == null) {
                return;
            }
            System.out.println("1. Edit this Suggestion, 2. Delete this Suggestion, 3. Select a new Suggestion or 4. Exit");
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
                    break;
                case 4:
                    System.out.println("Exiting");
                    return;
                default:
                    break;
            }
        }
    }

    public static void editSuggestion(Suggestion suggestion, ArrayList<Suggestion> SuggestionList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to edit the 1. Description or 2. Suggestion Category/Value?");
        int selection = sc.nextInt();
        if(selection == 1){
            System.out.println("Enter new description for your suggestion: ");
            String newDescription = sc.nextLine() + "\n**This suggestion has been edited**";
            suggestion.setDescription(newDescription);
            System.out.println("Your suggestion has been edited.\n");

        }
        else if(selection == 2 ){
            SuggestionEditor.changeCategoryValue(SuggestionList,suggestion);
        }
        else{
            System.out.println("Unrecognised response, aborting...");
        }

    }

    public static void deleteSuggestion(CampCommittee commUser ,Suggestion suggestion, ArrayList<Suggestion> SuggestionList) {
        commUser.getCommitteeOf().getSuggestionForCamp().remove(suggestion);
        SuggestionList.remove(suggestion);
        System.out.println("Your Suggestion has been deleted");
        commUser.addPoints(-1);
    }


}