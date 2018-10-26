
import java.net.InetAddress;

public class ipAdress {
	
	void getIpAdress() throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP Address:- " + inetAddress.getHostAddress());
        System.out.println("Host Name:- " + inetAddress.getHostName());
        System.out.println("Port no: 8000");
    }
}