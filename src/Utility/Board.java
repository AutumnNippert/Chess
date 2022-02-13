package Utility;

import Pieces.*;
import Utility.*;

/**
 * This manages everything having to do with the board
 * @author Chris Nippert
 * @version 0.1
 */
public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void set(CoordinatePair cp, Piece p) {
        this.board[cp.x][cp.y] = p;
    }
}
