/*====================================                                     
  class T048 --  implements the game 2048

  implements the game interface
  uses many methods that we wrote to deal with matrixes
  ====================================*/

public class T048 {
    
    //instance variables
    
    //
    private Board _board;

    public T048() {
	_board = new Board(4);
	_board.populate(0);
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

    public static void main(String[] args){
	
	T048 t = new T048();
	t.addNewTile();
	System.out.println(t._board);


	
    }//end main
    
}//end class T048
