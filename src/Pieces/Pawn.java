package Pieces;

import Utility.CoordinatePair;

/**
 * @author Chris Nippert
 * @version 0.1
 */
public class Pawn extends Piece {
    Pawn() {
        super();
    }

    @Override
    public CoordinatePair[] getValidMoves() {
        return new CoordinatePair[0];
    }
}
