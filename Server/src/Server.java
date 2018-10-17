import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Set;

public class Server {
	public static int numberOfPlayers=0;
	public static Thread [] connectedClients = new Thread[6];
	public static PlayerThread [] accessStuff = new PlayerThread[6]; 
	
public static void main(String args[]) {
	new Thread(() -> {
			
			try {
				// Creating ServerSocket and Socket
				ServerSocket server = new ServerSocket(6000);

				while (true) {
					if(numberOfPlayers < 6) {
						Socket socket = server.accept();
						
						PlayerThread thisObject = new PlayerThread(socket);
						Thread thisThread = new Thread(thisObject);
						thisThread.start();
						
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
	Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
	Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
	
	Thread[] tempClients = new Thread[numberOfPlayers];
	int index = 0;
	
	
	for(int i = 0; i<threadArray.length; i++) {
		if(threadArray[i].getName().substring(0, 6).equals("Client")) {
			tempClients[index] = threadArray[i];
			index++;
		}
	}
	connectedClients = tempClients;
}

public static void sendToAllClients(String string) throws IOException {
	for(int i = 0; i<accessStuff.length; i++) {
		System.out.println(accessStuff);
		accessStuff[i].sendMessage(string);
	}
	//toClient.writeUTF(message);
}

}
