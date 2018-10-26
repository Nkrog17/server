import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Set;

public class Server {
	public static int numberOfPlayers=0;
	public static Thread [] connectedClients = new Thread[6];
	public static PlayerThread [] accessStuff = new PlayerThread[6];
	public static Commands commands = new Commands();
	
	static Hængemand hangman;
	static ipAdress ipAdresse;
	
public static void main(String args[]) throws Exception {
	hangman = new Hængemand();
	ipAdresse = new ipAdress();
	ipAdresse.getIpAdress();
	
	new Thread(() -> {
			
			try {
				// Creating ServerSocket and Socket
				ServerSocket server = new ServerSocket(7700);

				while (true) {
					if(numberOfPlayers != 6) {
						Socket socket = server.accept();
						//Assigns a thread to a client
						PlayerThread thisObject = new PlayerThread(socket);
						Thread thisThread = new Thread(thisObject);
						thisThread.start();
						
						//accessStuff is used to access functions within a thread's object.
						accessStuff[numberOfPlayers] = thisObject;
						numberOfPlayers++;
						thisThread.setName("Client " + Integer.toString(numberOfPlayers));
					}
				}
				
				
			} catch (Exception e) {

			}
		}).start();
	
	System.out.println("Server ready");
		
	}

public static void updateClients() {
	//Get all active threads and convert to array
	Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
	Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
	
	Thread[] tempClients = new Thread[numberOfPlayers];
	int index = 0;
	
	//Check each thread and if thread is a client, append to tempClients
	for(int i = 0; i<threadArray.length; i++) {
		if(threadArray[i].getName().substring(0, 6).equals("Client")) {
			tempClients[index] = threadArray[i];
			index++;
		}
	}
	//Make the connected clients static and public.
	connectedClients = tempClients;
}

public static void sendToAllClients(String string, String name) throws IOException {
	//Send message to each connected client
	//string = commands.checkString(string);
	string = commands.checkString(string);
	
	for(int i = 0; i<numberOfPlayers; i++) {
		accessStuff[i].sendMessage(name + ": " + string);
	}
	System.out.println(name + ": " + string);
}

public static void disconnectClient(String name) {
	//controls if players leave the channel
	System.out.println(name + " has left the chat.");
	numberOfPlayers --;
	System.out.println("The total number of connected clients is now: " + numberOfPlayers);
}

}
