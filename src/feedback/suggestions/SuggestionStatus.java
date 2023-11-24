/**
 * The SuggestionStatus enum represents the possible statuses of a suggestion.
 * It includes the following states: PENDING, REJECTED, and ACCEPTED.
 * <p>
 * Implementing classes can use this enum to indicate the status of a suggestion.
 *
 * @author Shun Ping
 * @version 1.0
 * @since 2023-11-24
 */
package src.feedback.suggestions;

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
