package Pieces;

import Utility.Board;
import Utility.Colors;
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
    public ArrayList<CoordinatePair> getValidMoves(Board board) {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        String s = """
        ├┴┤
        │ │
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
