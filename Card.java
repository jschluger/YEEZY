/*==================================== 
  class Card --  creates a card to be used in Solitiare or other card games

  ====================================*/

public class Card {
    
    //instance vars
    private String _suit; //will be H D S or C
    private int _num; // range from 1 (ace) to 13 (king)
    private boolean _faceUp;
    
    //default constructor
    public Card() {
	_suit = "D";
	_num = 2;
	_faceUp = false;
    }
    
    //the useful constructor
    public Card(String suit, int num) {
	_suit = suit;
	_num = num;
	_faceUp = false;
    }
    
    //toString
    public String toString() {
	String s = "\033[107m"; //white background
	//if a card is face down
	if (! _faceUp) s+= "\033[1;34m||";
	
	else {
	    if (_suit.equals("H") ) s+= "\033[1;31m";
	    else if (_suit.equals("D") ) s+= "\033[1;31m";
	    else if (_suit.equals("C") ) s+= "\033[1;30m";
	    else if (_suit.equals("S") ) s+= "\033[1;30m";

	    //else
	    if (_num == 1) s+= "A" + _suit; 
	    else if (_num == 11) s+= "J" + _suit; 
	    else if (_num == 12) s+= "Q" + _suit; 
	    else if (_num == 13) s+= "K" + _suit; 
	    else s+= _num + _suit;
	}
	s += "\033[0m";
	
	return s;
    }

    /////////accessors//////////////////
    public String getSuit() {
	return _suit;
    }

    public int getNum() {
	return _num;
    }

    //returns R for red and B for black
    public String getColor() {
	if ( _suit.equals("D") || _suit.equals("H") ) return "R";
	else return "B";
    }

    public boolean getFaceUp() {
	return _faceUp;
    }
    
    //flips the card
    public void flip() {
	_faceUp = ! _faceUp;
    }




	
}//end class Card
