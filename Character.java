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
	System.out.println("The final bell rings to end your last day of high school. You reminisce over the frendships you've created, and look forward at your bright future...");
	Period.pause();

	System.out.println("Later that night, at the graduation ceremony: ");
	System.out.println("Ms. Zhang: I am proud to announce DJ Khaled as this year's guest speaker!");

	
	System.out.print("\nDJ Khaled: ");
	if ( getCreditsEarned() == getCreditsNeeded() ) {
	    System.out.println("Congratulations! You have earned enough credits to graduate Stuyvesant High School! We the best. Join me on the path to success. Lionnn.");
	}
	else if ( getCreditsEarned() > getCreditsNeeded() ) {
	    System.out.println("You a genius. But you have passed with flying colors. Here is your key to success! Another one.");
	}
	else {
	    System.out.println("They don't want you to succeed. You don't graduate Stuyvesant High School. :( Don't let them put you down. Another one.");
	}
	
    }
    
} //end class Character
