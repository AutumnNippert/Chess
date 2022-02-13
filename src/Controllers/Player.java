package Controllers;

import Utility.*;

/**
 * Controllers.Player Class
 * Deals with the Controllers.Player and its actions
 * Everything the Controllers.Player class does is interact with what the player can see (like the board)
 *
 * @author Chris Nippert
 * @version 0 (unreleased)
 */
public class Player extends Controller {

    public Player() { super(); }

    public CoordinatePair selectPosition(Board board) {
        return new CoordinatePair(0, 0);
    }

}