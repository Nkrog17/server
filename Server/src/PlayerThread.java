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
			DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
			
			playerName=fromClient.readUTF();
			System.out.println(playerName+ " connected to game!");
			System.out.println("The total number of connected players is now: "+Server.numberOfPlayers);
			
			while (true) {
			
			
				Server.numberOfPlayers--;
			break;
			}
			
		} catch(IOException e) {}
		System.out.println(this.playerName+ " has left the game");
	}
		
	}


