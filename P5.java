/*=====================================                                     
  class P5 -- period 5!
  
  ====================================*/

public class P5 extends Period {
    
    public P5() {
	_maxCredits = 1;
    }

    public int scenario() {
	
	System.out.println("\nYou run up the stairs, full of energy from your lunch! You arrive just on time to your math class, taught by Mr. Sterr!");

	System.out.println("\nMr. Sterr: Hello class. Today we are going to derive a solution to Fermat's last theorem: If we have three positive integers a, b, and c, then...");

	String s1,s2,s3,s4,s5,s6;
	int c1,c2,c3,c4,c5,c6;
	String[] a1,a2,a3,a4;

	s1 = "use a game to help us understand the problem";
	s2 = "stop learning math because it is boring";
	System.out.println("\nYou: I have a suggestion! I think we should...");
	c1 = Stuy.choose( new String[] {s1,s2} );

	if (c1 == 1) {
	    System.out.println("\nMr. Sterr: What game do you think will help us prove this theorem?");

	    System.out.println("\nYou: Ummmmmmm");
	    pause();
	    System.out.println("You: We could play solitaire!");

	    System.out.println("\nMr. Sterr: I do not think that will help us.");
	    System.out.println("\nYou: Hmmmmmm");
	}
	else if (c1 == 2) {
	    System.out.println("\nMr. Sterr: That is a very rude thing to say. Please stop distracting the class");

	    System.out.println("You: Is there anything I can do other than prove this theorem?");
	}
	
	System.out.println("\nMr. Sterr: If you are only going to disrupt the class, why don't you just go sit in the corner and play a game of solitaire quietly. I will grade you based on how you do");

	System.out.println("\nYou: Sure thing!");
	
	int score;
	score = Solitaire.play();
	
	if (score == 0) {
	    System.out.println("\nMr. Sterr: Hmm, you seem to have doon pretty poorly. Maybe you should have just payed attention to the class like everyone else. You get 0 credits for this class.");
	}
	else if (score == 1) {
	    System.out.println("\nMr. Sterr: Hmm, you didn't do so well. Maybe if you study solitaire you can improve one day. You get 1 credit for this class.");
	}
	else if (score == 2) {
	    System.out.println("\nMr. Sterr: You made it half way there. Maybe solitaire is not for you. Stick to math. You get 2 credits for this class.");
	}
	else if (score == 3) {
	    System.out.println("\nMr. Sterr: Almost a perfect game. Mabye solitaire is a good choice for your future. You get 3 credits for this class.");
	}
	else if (score == 4) {
	    System.out.println("\nMr. Sterr: Well, you won the game. Even if you are bad at math, at least you are good at solitaire. You get 4 credits for this class.");
	}
	
	return score;
    }//end scenario

    public static void main(String[] args) {
	Period p = new P5();
	p.scenario();
    }
}//end class P5
