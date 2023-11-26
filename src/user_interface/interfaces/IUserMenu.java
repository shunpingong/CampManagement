package src.user_interface.interfaces;

/**
 * The {@code IUserMenu} interface extends the {@code IMenu} interface and
 * defines additional methods for managing user-related information in the user interface.
 *
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public interface IUserMenu extends IMenu{
    /**
     * Prints the user's status in the user interface.
     */
    public void printUserStatus();
}
