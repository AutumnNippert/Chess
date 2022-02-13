package Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class VerticalMenu <T> extends Menu {

    private final String name;
    private final ArrayList<T> options;

    public VerticalMenu( String name, ArrayList<T> options ) {
        this.name = name;
        this.options = options;
    }

    /**
     * Displays the menu and all its contents.
     */
    public void display( ) {
        System.out.println( name );
        for ( int i = 1; i < this.options.size( ) + 1; i++ ) {
            System.out.println( "(" + i + ") " + this.options.get( i - 1 ) );
        }
    }

    /**
     * Gets the input of the menu.
     * @param prompt input prompt
     * @return input value
     */
    public String getInput(String prompt) {
        System.out.print( prompt );
        Scanner scn = new Scanner( System.in );
        return scn.nextLine( );
    }
}
