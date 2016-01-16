/*====================================                                     
  class KenKen -- implenemts the game KenKen as found in newspapers everywhere

  implements the game interface(sike not really)
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public class KenKen {

    //instance vars
    Board KEY1;
    Board input;
    
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

	input = new Board(4);
	
    }
    
    //prints out board 1
    public void print1() {
	String s = " ========= ========= ========= =========\n|12x      .         .         |2/       |\n|         .         .         |         |\n|    ";
	s += show( input.get(0,0) ); 
	s += "    .    ";
	s += show( input.get(0,1) );
	s += "    .    ";
	s += show( input.get(0,2) );
	s += "    |    ";
	s += show( input.get(0,3) );
	
	s+= "    |\n|         .         .         |         |\n ========= ========= ========= . . . . .\n|4        |6+       |2/       |         |\n|         |         |         |         |\n|    ";
	s += show( input.get(1,0) ); 
	s += "    |    ";
	s += show( input.get(1,1) );
	s += "    |    ";
	s += show( input.get(1,2) );
	s += "    |    ";
	s += show( input.get(1,3) );

	s+= "    |\n|         |         |         |         |\n ========= . . . . . . . . . . =========\n|1-       |         |         |8+       |\n|         |         |         |         |\n|    ";
	s += show( input.get(2,0) ); 
	s += "    |    ";
	s += show( input.get(2,1) );
	s += "    |    ";
	s += show( input.get(2,2) );
	s += "    |    ";
	s += show( input.get(2,3) );

	s+= "    |\n|         |         |         |         |\n . . . . . . . . . . ========= . . . . .\n|         |         |         .         |\n|         |         |         .         |\n|    ";
	s += show( input.get(3,0) );
	s += "    |    ";
	s += show( input.get(3,1) );
	s += "    |    ";
	s += show( input.get(3,2) );
	s += "    .    ";
	s += show( input.get(3,3) );

	s+= "    |\n|         |         |         .         |\n ======== ========= ========= =========\n";
	
	
	System.out.println(s);
    }

    //show -- so that we dont pront out a bunch of NULLs
    public String show( Object o ) {
	if (o == null) return " ";
	else return o.toString(); 
    }
    
    
    public static void main(String[] args) {

	KenKen k = new KenKen();
	System.out.println(k.KEY1);
	k.print1();
    }

    


}//end class KenKen
