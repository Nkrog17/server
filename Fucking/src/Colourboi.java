import java.util.Random;
import java.util.Scanner;

public class Colourboi {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.nextInt(5));
		
		System.out.println(ANSI_GREEN + "Open" + ANSI_RESET);
		
		Scanner sc = new Scanner(System.in);
		
		String msg = sc.nextLine();
		
		System.out.println(ANSI_BLACK + msg + ANSI_RESET);
		System.out.println(msg);
		
		sc.close();
		

	}

}
