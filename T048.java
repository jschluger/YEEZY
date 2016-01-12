/*====================================                                     
  class T048 --  implements the game 2048

  implements the game interface(sike not really)
  uses Board as data type
  ====================================*/

import cs1.Keyboard;

public class T048 {
    
    //instance variables
    private Board _board;

    //constructor
    public T048() {
	_board = new Board(4);
	_board.populate(0);
	addNewTile();
	addNewTile();
    }


    /*====================================
      adds a new tile to the board in a random location
      1/10 chance of the tile being a 4, 9/10 of a 2
      ====================================*/
    public void addNewTile() {
	int valToAdd;
	if (Math.random() * 10 < 1) valToAdd = 4;
	else valToAdd = 2;
	
	int r = (int)(Math.random() * 4);
	int c = (int)(Math.random() * 4);

	//making sure its not overwriting an existing value
	while ( _board.get(r,c) != 0 ) {
	    r = (int)(Math.random() * 4);
	    c = (int)(Math.random() * 4);
	}

	_board.set(r,c, valToAdd);
    }
    
    /*====================================
      swipe left: swipes left, combining necessary tiles
      returns true if a swipe was able to happen and did happen,
      false if you cannot swipe left
      ====================================*/
    public boolean swipeL() {
	//to compare to new one after a swipe
	String old = _board.toString();

	//for each row
	for (int r = 0; r < 4; r++){
	    //first to combine similar tiles
	    //for the first 3 tiles
	    for (int c = 0; c < 3; c++){
		//if you find a meaningful element . . .
		if ( !_board.get(r, c).equals(0)){
		    //for the rest of the tiles . . . 
		    for (int n = c + 1; n < 4; n++){
			if (_board.get(r, c).equals( _board.get(r, n) )){
			    _board.set(r, c, 2 * (Integer)_board.get(r, c) );
			    _board.set(r, n, 0 );
			    break;
			}
			else if (!_board.get(r, c).equals(0)) break;
		    }
		}
	    }
	    //then to get rid of 0s and move everything over
	    //for the first 3 tiles again
	    for (int c = 0; c < 3; c++){
		//if you find a 0
		if (_board.get(r, c).equals(0)) {
		    //for the rest of the tiles . . .
		    for (int n = c + 1; n < 4; n++){
			if (!_board.get(r, n).equals(0)){
			    _board.set(r, c, _board.get(r, n) );
			    _board.set(r, n, 0 );
			    break;
			}
		    }
		}
	    }
	}
	if (old.equals(_board.toString())) return false;
	return true;
    }
    
