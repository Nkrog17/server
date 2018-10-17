import java.util.*;

public class Commands {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	String checkString(String string) {
		if(string.charAt(0) != '/')
			return string;
		
		else if(string.substring(0, 7).equals("/yellow "))
			string = yellowString(string);
		
		else if(string.substring(0, 4).equals("/red "))
			string = redString(string);
		
		else if(string.substring(0, 6).equals("/green "))
			string = greenString(string);
		
		else if(string.substring(0, 5).equals("/blue "))
			string = blueString(string);
		
		else if(string.equals("/joke"))
			string = jokeString();
			
		return string;
	}
	
	String yellowString(String string) {
		return ANSI_YELLOW + string + ANSI_RESET;
	}
	
	String redString(String string) {
		return ANSI_RED + string + ANSI_RESET;
	}
	
	String greenString(String string) {
		return ANSI_GREEN + string + ANSI_RESET;
	}
	
	String blueString(String string) {
		return ANSI_BLUE + string + ANSI_RESET;
	}
	
	String jokeString() {
		Random rand = new Random();
		int myInt = rand.nextInt(3);
		String output = "No jokes today.";
		
		if(myInt == 0)
			output = "What do you call a fish with no eyes? - A fsh.";
		else if(myInt == 1)
			output = "What did the fish say when it swam into a wall? - Dam.";
		else if(myInt == 2)
			output = "What are penguins' favorite relative? Aunt Arctica.";
		else if(myInt == 3)
			output = "You should never let your children play in an orchestra! There's too much sax and violins.";
		
		return output;
	}
	
	

}
