/*====================================                                                  
  class HonStudent extends RegStudent                                                                  
  ====================================*/

import java.util.ArrayList;


public class HonStudent extends RegStudent {
    
    public HonStudent() {
	super();
	_creditsNeeded += 3;

	_schedule.add( new P4() );
	_schedule.add( new P5() );
	_schedule.add( new P6() );
	_schedule.add( new P7() );
	
    }
    
}//end class HonStudent
