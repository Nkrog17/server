import java.io.PrintStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
public static void main(String args[]) {
	new Thread(() -> {
			int client = 0;
			try {
				// Creating ServerSocket and Socket
				ServerSocket server = new ServerSocket(8867);

				while (true) {
					Socket socket = server.accept();
					client++;
					
					new Thread(new PlayerThread(socket)).start();
					System.out.println("Client connected to game server!");
<<<<<<< HEAD
				
=======
>>>>>>> branch 'master' of https://github.com/Nkrog17/server.git
				}
			} catch (Exception e) {

			}
		}).start();
		
	}

}
