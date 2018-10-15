import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class MultiThread implements Runnable {
	private Socket socket;

	public MultiThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream fromClient = new DataInputStream(socket.getInputStream());
			DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
			
			
			while(true) {
				double amount = fromClient.readDouble();
				int years = fromClient.readInt();
				double annualInterestRate = fromClient.readDouble();
				
				double monthlyInterestRate = annualInterestRate / 1200;
				double monthlyPayment = amount * monthlyInterestRate / (1 - 
						(1 / Math.pow(1 + monthlyInterestRate, years * 12)));
				toClient.writeDouble(monthlyPayment);
				
				double totalPayment = monthlyPayment * years * 12;
				toClient.writeDouble(totalPayment);
			}
		} catch(IOException e) {}
	}
		
	}


