package Pieces;

import Utility.Board;
import Utility.CoordinatePair;

import java.util.ArrayList;

/**
 * Abstract class for all Pieces.
 *
 * @author Chris Nippert
 * @version 0.1;
 */
public abstract class Piece {
    public CoordinatePair position;
    public final int controllerNum;

    /**
     * Constructor.
     *
     * @param position      Defines the position of the piece.
     * @param controllerNum Defines who controls this piece.
     */
    public Piece(CoordinatePair position, int controllerNum) {
        this.position = position;
        this.controllerNum = controllerNum;
    }

    /**
     * Gets valid moves of a piece.
     *
     * @return Utility.CoordinatePair[]
     */
    public ArrayList<CoordinatePair> getValidMoves(Board board) {
        return new ArrayList<CoordinatePair>();
    }

    @Override
    public String toString() {
        return """
                 \n
                 \n
                 \n
                """;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Piece p;
    }
}
