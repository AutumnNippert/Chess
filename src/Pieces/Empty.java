package Pieces;

import Utility.CoordinatePair;

public class Empty extends Piece {

    /**
     * Constructor.
     *
     * @param position      Defines the position of the piece.
     * @param controllerNum Defines who controls this piece.
     */
    public Empty(CoordinatePair position, int controllerNum) {
        super(position, controllerNum);
    }
}
