/*====================================                                                  
  class RegStudent extends Character                                                                        
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;


public class RegStudent extends Character {
    
    public RegStudent() {
	_creditsNeeded = 3;

	_schedule = new ArrayList<Period>();
	_schedule.add( new P1() );
	_schedule.add( new P2() );
	
    }
    
    

}//end class RegStudent
