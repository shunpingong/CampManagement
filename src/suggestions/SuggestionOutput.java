package src.suggestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import src.CampCommittee;


public interface SuggestionOutput{

    public static void viewSuggestion(Suggestion suggestion) {
    ArrayList<String> fieldNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
        "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
        System.out.println("Suggestion Description: " + suggestion.getDescription());
        System.out.println("Suggestion Category: " + fieldNames.get(suggestion.getCategory()));
        System.out.println("Suggestion Changes: " + suggestion.getChange());
        System.out.println("Sender: " + suggestion.getSender().getName()); 
        System.out.println("Camp: " + suggestion.getCamp().getCampName()); 
        System.out.println("Status: " + suggestion.getStatus());
        System.out.println("---------------------------------------------");
    }

    //Get list of suggestions process/ not processed
    public static ArrayList<Suggestion> getModifiableSuggestions(CampCommittee commUser, SuggestionStatus status){
        ArrayList<Suggestion> requiredSuggestions = new ArrayList<Suggestion>();
        for (Suggestion suggestion : commUser.getSuggestionsMade()){
            if (suggestion.getStatus()== status){
                requiredSuggestions.add(suggestion);
            }
        }
        return  requiredSuggestions;
    }

    //Print out the every modifiable suggestions
    public static void viewModifiableSuggestions(CampCommittee commUser, SuggestionStatus status) {
        ArrayList<Suggestion> suggestionList = SuggestionOutput.getModifiableSuggestions(commUser,status);
        if(suggestionList.size()==0){
            System.out.println("No suggestions to show;");
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