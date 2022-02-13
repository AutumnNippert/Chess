package Utility;

import java.util.Scanner;

public class MessagePrompts {

    public static void invalidSelection( ) {
        Scanner scn = new Scanner( System.in );
        System.out.println( "Invalid selection" );
        System.out.print( "Press 'Enter' to continue..." );
        scn.nextLine( );
    }

    public static void invalidNumber( ) {
        Scanner scn = new Scanner( System.in );
        System.out.println( "Invalid number" );
        System.out.print( "Press 'Enter' to continue..." );
        scn.nextLine( );
    }

    public static void gameOver( ) {
        System.out.println( """
                      _____                         ____                 
                     / ____|                       / __ \\                
                    | |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __ 
                    | | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__|
                    | |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |   
                     \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|   
                                                """
        );
    }
}