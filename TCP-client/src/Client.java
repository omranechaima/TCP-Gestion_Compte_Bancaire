import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main (String[] args)  {
		String hostname="127.0.0.1";
		int port=3000;
		Socket client;
		try {
			client = new Socket(hostname,port);
		
		while(true) {
			
			BufferedReader InFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			PrintWriter outToServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
			
			String msg=InFromUser.readLine();
			
			outToServer.println(msg);
			
			String messge=inFromServer.readLine();
			
			System.out.println("server: "+ messge);
		}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
