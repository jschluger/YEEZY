/*====================================
  class Board -- creates a square board

  useful in games: Battleship, Tic Tac Toe, et al
  ====================================*/ 

public class Board {
    public static final int DEFAULT_SIZE = 5;
    private int _size;
    private Object[][] _board;

    // default constructor initializes board of default size
    public Board() {
	_board = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
	_size = DEFAULT_SIZE;
    }

    // overloaded constructor
    public Board(int a) {
	_board = new Object[a][a];
	_size = a;
    }

    // return size
    public int size() {
	return _size;
    }

    // set specified coordinate to specified value
    public void set(int r, int c, Object newVal) {
	_board[r][c] = newVal;
    }

    // get value at specified coordinate
    public Object get(int r, int c) {
	return _board[r][c];
    
    // each point populated
    public void populate(Object a) {
	for (int r = 0; r < _size; r++) {
	    for (int c = 0; c < _size; c++) {
		_board[r][c] = a;
	    }
	}
    }

    // override toString()
    public String toString() {
	String retStr = "";
	for (Object[] row : _board) {
	    for (Object a : row) {
	        retStr += a + "\t";
	    }
	    retStr += "\n\n";
	}
	return retStr;
    }
}
