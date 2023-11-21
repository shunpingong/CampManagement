package src.suggestions;

import src.CampInfo;
import src.User;
import src.Staff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public interface SuggestionProcessor {
    Scanner sc = new Scanner(System.in);
    public static void processMenu(ArrayList<CampInfo> campList, User activeUser){

        ArrayList<String> fieldNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
        "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
        ArrayList<CampInfo> inchargeCamps = ((Staff) activeUser).getCampsCreated();
        ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
        // create a list of all suggestions
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
        System.out.print("Select a Suggestion: ");
        for (Suggestion suggestion : suggestionList) {
            i++;
            System.out.println(i+ ": " + suggestion.getDescription());
        }
        int choice = sc.nextInt();
        Suggestion activeSuggestion = suggestionList.get(choice - 1);
        System.out.println("Changing: " + fieldNames.get(activeSuggestion.getCategory()));
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