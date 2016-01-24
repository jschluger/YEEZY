/*=====================================                                     
  class P2 -- period 2!
  
  ====================================*/

public class P2 extends Period {
    
    public P2() {
	_maxCredits = 1;
    }

    //wrapper function for all that will happen during each period
    public int scenario(){
	System.out.println("\nBEEEEEEEEEEEEEEEB. Time to go to your next class! Looks like you have a physics lab today! Time to head up the the 8th floor!\n");
	
	System.out.println("How do you want to get to class?");
	String s1 = "Take the stairs";
	String s2 = "Take the escalators";
	String s3 = "Take the elevator";
	String s4, s5, s6;
	
	int c1 = Stuy.choose( new String[] {s1,s2,s3} );
	
	int c2, c3, c4, c5, c6;

	
	if (c1 == 1) {
	    System.out.println("\nYou make it to class 15 minutes early (despite passing being only 5 minutes long), but completely out of breath. As you enter your physics lab you are gasping so hard for air that you accidentally knock over the lab setup, ruining the lab!");
	    System.out.println("\nMr. Wang: Why did you knock over the lab setup?");
	    System.out.println("\n*thinking* hmmm. What should I do?");
	    s1 = "Vow never to take the stairs again";
	    s2 = "Use your accumulated physics knowledge to rebuild the lab";
	    s3 = "Apologize";

	    c2 = Stuy.choose( new String[] {s1,s2,s3} );
	    while (c2 == 2) {
		System.out.println("\nYou immediately fail, because you have no physics knowledge.\n\nMr Wang: Minus one!\n\nPick again: ");
		c2 = Stuy.choose( new String[] {s1,s2,s3} );
	    }
	    if (c2 == 1) {
		System.out.println("\nYou: The reason I have broken the lab is because I was completely winded from taking the stairs all the way from the 5th floor. I vow never to take the stairs again, for as long as I attend Stuyvesant High School!");
		System.out.println("\nMr. Wang: Minus one!");
		
	    }
	    else if (c2 == 3) {
		System.out.println("\nYou: I am so sorry for breaking the lab Mr. Wang. I promise to master the art of physics in honor of this broken lab that I have destroyed. Please accept my apology");
		System.out.println("\nMr. Wang: Minus one!");
	    }

	    System.out.println("\nMr. Wang: Because the lab is broken, no one can do the lab today!");
	    
	}
	else if (c1 == 2) {
	    System.out.println("\nThe escalators are so delayed that you miss the entire first period of your double period lab. ");
	    
	    System.out.println("\nAs you walk in at the start of the second of the two periods ...");
	    System.out.println("Mr. Wang: Where is your late pass?");

	    System.out.println("\nHow are you gonna handle this one?");
	    s1 = "lie";
	    s2 = "be truthful";
	    
	    c3 = Stuy.choose( new String[] {s1,s2} );
	    if (c3 == 1) {
		System.out.println("\nYou: The 7 train was delayed again");
		System.out.println("\nMr Wang: I ride the 7 train, and there were no delays today! You are lying! Minus one!");
	    }
	    else if (c3 == 2) {
		System.out.println("\nYou: I was stuck on the escalators");
		System.out.println("\nMr. Wang: That is a lie. Minus one!");		
	    }

	    System.out.println("\nMr. Wang: Also, you are so late that you cannot participate in today's lab!");
	}
	else if (c1 == 3) {
	    System.out.println("\nAs the doors for the elevator open, you see none but SENOR SIMON waiting in the elevator!");
	    System.out.println("\nYou: Senor, how did you get out of class so quickly?");
	    System.out.println("\nSenor Simon: Chico. You know that students cannot ride the elevators. You must come down to my office right now so that you can think about what you have done.");
	    
	}

	System.out.println("\nYou: Is there anything I can do instead of my lab to get credit for today's lab?");

	if (c1 == 3) {
	    System.out.println("\nSenor Simon: If you can beat me in a game of connect 4, I will let you go to your lab and learn physics!");

	    System.out.println("\nYou: That only seems fair");
	}
	else {
	    System.out.println("\nMr. Wang: According to the regents curriculum, connect 4 counts as an offical state physics lab. If you can beat me in a game, you will get credit for today's lab");

	    System.out.println("\nYou: What does this have to do with physics?");
	    System.out.println("\nMr. Wang: shhh\n");
	    
	}
       
	if ( Connect4.play() ) {
	    if (c1 == 3) {
		System.out.println("\nSenor Simon: Aye chico, you have beat me. Just make sure you stay out of the elevators!");
	    }
	    else {
		System.out.println("\nMr. Wang: Very good! Now you get credit for todays lab!");
	    }

	    return _maxCredits;
	}
	else {

	    if (c1 == 3) {
		System.out.println("\nSenor Simon: Aye chico, you have failed. No credit for you!");
	    }
	    else {
		System.out.println("\nMr. Wang: You have failed! No credit!");
	    }
	    
	    return 0;
	}

    }
    
} // end class P2
