package Pieces;

import Utility.Board;
import Utility.Colors;
import Utility.CoordinatePair;
import jdk.jshell.execution.Util;

import java.util.ArrayList;

/**
 * @author Chris Nippert
 * @version 0.1
 */
public class Pawn extends Piece {

    // This will have to be set somewhere! Just don't know where.
    // This will be used for rook, king, and pawn because special moves like Castling, and pawns get to move 2 forward on their first move.
    public boolean hasMoved;

    /**
     * Constructor.
     *
     * @param position      Defines the position of the piece.
     * @param controllerNum Defines who controls this piece.
     */
    public Pawn(CoordinatePair position, int controllerNum) {
        super(position, controllerNum);
        hasMoved = false;
    }

    @Override
    public ArrayList<CoordinatePair> getValidMoves(Board board) {
        ArrayList<CoordinatePair> validMoves = new ArrayList<>();
        //Top right and circle around
        CoordinatePair upRight = new CoordinatePair(this.position.x + 1, this.position.y + 1);
        CoordinatePair upLeft = new CoordinatePair(this.position.x - 1, this.position.y + 1);
        CoordinatePair up = new CoordinatePair(this.position.x , this.position.y + 1);

        ArrayList<CoordinatePair> allMoves = new ArrayList<>();
        allMoves.add(upRight);
        allMoves.add(upLeft);
        allMoves.add(up);

        for (CoordinatePair move : allMoves ) {
            //if theres a piece that isn't yours
            if (board.pieceExists(move) && board.get(move).controllerNum != this.controllerNum) {
                //add the move to validMoves
                validMoves.add(move);
            }
        }
        return validMoves;
    }

    @Override
    public String toString() {
        String s = """
                 0-
                ┌┴┐
                └─┘
                """ ;
        if (controllerNum == 1) {
            s = Utility.Colors.stringColor(s, Colors.GREEN);
        } else {
            s = Utility.Colors.stringColor(s, Colors.RED);
        }
        return s;
    }
}
