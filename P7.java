/*=====================================                                     
  class P7 -- period 7!
  
  ====================================*/

public class P7 extends Period {
    
    public P7() {
	_maxCredits = 1;
    }
    
    public int scenario() {

	System.out.println("\nYou sprint down the stairs and into the hidden hallway to find room 251, your CS class. You sit down quietly at your desk and look up at the board: ");
	
	System.out.println("\n*Board*\n\tAim: Reflect, look ahead\n\tDN: Think about a potential final project.");


	String s1,s2,s3,s4,s5,s6;
	int c1,c2,c3,c4,c5,c6;
	String[] a1,a2,a3,a4;
	
	s1 = "Work on the Do Now";
	s2 = "Turn on your computer and start working";
	
	System.out.println("\nWhat do you do?");
	c1 = Stuy.choose( new String[] {s1, s2} );

	if (c1 == 1) {
	    System.out.println("\nYou write in your notebook for a few minutes");
	    pause();
	}
	else if (c1 == 2) {
	    System.out.println("\nYou wait for your computer to load for a few minutes");
	    pause();
	}
	System.out.println("\nMr. Brown: Okay class, today we have a lot to do. But first, lets go over the Do Now!");

	System.out.println("\nJackson: Well um this might be right, but I think a final project is some type of project that we do at the end of a class or something like that");
	System.out.println("\nMr. Brown: Sure, one could say that");

	System.out.println("\nYou: But Mr. Brown, today is the last day of class! When will we have time to do our projects?");

	System.out.println("\nMr. Brown: I know it's short notice, but I think you all should be able to finish by the deadline of 8 AM tomorrow morning. You are Stuyvesant students after all.");

	System.out.println("\nHow do you respond?");
	s1 = "Accept the challenge";
	s2 = "Freak out because you have less than 24 hours to complete a final project";
	c2 = Stuy.choose( new String[] {s1,s2} );

	if (c2 == 1) {
	    System.out.println("\nYou: I accept this challenge!");
	}
	else if (c2 == 2) {
	    System.out.println("\nYou: What am I going to do? There is no way I will be able to do a good job!");
	}
	System.out.println("\nMr. Brown: Lets look at some of the guidelines first: ");

	System.out.println("\n*board*\nGuidelines:\n\t*Solidify: Use this project as an opportunity to revisit concepts you struggled with during the term.\n\t*Showcase: Your project should incorporate each major topic/tool we’ve covered this term in an integral manner.\n\t*Stretch: Ideally, your project should also be a chance to explore something new, to teach yourself a thing or two that we have not covered this term. First 2 S’s take precedence.\n\t*Your project should take the grader (yours truly) at least 10 minutes to “digest.”\n\t*Graphics? What graphics? Ain't nobody got time for that.");

	System.out.println("\n*thinking*");
	pause();
	if (c2 == 1) {
	    System.out.println("\nYou: This seems harder than I first thought.");
	}
	else if (c2 == 2) {
	    System.out.println("\nYou: This seems even harder than I thought! There's no way I will be able to do this by tomorrow morning!");
	}

	System.out.println("\nMr. Brown: There is one other option. I usually don't like to resort to this, but I would rather see you do a good job on this than hand in a bad final project. ");

	System.out.println("\nHow do you respond?");
	s1 = "What is the other option?";
	s2 = "But what about our final projects?";
	c3 = Stuy.choose( new String[] {s1,s2} );
	if (c3 == 1) {

	}
	else if (c3 == 2) {
	    System.out.println("\nMr. Brown: Don't wory about it");
	    System.out.println("\nYou: If you say so. What is the other option?");
	}

	System.out.println("\nMr. Brown: Instead of a final project, I will grade you based on how well you can play the game 2048. Good luck");

	System.out.println("\nYou: I accept!");

	int score;
	score = T048.play();

	if (score == 0) System.out.println("\nMr. Brown: What a shame. You seem to have failed. 0 credits for you.");
	if (score == 1) System.out.println("\nMr. Brown: You did alright. You get 1 credit.");
	if (score == 2) System.out.println("\nMr. Brown: You almost made it. You get 2 credits.");
	if (score == 3) System.out.println("\nMr. Brown: Well, now I know that you are a champion at 2048. Those skills probably transfer over to CS. You get 3 credits.");
	
	return score;
    }//end scenario()

    public static void main(String[] args){
	Period p = new P7();
	System.out.println( p.scenario() );
    }
    
}//end class P7
