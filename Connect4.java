/*====================================
  class Connect4 - implements the Connect4 game

  implements Game interface
  uses Board as data type
  ====================================*/

import cs1.Keyboard;

public class Connect4 implements Game {
    private static final String PIECE_1 = "X";
    private static final String PIECE_2 = "U";

    private Board _board;
    private int _numTurn; // to track turn number
    private int _col; // user input to drop piece

    // default constructor: 8x8 board
    public Connect4() {
	_board = new Board(8);
	_board.populate("O");
	_numTurn = 1;
	_col = -1;
    }

    // to signify a stalemate
    public boolean isBoardFull() {
	return (! (_board.contains("O") ));
    }

    // looks for four in a row
    public boolean isGameOver() {
	return false;
    }

    // for UX
    public void displayInstructions() {
	System.out.println("Welcome to Connect 4, where you will try to get four in a row. Use integers 1-8, inclusive to show where you want to place your piece.\n");
	System.out.println("X: Player 1 Piece\nU: Player 2 (COM) Piece\n");
    }

    // verifies user input to avoid errors
    public boolean checkH() {
	// make sure 
	if (! ((_col - 1) >= 0 && (_col - 1) < 8) ) {
	    System.out.print("Out of boundaries! Try again... ");
	    return false;
	}

	else if (!_board.get(0,_col-1).equals("O")) { // check first row to see if empty
	    System.out.println("Cannot drop piece here! Try again... ");
	    return false;
	}

	return true;
    }

    public boolean checkC() { // avoid text if computer player is choosing column
	// make sure 
	if (! ((_col - 1) >= 0 && (_col - 1) < 8) ) {
	    return false;
	}

	else if (!_board.get(0,_col-1).equals("O")) { // check first row to see if empty
	    return false;
	}

	return true;
    }

    // drops piece at the first free space in the column
    public void dropPiece(String piece) {
	// extract specified column
	Object[] col = _board.getCol(_col - 1);
	int x = 7;
	for (int p = 7; p >= 0; p--) {
	    if (!col[p].equals("O")) x--; // find first free spot
	    else break;
	}
	int dropPos = x;
	col[dropPos] = piece;

	// modify _board with dropped piece
	_board.setCol(_col - 1, col);
    }
 
    public void playTurn() {
	// ======= USER TURN =======
	System.out.print("User Turn #" + _numTurn + ": ");

	_col = Keyboard.readInt();
	while (!checkH()) { // makes sure user has valid input
	    _col = Keyboard.readInt();
	}

	// drop the piece after check is true
	dropPiece(PIECE_1);

	// show output
	System.out.println("\n" + _board);
	// check for end of game or stalemate
	if (isGameOver()) {
	    System.out.println("Congratulations! You have beat me!\n");
	    return;
	}
	if ( isBoardFull() ) {
	    System.out.println("Stalemate.\n");
	    return;
	}
	
	// ======= COM TURN =======
	System.out.println("Computer Turn #" + _numTurn + "\n");
	_col = (int)(Math.random() * 8) + 1; // [1,8]

	// similarly verify input
	while (!checkC()) {
	    _col = (int)(Math.random() * 8) + 1;
	}
	
	try {
	    Thread.sleep(1000); // 1000 milliseconds is one second.
	}
	catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
	// drop piece
	dropPiece(PIECE_2);
	
	// show output
	System.out.println(_board);
	// check for end of game or stalemate
	if (isGameOver()) {
	    System.out.println("Welp, I have defeated you!\n");
	    return;
	}
	if ( isBoardFull() ) {
	    System.out.println("Stalemate.\n");
	    return;
	}

	// increment numTurn by 1
	_numTurn++;
    }

    public void playGame() {
	System.out.println(_board);
	while ( !isGameOver() ) {
	    playTurn();
	}
    }

    public static void play() {
	Connect4 game = new Connect4();
	game.playGame();
    }

    public static void main(String[] args) {
	play();
    }
} // end class Connect4
    
	
