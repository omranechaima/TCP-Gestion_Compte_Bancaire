package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Serveur {
	static List<Compte> lc=new ArrayList<Compte>() ;
	public static void main(String[] args)  {
		lc=new ArrayList<Compte>();
		ServerSocket ss;
		try {
			ss = new ServerSocket(3000);
		
		while(true) {
			Socket sc =ss.accept();
			Gestion g =new Gestion(sc);
			g.start();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}