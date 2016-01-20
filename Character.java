/*====================================                                     
  class Character 
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public class Character {
    
    protected ArrayList<Period> _schedule;

    //returns an instance of the period that the student has at the nth spot in their schedual 
    public Period getPeriod(int n) {
	return _schedule.get(n - 1);
    }
    
    

} //end class Character
