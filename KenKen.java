/*====================================                                     
  class KenKen -- implenemts the game KenKen as found in newspapers everywhere

  implements the game interface(sike not really)
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public class KenKen {

    //instance vars
    Board KEY1;
    
    
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
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {

	KenKen k = new KenKen();
	System.out.println(k.KEY1);
			
    }

    


}//end class KenKen
