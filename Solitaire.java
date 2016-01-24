/*====================================                                     
  class Solitaire --  implements the card game solitaire

  implements Game interface
  uses Card as data type
  ====================================*/

import cs1.Keyboard;
import java.util.ArrayList;

public class Solitaire implements Game {
    
    //instance vars
    //the deck of cards not yet used
    ArrayList<Card> _deck = new ArrayList<Card>();
    //the piles of cards that you usually play with
    ArrayList<ArrayList <Card> > _piles = new ArrayList<ArrayList <Card> >();
    //the place where you finish the game (starting with aces)
    ArrayList<ArrayList <Card> > _final = new ArrayList<ArrayList <Card> >();
    //where in the deck you are, points to the card from the deck being delt
    int _currentPos;

    int _magicUsed;
    
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
	
	_magicUsed = 0;
    }
    
    //randomly rearrange elements of an ArrayList
    //taken from skeleton for various sorts
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
	s = "D:\tDECK\t\t\t0\t1\t2\t3\n";
	s += "\t" + topCard() + "\t\t\t";

	//final
	for (int i = 0; i < longestSubArrayList(_final); i++) {
	    //for each ArrayList<Card> in _final
	    for (int j = 0; j < _final.size(); j++) {
		if ( i < _final.get(j).size() ) s+= _final.get(j).get(i) + "\t"; 
		else s+= "\t";
	    }
	    
	    s += "\n\t\t\t\t";
	}

	//commands
	s += "\n\t\t\t\t\t\t\t\tSpecial Commands:";
	s += "\n\t\t\t\t\t\t\t\tD -- deal";
	s += "\n\t\t\t\t\t\t\t\tM -- magic! (" + (3 - _magicUsed) + " remaining)";
	s += "\n\t\t\t\t\t\t\t\tE -- exit";
	
	//piles
	s += "\n\n4\t5\t6\t7\t8\t9\t10\n";
	for (int i = 0; i < longestSubArrayList(_piles); i++) {
	    //for each ArrayList<Card> in _final
	    for (int j = 0; j < _piles.size(); j++) {
		if ( i < _piles.get(j).size() ) s+= _piles.get(j).get(i) + "\t"; 
		else s+= "\t";
	    }
	    s += "\n";
	}
	s+= "\n\n";
	return s;
    }

    //returns the longest length subArrayList in an ArrayList, for printing purposes
    public int longestSubArrayList(ArrayList <ArrayList<Card>> a) {
	int max = 0;
	for (int i = 0; i < a.size(); i++) {
	    if ( a.get(i).size() > max ) max = a.get(i).size();
	}
	return max;
    }
    
    
    //returns a string form of one pile horozontally
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
	if (_deck.size() > 0)
	    return _deck.get( _currentPos );
	else return null;
    }
    
    //deals one card, putting the prevously delt card back at the "bottom" of the deck
    public void dealCard() {
	if ( _deck.size() > 0 ){
	    topCard().flip();
	    _currentPos++;
	    if (_currentPos == _deck.size() ) _currentPos = 0;
	    topCard().flip();
	}
	
    }
    
    //picks where the card you will move is
    //returns int[] in the form {chosen pile, chosen card} if it is valid
    //where pile cooresponds to the pile ##s as numbered on the board
    public int[] pickOrigin() {
	int[] empty = new int[0];
	System.out.print("Pick up card ...: ");
	String target = Keyboard.readString();
	if (target.equals("E")) {
	    return empty;
	}
	else if (target.equals("D")) {
	    dealCard();
	    System.out.println("\nDELT. PICK AGAIN!! \n");
	    System.out.println(this);
	    return pickOrigin();
	}

	else if (target.equals("M")) {
	    magic();
	    System.out.println("\nMAGICCCCCC! \n");
	    System.out.println(this);
	    return pickOrigin();
	}
	
	else return linSearch(target);
    }


    public int[] linSearch(String target) {
	if ( target.equals(topCard().toString()) ) return new int[] {-1, _currentPos};

	for (int r = 0; r < _final.size(); r++) {
	    for (int c = 0; c < _final.get(r).size(); c++){
		if ( target.equals(_final.get(r).get(c).toString()) ) return new int[] {r,c};
	    }
	}
	for (int r = 0; r < _piles.size(); r++) {
	    for (int c = 0; c < _piles.get(r).size(); c++){
		if ( target.equals(_piles.get(r).get(c).toString()) ) return new int[] {r + 4,c};
	    }
	}
	return new int[] {-100,-100};
    }

    //picks where you will move a chosen card to
    //returns pile you have chosen, if it is valid
    public int pickLocation() {

	System.out.print("and move it to the end of pile ...: ");
	int pile = Keyboard.readInt();
	
	if (pile >= 0 && pile < 11)
	    return pile;
	
	else {
	    System.out.println("\nBAD CHOICE. PICK AGAIN: \n");
	    return pickLocation(); 
	}

    }
    
    //checks to see it moving Card choice ontop of dest is valid
    public boolean isValidMove(int[] choice, int dest) {
	Card origin;
	Card destination;
	if (choice[0] == -1) origin = topCard();
	else if (choice[0] < 4) return false;/*{
	    if (choice[1] < _final.get( choice[0] ).size() - 1) return false;
	    else origin = _final.get( choice[0] ).get( choice[1] );
	    }*/
	else origin = _piles.get( choice[0] - 4 ).get( choice[1] );
	
	if (dest < 4){
	    //must be last card in origin pile
	    if (choice[0] > 4
		&& choice[1] < _piles.get(choice[0] - 4).size() - 1
		) return false;
	    
	    if ( _final.get(dest).size() > 0)
		destination = _final.get(dest).get( _final.get(dest).size() - 1 );
	    //only aces can move to empty final piles
	    else return origin.getNum() == 1;
	}
	else {
	    if ( _piles.get(dest - 4).size() > 0)
		destination = _piles.get(dest - 4).get( _piles.get(dest - 4).size() - 1 );
	    //only kings can move to empty piles
	    else return origin.getNum() == 13;
 	}

	//to move to a final pile must be same suit and 1 higher
	if (dest < 4)
	    return destination.getSuit().equals( origin.getSuit() )
		&& destination.getNum() == origin.getNum() - 1;
	//to move to normal pile must be opposite color and 1 lower
	else return !(destination.getColor().equals( origin.getColor() ))
		 && destination.getNum() == origin.getNum() + 1;
	
    }

    //moves card (and anything on top of it) to the designated pile
    public void makeMove(int[] choice, int dest) {
	int size; //must use bc you cant recalculate the size every time bc it gets smaller with the .remove

	if (dest < 4){
	    //dont have to account for moving from final to final bc wont happen bc of suits
	    if (choice[0] > 0) {
		size = _piles.get(choice[0] - 4).size();
		for (int i = choice[1]; i < size; i++){
		_final.get(dest).add( _piles.get(choice[0] - 4).get(choice[1]));
		_piles.get(choice[0] - 4).remove(choice[1]);
		}
		if (choice[1] > 0 
		    &&! _piles.get(choice[0] - 4).get(choice[1]-1).getFaceUp()
		    ) _piles.get(choice[0] - 4).get(choice[1]-1).flip();
		
	    }
	    else{ //comeing from the delt card
		_final.get(dest).add( topCard() );
		_deck.remove(_currentPos);

		if (_currentPos == 0) _currentPos = _deck.size() - 1;
		else _currentPos--;//to go back to the prevous card

		topCard().flip();
	    }
	    
	}
	else {
	    if (choice[0] > 3) {

		size = _piles.get(choice[0] - 4).size();
		for (int i = choice[1]; i < size; i++){
		    _piles.get(dest - 4).add( _piles.get(choice[0] - 4).get(choice[1]));
		    _piles.get(choice[0] - 4).remove(choice[1]);
		}
		if (choice[1] > 0
		    &&! _piles.get(choice[0] - 4).get(choice[1]-1).getFaceUp()
		    ) _piles.get(choice[0] - 4).get(choice[1]-1).flip();
		
	    }
	    else if (choice[0] > 0) {

		size = _final.get(choice[0]).size();
		for (int i = choice[1]; i < size; i++){
		    _piles.get(dest - 4).add( _final.get(choice[0]).get(choice[1]));
		    _final.get(choice[0]).remove(choice[1]);
		}
		if (choice[1] > 0 
		    &&! _piles.get(choice[0] - 4).get(choice[1]-1).getFaceUp()
		    ) _piles.get(choice[0]).get(choice[1]-1).flip();

	    }
	    else{ //comeing from the delt card
		_piles.get(dest - 4).add( topCard() );
		_deck.remove(_currentPos);

		if (_currentPos == 0) _currentPos = _deck.size() - 1;
		else _currentPos--;//to go back to the prevous card

		topCard().flip();
	    }
	}
    }

    //sees if the game is over
    public boolean isGameOver() {
	for (int i = 0; i < _final.size(); i++) {
	    if (_final.get(i).size() < 13) return false;
	}
	return true;
	
    }


    //magic -- swaps cards in the deck for cards that are face down in the piles,
    //so that if there are no more moves the user can keep playing
    public void magic() {
	if ( _magicUsed < 3 ) {
	    for (int i = 0; i < _deck.size(); i++) {
		int r = 0; int c = 0;
		boolean b = false;
		for (r = 0; r < _piles.size(); r++)
		    for (c = 0; c < _piles.get(r).size(); c++)
			if (! _piles.get(r).get(c).getFaceUp()) {
			    b = true;
			    break;
			}
		if (b) break;
		_deck.set(i,_piles.get(r).set(c, _deck.get(i)) );
	    }
	    _magicUsed++;
	}
    }
    
    
    //picks where you will move a chosen card too and moves it there
    //first checking if it is a valid move
    public boolean playTurn() {
	int[] choice = pickOrigin();
	if (choice.length == 0) {
	    return false;
	}
	int dest = pickLocation();
	
	if (isValidMove(choice, dest)) makeMove(choice, dest);
	else {
	    System.out.println("\nNOT A VALID MOVE. TRY AGAIN: \n");
	    playTurn();
	    return true;
	}
	return true;
    }

    public void displayInstructions() {
	System.out.println("\nWelcom to Solitaire! The fun card game play solo! To play, type in the name of a card, and then choose where to place it. Remeber that on the regular piles (on the bottom of the screen) the cards must be placed in descending order, and alternating color. To win, move the cards to the piles in the top right, where the cards must be placed in ascending order, and grouped by suit.\n\nThere are some special commands which you should know\n\t*Press D to deal a new card from the deck\n\t*Press E to give up and exit the game\n\t*Press M for Magic! Use this if you are stuck to shuffle some cards around in the deck, hopefully allowing for some new moves. You can use this up to 3 times\n\nYour score will depend on how many cards you get to their final position, in the piles in the top right. The maximum number points possible is 4. Note: Each time you use  Magic! you will lose one point from your total score\n\nGood luck!");
    }

    
    public int playGame() {
	displayInstructions();
	boolean test = false;
	while (! isGameOver() ) {
	    System.out.println(this);	
	    test = playTurn();
	    if (!test)
		break;
	}
	if (!test) {
	    System.out.println("Defeat");
	}
	
	return getScore();
    }

    public int getScore() {
	double count = 0.0;
	for (int i = 0; i < _final.size(); i++) count += _final.get(i).size();
	return (int)( count / 52.0 * 4.0) - _magicUsed;
    }

    
    public static int play() {
	Solitaire s = new Solitaire();
	return s.playGame();
    }

    
    public static void main(String[] args) {
	System.out.println( Solitaire.play() );
    }

}//end class Solitaire
