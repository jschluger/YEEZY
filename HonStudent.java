/*====================================                                                  
  class HonStudent extends RegStudent                                                                  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;


public class HonStudent extends RegStudent {
    
    public HonStudent() {
	super();
	_creditsNeeded += 2;

	_schedule.add( new P4() );
	//_schedule.add( new P5() );
	
    }
    
}//end class HonStudent
