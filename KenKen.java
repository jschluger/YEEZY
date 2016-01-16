/*====================================                                     
  class KenKen -- implenemts the game KenKen as found in newspapers everywhere

  implements the game interface(sike not really)
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public class KenKen {

    //instance vars
    Board KEY1;
    Board _input;
    
    public KenKen() {
	//programing the board -->
	//found in thursday January 14, 2016 New York Times
	//******* NOTE: CREDIT THIS LATER
	KEY1 = new Board(4);
	KEY1.set(0,0,1);
	KEY1.set(0,1,4);
	KEY1.set(0,2,3);
	KEY1.set(0,3,2);
	KEY1.set(1,0,4);
	KEY1.set(1,1,3);
	KEY1.set(1,2,2);
	KEY1.set(1,3,1);
	KEY1.set(2,0,2);
	KEY1.set(2,1,1);
	KEY1.set(2,2,4);
	KEY1.set(2,3,3);
	KEY1.set(3,0,3);
	KEY1.set(3,1,2);
	KEY1.set(3,2,1);
	KEY1.set(3,3,4);

	_input = new Board(4);
	
    }
    
    //prints out board 1
    public void print1() {
	String s = " ========= ========= ========= =========\n|12x      .         .         |2/       |\n|         .         .         |         |\n|    ";
	s += show( _input.get(0,0) ); 
	s += "    .    ";
	s += show( _input.get(0,1) );
	s += "    .    ";
	s += show( _input.get(0,2) );
	s += "    |    ";
	s += show( _input.get(0,3) );
	
	s+= "    |\n|         .         .         |         |\n ========= ========= =========|. . . . .|\n|4        |6+       |2/       |         |\n|         |         |         |         |\n|    ";
	s += show( _input.get(1,0) ); 
	s += "    |    ";
	s += show( _input.get(1,1) );
	s += "    |    ";
	s += show( _input.get(1,2) );
	s += "    |    ";
	s += show( _input.get(1,3) );

	s+= "    |\n|         |         |         |         |\n =========|. . . . .|. . . . . =========\n|1-       |         |         |8+       |\n|         |         |         |         |\n|    ";
	s += show( _input.get(2,0) ); 
	s += "    |    ";
	s += show( _input.get(2,1) );
	s += "    |    ";
	s += show( _input.get(2,2) );
	s += "    |    ";
	s += show( _input.get(2,3) );

	s+= "    |\n|         |         |         |         |\n|. . . . .|. . . . .|========= . . . . .|\n|         |         |         .         |\n|         |         |         .         |\n|    ";
	s += show( _input.get(3,0) );
	s += "    |    ";
	s += show( _input.get(3,1) );
	s += "    |    ";
	s += show( _input.get(3,2) );
	s += "    .    ";
	s += show( _input.get(3,3) );

	s+= "    |\n|         |         |         .         |\n ========= ========= ========= =========\n";
	
	System.out.println(s);
    }
    
    //show -- so that we dont pront out a bunch of NULLs
    public String show( Object o ) {
	if (o == null) return " ";
	else return o.toString(); 
    }

    //takeInput -- takes user input and returns int[] in form:
    //{row, column, guess}
    public int[] takeInput() {
	int row;
	int column;
	int guess;
	
	System.out.print("Row: ");
	row = Keyboard.readInt();

	System.out.print("Column: ");
	column = Keyboard.readInt();

	if (row < 0 || row > 3 || column < 0 || column > 3) {
	    System.out.println("This is not a valid position.\nPick again.\n");
	    return takeInput();
	}

	System.out.print("Guess: ");
	guess = Keyboard.readInt();
	
	return new int[] {row, column, guess};
    }

    //isCorrect -- checks if user input, gotten via takeInput(), is the correct number for that spot
    public boolean isCorrect(int[] in) {
	return _input.get(in[0],in[1]).equals( KEY1.get(in[0],in[1]) );
	
    }
    
    public void playTurn() {
	print1();
	int[] in = takeInput();
	if ( isCorrect(in) ) {
	    _input.set(in[0],in[1],in[2]);
	}
	else System.out.println("Sorry, this is not correct. Try again.\n");
    }

    public boolean isGameOver() {
	for (int r = 0; r < _input.size(); r++)
	    for (int c = 0; c < _input.size(); c++)
		if ( _input.get(r,c) == null ) return false;
	return true;
    }

    
    public void playGame() {
	while ( ! isGameOver() ) {
	    playTurn();
	}
	System.out.println("YOU HAVE WON !!!");
    }
    
    public static void play() {
	KenKen k = new KenKen();
	k.playGame();
    }
			   
    
    public static void main(String[] args) {
	KenKen.play();
    }

    


}//end class KenKen
