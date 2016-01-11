/*====================================
  class Battleship - the classic Battleship game 
  ====================================*/

import cs1.Keyboard;

public class Battleship {

    private Board _board;
    private int _shipRow;
    private int _shipCol;
    private int _size;
    private int _numTurns;

    private int _row;
    private int _col;

    // default constructor with default board
    public Battleship() {
	_board = new Board();
	_board.populate("O"); // denotes unknown point in sea
        _size = _board.size();
	_numTurns = _size;
	_shipRow = (int)(Math.random() * _size) + 1; // [1,size]
	_shipCol = (int)(Math.random() * _size) + 1; // [1,size]
    }

    // overloaded constructor with customized board
    public Battleship(int a) {
	_board = new Board(a);
	_board.populate("O"); // denotes unknown point in sea
        _size = a;
	_numTurns = _size;
	_shipRow = (int)(Math.random() * a) + 1; // [1,a]
	_shipCol = (int)(Math.random() * a) + 1; // [1,a]
    }

    // verifies guess values to actual location of ship
    public void check() {
	if (!(_row > 0 && _row <= _size && _col > 0 && _col <= _size)) {
	    System.out.println("Oops, not in the ocean!\n");
	    return; // exit method
	}

	else if (_board.get(_row - 1, _col - 1).equals("X")) {
	    System.out.println("You already guessed that!\n");
	    return;
	}

	else if (_row == _shipRow && _col == _shipCol) {
	    System.out.println("You sunk my battleship! Congratulations on your victory!\n");
	    _board.set(_row - 1, _col - 1, "H"); // H denotes sunken battleship
	    return;
	}
	
	// if all of the above are false, guess is incorrect
	System.out.println("You missed my battleship!\n");
	_board.set(_row - 1, _col - 1, "X"); 
    }

    // checks whether game has been completed with correct guess
    public boolean isGameOver() {
	return _board.contains("H");
    }

    public void play() {
	System.out.println("Welcome to BATTLESHIP, where you will try to sink my sole battleship in this vast sea! Be strategic and make wise decisions, or else fail miserably!\n");

	while (_numTurns > 0) {
	    System.out.print(_board);
	    System.out.println("TURNS LEFT: " + _numTurns + "\n");
	    
	    // user input for row and column using Keyboard class
	    System.out.print("Row: ");
	    _row = Keyboard.readInt();
	    System.out.print("Column: ");
	    _col = Keyboard.readInt();

	    System.out.println();

	    check(); // verify values
	    _numTurns -= 1; // decimate turns left by 1

	    // check if game has been completed before user has exhausted the number of turns available
	    if (isGameOver()) {
		System.out.print(_board);
		break;
	    }
	}
	
	// check to see if user has failed to correctly pinpoint battleship
	if (!(isGameOver())) {
	    System.out.println("Despite your great efforts, you have failed to sink my battleship in this vast sea. Success awaits.\n");
	    _board.set(_shipRow - 1, _shipCol - 1, "H"); // show true location
	    System.out.print(_board);
	}
    }

    public static void main(String[] args) {
	Battleship game = new Battleship();
	game.play();
    }
}
		
	    
	
	    
	    
	
