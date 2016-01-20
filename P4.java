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

	s1 = "We should wait for our other pal, Evan";
	s2 = "Lets go out now without waiting for Evan. I hate Evan.";
	c1 = Stuy.choose( new String[] {s1,s2} );


	if (c1 == 1) {
	    System.out.println("\nJackson: Yes we should!");
	    pause();
	}
	
	else if (c1 == 2) {

	}
    















	return 0;
    }


    public static void main(String[] args) {
	Period p = new P4();
	p.scenario();
    }

}//end class P4
