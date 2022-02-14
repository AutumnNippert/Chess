package Pieces;

import Utility.Board;
import Utility.Colors;
import Utility.CoordinatePair;

import java.util.ArrayList;

public class King extends Piece  {
    /**
     * Constructor.
     *
     * @param position      Defines the position of the piece.
     * @param controllerNum Defines who controls this piece.
     */
    public King(CoordinatePair position, int controllerNum) {
        super(position, controllerNum);
    }

    @Override
    public ArrayList<CoordinatePair> getValidMoves(Board board) {
        ArrayList<CoordinatePair> validMoves = new ArrayList<>();
        //Top right and circle around
        CoordinatePair upRight = new CoordinatePair(this.position.x + 1, this.position.y + 1);
        CoordinatePair right = new CoordinatePair(this.position.x + 1, this.position.y );
        CoordinatePair downRight = new CoordinatePair(this.position.x + 1, this.position.y - 1);
        CoordinatePair down = new CoordinatePair(this.position.x , this.position.y - 1);
        CoordinatePair downLeft = new CoordinatePair(this.position.x - 1, this.position.y - 1);
        CoordinatePair left = new CoordinatePair(this.position.x - 1, this.position.y );
        CoordinatePair upLeft = new CoordinatePair(this.position.x - 1, this.position.y + 1);
        CoordinatePair up = new CoordinatePair(this.position.x , this.position.y + 1);

        ArrayList<CoordinatePair> allMoves = new ArrayList<>();
        allMoves.add(upRight);
        allMoves.add(right);
        allMoves.add(downRight);
        allMoves.add(down);
        allMoves.add(downLeft);
        allMoves.add(left);
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
         ┼-
        ┌┴┐
        └─┘
        """;
        if (controllerNum == 1) {
            s = Utility.Colors.stringColor(s, Colors.GREEN);
        } else {
            s = Utility.Colors.stringColor(s, Colors.RED);
        }
        return s;
    }
}
