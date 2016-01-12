/*====================================
  class Connect4 - implements the Connect4 game

  implements Game interface
  uses Board as data type
  ====================================*/

public class Connect4 implements Game {
    private static final String PIECE_1 = "X";
    private static final String PIECE_2 = "U";

    private Board _board;

    private boolean gameOver;

    public Connect4() {
	_board = new Board(8);
	gameOver = false;
    }

    public boolean isGameOver() {

    }
} // end class Connect4
	
