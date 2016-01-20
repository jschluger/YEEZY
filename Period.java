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

} //end class Period
