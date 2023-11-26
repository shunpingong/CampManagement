package src.user_interface.interfaces;

/**
 * The {@code ICampViewer} interface extends the {@code IMenu} interface and
 * provides a method for printing information about the type of camp in the user interface.
 *
 * @author Kenneth
 * @version 1.0
 * @since 2023-11-26
 */
public interface ICampViewer extends IMenu{

    /**
     * Prints information about the type of camp in the user interface.
     */
    public void printCampType();
}
