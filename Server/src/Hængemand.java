import java.util.Arrays;
import java.util.Random;

public class Hængemand {
//String array with all the words to choose from when randomly selecting a word.
String[] words = new String[14];

//An array that makes the string seperate into chars
char[] charArray;

//An array that determines which letters in the word has been guessed and which ones has not
boolean[] booleanArray;

//A boolean that determines whether there is an ongoing game or not
boolean hangmanStarted;

//The word that needs to be guessed in that round of hangman
String wordUsed;

//An int used to cound amount of guessed letters
int correctlyGuessedLetters = 0;

//A string to contain the output of when a letter is guessed.
String output;

//A string for what is shown to the clients playing.
String wordShown;

void populateArray() {
	words[0] = "cheese";
	words[1] = "sensual";
	words[2] = "pepperoni";
	words[3] = "seduction";
	words[4] = "warcraft";
	words[5] = "spaghetti";
	words[6] = "leech";
	words[7] = "tsampikos";
	words[8] = "evangelia";
	words[9] = "childish";
	words[10] = "shaman";
	words[11] = "healing";
	words[12] = "lasagna";
	words[13] = "bug";
}

String newGame() {
	if(hangmanStarted == false) {
	//Makes the boolean true that the game is started and there can be no more started games before this one has ended.
	hangmanStarted = true;
	
	//populates array with all the words that have the possibility of being chosen as the one to guess.
	this.populateArray();
	
	//Implements a random number generator.
	Random rand = new Random();
	int myInt = rand.nextInt(words.length - 1) + 0;
	//Picks a random word from the words array that will be used as the word to guess later on. A number between 0 and the length of the words array.
	wordUsed = words[myInt];
	//Makes an array of Chars out of the word picked.
	charArray = wordUsed.toCharArray();
	
	//Makes a boolean array with same amount of booleans as there are letters in the word. Will be used to determine which letters are guessed and which aren't.
	booleanArray = new boolean[charArray.length];
	
	//Returns welcome message and the progress method to know how many letters are in the word.
	return "Welcome to hangman \n " + this.progress() ;
	}
	else {
	//Returns if a game is currently being played
	return "A game of hangman is already happening";
	}
	
}

String guessLetter(String guessedInput) {
	if(hangmanStarted) {
	if(guessedInput.length() == 2 && guessedInput.charAt(0) == '!' && hangmanStarted == true){
		//Making a string and a char for the input aka. the guessed letter.
		char guessedLetter;
		//String is needed to use the .contains method.
		String guessedLetterStr;
		//Isolates the guessed letter to only be that one char.
		guessedLetter = guessedInput.charAt(1);
		guessedLetterStr = guessedInput.substring(1,2);
		
		if(wordUsed.contains(guessedLetterStr)) {
			//Creates a for loop finding out which letters are correctly guessed and turning the boolean for those letters to true as in "guessed correctly".
			for(int i = 0; i < charArray.length; i++) {
				//Resets correctly guessed number so it does not continue getting bigger always.
				correctlyGuessedLetters = 0;
				//An if statement to determine what characters are the same as the one guessed.
				if(charArray[i] == guessedLetter) {
					//If the guessed letter is the same as the one in the word the boolean at that spot turns true
					booleanArray[i] = true;
					//A for loop to count how many letters are currently guessed correctly.
					for(int j = 0; j < booleanArray.length; j++) {
						if(booleanArray[j] == true) {
							correctlyGuessedLetters++;
						}
					}
					//If the letter is correctly guessed the output is set to this String.
					output = "Good guess! It is correct! You now have " + correctlyGuessedLetters + " letters correctly guessed";
				
				
					
				}	
				
				}
				}else {
					//If letterGuessed is wrong output is set to this String:
					output = "Too bad. The letter " + guessedLetter + " is not in the word you are trying to guess.";
			}
	}
	//returns the output message (whether or not the letter is in the word) and then returns progress.
	return output + "\n " + this.progress();
	} else {
		return "There is currently no Hangman game being played. type /Hangman to start a game";
	}
}// end of guessLetter class


String progress() {
	//If all the letters have been guessed the client has won the game and hangmanStarted is false since there is currently no Hangman game happening.
	if(areAllTrue(booleanArray)){
		hangmanStarted = false;
		System.out.println("Congratulations! You guessed the word! The word you guessed was: " + wordUsed);
		return "Congratulations you guessed the word! The word you guessed was: " + wordUsed;
	} else if(!(areAllTrue(booleanArray))) {
		wordShown = "";
		for(int i = 0; i < booleanArray.length; i++) {
			//If the letter is guessed correctly the letter will be added to the word shown to clients with a space behind it.
			if(booleanArray[i] == true) {
				wordShown = wordShown + charArray[i] + ' ';
				//If the letter is not guessed yet there will be a "_" and a space after it.
			}else {
				wordShown = wordShown + '_' + ' ';
			}	
		}
	}
	//Returns the progress of the word you try to guess and a guide that shows the user how to guess another one.
	return "Your hangman word is: " + wordShown + " \n To guess, write a letter with a '!' in front. Example: '!x'";
}

//Making a method to determine whether all booleans in a boolean array are true.
public static boolean areAllTrue(boolean[] array)
{
    for(boolean b : array) if(!b) return false;
    return true;
}

} // end of hængemand class