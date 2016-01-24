/*=====================================                                    
  class P3 -- period 3!
  
  ====================================*/

public class P3 extends Period {
    
    public P3() {
	_maxCredits = 1;
    }

    //wrapper function for all that will happen during each period
    public int scenario() {
	System.out.println("\nThe bell has rung! It's time to go to Physical Education. Quick, run down to the 5th floor\n");
	
	System.out.println("How do you want to get to class?");
	String s1 = "Take the stairs";
	String s2 = "Take the escalators";
	
	int c1 = Stuy.choose( new String[] {s1,s2} );
	
	int c2;
	int c3 = 0;
	int c4;

       
	if (c1 == 1) {
	    System.out.println("\nYou make it to class early but it seems like you have already completed your workout for today. You're yearning for water, but the water fountains in the fifth floor are not working.");
	    System.out.println("\nYou: Mr. Galano (Phys. Ed Teacher), can I go to the 6th floor for a drink of water?");
	    System.out.println("\nMr. Galano: Missing my class to go quench your thirst? I want to see you sweating first! Quick, change your clothes and run the perimeter!");
	    System.out.println("\n*thinking* hmmm what should I do...");
	    s1 = "Yes, of course Mr. Galano";
	    s2 = "I can't, I have to go drink some water";
	    
	    c2 = Stuy.choose( new String[] {s1,s2} );
	    while (c2 == 2) {
		System.out.println("\nYou already have three missed classes. One more will result in complete failure. You don't want to fail your PE class!\n\nMr. Galano: What did I just hear?!\n\nPick again: ");
		c2 = Stuy.choose( new String[] {s1,s2} );
	    }
	    if (c2 == 1) {
		System.out.println("\nMr. Galano: Perfect! That's what I expect to hear from a scholar athelete like you. I know a quick way to quench your thirst! Since you have a math test today, you will only be marked prepared in my class if you are able to complete this KenKen board!");
		System.out.println("\nYou: Thank you...");
		
	    }
	    
	}
	
	else if (c1 == 2) {
	    System.out.println("\nThe escalators are surprisingly working now. Unfortunately, you skip a step and fall down the rest of the escalator.");
	    
	    System.out.println("\nAs you limp in to the locker rooms...");
	    System.out.println("\nMr. Galano: What happened to your leg? Can't you walk like a homo sapien sapien?");

	    System.out.println("\nHow are you gonna handle this one?");
	    s1 = "walk it off";
	    s2 = "ask for a pass to the Nurse's office";
	    
	    c3 = Stuy.choose( new String[] {s1,s2} );
	    if (c3 == 1) {
		System.out.println("\nYou: I'm just a little tired from all this weight on my shoulders. Don't worry, I'll be ready just in time!");
		System.out.println("\nMr. Galano: Tired? I know how to fix that. To increase the pressure, I will only mark you prepared if you are able to finish this KenKen board. Get your mind thinking and your body active!");
	    }
	    else if (c3 == 2) {
		System.out.println("\nYou: I think I twisted my ankle when I fell off the escalator. I need a note for the Nurse's office please.");
		System.out.println("\nMr. Galano: Alright, make sure you get that fixed ASAP. Feel better!");
		System.out.println("\nAfter much difficulty, you make your way to the Nurse's office.");
		pause();
		System.out.println("\nNurse: Hi honey, what brings you here today?");
		System.out.println("\nYou: I sprained my ankle today, as I tried to rush down the escalator.");
		System.out.println("\nNurse: Oh I'm so sorry! Where's your note?");
		System.out.println("\nYou have misplaced your note while limping to the Nurse's office!");
		pause();
		System.out.println("\nYou: I don't have it, I'm sorry!");
		System.out.println("\nNurse: If that is the case, the only way I will be able to treat you is if you are able to complete this KenKen board!");
		s1 = "Okay";
		s2 = "Why?";

		c4 = Stuy.choose( new String[] {s1,s2} );
		while (c4 == 2) {
		    System.out.println("\nNurse: You dare ask why? Think again youngster...");
		    c4 = Stuy.choose( new String[] {s1,s2} );
		}
		if (c4 == 1) {
		    System.out.println("\nNurse: Great let's begin!");
		}
	    }
	}

	// ready to play, same point
	
	if ( KenKen.play() ) {
	    // individual responses

	    if (c1 == 1) {
		System.out.println("\nMr. Galano: Great work! Look! You're not thirsty anymore! Now you are marked prepared!");
	    }
	    else if (c3 == 1) {
		System.out.println("\nMr. Galano: Terrific! You get one credit for attending class and you look like you have overcome your fatigue!");
	    }
	
	    else {
		System.out.println("\nNurse: Time to get you checked up! And don't worry, I told Mr. Galano to give you a credit for attending class already!");
	    }

	    return _maxCredits;
	}
	// game lost
	else {

	    if (c1 == 1 || c3 == 1) {
		System.out.println("\nMr. Galano: Failure! Seems like you're failing PE...");
	    }
	    else {
		System.out.println("\nNurse: No note, no treatment! Seems like you used this period to miss class. Failure!");
	    }
	    
	    return 0;
	}

    }
    
} // end class P3
