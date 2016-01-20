/*====================================
  class Battleship - the classic Battleship game 

  implements Game interface
  uses Board as data type
  ====================================*/

import cs1.Keyboard;

public class Battleship implements Game {

    private Board _board;
    private int _shipRow; // location of
    private int _shipCol; // battleship
    private int _size;
    private int _numTurns; // algo: (1/4) * area of ocean

    // guessed values
    private int _row;
    private int _col;

    // default constructor with default board
    public Battleship() {
	_board = new Board();
	_board.populate("~"); // denotes unknown point in ocean
        _size = _board.size();
	_numTurns = (_size * _size)/4; 
	_shipRow = (int)(Math.random() * _size) + 1; // [1,size]
	_shipCol = (int)(Math.random() * _size) + 1; // [1,size]
    }

    // overloaded constructor with customized board
    public Battleship(int a) {
	_board = new Board(a);
	_board.populate("~"); // denotes unknown point in ocean
        _size = a;
	_numTurns = (a * a)/4; 
	_shipRow = (int)(Math.random() * a) + 1; // [1,a]
	_shipCol = (int)(Math.random() * a) + 1; // [1,a]
    }

    // verifies guess values to actual location of ship
    public boolean check() {
	if (!(_row > 0 && _row <= _size && _col > 0 && _col <= _size)) {
	    System.out.println("Oops, not in the ocean!\n");
	    return false; // exit method
	}

	else if (_board.get(_row - 1, _col - 1).equals("X")) {
	    System.out.println("You already guessed that!\n");
	    return false;
	}

	else if (_row == _shipRow && _col == _shipCol) {
	    System.out.println("You sunk my battleship! Congratulations on your victory!\n");
	    _board.set(_row - 1, _col - 1, "O"); // O denotes sunken battleship
	    return true;
	}
	
	// if all of the above are false, guess is incorrect
	System.out.println("You missed my battleship!\n");
	_board.set(_row - 1, _col - 1, "X");
	return true;
    }

    // checks whether game has been completed with correct guess
    public boolean isGameOver() {
	return _board.contains("O");
    }

    // for UX
    public void displayInstructions() {
        System.out.println("Welcome to BATTLESHIP, where you will try to sink my sole battleship in this vast ocean! Be strategic and make wise decisions, or else fail miserably!\n");
	System.out.println("Your goal is to sink my battleship. Enter integer values for the row and column you think my battleship is located in. You only have a set amount of turns, so be careful!\n");
	System.out.println("Try not to go out of boundaries or choose the same location!\n\nX: Marks missed spot\n\nO: Battleship location\n");
    }

    // simulates one turn of Battleship
    public void playTurn() {
	// user input for row and column using Keyboard class
	System.out.print("Row: ");
	_row = Keyboard.readInt();
	System.out.print("Column: ");
	_col = Keyboard.readInt();

	System.out.println();

	if (check() && !isGameOver() && _numTurns > 0) {; // verify values
	    System.out.println(_board);
	    _numTurns -= 1;
	}
    }

    // play a game of Battleship in a nonstatic context
    //true if you win, false if you lose
    public boolean playGame() {
	displayInstructions();
	System.out.print(_board);
	while (_numTurns > 0) {
	    System.out.println("Remaining Turns: " + _numTurns + "\n");
	    playTurn();

	    // check if game has been completed before user has exhausted the number of turns available
	    if (isGameOver()) {
		System.out.print(_board);
		return true;
	    }
	}
	
	// user has failed to correctly pinpoint battleship

	System.out.println("Despite your great efforts, you have failed to sink my battleship in this vast ocean. Success awaits.\n");
	_board.set(_shipRow - 1, _shipCol - 1, "O"); // show true location
	System.out.print(_board);
	return false;

    }

    // plays an entire game of Battleship from static context
    public static boolean play() {
	// allow for user input of size of ocean
	boolean passed = false;
	int s = 5;
	System.out.print("Please enter the width of the ocean within 5 - 10 units, inclusive: ");
	while (!passed) { // continue to try until size within specified boundaries
	    s = Keyboard.readInt();
	    if (s >= 5 && s <= 10) {
		passed = true;
	    }
	    else
		System.out.print("Try again... ");
	}
	System.out.println();   
	Battleship game = new Battleship(s);
	return game.playGame();
    }

    // for testing
    public static void main(String[] args) {
	play();
    }
} // end class Battleship
