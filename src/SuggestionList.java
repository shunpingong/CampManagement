package src;

import java.util.ArrayList;

public class SuggestionList {
    private static ArrayList<Suggestion> suggestions = new ArrayList<>();

    public SuggestionList() {
    }

    public static void initSuggestions() {
        suggestions = new ArrayList<>();
    }

    public static void addSuggestion(Suggestion suggestion) {
        suggestions.add(suggestion);
        System.out.println("Suggestion for camp " + suggestion.getCamp() + " submitted.");
    }

    // Delete suggestion
    public static void deleteSuggestion(String campName, User currentUser) {
        for (Suggestion suggestion : suggestions) {
            if (!suggestion.isProcessed() && suggestion.getSender().equals(currentUser) && suggestion.getCamp().equals(campName)) {
                suggestions.remove(suggestion);
                System.out.println("Suggestion Deleted");
                return;  // Assuming there is at most one matching suggestion
            }
        }
        System.out.println("Suggestion not found or already processed.");
    }

    public static Suggestion getSuggestion(int index) {
        return suggestions.get(index - 1);
    }

    // Display suggestions by the currentUser
    public static void displaySuggestionsForCamp(String campName, User currentUser) {
        System.out.println("Suggestions for Camp: " + campName);

        int count = 1;  // Initialize a counter variable

        for (Suggestion suggestion : suggestions) {
            if (suggestion.getCamp().equals(campName) && suggestion.getSender().equals(currentUser)) {
                System.out.println("Suggestion " + count + ":");
                suggestion.viewDetails();
                count++;  // Increment the counter after printing a suggestion
            }
        }

        // Check if no suggestions were displayed
        if (count == 1) {
            System.out.println("None");
        }
    }

    // To check whether camp has suggestions or not
    public static ArrayList<Suggestion> getSuggestionsForCamp(String campName, User currentUser) {
        ArrayList<Suggestion> campSuggestions = new ArrayList<>();

        for (Suggestion suggestion : suggestions) {
            if (suggestion.getCamp().equals(campName) && suggestion.getSender().equals(currentUser)) {
                campSuggestions.add(suggestion);
            }
        }

        return campSuggestions;
    }

    // You can implement additional methods for managing and retrieving suggestions as needed.
}
