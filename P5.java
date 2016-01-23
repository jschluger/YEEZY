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
























	return 0;
    }//end scenario

    public static void main(String[] args) {
	Period p = new P5();
	p.scenario();
    }
}//end class P5
