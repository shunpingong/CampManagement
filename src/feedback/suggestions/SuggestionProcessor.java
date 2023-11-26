package src.feedback.suggestions;

import src.camp_management.CampInfo;
import src.user_data.Staff;
import src.user_data.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The {@code SuggestionProcessor} class provides methods for processing and managing suggestions made by camp committee members.
 * It allows staff members to view and modify suggestions related to the camps they created, accepting or rejecting proposed changes.
 * <p>
 * This class is part of the feedback and suggestion module in the application.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
public class SuggestionProcessor {

    /**
     * Displays a menu for processing suggestions related to camps created by the active staff member.
     * The user can choose a suggestion, view the proposed change, and decide to accept, reject, or cancel the modification.
     *
     * @param campList   The list of camps available in the application.
     * @param activeUser The staff member processing the suggestions.
     */
    public static void processMenu(ArrayList<CampInfo> campList, User activeUser){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> categoryNames = new ArrayList<String>(Arrays.asList("Camp Name", "Camp Description", 
        "Camp Location", "Camp Total Slots", "Camp Committee Slots", "Faculty opened to"));
        ArrayList<CampInfo> requiredCamps = ((Staff) activeUser).getCampsCreated();
        ArrayList<Suggestion> requiredSuggestionList = new ArrayList<Suggestion>();
        for (CampInfo camp : requiredCamps) {
            for (Suggestion suggestion : camp.getSuggestionForCamp()) {
                requiredSuggestionList.add(suggestion);
            }
        }
        if (requiredSuggestionList.size() ==0){
            System.out.println("No suggestions to show.");
            int confirm = 0;
            do{
                System.out.print("Press '1' to Confirm: ");
                confirm = sc.nextInt();
            }while(confirm != 1);
            return;
        }
        int i = 0;
        System.out.print("Choose a Suggestion: \n");
        for (Suggestion suggestion : requiredSuggestionList) {
            i++;
            System.out.println(i+ ": " + suggestion.getDescription());
        }
        int choice = sc.nextInt();
        Suggestion requiredSuggestion = requiredSuggestionList.get(choice - 1);
        System.out.println("Modifying: " + categoryNames.get(requiredSuggestion.getCategory()));
        System.out.println("to: " + requiredSuggestion.getChange());
        System.out.println("Accept? 1) Yes  2) No  3) Cancel.");
        System.out.print("Enter choice: ");
        choice = sc.nextInt();
        if (choice == 1){
            System.out.println("Suggestion accepted");
            requiredSuggestion.accept();
        }
        else if(choice == 2){
            System.out.println("Suggestion rejected");
            requiredSuggestion.reject();
        }
        else{
            System.out.println("Suggestion pending.");
        }
        int confirm = 0;
        do{
            System.out.print("Press '1' to Confirm: ");
            confirm = sc.nextInt();
        }while(confirm != 1);
    }
}