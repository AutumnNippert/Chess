package Pieces;

import Utility.CoordinatePair;

import java.util.ArrayList;

/**
 * @author Chris Nippert
 * @version 0.1
 */
public class Pawn extends Piece {

    /**
     * Constructor.
     *
     * @param position      Defines the position of the piece.
     * @param controllerNum Defines who controls this piece.
     */
    public Pawn(CoordinatePair position, int controllerNum) {
        super(position, controllerNum);
    }

    @Override
    public ArrayList<CoordinatePair> getValidMoves() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return """
                 0
                ┌┴┐
                └─┘
                """;
    }
}
