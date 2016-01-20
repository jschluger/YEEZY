/*====================================                                                  
  class RegStudent extends Character                                                                        
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;


public class RegStudent extends Character {
    
    public RegStudent() {
	_schedule = new ArrayList<Period>();
	_schedule.add( new P1() );
	
    }
    
    

}//end class RegStudent
