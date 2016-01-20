import cs1.Keyboard;
import java.util.ArrayList;

public class Stuy {
    private String _name;
    private int _credits;
    private Character _player;
    
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
	System.out.println("Welcome to A Day In Stuy, where you will try to make it through your final day in Stuy and earn enough credits to finally graduate. Bear in mind that failure to win a game will result in no credits earned!");
	System.out.println("What Character do you want to be?");
    }

    public void playGame() {
	displayInstructions();
	
	String a = "AP Student";
	String b = "Honors Student";
	String c = "Regular Student";
	String[] student = {a,b,c};
	
	int numStudent = choose(student);
	if (numStudent == 1) {
	    _player = new APStudent();
	}
	else if (numStudent == 2) {     ///havent written these classes yet
	    _player = new HonStudent();
	}
	else if (numStudent == 3) {
	    _player = new RegStudent();
	    
	}

	_name = ask("\nWhat is your name?");

	System.out.println("\nWelcome " + _name + ". Get ready for a fun day in Stuyvesant High School :) Good luck (y)\n.\n.\n.\n\n");

	//this plays the whole day
	for (int i = 1; i <= _player.scheduleLength(); i++) {
	    _player.getPeriod(i).scenario();
	}
	
    }
	
    public static void play(){
	Stuy game = new Stuy();
	game.playGame();
    }


    public static void main(String[] args){
        play();
    }
} // end class Stuy
