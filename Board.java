/*====================================
  class Board -- creates a square board

  useful in games: Battleship, Tic Tac Toe, et al
  ====================================*/ 

public class Board {
    private static final int DEFAULT_SIZE = 5;
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
    
    // each point populated
    public void populate(Object a) {
	for (int r = 0; r < _size; r++) {
	    for (int c = 0; c < _size; c++) {
		_board[r][c] = a;
	    }
	}
    }

    //return the item at the specified row & column
    public Object get( int r, int c ) {
	return _board[r][c];
    }  

    // overwrite item at specified row and column with newVal
    // return old value
    public Object set( int r, int c, Object newVal ) {
	Object oldVal = get(r,c); // save oldVal
	_board[r][c] = newVal;
	return oldVal;
    }

    // return specific row
    public Object[] getRow( int r ) {
	return _board[r];
    }

    // modify specific row, return old row
    public Object[] setRow( int r, Object[] newRow ) {
	Object[] temp = getRow(r); // save old row
	_board[r] = newRow;
	return temp;
    }

    // return specific column
    public Object[] getCol( int c ) {
	Object[] retVal = new Object[size()];
	for (int r = 0; r < size(); r++){
	    retVal[r] = _board[r][c];
	}
	return retVal;
    }

    // modify specific column, return old column
    public Object[] setCol( int c, Object[] newCol ) {
	Object[] temp = getCol(c); // save old col
	for (int r = 0; r < size(); r++){
	    _board[r][c] = newCol[r];
	}
	return temp;
    }

    // transpose board
    public void transpose() {
	Board temp = new Board(size());
	// copy _board to temp to avoid aliasing
	for (int i = 0; i < size(); i++) {
	    for (int j = 0; j < size(); j++) {
		temp.set(i, j, get(i,j));
	    }
	}

	for (int i = 0; i < size(); i++) {
	    setRow(i,temp.getCol(i)); // transpose
	}
    } 

    // t/f if Object is present in _board
    public boolean contains( Object o ) {
	for (int r = 0; r < size(); r++)
	    for (int c = 0; c < size(); c++)
		if ( o.equals(get(r,c)) ) return true; // true if equivalence found
	return false;
    }
    
    // override toString()
    public String toString() {
	String retStr = "";
	for (Object[] row : _board) {
	    for (Object a : row) {
	        retStr += a + "    ";
	    }
	    retStr += "\n\n";
	}
	return retStr;
    }
} // end class Board
