/*====================================                                     
  class Character 
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public abstract class Character {
    
    protected ArrayList<Period> _schedule;
    //number of credits needed for each character type to graduate
    protected int _creditsNeeded;
    
    //returns an instance of the period that the student has at the nth spot in their schedual 
    public Period getPeriod(int n) {
	return _schedule.get(n - 1);
    }

    public int scheduleLength() {
	return _schedule.size();
    }

    public int getCreditsNeeded() {
	return _creditsNeeded;
    }

} //end class Character
