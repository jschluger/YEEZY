import cs1.Keyboard;

public class Stuy {


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
	

    public static void play(){
	
	
    }


    public static void main(String[] args){
	String s = "the first option";
	String r = "the second one";
	String t = "and anotha one";
	System.out.println( choose(new String[] {s,r,t}) );
    }
}
