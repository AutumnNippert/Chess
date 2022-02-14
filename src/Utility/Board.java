package Utility;

import Pieces.*;

import java.util.ArrayList;

/**
 * This manages everything having to do with the board.
 *
 * @author Chris Nippert
 * @version 0.1
 */
public class Board {
    private Piece[][] board;
    private final boolean isDebug = false;

    /**
     * Constructor for Board.
     * Creates an 8 by 8 board of pieces.
     */
    public Board() {
        board = new Piece[8][8];
    }

    public Piece[][] getBoard() {
        return board;
    }

    /**
     * Adds a piece to the board.
     *
     * @param p Piece
     */
    public void add(Piece p) {
        this.board[p.position.y][p.position.x] = p;
    }

    /*
     * Sets coordinate on board to piece specified.
     * Starts at 0.
     * From the top left.
     * @param cp Coordinate Pair
     * @param p Piece
    public void set(Piece p, CoordinatePair cp) {
        this.board[cp.y][cp.x] = p;
    }
     */

    /**
     * Gets the piece at a specified coordinate pair
     *
     * @param cp Coordinate pair
     * @return Piece at coordinate pair
     */
    public Piece get(CoordinatePair cp) {
        return this.board[cp.y][cp.x];
    }

    /**
     * Swaps the position of piece position and destination
     *
     * @param p    Piece
     * @param dest Destination
     */
    public void move(Piece p, CoordinatePair dest) {
        this.board[p.position.y][p.position.x] = this.get(dest);
        p.position.x = dest.x;
        p.position.y = dest.y;
        this.board[dest.y][dest.x] = p;
    }

    /**
     * Checking if the movement trying to be made is valid
     *
     * @param p    Piece
     * @param dest Destination
     * @return Boolean
     */
    public boolean isValidPieceMovement(Piece p, CoordinatePair dest) {
        ArrayList<CoordinatePair> validDests = p.getValidMoves(this);
        return validDests.contains(dest);
    }

    public boolean pieceExists(CoordinatePair position){
        return !this.get(position).equals(new Empty(position, 0));
    }

