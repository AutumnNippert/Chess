package Menu;

/**
 * Menu Class.
 * Allows for easy menu creation output and input
 * @author Chris Nippert
 * @version 1.0
 */
public abstract class Menu {

    /**
     * Displays the menu and all its contents.
     */
    abstract void display( );

    /**
     * Gets the input of the menu.
     * @param prompt input prompt
     * @return input value
     */
    abstract String getInput(String prompt);
}