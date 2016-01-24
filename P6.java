/*=====================================                                     
  class P6 -- period 6!
  
  ====================================*/

public class P6 extends Period {
    
    public P6() {
	_maxCredits = 1;
    }

    //wrapper function for all that will happen during each period
    public int scenario(){

	System.out.println("\nAfter saying bye to Mr. Sterr, you have to rush to Health class. You go to class but you realize you forget your health textbook.");

	System.out.println("\nMs. Garber: Why are you late?");
	
	System.out.println("\nYou: But, Ms. Garber, the late bell hasn't rung yet.");
	
	System.out.println("\nMs. Garber: Ok, go take a seat.");
	pause();
	System.out.println("\nMs. Garber: Can you write on the board today for me? We are going to recap everything we learned in class yesterday.");
	System.out.println("\n*thinking...");

	String s1, s2;
	int c1, c2;
	    
	s1 = "We didn't learn anything in class yesterday.";
	s2 = "Sure Ms. Garber!";
	c1 = Stuy.choose( new String[] {s1,s2} );


	while (c1 == 1) {
	    System.out.println("\nMs. Garber: Oh come on. Class, we learned so much yesterday right? Stop trying to trick me!");
	    pause();
	    System.out.println("\n*Mr. Mott enters*\n\nMr. Mott: Ms. Garber, stop forcing the poor kid to write on the board for you. Hey, by the way, do you have some chalk I can use?");
	    System.out.println("\nMs. Garber: Of course, Mr. Mott!");
	    System.out.println("\nMr. Mott: Back in my day, kids always paid attention. Nowadays, no one pays attention, especially in this Health class!");
	    System.out.println("\nMs. Garber: Hey, you still didn't answer my question correctly. Can you write on the board today?");
	    s1 = "But...";
	    s2 = "Okay";

	    c1 = Stuy.choose( new String[] {s1,s2} );
	}
	
	if (c1 == 2) {
	    System.out.println("\nMs. Garber: Awesome, now class, what did we do in class yesterday again?");
	    pause();
	    System.out.println("\n*class stays mute*");
	    //pause();
	    System.out.println("\nMs. Garber: Oh come on, we definitely did something in class yesterday!");
	    System.out.println("\nMs. Garber: Okay... let's just play some health bingo");
	    System.out.println("\n*class remains mute*");
	    System.out.println("\nMs. Garber: Why is this class so quiet everyday. We need some more energy!");
	    System.out.println("\n*Ms.Garber proceeds to dance to some Kanye*\n");
	    pause();
	    System.out.println("\nMs.Garber: Now class, Kanye is on a fat free diet. What essential vitamins is he lacking?");
	    s1 = "Vitamins A, D, E, and K";
	    s2 = "Vitamins B and C";
	    c2 = Stuy.choose( new String[] {s1,s2} );

	    if (c2 == 2) {
		// leading to game initiation
		System.out.println("\nMs. Garber: Not quite... But you know what you can do? Play a game of battleship with me!");
		pause();
		System.out.println("\nYou: Why battleship?!");
		System.out.println("\nMs. Garber: You do want a 100 in this class, no?\n");
	    }

	    else {
		// also leading to game initiation
		System.out.println("\nMs.Garber: Correct! Now you can play this new game of battleship I bought in K-Mart!");
		System.out.println("\nYou: Do I get a 100 in this class if I beat you?");
		System.out.println("\nMs. Garber: If you don't beat me, you're going to be marked late.\n");
	    
	    }
	}
	// at this point, game is ready to begin

	if (Battleship.play()) {
	    System.out.println("Ms. Garber: Wow you got me! Congratulation!");
	    return _maxCredits;
	}

	else {
	    System.out.println("Ms. Garber: You couldn't even find my battleship! Terrible!");
	    return 0;
	}
    }

    public static void main(String[] args) {
	Period p = new P6();
	p.scenario();
    }

}//end class P6
