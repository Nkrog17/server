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
				ServerSocket server = new ServerSocket(4000);

				while (true) {
					Socket socket = server.accept();
					client++;
					
					new Thread(new MultiThread(socket)).start();
					System.out.println("New Client");
				}
			} catch (Exception e) {

			}
		}).start();
		
	}

}
