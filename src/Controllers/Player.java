package Controllers;

import Menu.VerticalMenu;
import Pieces.Piece;
import Utility.*;

import java.util.ArrayList;

/**
 * Controllers.Player Class
 * Deals with the Controllers.Player and its actions
 * Everything the Controllers.Player class does is interact with what the player can see (like the board)
 *
 * @author Chris Nippert
 * @version 0 (unreleased)
 */
public class Player extends Controller {

    public enum Letters{
        A, B, C, D, E, F, G, H
    }

    public Player(int controllerNumber) { super(controllerNumber); }

    @Override
    public Piece selectPiece(Board board) {
        VerticalMenu<String> selectionMenu = new VerticalMenu<String>("Select the piece you want to move (ex. A1, C3).", new ArrayList<>(0));
        selectionMenu.display();
        String input = selectionMenu.getInput(">>> ");
        int y = Letters.valueOf(String.valueOf(input.charAt(0))).ordinal();
        int x = Character.getNumericValue(input.toCharArray()[1]) - 1;
        CoordinatePair pieceSelection = new CoordinatePair(x, y);
        System.out.println(pieceSelection);
        return board.get(pieceSelection);
    }

    @Override
    public CoordinatePair selectPosition(Board board) {
        VerticalMenu<String> selectionMenu = new VerticalMenu<String>("Select where you would like to move to (ex. A1, C3).", new ArrayList<>(0));
        selectionMenu.display();
        String input = selectionMenu.getInput(">>> ");
        int y = Letters.valueOf(String.valueOf(input.charAt(0))).ordinal();
        int x = Character.getNumericValue(input.toCharArray()[1]) - 1;
        return new CoordinatePair(x, y);
    }

}