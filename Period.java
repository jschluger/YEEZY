/*=====================================       
                              
  class period -- abstract class for each period of the day 
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public abstract class Period {

    //max credits earned if you win the game in that period
    protected int _maxCredits;
    
    //wrapper function for all that will happen during each period
    public abstract int scenario();

    /*prints out
      .
      
      .

      .
      with pauses between them, so signify waiting*/
    public void pause() {
	for (int i = 0; i < 3; i++) {
	    System.out.println("\n.");
	    try {
		Thread.sleep(1000); // 1000 milliseconds is one second. 
	    }
	    catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
	    }    
	}
    }

} //end class Period
