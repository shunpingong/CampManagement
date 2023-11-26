package src.user_interface.interfaces;

/**
 * The {@code IMenu} interface defines the basic structure for a menu in the user interface.
 * It includes methods for printing the menu, menu title, menu options, and handling user input.
 *
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public interface IMenu {

    /**
     * Prints the entire menu.
     */
    public void printMenu();

    /**
     * Prints the title of the menu.
     */
    public void printMenuTitle();

    /**
     * Prints the available options within the menu.
     */
    public void printMenuOptions();

    /**
     * Handles the user's selection of menu options.
     */
    public void selectOptions();
}
