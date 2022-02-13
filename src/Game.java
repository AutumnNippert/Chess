import Controllers.*;
import Menu.*;
import Pieces.*;
import Utility.*;

public class Game {
    Board board;
    Controller c1; // Closest to bottom
    Controller c2; // Furthest from bottom

    public void initGame(){
        //INIT VARS
        board = new Board();
        board.initBoard();
        c1 = new Player(1);
        c2 = new Player(2);

        //GAME LOOP
        Controller currentController = c1;
        while(true) {
            Utility.ConsoleFunctions.cls();
            System.out.println(board);
            Piece selectedPiece = currentController.selectPiece(board);
            CoordinatePair selectedPosition = currentController.selectPosition(board);
            board.move(selectedPiece, selectedPosition);

            //END TURN
            //Setting the proper controller to play
            currentController = (currentController == c1) ? c2: c1;
        }
    }
}
