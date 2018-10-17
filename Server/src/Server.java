import java.io.PrintStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static int numberOfPlayers=0;
public static void main(String args[]) {
	new Thread(() -> {
			
			try {
				// Creating ServerSocket and Socket
				ServerSocket server = new ServerSocket(6000);

				while (true) {
					Socket socket = server.accept();
					
					
					new Thread(new PlayerThread(socket)).start();
					
					numberOfPlayers++;

				}
				
				
			} catch (Exception e) {

			}
		}).start();
	
		
	}

}
