import cs1.Keyboard;
import java.util.ArrayList;

public class Stuy {
    private String _name;
    private Character _player;

    public Stuy() {
	//_credits = 0; --> moved to Character
	//the other 2 instance variables get set later via user input
    }
    
    public static int choose(String[] a){
	String s = "";
	for (int i = 0; i < a.length; i++) {
	    s += "\t" + (i + 1) + " : " + a[i] + "\n";
	}
	s += "Make your selection: ";
	System.out.print(s);
	int choice = Keyboard.readInt();
	
	while (! (choice > 0 && choice < a.length + 1) ){
	    System.out.print("Bad choice. Pick again: ");
	    choice = Keyboard.readInt();
	}
	return choice;
    }
	
    public static String ask(String question) {
	System.out.print(question + ": ");
	String ans = Keyboard.readString();
	return ans;
    }

    public void displayInstructions() {
	System.out.println("Welcome to \033[46mA DAY IN STUY\033[0m, where you will try to make it through your final day in Stuy and earn enough credits to finally graduate. Bear in mind that failure to win a game will result in no credits earned!");
	System.out.println("What Character do you want to be?");
    }

    public void playGame() {
	displayInstructions();
	
	String a = "\033[41mAP Student\033[0m\n\t\t*Difficulty: Hard\n\t\t*7 period schedule (including lunch)\n\t\t*10 credits required to graduate\n";
	String b = "\033[43mHonors Student\033[0m\n\t\t*Difficulty: Medium\n\t\t*7 period schedule (including lunch)\n\t\t*6 credits required to graduate\n";
	String c = "\033[42mRegular Student\033[0m\n\t\t*Difficulty: Easy\n\t\t*3 period schedule\n\t\t*3 credits required to graduate\n";
	String[] student = {a,b,c};
	
	int numStudent = choose(student);
	if (numStudent == 1) {
	    _player = new APStudent();
	}
	else if (numStudent == 2) {
	    _player = new HonStudent();
	}
	else if (numStudent == 3) {
	    _player = new RegStudent();
	    
	}

	_name = ask("\nWhat is your name?");

	System.out.println("\nWelcome " + _name + ". Get ready for a fun day in Stuyvesant High School :) Good luck (y)");
	Period.pause();

	//this plays the whole day
	for (int i = 1; i <= _player.scheduleLength(); i++) {
	    _player.playPeriod(i);

	    int earn = _player.getCreditsEarned();
	    int need = _player.getCreditsNeeded();
	    if (earn >= need) {
		System.out.println("You have already earned enough credits (" + need + ") needed to graduate. You currently have earned " + earn + " credits.");
	    }
	    else {
		System.out.println("\nYou still need " + ( need - earn ) + " credits to graduate. Make sure you earn them by the end of the day!\n");
	    }
	}

	_player.endGame();
	
    }
	
    public static void play(){
	Stuy game = new Stuy();
	game.playGame();
    }


    public static void main(String[] args){
        play();
    }
} // end class Stuy
