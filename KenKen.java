/*====================================                                     
  class KenKen -- implenemts the game KenKen as found in newspapers everywhere

  implements the game interface
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public class KenKen implements Game {

    //instance vars
    Board KEY1;
    Board _input;
    
    public KenKen() {
	//programing the board -->
	//found in thursday January 14, 2016 New York Times
	//******* NOTE: CREDIT THIS LATER
	KEY1 = new Board(4);
	KEY1.set(0,0,3);
	KEY1.set(0,1,2);
	KEY1.set(0,2,1);
	KEY1.set(0,3,4);
	KEY1.set(1,0,4);
	KEY1.set(1,1,1);
	KEY1.set(1,2,3);
	KEY1.set(1,3,2);
	KEY1.set(2,0,2);
	KEY1.set(2,1,3);
	KEY1.set(2,2,4);
	KEY1.set(2,3,1);
	KEY1.set(3,0,1);
	KEY1.set(3,1,4);
	KEY1.set(3,2,2);
	KEY1.set(3,3,3);

	_input = new Board(4);
	
    }
    
    //prints out board 1
    public void print1() {
	String s = " ========= ========= ========= =========\n|7+       |8x       .         .         |\n|         |         .         .         |\n|    ";
	s += show( _input.get(0,0) ); 
	s += "    |    ";
	s += show( _input.get(0,1) );
	s += "    .    ";
	s += show( _input.get(0,2) );
	s += "    .    ";
	s += show( _input.get(0,3) );
	
	s+= "    |\n|         |         .         .         |\n|. . . . .|============================= \n|         |1        |36x      |2/       |\n|         |         |         |         |\n|    ";
	s += show( _input.get(1,0) ); 
	s += "    |    ";
	s += show( _input.get(1,1) );
	s += "    |    ";
	s += show( _input.get(1,2) );
	s += "    |    ";
	s += show( _input.get(1,3) );

	s+= "    |\n|         |         |         |         |\n ========= ========= . . . . .|. . . . .|\n|2        |         .         |         |\n|         |         .         |         |\n|    ";
	s += show( _input.get(2,0) ); 
	s += "    |    ";
	s += show( _input.get(2,1) );
	s += "    .    ";
	s += show( _input.get(2,2) );
	s += "    |    ";
	s += show( _input.get(2,3) );

	s+= "    |\n|         |         .         |         |\n =================== =================== \n|3-       .         |1-       .         |\n|         .         |         .         |\n|    ";
	s += show( _input.get(3,0) );
	s += "    .    ";
	s += show( _input.get(3,1) );
	s += "    |    ";
	s += show( _input.get(3,2) );
	s += "    .    ";
	s += show( _input.get(3,3) );

	s+= "    |\n|         .         |         .         |\n ========= ========= ========= =========";
	
	System.out.println(s);
    }
    
    //show -- so that we dont print out a bunch of NULLs
    public String show( Object o ) {
	if (o == null) return " ";
	else return o.toString(); 
    }

    //takeInput -- takes user input and returns int[] in form:
    //{row, column, guess}
    public Integer[] takeInput() {
	int row;
	int column;
	int guess;
	
	System.out.print("Row: ");
	row = Keyboard.readInt() - 1;

	System.out.print("Column: ");
	column = Keyboard.readInt() - 1;

	if (row < 0 || row > 3 || column < 0 || column > 3) {
	    System.out.println("\nThis is not a valid position.\nPick again.\n");
	    return takeInput();
	}
	
	System.out.print("Guess: ");
	guess = Keyboard.readInt();
	System.out.println();

	if (guess < 0) return new Integer[] {row, column, null};
	return new Integer[] {row, column, guess};
    }

    //isCorrect -- checks if user input, gotten via takeInput(), is the correct number for that spot
    public boolean isCorrect(int[] in) {
	return KEY1.get(in[0],in[1]).equals( in[2] );
	
    }
    
    public void playTurn() {
	print1();
	Integer[] in = takeInput();
	//if ( isCorrect(in) ) {
	
	_input.set(in[0],in[1],in[2]);

	//}
	//else System.out.println("Sorry, this is not correct. Try again.");
    }

    public boolean isGameOver() {
	for (int r = 0; r < _input.size(); r++)
	    for (int c = 0; c < _input.size(); c++)
		if ( !KEY1.get(r,c).equals(_input.get(r,c)) ) return false;
	return true;
    }
    
    public void displayInstructions() {
	System.out.println("Welcom to KenKen! The game found in newspapers everywhere!");
	System.out.println("The goal of the game is to fill the board with the correct numbers. You will be playing on a 4x4 board, so you can use the numbers 1-4. Fill the board in with numbers so as not to repeat a number in any row od column, and so that the numbers in each heavily outlined area will produce the target number shown, by using the opperation shown, on the numbers in that heavily outlined area. Good luck!");
	System.out.println("\nThis KenKen comes to us from the Thursday, January 14, 2016 edition of The New York Times ");


	
    }

    
    public boolean playGame() {
	displayInstructions();
	while ( ! isGameOver() ) {
	    if ( _input.isFull() ) {
		print1();
		System.out.println("The board is full, but not correct. Do you want to keep playing?");
		System.out.print("Answer y/n (IF YOU ANSWER n YOU WILL LOSE THE GAME): ");

		if (Keyboard.readString().equals("n")) {
		    System.out.println("You have lost. :(");
		    return false;
		}
	    }
	    
	    playTurn();
	}
	print1();
	System.out.println("YOU HAVE WON !!!");
	return true;
    }
    
    public static boolean play() {
	KenKen k = new KenKen();
	return k.playGame();
    }
			   
    
    public static void main(String[] args) {
	KenKen.play();
    }

    


}//end class KenKen
