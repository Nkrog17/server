import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class PlayerThread implements Runnable {
	private Socket socket;
	public String playerName;	

	public PlayerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			
			DataInputStream fromClient = new DataInputStream(socket.getInputStream());
			
			playerName = fromClient.readUTF();
			System.out.println(playerName + " connected to game!");
			System.out.println("The total number of connected players is now: " + Server.numberOfPlayers);
			
			Server.updateClients();
			
			while (true) {
				//Fetch string from client
				String message = fromClient.readUTF();
				//Send string to Server class
				Server.sendToAllClients(message, playerName);
				if(Commands.quitBoolean = true) {
					System.out.println("Player has quit");
					if(Thread.currentThread().isAlive()) {
						sendMessage("b00ejjk");
						return;
					}
				}
			}
			
		} catch(IOException e) {}
			Server.disconnectClient(playerName);
	}
	
	public void sendMessage(String message) throws IOException {
		//Send the message to this client.
		DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());		
		toClient.writeUTF(message);
	}
		
	}


