import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class PlayerThread implements Runnable {
	private Socket socket;

	public PlayerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream fromClient = new DataInputStream(socket.getInputStream());
			DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
			
			
			
				String playerName=fromClient.readUTF();
				System.out.println(playerName);
			
		} catch(IOException e) {}
	}
		
	}


