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
	public static int myInt;
	public static String myIntString;
	public static boolean numberGameStarted = false;
	int clientNumber;

	String checkString(String string, String name) {
		// to avoid checking empty strings or strings with only '/', the length has to
		// be at least 2
		if (string.length() > 1) {
			if (string.charAt(0) != '/' && string.charAt(0) != '!') {
				return string;
			}
			// colour codes, does not work
			else if (string.length() >= 8 && string.substring(0, 8).equals("/yellow ")) {
				System.out.println("HEY");
				string = yellowString(string.substring(7, string.length()));
			}

			else if (string.length() >= 5 && string.substring(0, 5).equals("/red ")) {
				string = redString(string.substring(4, string.length()));
			}

			else if (string.length() >= 7 && string.substring(0, 7).equals("/green ")) {
				string = greenString(string.substring(6, string.length()));
			}

			else if (string.length() >= 6 && string.substring(0, 6).equals("/blue ")) {
				string = blueString(string.substring(5, string.length()));
			}
			// checks if the user writes '/joke', and will send a joke from jokeString
			else if (string.equals("/joke")) {
				string = jokeString();
			}
			// checks if the user writes '/help', and will send a help list from jokeString
			else if (string.equals("/help")) {
				string = helpString();
			}

			// Implements the command /hangman to start a game of hangman.
			else if (string.equals("/hangman")) {
				System.out.println("Abekat");
				// Starts a new hangman game.
				string = Server.hangman.newGame();
			}
			// Implements the guessing command for when a hangman game is ongoing. If the
			// command is 2 letters long and starts with '!' it's a guess.
			else if (string.length() == 2 && string.charAt(0) == '!') {
				string = Server.hangman.guessLetter(string);
			}
			// tsampikos okay cul command
			else if (string.equalsIgnoreCase("/tsampikos")) {
				string = "okay, cul";
			} 
			else if (string.equals("/roll")) {
				string = rollNumber();
			} 
			
			//Does not work properly
			/*else if (string.equals("/numbergame")) {
				string = startNumberGame();
				

			} else if (string.substring(0,1).equals("-")) {
				System.out.println("Hejsa nu er du her!");
			 } */

			else if (string.substring(0, 8).equals("/rename ")) {
				string = renamePlayer(string.substring(8, string.length()), name);
			}

			else {
				string = "Command not recognized. Type /help for help.";
			}

			return string;
		}
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

	// creates jokes
	String jokeString() {
		Random rand = new Random();
		int myInt = rand.nextInt(3);
		String output = "No jokes today.";

		if (myInt == 0)
			output = "What do you call a fish with no eyes? - A fsh.";
		else if (myInt == 1)
			output = "What did the fish say when it swam into a wall? - Dam.";
		else if (myInt == 2)
			output = "What are penguins' favorite relative? Aunt Arctica.";
		else if (myInt == 3)
			output = "You should never let your children play in an orchestra! There's too much sax and violins and tromBONING.";

		return output;
	}

	String helpString() {
		String help = "-- List of commands --\n" + "/help - shows list of commands.\n"
				+ "/joke - server tells a joke.\n" + "/red <msg> - message appears in red.\n"
				+ "/yellow <msg> - message appears in yellow.\n" + "/green <msg> - message appears in green.\n"
				+ "/blue <msg> message appears in blue.\n" + "/hangman - starts a new hangman game. \n"
				+ "!<char> - guesses char in hangman game. \n" + "/rename <name> - change your name. \n"
				+ "/renaeme <name> - change your name.\n"
				+ "/roll - roll the die.;

		return help;
	}

	String rollNumber() {
		Random rand = new Random();
		int myInt = rand.nextInt(99) + 1;
		String myInt1 = "" + myInt;
		return myInt1;
	}

	
	//Still does not work properly
	/*String startNumberGame() {
		if(numberGameStarted == false) {
			Random rand = new Random();
			myInt = rand.nextInt(99) + 1;
			numberGameStarted = true;
			return "You have started the numbergame, guess the number the server thinks of by writing #number" + myInt;
		}else {
			return "Numbergame already running";
		}

	} */

	String renamePlayer(String newName, String oldName) {
		for (int i = 0; i < Server.numberOfPlayers; i++) {
			if (Server.accessStuff[i].playerName.equals(oldName)) {
				Server.accessStuff[i].playerName = newName;
				break;
			}
		}

		return oldName + " changed their name to " + newName;
	}

}
