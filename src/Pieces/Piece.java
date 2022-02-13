package Pieces;
import Utility.*;

/**
 * Abstract class for all Pieces.
 * @author Chris Nippert
 * @version 0.1;
 */
public abstract class Piece {
    /**
     * Constructor.
     */
    public Piece() { }

    /**
     * Gets valid moves of a piece.
     * @return Utility.CoordinatePair[]
     */
    public abstract CoordinatePair[] getValidMoves();
}
