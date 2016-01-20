/*====================================                                     
  class Character 
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public abstract class Character {
    
    protected ArrayList<Period> _schedule;
    //number of credits needed for each character type to graduate
    protected int _creditsNeeded;

    //is incremented throughout the day
    protected int _creditsEarned;
    
    //returns an instance of the period that the student has at the nth spot in their schedual 
    public Period getPeriod(int n) {
	return _schedule.get(n - 1);
    }

    
    /////////////////////////////////////////////
    //accessors
    public int scheduleLength() {
	return _schedule.size();
    }

    public int getCreditsNeeded() {
	return _creditsNeeded;
    }

    public int getCreditsEarned() {
	return _creditsEarned;
    }
    /////////////////////////////////////////////

    public void playPeriod(int p) {
	_creditsEarned += _schedule.get(p - 1).scenario();
    }

    
    //run after all Periods are run, to see if you won or lost the game
    public void endGame() {
	if ( getCreditsEarned() >= getCreditsNeeded() ) {
	    System.out.println("You graduate!");

	}
	else {
	    System.out.println("You don't graduate");
	}
	
    }
    
} //end class Character
