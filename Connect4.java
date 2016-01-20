/*====================================
  class Connect4 - implements the Connect4 game

  implements Game interface
  uses Board as data type
  ====================================*/

import cs1.Keyboard;

public class Connect4 implements Game {
    
    private static final String PIECE_1 = "X";
    private static final String PIECE_2 = "O";

    private Board _board;
    private int _numTurn; // to track turn number
    private int _col; // user input to drop piece

    // default constructor: 8x8 board, no customization
    public Connect4() {
	_board = new Board(8);
	_board.populate("_");
	_numTurn = 1;
	_col = -1;
    }

    // to signify a stalemate
    public boolean isBoardFull() {
	return (! (_board.contains("_") ));
    }

    // HORIZONTAL CHECK
    public boolean winH() {
	boolean retVal = true;
	for (int r = 0; r < 8; r++) {
	    for (int c = 0; c < 5; c++) {
		retVal = true;
		for (int n = c + 1; n < (c + 4); n++) {
		    // checks for equivalence with pieces horizontal (right) to it
		    // makes sure they are not meaningless positions
		    if ( !(_board.get(r,c).equals(_board.get(r,n)) ) || _board.get(r,c).equals("_") ) {
			retVal = false; // didn't pass test
			break; // check next piece to the right
		    }
		}
		// return true if retVal remains true after test of four consecutive pieces
		if (retVal) return true;
	    }
	}
	return false;
    }
    
    // VERTICAL CHECK
    public boolean winV() {
	boolean retVal = true;
	for (int r = 0; r < 8; r++) {
	    for (int c = 0; c < 5; c++) {
		retVal = true;
		for (int n = c + 1; n < (c + 4); n++) {
		    // checks for equivalence with pieces vertical (down) to it
		    // makes sure they are not meaningless positions
		    if ( !(_board.get(c,r).equals(_board.get(n,r)) ) || _board.get(c,r).equals("_") ) {
			retVal = false; // didn't pass test
			break; // check next piece to the bottom
		    }
		}
		// return true if retVal remains true after test of four consecutive pieces
		if (retVal) return true;
	    }
	}
	return false;
    }

    // DIAGONAL CHECK RIGHTWARDS
    public boolean winDiagUp() {
	// CHECK LEFT BORDER
	boolean retVal = true;
	for (int r = 3; r < 8; r++) {
	    Object[] diag = _board.getDiagUp(r,0);
	    for (int i = 0; i < diag.length - 3; i++) {
		retVal = true;
		for (int n = i + 1; n < (i + 4); n++) {
		    if ( !diag[i].equals(diag[n]) || diag[i].equals("_") ) {
			retVal = false; // didn't pass test
			break; // check next piece in diagonal
		    }
		}
		// return true if retVal remains true after test of four consecutive pieces
		if (retVal) return true;
	    }
	}

	// CHECK BOTTOM BORDER
	for (int c = 1; c < 5; c++) {
	    Object[] diag = _board.getDiagUp(7,c);
	    for (int i = 0; i < diag.length - 3; i++) {
		retVal = true;
		for (int n = i + 1; n < (i + 4); n++) {
		    if ( !diag[i].equals(diag[n]) || diag[i].equals("_") ) {
			retVal = false; // didn't pass test
			break; // check next piece in diagonal
		    }
		}
		// return true if retVal remains true after test of four consecutive pieces
		if (retVal) return true;
	    }
	}
	return false; // if none of the above remains true			
    }

    // DIAGONAL CHECK LEFTWARDS
    public boolean winDiagDown() {
	// CHECK LEFT BORDER
	boolean retVal = true;
	for (int r = 0; r < 5; r++) {
	    Object[] diag = _board.getDiagDown(r,0);
	    for (int i = 0; i < diag.length - 3; i++) {
		retVal = true;
		for (int n = i + 1; n < (i + 4); n++) {
		    if ( !diag[i].equals(diag[n]) || diag[i].equals("_") ) {
			retVal = false; // didn't pass test
			break; // check next piece in diagonal
		    }
		}
		// return true if retVal remains true after test of four consecutive pieces
		if (retVal) return true;
	    }
	}

	// CHECK TOP BORDER
	for (int c = 1; c < 5; c++) {
	    Object[] diag = _board.getDiagDown(0,c);
	    for (int i = 0; i < diag.length - 3; i++) {
		retVal = true;
		for (int n = i + 1; n < (i + 4); n++) {
		    if ( !diag[i].equals(diag[n]) || diag[i].equals("_") ) {
			retVal = false; // didn't pass test
			break; // check next piece in diagonal
		    }
		}
		// return true if retVal remains true after test of four consecutive pieces
		if (retVal) return true;
	    }
	}
	return false; // if none of the above remains true
    }

    public boolean isGameOver() {
	return winH() || winV() || winDiagDown() || winDiagUp(); // game is over if four consecutive (same) pieces found
    }

    // for UX
    public void displayInstructions() {
	System.out.println("Welcome to Connect 4, where you will try to get four in a row. Use integers 1-8, inclusive to show where you want to place your piece.\n");
	System.out.println("X: Player 1 Piece\nU: Player 2 (COM) Piece\n");
    }

    // verifies user input to avoid errors
    public boolean checkH() {
	// make sure in boundaries
	if (! ((_col - 1) >= 0 && (_col - 1) < 8) ) {
	    System.out.print("Out of boundaries! Try again... ");
	    return false;
	}

	else if (!_board.get(0,_col-1).equals("_")) { // check first row to see if empty
	    System.out.print("Cannot drop piece here! Try again... ");
	    return false;
	}

	return true;
    }
    
    // avoid text output if computer player is choosing column
    public boolean checkC() { 
	// make sure in boundaries
	if (! ((_col - 1) >= 0 && (_col - 1) < 8) ) {
	    return false;
	}

	else if (!_board.get(0,_col-1).equals("_")) { // check first row to see if empty
	    return false;
	}

	return true;
    }

    // drops piece at the first free space in the column
    public void dropPiece(String piece) {
	// extract specified column
	Object[] col = _board.getCol(_col - 1);
	int x = 7;
	for (; x >= 0; x--) {
	    if (col[x].equals("_")) {
		break;
	    }
	}
	int dropPos = x;
	col[dropPos] = piece;

	// modify _board with dropped piece
	_board.setCol(_col - 1, col);
    }

    // simulate one turn between user and COM
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

	// increment numTurn by 1
	_numTurn++;
	
	// ======= COM TURN =======
	System.out.println("COM thinking...\n");
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

	// check if COM has beat you
	if ( isGameOver() ) {
	    System.out.println("I have beat you! Success awaits.");
	}
    }

    // simulate entire game from static context
    public boolean playGame() {
	displayInstructions();
	System.out.println(_board);
	while ( !isGameOver() && !isBoardFull() ) {
	    playTurn();
	}

	// stalemate only possible by COM
	if ( isBoardFull() ) {
	    System.out.println("Stalemate.");
	}
	//fix this later
	return true;
	    
    }

    // simulate entire game from non static context
    public static boolean play() {
	Connect4 game = new Connect4();
	return game.playGame();
    }

    // for testing
    public static void main(String[] args) {
	play();
    }
} // end class Connect4
    
	
