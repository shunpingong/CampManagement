package src.feedback.suggestions;

/**
 * The {@code SuggestionStatus} enum represents the possible statuses of a suggestion.
 * It includes three states: PENDING, REJECTED, and ACCEPTED.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
public enum SuggestionStatus {

    /**
     * The suggestion is pending and has not been processed.
     */
    PENDING,

    /**
     * The suggestion has been rejected.
     */
    REJECTED,

    /**
     * The suggestion has been accepted.
     */
    ACCEPTED
}
