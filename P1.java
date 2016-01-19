/*=====================================                                     
  class P1 -- the first period of the day
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public class P1 extends Period {
    
    
    
    //wrapper funciton for all that will happen during each period
    public void scenario(){
	System.out.println("\nAs you run up the stairs to the fifth floor, you hear the bell ring. You burst into Spanish class and hear Senor Simon yell, 'Por que estas tarde chico? Aye, donde era?'\n");

	System.out.println("Your response: ");
	String s1 = "The 7 train was delayed again!";
	String s2 = "I overslept";
	int c1 = Stuy.choose( new String[] {s1,s2} );
	if (c1 == 1) {
	    System.out.println("\nSenor Simon: El 7 train es muy malo. Please come to class on time chico!" );
	}
	else if (c1 == 2) {
	    System.out.println("\nSenior Simon: Minus 50 points from your next test! No sleep ever!");
	}
	
	System.out.println("\n... Exausted from running up the stairs all the way to the fifth floor, you become drowsy. What do you do?");
	s1 = "Take a nap.";
	s2 = "Raise your hand to stay awake";
	int c2 = Stuy.choose( new String[] {s1,s2} ); 

	int c3;
	if (c2 == 1) {
	    System.out.println("\nYou fall drift off to sleep\n.\n.\n.\n*softly* chico\n\n*louder* Chico\n\n*SCREAMING*CHICO WAKE UP, DO NOT SLEEP IN MY CLASS\n");

	    System.out.println("Your response: ");
	    s1 = "I am so sorry senor. It will never happen again.";
	    s2 = "Fall back asleep";
	    
	    c3 = Stuy.choose( new String[] {s1,s2} );

	    if (c3 == 1) {
		System.out.println("\nSenor Simon: Why don't you come up to the board and play a game of TicTacToe to redeem your self. If you beat me, you can pass this class. If I win, you fail.\n");
	    }
	    else if (c3 == 2) {
		System.out.println("\nSenor Simon: No sleeping chico! Why don't you come up to the board and play a game of TicTacToe to stay awake. If you beat me, you can pass this class. If I win, you fail.\n");
	    }
	    
	}
	else if (c2 == 2) {
	    System.out.println("\nSenor Simon *calls on you*: Why don't you come up the the board and play a game of TicTacToe. If you beat me, you can pass this class. If I win, you fail.\n");
	}
	
	TicTacToe.play();

    }
    
    public static void main(String[] args) {
	Period p = new P1();
	p.scenario();
    }
    
    
    
} //end class Period
