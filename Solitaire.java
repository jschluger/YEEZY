/*====================================                                     
  class Solitaire --  implements the card game solitaire

  implements the game interface(sike not really)
  
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public class Solitaire {
    
    //instance vars
    //the deck of cards not yet used
    ArrayList<Card> _deck = new ArrayList<Card>();
    //the piles of cards that you usually play with
    ArrayList<ArrayList <Card> > _piles = new ArrayList<ArrayList <Card> >();
    //the place where you finish the game (starting with aces)
    ArrayList<ArrayList <Card> > _final = new ArrayList<ArrayList <Card> >();
    //where in the deck you are, points to the card from the deck being delt
    int _currentPos;

    
    //constructor
    public Solitaire() {
	//populate the deck
	String[] temp = {"H","D","S","C"};
	for (String s : temp)
	    for (int n = 1; n <= 13; n++)
		_deck.add( new Card(s,n) );
	shuffle(_deck);

	//set up the deck
	for (int i = 0; i < 7; i++){
	    _piles.add( new ArrayList <Card>() );
	    //add this many cards and leave them face down
	    for (int j = 0; j < i; j++){
		_piles.get(i).add( _deck.get(0) );
		_deck.remove(0);
	    }
	    //add one more card flip it
	    _piles.get(i).add( _deck.get(0) );
	    _piles.get(i).get(i).flip();
	    _deck.remove(0);
	}
	for (int i = 0; i < 4; i++){
	    _final.add( new ArrayList <Card>() );
	}

	_currentPos = 0;
	topCard().flip();
    }

    //randomly rearrange elements of an ArrayList
    //taken from skelatin for various sorts
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    
    //toString
    public String toString() {
	String s;
	s = "d:\tDECK\n";
	s += "n:\t" + topCard() + "\n\n";
	for (int i = 0; i < _final.size(); i++) {
	    s+= i + ":\t" + showPile( _final.get(i) );
	}
	s += "\n";
	for (int i = 0; i < _piles.size(); i++) {
	    s+= (i + 4) + ":\t" + showPile( _piles.get(i) );
	}
	s+= "\t 0  1  2  3  4  5  6";
	return s;
    }

    //returns a string form of one pile
    public String showPile(ArrayList<Card> a) {
	String s = "";
	if ( a.size() == 0 ) return "EMPTY\n";
	
	for (int i = 0; i < a.size(); i++) {
	    s += a.get(i) + " ";
	}
	s += "\n";
	return s;
    }

    //returns the card that has been delt
    public Card topCard() {
	return _deck.get( _currentPos );
    }
    
    //picks where the card you will move is
    //returns selected pile
    public Card pickOrigin() {
	
	System.out.println(this);	
	System.out.print("move some cards from pile...: ");
	String pile = Keyboard.readString();
	int pileI = -1;
	try {
	    pileI = Integer.parseInt(pile);
	}
	catch (NumberFormatException e){}

	if (pile.equals("d")) {
	    dealCard();
	    System.out.println("\nDELT. PICK AGAIN!!: \n");
	    return pickOrigin();
	}
	else if ( pile.equals("n") ) return topCard();

	System.out.print(" ...card: ");
	
	int card = Keyboard.readInt();
	
	if ( pileI > 0 && pileI < 4 &&
	     _final.get(pileI).size() > 0
	     && card < _final.get(pileI).size()
	     && card > 0 
	     && _final.get(pileI).get(card).getFaceUp()
	     )
	    return _final.get(pileI).get(card);
	
	else if ( pileI > 3 && pileI < 11 &&
		  _piles.get(pileI - 4).size() > 0
		  && card < _piles.get(pileI - 4).size()
		  && card > 0 
		  && _piles.get(pileI - 4).get(card).getFaceUp()
		  )
	    return _piles.get(pileI - 4).get( card);
	
	else {
	    System.out.println("\nBAD CHOICE. PICK AGAIN: \n");
	    return pickOrigin();

	}
    }
    /*
    //picks where you will move a chosen card too and moves it there
    //first checking if it is a valid move
    public void makeMove(Card choice) {
	System.out.print("to the top of pile ...: ");
	int location = Keyboard.readInt();
	if dest = 
	    
	    if (isValidMove(Card choice, Card dest)) return;
	*/
    public void playTurn() {
	//Card choice = pickOrigin() ;
	//makeMove(choice)
	System.out.println(pickOrigin());
	
    }
    
    //deals one card, putting the prevously delt card back at the "bottom" of the deck
    public void dealCard() {
	topCard().flip();
	_currentPos++;
	topCard().flip();

    }
    
    public static void main(String[] args) {
	Solitaire s = new Solitaire();
	
	s.playTurn();
    }

}//end class Solitaire