    /**
     * Initializes the board with starting game state
     */
    public void initBoard() {
        //Setting far side
        this.add(new Rook(new CoordinatePair(0, 0), 2));
        this.add(new Knight(new CoordinatePair(1, 0), 2));
        this.add(new Bishop(new CoordinatePair(2, 0), 2));
        this.add(new Queen(new CoordinatePair(3, 0), 2));
        this.add(new King(new CoordinatePair(4, 0), 2));
        this.add(new Bishop(new CoordinatePair(5, 0), 2));
        this.add(new Knight(new CoordinatePair(6, 0), 2));
        this.add(new Rook(new CoordinatePair(7, 0), 2));
        for (int i = 0; i < 8; i++) {
            this.add(new Pawn(new CoordinatePair(i, 1), 2));
        }

        //Setting Empty Spots
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                this.add(new Empty(new CoordinatePair(j, i), 0));
            }
        }

        //Setting close side
        for (int i = 0; i < 8; i++) {
            this.add(new Pawn(new CoordinatePair(i, 6), 1));
        }
        this.add(new Rook(new CoordinatePair(0, 7), 1));
        this.add(new Knight(new CoordinatePair(1, 7), 1));
        this.add(new Bishop(new CoordinatePair(2, 7), 1));
        this.add(new King(new CoordinatePair(3, 7), 1));
        this.add(new Queen(new CoordinatePair(4, 7), 1));
        this.add(new Bishop(new CoordinatePair(5, 7), 1));
        this.add(new Knight(new CoordinatePair(6, 7), 1));
        this.add(new Rook(new CoordinatePair(7, 7), 1));

    }

    /**
     * Don't worry about how this works. It does.
     *
     * @return board
     */
    @Override
    public String toString() {
        String boardString = String.format("""
                              1     2     3     4     5     6     7     8
                           ┌─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┐
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                         A │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           ├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                         B │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           ├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                         C │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           ├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                         D │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           ├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                         E │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           ├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                         F │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           ├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                         G │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           ├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                         H │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │ %-3s │
                           └─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘
                        """,
                board[0][0].toString().split("\n")[0],
                board[0][1].toString().split("\n")[0],
                board[0][2].toString().split("\n")[0],
                board[0][3].toString().split("\n")[0],
                board[0][4].toString().split("\n")[0],
                board[0][5].toString().split("\n")[0],
                board[0][6].toString().split("\n")[0],
                board[0][7].toString().split("\n")[0],
                board[0][0].toString().split("\n")[1],
                board[0][1].toString().split("\n")[1],
                board[0][2].toString().split("\n")[1],
                board[0][3].toString().split("\n")[1],
                board[0][4].toString().split("\n")[1],
                board[0][5].toString().split("\n")[1],
                board[0][6].toString().split("\n")[1],
                board[0][7].toString().split("\n")[1],
                board[0][0].toString().split("\n")[2],
                board[0][1].toString().split("\n")[2],
                board[0][2].toString().split("\n")[2],
                board[0][3].toString().split("\n")[2],
                board[0][4].toString().split("\n")[2],
                board[0][5].toString().split("\n")[2],
                board[0][6].toString().split("\n")[2],
                board[0][7].toString().split("\n")[2],
                board[1][0].toString().split("\n")[0],
                board[1][1].toString().split("\n")[0],
                board[1][2].toString().split("\n")[0],
                board[1][3].toString().split("\n")[0],
                board[1][4].toString().split("\n")[0],
                board[1][5].toString().split("\n")[0],
                board[1][6].toString().split("\n")[0],
                board[1][7].toString().split("\n")[0],
                board[1][0].toString().split("\n")[1],
                board[1][1].toString().split("\n")[1],
                board[1][2].toString().split("\n")[1],
                board[1][3].toString().split("\n")[1],
                board[1][4].toString().split("\n")[1],
                board[1][5].toString().split("\n")[1],
                board[1][6].toString().split("\n")[1],
                board[1][7].toString().split("\n")[1],
                board[1][0].toString().split("\n")[2],
                board[1][1].toString().split("\n")[2],
                board[1][2].toString().split("\n")[2],
                board[1][3].toString().split("\n")[2],
                board[1][4].toString().split("\n")[2],
                board[1][5].toString().split("\n")[2],
                board[1][6].toString().split("\n")[2],
                board[1][7].toString().split("\n")[2],
                board[2][0].toString().split("\n")[0],
                board[2][1].toString().split("\n")[0],
                board[2][2].toString().split("\n")[0],
                board[2][3].toString().split("\n")[0],
                board[2][4].toString().split("\n")[0],
                board[2][5].toString().split("\n")[0],
                board[2][6].toString().split("\n")[0],
                board[2][7].toString().split("\n")[0],
                board[2][0].toString().split("\n")[1],
                board[2][1].toString().split("\n")[1],
                board[2][2].toString().split("\n")[1],
                board[2][3].toString().split("\n")[1],
                board[2][4].toString().split("\n")[1],
                board[2][5].toString().split("\n")[1],
                board[2][6].toString().split("\n")[1],
                board[2][7].toString().split("\n")[1],
                board[2][0].toString().split("\n")[2],
                board[2][1].toString().split("\n")[2],
                board[2][2].toString().split("\n")[2],
                board[2][3].toString().split("\n")[2],
                board[2][4].toString().split("\n")[2],
                board[2][5].toString().split("\n")[2],
                board[2][6].toString().split("\n")[2],
                board[2][7].toString().split("\n")[2],
                board[3][0].toString().split("\n")[0],
                board[3][1].toString().split("\n")[0],
                board[3][2].toString().split("\n")[0],
                board[3][3].toString().split("\n")[0],
                board[3][4].toString().split("\n")[0],
                board[3][5].toString().split("\n")[0],
                board[3][6].toString().split("\n")[0],
                board[3][7].toString().split("\n")[0],
                board[3][0].toString().split("\n")[1],
                board[3][1].toString().split("\n")[1],
                board[3][2].toString().split("\n")[1],
                board[3][3].toString().split("\n")[1],
                board[3][4].toString().split("\n")[1],
                board[3][5].toString().split("\n")[1],
                board[3][6].toString().split("\n")[1],
                board[3][7].toString().split("\n")[1],
                board[3][0].toString().split("\n")[2],
                board[3][1].toString().split("\n")[2],
                board[3][2].toString().split("\n")[2],
                board[3][3].toString().split("\n")[2],
                board[3][4].toString().split("\n")[2],
                board[3][5].toString().split("\n")[2],
                board[3][6].toString().split("\n")[2],
                board[3][7].toString().split("\n")[2],
                board[4][0].toString().split("\n")[0],
                board[4][1].toString().split("\n")[0],
                board[4][2].toString().split("\n")[0],
                board[4][3].toString().split("\n")[0],
                board[4][4].toString().split("\n")[0],
                board[4][5].toString().split("\n")[0],
                board[4][6].toString().split("\n")[0],
                board[4][7].toString().split("\n")[0],
                board[4][0].toString().split("\n")[1],
                board[4][1].toString().split("\n")[1],
                board[4][2].toString().split("\n")[1],
                board[4][3].toString().split("\n")[1],
                board[4][4].toString().split("\n")[1],
                board[4][5].toString().split("\n")[1],
                board[4][6].toString().split("\n")[1],
                board[4][7].toString().split("\n")[1],
                board[4][0].toString().split("\n")[2],
                board[4][1].toString().split("\n")[2],
                board[4][2].toString().split("\n")[2],
                board[4][3].toString().split("\n")[2],
                board[4][4].toString().split("\n")[2],
                board[4][5].toString().split("\n")[2],
                board[4][6].toString().split("\n")[2],
                board[4][7].toString().split("\n")[2],
                board[5][0].toString().split("\n")[0],
                board[5][1].toString().split("\n")[0],
                board[5][2].toString().split("\n")[0],
                board[5][3].toString().split("\n")[0],
                board[5][4].toString().split("\n")[0],
                board[5][5].toString().split("\n")[0],
                board[5][6].toString().split("\n")[0],
                board[5][7].toString().split("\n")[0],
                board[5][0].toString().split("\n")[1],
                board[5][1].toString().split("\n")[1],
                board[5][2].toString().split("\n")[1],
                board[5][3].toString().split("\n")[1],
                board[5][4].toString().split("\n")[1],
                board[5][5].toString().split("\n")[1],
                board[5][6].toString().split("\n")[1],
                board[5][7].toString().split("\n")[1],
                board[5][0].toString().split("\n")[2],
                board[5][1].toString().split("\n")[2],
                board[5][2].toString().split("\n")[2],
                board[5][3].toString().split("\n")[2],
                board[5][4].toString().split("\n")[2],
                board[5][5].toString().split("\n")[2],
                board[5][6].toString().split("\n")[2],
                board[5][7].toString().split("\n")[2],
                board[6][0].toString().split("\n")[0],
                board[6][1].toString().split("\n")[0],
                board[6][2].toString().split("\n")[0],
                board[6][3].toString().split("\n")[0],
                board[6][4].toString().split("\n")[0],
                board[6][5].toString().split("\n")[0],
                board[6][6].toString().split("\n")[0],
                board[6][7].toString().split("\n")[0],
                board[6][0].toString().split("\n")[1],
                board[6][1].toString().split("\n")[1],
                board[6][2].toString().split("\n")[1],
                board[6][3].toString().split("\n")[1],
                board[6][4].toString().split("\n")[1],
                board[6][5].toString().split("\n")[1],
                board[6][6].toString().split("\n")[1],
                board[6][7].toString().split("\n")[1],
                board[6][0].toString().split("\n")[2],
                board[6][1].toString().split("\n")[2],
                board[6][2].toString().split("\n")[2],
                board[6][3].toString().split("\n")[2],
                board[6][4].toString().split("\n")[2],
                board[6][5].toString().split("\n")[2],
                board[6][6].toString().split("\n")[2],
                board[6][7].toString().split("\n")[2],
                board[7][0].toString().split("\n")[0],
                board[7][1].toString().split("\n")[0],
                board[7][2].toString().split("\n")[0],
                board[7][3].toString().split("\n")[0],
                board[7][4].toString().split("\n")[0],
                board[7][5].toString().split("\n")[0],
                board[7][6].toString().split("\n")[0],
                board[7][7].toString().split("\n")[0],
                board[7][0].toString().split("\n")[1],
                board[7][1].toString().split("\n")[1],
                board[7][2].toString().split("\n")[1],
                board[7][3].toString().split("\n")[1],
                board[7][4].toString().split("\n")[1],
                board[7][5].toString().split("\n")[1],
                board[7][6].toString().split("\n")[1],
                board[7][7].toString().split("\n")[1],
                board[7][0].toString().split("\n")[2],
                board[7][1].toString().split("\n")[2],
                board[7][2].toString().split("\n")[2],
                board[7][3].toString().split("\n")[2],
                board[7][4].toString().split("\n")[2],
                board[7][5].toString().split("\n")[2],
                board[7][6].toString().split("\n")[2],
                board[7][7].toString().split("\n")[2]);

        final int boardHeight = boardString.split("\n").length;

        //40 tall
        String[] strs = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        for (int i = 0; i < boardHeight; i++) {
            strs[i] += (boardString.split("\n")[i]);
        }

        String str = "";
        for (String s : strs) {
            str += s + "\n";
        }
        return str;
    }
}
