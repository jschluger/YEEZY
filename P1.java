/*=====================================                                     
  class P1 -- period 1!
  
  ====================================*/

public class P1 extends Period {
    
    public P1() {
	_maxCredits = 1;
    }

    //wrapper function for all that will happen during each period
    public int scenario(){
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
	
	System.out.println("\n... Exhausted from running up the stairs all the way to the fifth floor, you become drowsy. What do you do?");
	s1 = "Take a nap.";
	s2 = "Raise your hand to stay awake";
	int c2 = Stuy.choose( new String[] {s1,s2} ); 

	int c3;
	if (c2 == 1) {
	    System.out.println("\nYou drift off to sleep");
	    pause();
		System.out.println("*softly*Mr. Simon: chico\n\n*louder*Mr. Simon: Chico\n\n*SCREAMING*Mr. Simon: CHICO WAKE UP, DO NOT SLEEP IN MY CLASS\n");

	    System.out.println("Your response: ");
	    s1 = "I am so sorry senor. It will never happen again.";
	    s2 = "Fall back asleep";
	    
	    c3 = Stuy.choose( new String[] {s1,s2} );

	    if (c3 == 1) {
		System.out.println("\nSenor Simon: Why don't you come up to the board and play a game of TicTacToe to redeem yourself. If you beat me, you can pass this class. If I win, you fail.\n");
	    }
	    else if (c3 == 2) {
		System.out.println("\nSenor Simon: No sleeping chico! Why don't you come up to the board and play a game of TicTacToe to stay awake. If you beat me, you can pass this class. If I win, you fail.\n");
	    }
	    
	}
	else if (c2 == 2) {
	    System.out.println("\nSenor Simon *calls on you*: Why don't you come up the the board and play a game of TicTacToe. If you beat me, you can pass this class. If I win, you fail.\n");
	}
	
	if ( TicTacToe.play() ) {
	    System.out.println("\nSenor Simon: Aye chico, now you can pass this class! Maybe you will graduate afterall!");
	    
	    return _maxCredits;
	}
	else {
	    System.out.println("\nSenor Simon: Aye chico, you fail. I see summer school in your future if you don't step up your game ...");

	    return 0;//no points earned
	}
	
    } 
    
} // end class Period
