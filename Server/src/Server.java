import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	public static void main(String[] args) {
    try {
	      // Hejsa
	      ServerSocket serverSocket = new ServerSocket(8000);
	     System.out.println("Loan Server started at " + new Date() + '\n');

	      Socket connectToClient = serverSocket.accept();

	      // Display the client number
	      System.out.println("Connected to a client " + " at " + new Date() + '\n');

	      // Create data input and output streams
	      DataInputStream isFromClient = new DataInputStream(
	        connectToClient.getInputStream());
	      DataOutputStream osToClient = new DataOutputStream(
	        connectToClient.getOutputStream());

	      // Continuously serve the client
	      while (true) {
	        // Receive annual interest rate from the client
	        double annualInterestRate = isFromClient.readDouble();

	        // Receive number of years f6hhurom the client
	        int numOfYears = isFromClient.readInt();

	        // Receive loan from the client
	        double loanAmount = isFromClient.readDouble();

	        // Compute monthly payment and total payment
	        double monthlyInterestRate = annualInterestRate / 1200;
	        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numOfYears * 12)));
	        
	        double totalPayment = monthlyPayment * numOfYears * 12;
	        // Send results back to the client
	        osToClient.writeDouble(monthlyPayment);
	        osToClient.writeDouble(totalPayment);

	        System.out.println("Annual Interest Rate: " + annualInterestRate +
	          "\nNumber of Years: " + numOfYears + "\nLoan Amount: " +
	          loanAmount + "\n");
	        System.out.println("monthlyPayment: " + monthlyPayment + " " +
	          "\ntotalPayment: " + totalPayment + '\n');
	        
	      }
	    }
	    catch(IOException e) {
	      System.err.println(e);
	    }
	  }
	  
	
}
