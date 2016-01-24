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
	    System.out.println("As you walk, you hear Evan running up behind you!");
	    System.out.println("\nEvan: WAAAIT for MEEEEEEEE");

	    System.out.println("\nJackson: Let's wait for Evan");
	    s1 = Stuy.ask("\nSay something to Evan to tell him to hurry up");
	    System.out.println("\nYou: " + s1.toUpperCase() + "!!!");

	    System.out.println("\nEvan catches up just as you walk in the door of " + lunchDest);
	    System.out.println("\nEvan: I made it! Thanks for waiting!");

	    System.out.println("\n*thinking*You: Evan smells bad");
	}
	
	//at this point you are with both evan and jackson, regardless of earlier choices
	
	System.out.println("\nYou get on the line at " + lunchDest + " and wait to place your order");
	pause();
	System.out.println("You have reached the front of the line! What do you want to eat?\n");
	s1 =  "Baconeggandcheeseavacadochipotleonaroll";
	s2 = "Combo over rice, no salad";
	s3 = "Toasted everything bagel with lox spread";
	a2 = new String[] {s1, s2, s3};
	
	c3 = Stuy.choose( a2 );

	while (c3 != c2) {//you picked the wrong option
	    System.out.println("\n" + lunchDest + " Worker: Sorry, we don't have the " + a2[c3 - 1] + " here. Maybe they have that at " + a1[c3 - 1] + ". What else would you like to eat?\n");
      
	    c3 = Stuy.choose( a2 );
	}

	//now you know you picked the right option
	String food = a2[c3 - 1];
	

	System.out.println("\n" + lunchDest + " Worker: Great choice! Why don't you sit down and wait for your food?");
	pause();
	System.out.println("\n" + lunchDest + " Worker: Here is your " + food + "!");

	System.out.println("\nWhat do you want to do with your food?");
	s1 = "Eat it";
	s2 = "Throw it at Evan";

	c4 = Stuy.choose( new String[] {s1, s2} );
	
	if (c4 == 1) {
	    System.out.println("\nWhich hand do you want to use to eat your food?");
	    s1 = "right";
	    s2 = "left";

	    c5 = Stuy.choose( new String[] {s1,s2} );

	    if (c5 == 1) {
		System.out.println("\nYou pick up your " + food + " with your right hand, but you are a lefty so you spill it everywhere! Evan, who is sitting directly adjacent to you, gets covered in your " + food + "!");
	    }
	    else if (c5 == 2) {
		System.out.println("\nYou pick up your " + food + " with your left hand, but you are a righty so you spill it everywhere! Evan, who is sitting directly adjacent to you, gets covered in your " + food + "!");
	    }
	}

	else if (c4 == 2) {
	    System.out.println("\nYou pick up your " + food + ", and throw it directly into Evan's face! ");
	    if(c1 == 1) {
		System.out.println("\nYou: This is for making us wait for you at the begining of the period!");
	    }
	    else if (c1 == 2) {
		System.out.println("\nYou: This is for smelling so bad!");
	    }
	}
	
	System.out.println("\nEvan: GEEZ! Your " + food + " is all over me! What am I going to do!?");
	System.out.println("\nJackson: I'll carry you back to school! Vamanos!");

	System.out.println("\nYou: I am still hungry :(");
	
	System.out.println("\nYou walk back to school with Evan and Jackson. You swipe in just in time, and get ready to go to your next class!");

	return 0;
    }


    public static void main(String[] args) {
	Period p = new P4();
	p.scenario();
    }

}//end class P4
