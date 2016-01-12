/*====================================                                     
  class Solitaire --  implements the card game solitaire

  implements the game interface(sike not really)
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public class Solitaire {
    
    //instance vars
    ArrayList<Card> _deck = new ArrayList<Card>();
    
    //constructor
    public Solitaire() {
	//populate the deck
	String[] temp = {"H","D","S","C"};
	for (String s : temp)
	    for (int n = 1; n <= 13; n++)
		_deck.add( new Card(s,n) );

    }

    
    public static void main(String[] args) {
	Solitaire s = new Solitaire();
	System.out.println(s._deck);
    }

}//end class Solitaire
