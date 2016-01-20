/*====================================                                     
  class Character 
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public abstract class Character {
    
    protected ArrayList<Period> _schedule;
    
    //returns an instance of the period that the student has at the nth spot in their schedual 
    public Period getPeriod(int n) {
	return _schedule.get(n - 1);
    }

    public int scheduleLength() {
	return _schedule.size();
    }
    

} //end class Character
