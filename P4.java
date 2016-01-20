/*=====================================                                     
  class P4 -- period 4!
  
  ====================================*/

public class P4 extends Period {
    
    public P4() {
	_maxCredits = 1;
    }

    //wrapper function for all that will happen during each period
    public int scenario(){

	System.out.println("\nIt's time for lunch! You walk down to the second floor, and wait for your pals to go eat!");

	System.out.println("\n*one pal arives*");
	
	System.out.println("Jackson (pal): Howwdy. Where should we go to lunch today?");
	
	System.out.println("\nYour response: ");

	String s1, s2, s3, s4, s5, s6;
	int c1, c2, c3, c4, c5, c6;
	String[] a1, a2, a3, a4, a5, a6;

	    
	s1 = "We should wait for our other pal, Evan";
	s2 = "Lets go out now without waiting for Evan. Evan smells bad.";
	c1 = Stuy.choose( new String[] {s1,s2} );


	if (c1 == 1) {
	    System.out.println("\nJackson: Yes we should!");
	    pause();
	    System.out.println("\n*Evan walks over*\nEvan: Where should we eat for lunch today!?");
	    System.out.println("\nWhere do you want to eat? ");
	    s1 = "Ferrys";
	    s2 = "Halal";
	    s3 = "Zuckers";
	    s4 = "Terrys";
	    a1 = new String[] {s1,s2,s3,s4};
	    
	    c2 = Stuy.choose( a1 );
	    System.out.println("\nYou: Let's eat at " + a1[c2 - 1] );
	    
	    while (c2 == 4) {
		System.out.println("\nEvan: Why would anyone ever go to Terrys? It is quite possible the worst place ever! They even charge tax!");
		System.out.println("\nJackson: Geez!");
		
		System.out.println("\nPick again: ");
		c2 = Stuy.choose( new String[] {s1,s2,s3,s4} );
		System.out.println("\nYou: Let's eat at " + a1[c2 - 1] );
	    }
	    
	}
	
	else { //(c2 == 2)
	    System.out.println("\nJackson: Hmm. I actually don't have a nose so I have no idea how Evan smells, but I'll take your word for it! Where do you want to go for lunch!?");
	    System.out.println("\nWhere do you want to eat? ");
	    s1 = "Ferrys";
	    s2 = "Halal";
	    s3 = "Zuckers";
	    s4 = "Terrys";
	    a1 = new String[] {s1,s2,s3,s4};
	    
	    c2 = Stuy.choose( a1 );
	    System.out.println("\nYou: Let's eat at " + a1[c2 - 1] );

	    while (c2 == 4) {
		System.out.println("\nJackson: NO TERRYS. NEVER!");

		System.out.println("\nPick again: ");
		c2 = Stuy.choose( new String[] {s1,s2,s3,s4} );
		System.out.println("\nYou: Let's eat at " + a1[c2 - 1] );
	    }
	    
	}
	//where you eventually decide to go for lunch
	String lunchDest = a1[c2 - 1];
	
	System.out.println("\nJackson: " + lunchDest + " it is!");

	System.out.println("\n*You walk towards " + lunchDest + "*");

	if (c1 == 2) {//you left evan
	    System.out.println("\nAs you walk, you hear evan running up behind you!");
	    System.out.println("\nEvan: WAAAIT for MEEEEEEEE");

	    System.out.println("\nJackson: Let's wait for Evan");
	    s1 = Stuy.ask("\nSay something to Evan to tell him to hurry up");
	    System.out.println("\nYou: " + s1.toUpperCase() + "!!!");

	    System.out.println("\nEvan catches up just as you walk in the door of " + lunchDest);
	    System.out.println("\nEvan: I made it! Thanks for waiting!");

	    System.out.println("\n*thinking*You: Evan smells bad");
	}
	
	//System.out.println();









	/*
	if (c2 == 1) {
	    System.out.println("\nJackson: Ferrys it is!");
	    System.out.println("");
	}
	else if (c2 == 2) {
	    System.out.println("\nJackson: Halal it is!");
	}
	else if (c2 == 3) {
	    System.out.println("\nJackson: Zuckers it is!");
	}
	*/




		 
    















	return 0;
    }


    public static void main(String[] args) {
	Period p = new P4();
	p.scenario();
    }

}//end class P4
