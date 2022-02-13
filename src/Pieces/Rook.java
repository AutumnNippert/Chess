package Pieces;

import Utility.CoordinatePair;

import java.util.ArrayList;

public class Rook extends Piece  {

    /**
     * Constructor.
     *
     * @param position      Defines the position of the piece.
     * @param controllerNum Defines who controls this piece.
     */
    public Rook(CoordinatePair position, int controllerNum) {
        super(position, controllerNum);
    }

    @Override
    public ArrayList<CoordinatePair> getValidMoves() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return """
        ├┴┤
        │ │
        └─┘
        """;
    }
}
