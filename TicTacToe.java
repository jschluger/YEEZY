/*====================================
  class TicTacToe - implements the TicTacToe game

  implements Game interface
  uses Board as data type
  ====================================*/

import cs1.Keyboard;

public class TicTacToe implements Game {
    
    private Board _board;
    private static final String PIECE_1 = "X";
    private static final String PIECE_2 = "O";

    private int _numTurn;
    private int _row;
    private int _col;

    // default constructor - 3x3 board
    public TicTacToe() {
	_board = new Board(3);
	_board.populate("__");
	_numTurn = 0;
    }

    // stalemate
    public boolean isBoardFull() {
	return (! (_board.contains("__") ));
    }

    // HORIZONTAL CHECK
    public boolean winH() {
	boolean retVal = true;
	for (int r = 0; r < 3; r++) {
	    retVal = true;
	    for (int n = 1; n < 3; n++) {
		// checks for equivalence with pieces horizontal (right) to it
		// makes sure they are not meaningless positions
		if ( !(_board.get(r,0).equals(_board.get(r,n)) ) || _board.get(r,0).equals("__") ) {
		    retVal = false; // didn't pass test
		    break; // check next piece to the right
		}
	    }
	    // return true if retVal remains true after test of three consecutive pieces
	    if (retVal) return true;
	}
	return false;
    }

    // VERTICAL CHECK
    public boolean winV() {
	boolean retVal = true;
	for (int c = 0; c < 3; c++) {

	    retVal = true;
	    for (int n = 1; n < 3; n++) {
		// checks for equivalence with pieces vertical (down) to it
		// makes sure they are not meaningless positions
		if ( !(_board.get(0,c).equals(_board.get(n,c)) ) || _board.get(0,c).equals("__") ) {
		    retVal = false; // didn't pass test
		    break; // check next piece to the bottom
		}
	    }
	    // return true if retVal remains true after test of four consecutive pieces
	    if (retVal) return true;
	}
	return false;
    }

    // DIAGONAL CHECK RIGHTWARDS
    public boolean winDiag() {
	// CHECK DIAG FROM 0,0
	boolean retVal = true;
	Object[] diag = _board.getDiagDown(0,0);
	for (int i = 1; i < 3; i++) {
	    retVal = true;
	    if ( !diag[0].equals(diag[i]) || diag[0].equals("__") ) {
		retVal = false; // didn't pass test
	        break;
	    }
	}

	if (retVal) return true;

	// CHECK DIAG FROM 2,0
	retVal = true;
        diag = _board.getDiagUp(2,0);
	for (int i = 1; i < 3; i++) {
	    retVal = true;
	    if ( !diag[0].equals(diag[i]) || diag[0].equals("__") ) {
		retVal = false; // didn't pass test
	        break;
	    }
	}

	if (retVal) return true;

	return false;
    }
	
    public boolean isGameOver() {
	return winH() || winV() || winDiag(); // game is over if three consecutive (same) pieces found
    }

    // for UX
    public void displayInstructions() {
	System.out.println("Welcome to TicTacToe, where you will try to get three in a row. Enter the coordinate where you want to place your piece.\n");
	System.out.println("X: Player 1 Piece\nO: Player 2 (COM) Piece\n");
    }

    // verifies user input to avoid errors
    public boolean checkH() {
	// make sure in boundaries
	if (! ((_col - 1) >= 0 && (_col - 1) < 3 && (_row - 1) >=0 && (_row - 1) < 3) ) {
	    System.out.print("Out of boundaries! Try again...\n");
	    return false;
	}

	else if (_board.get(_row-1,_col-1).equals("X") || _board.get(_row-1,_col-1).equals("O")) { // check if coordinate is filled
	    System.out.print("Invalid! Try again...\n");
	    return false;
	}

	return true;
    }
    
    // avoid text output if computer player is choosing column
    public boolean checkC() { 
	// make sure in boundaries
	if (! ((_col - 1) >= 0 && (_col - 1) < 3 && (_row - 1) >=0 && (_row - 1) < 3) ) { 
	    return false;
	}

	else if (_board.get(_row-1,_col-1).equals("X") || _board.get(_row-1,_col-1).equals("O")) { // check if coordinate is filled
	    return false;
	}

	return true;
    }

    // drops piece at the first free space in the column
    public void placePiece(String piece) {
        _board.set(_row-1,_col-1,piece);
    }

    // simulate one turn between user and COM
    public void playTurn() {
	// ======= USER TURN =======
	System.out.print("User Turn " + _numTurn + ":\n");

	// user input
	System.out.print("Row: ");
	_row = Keyboard.readInt();
	System.out.print("Column: ");
	_col = Keyboard.readInt();
	
	while (!checkH()) { // makes sure user has valid input
	    System.out.print("Row: ");
	    _row = Keyboard.readInt();
	    System.out.print("Column: ");
	    _col = Keyboard.readInt();
	}

	// drop the piece after check is true
	placePiece(PIECE_1);

	// show output
	System.out.println("\n" + _board);
	// check for end of game or stalemate
	
	if (isGameOver()) {
	    System.out.println("Congratulations! You have beat me!\n");
	    return;
	}
	
	// increment numTurn by 1
	_numTurn++;
	
	// ======= COM TURN =======
	System.out.println("COM thinking...\n");
	_row = (int)(Math.random() * 3) + 1; // [1,3]
	_col = (int)(Math.random() * 3) + 1; // [1,3]

	// similarly verify input
	while (!checkC()) {
	    _row = (int)(Math.random() * 3) + 1;
	    _col = (int)(Math.random() * 3) + 1;
	}
	       
	try {
	    Thread.sleep(1000); // 1000 milliseconds is one second.
	}
	catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
	// drop piece
	placePiece(PIECE_2);
	
	// show output
	System.out.println(_board);

	// check if COM has beat you
	if ( isGameOver() ) {
	    System.out.println("I have beat you! Success awaits.");
	}
    }

    // simulate entire game from static context
    public void playGame() {
	displayInstructions();
	System.out.println(_board);
	while ( !isGameOver() && !isBoardFull() ) {
	    playTurn();
	}

	// stalemate only possible by COM
	if ( isBoardFull() ) {
	    System.out.println("Stalemate.");
	}
	    
    }

    // simulate entire game from non static context
    public static void play() {
	TicTacToe game = new TicTacToe();
	game.playGame();
    }

    // for testing
    public static void main(String[] args) {
	play();
    }
} // end class TicTacToe