    /*====================================
      swipe right: swipes right, combining necessary tiles
      returns true if a swipe was able to happen and did happen,
      false if you cannot swipe right
      ====================================*/
    public boolean swipeR() {
	//to compare to new one after a swipe
	String old = _board.toString();

	//for each row
	for (int r = 0; r < 4; r++){
	    //first to combine similar tiles
	    //for the first 3 tiles
	    for (int c = 3; c > 0; c--){
		//if you find a meaningful element . . .
		if ( !_board.get(r, c).equals(0)){
		    //for the rest of the tiles . . . 
		    for (int n = c - 1; n >= 0; n--){
			if (_board.get(r, c).equals( _board.get(r, n) )){
			    _board.set(r, c, 2 * (Integer)_board.get(r, c) );
			    _board.set(r, n, 0 );
			    break;
			}
			else if (!_board.get(r, c).equals(0)) break;
		    }
		}
	    }
	    //then to get rid of 0s and move everything over
	    //for the first 3 tiles again
	    for (int c = 3; c > 0; c--){
		//if you find a 0
		if (_board.get(r, c).equals(0)) {
		    //for the rest of the tiles . . .
		    for (int n = c - 1; n >= 0; n--){
			if (!_board.get(r, n).equals(0)){
			    _board.set(r, c, _board.get(r, n) );
			    _board.set(r, n, 0 );
			    break;
			}
		    }
		}
	    }
	}
	if (old.equals(_board.toString())) return false;
	return true;
    }
    /*====================================
      swipe down: swipes down, combining necessary tiles
      returns true if a swipe was able to happen and did happen,
      false if you cannot swipe down
      ====================================*/
    public boolean swipeD() {
	//to compare to new one after a swipe
	String old = _board.toString();

	//for each column
	for (int c = 0; c < 4; c++){
	    //first to combine similar tiles
	    //for the first 3 tiles
	    for (int r = 3; r > 0; r--){
		//if you find a meaningful element . . .
		if ( !_board.get(r, c).equals(0)){
		    //for the rest of the tiles . . . 
		    for (int n = r - 1; n >=0; n--){
			if (_board.get(r, c).equals( _board.get(n, c) )){
			    _board.set(r, c, 2 * (Integer)_board.get(r, c) );
			    _board.set(n, c, 0 );
			    break;
			}
			else if (!_board.get(r, c).equals(0)) break;
		    }
		}
	    }
	    //then to get rid of 0s and move everything over
	    //for the first 3 tiles again
	    for (int r = 3; r > 0; r--){
		//if you find a 0
		if (_board.get(r, c).equals(0)) {
		    //for the rest of the tiles . . .
		    for (int n = r - 1; n >=0; n--){
			if (!_board.get(n, c).equals(0)){
			    _board.set(r, c, _board.get(n, c) );
			    _board.set(n, c, 0 );
			    break;
			}
		    }
		}
	    }
	}
	if (old.equals(_board.toString())) return false;
	return true;
    }
    

    
    /*====================================
      swipe up: swipes up, combining necessary tiles
      returns true if a swipe was able to happen and did happen,
      false if you cannot swipe up
      ====================================*/
    public boolean swipeU() {
	//to compare to new one after a swipe
	String old = _board.toString();

	//for each column
	for (int c = 0; c < 4; c++){
	    //first to combine similar tiles
	    //for the first 3 tiles
	    for (int r = 0; r < 3; r++){
		//if you find a meaningful element . . .
		if ( !_board.get(r, c).equals(0)){
		    //for the rest of the tiles . . . 
		    for (int n = r + 1; n < 4; n++){
			if (_board.get(r, c).equals( _board.get(n, c) )){
			    _board.set(r, c, 2 * (Integer)_board.get(r, c) );
			    _board.set(n, c, 0 );
			    break;
			}
			else if (!_board.get(r, c).equals(0)) break;
		    }
		}
	    }
	    //then to get rid of 0s and move everything over
	    //for the first 3 tiles again
	    for (int r = 0; r < 3; r++){
		//if you find a 0
		if (_board.get(r, c).equals(0)) {
		    //for the rest of the tiles . . .
		    for (int n = r + 1; n < 4; n++){
			if (!_board.get(n, c).equals(0)){
			    _board.set(r, c, _board.get(n, c) );
			    _board.set(n, c, 0 );
			    break;
			}
		    }
		}
	    }
	}
	if (old.equals(_board.toString())) return false;
	return true;
    }
    

    /*====================================
      displays the instructions at the start of the game, so the user will be able to play
      ====================================*/
    public void displayInstructions(){
	String s;
	s = "This is a game of 2048. The objective is to get a tile with the face 2048, by combining tiles in a smart way.\n";
	System.out.println(s);
	s = "To play, you can swipe up, down, left, or right. The keys are as follows:\n";
	s+="\t* w : up\n";
	s+="\t* a : left\n";
	s+="\t* s : down\n";
	s+="\t* d : right\n";
	System.out.println(s);
	s = "When you swipe, if two tiles with the same face are push against eachother, they will combine to a tile with twice the value!\n";
	System.out.println(s);
	s = "REMEMBER: you must hit enter after every keystroke for it to proccess\n";
	System.out.println(s);
	s = "Good luck! :)";
	System.out.println(s);
    }
    /*====================================
      plays one turn of 2048
      ====================================*/
     public void playTurn(){
	String s = Keyboard.readString();
	if ( s.equals("w") && swipeU() ) addNewTile();
	else if ( s.equals("a") && swipeL() ) addNewTile();
	else if ( s.equals("s") && swipeD() ) addNewTile();
	else if ( s.equals("d") && swipeR() ) addNewTile();
	else return;//if the input is not w a s or d, do nothing
	System.out.println("\n" + _board);
    }
    
    /*===================================
      playGame -- play a game of 2048 with an EXISTING T048 object created
      ====================================*/
    public void playGame() {
	displayInstructions();
	System.out.println(_board);
	while ( !_board.contains(2048) )
	    playTurn();
    }

    /*====================================
      plays an entire game of 2048, from STATIC
      therefore will be called as T048.play()
      ====================================*/
    public static void play(){
	T048 t = new T048();
	t.playGame();
    }
    
    /*===================================
      main() (for testing)
      ====================================*/
    public static void main(String[] args){
	play();
    }//end main
    
}//end class T048
