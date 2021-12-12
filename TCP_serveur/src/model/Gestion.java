package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Gestion extends Thread {
	private Socket sc;
	String messageClient, msg = "";

	public Gestion(Socket sc) {

		this.sc = sc;
	}

	public void run() {
		try {
			BufferedReader inFromClient=new BufferedReader(new InputStreamReader(sc.getInputStream()));
			PrintWriter outToClient=new PrintWriter(new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())),true);
			
		
			
				messageClient=inFromClient.readLine();
								
				String[] cmd1=messageClient.split(" ");
								
				if(cmd1[0].equalsIgnoreCase("CREATION")) {
				Compte c =new Compte();					
				c.setNom(cmd1[1]);
				Serveur.lc.add(c);
				msg="welcome "+c.getNom()+", your account is created successfuully !";
				outToClient.println(msg);
								
				while(true) {
					messageClient=inFromClient.readLine();
					String[] cmd=messageClient.split(" ");
					if(cmd[0].equalsIgnoreCase("CREDIT")) {
						float credit=Float.parseFloat(cmd[1]) ;
						float nouveauSolde = c.getSolde()+credit;
						c.setSolde(nouveauSolde);
						msg="solde mis a jour avec success";
						outToClient.println(msg);

					}else if(cmd[0].equalsIgnoreCase("SOLDE")){
						msg="solde est "+c.getSolde();
						outToClient.println(msg);
						
					}else if(cmd[0].equalsIgnoreCase("DEBIT")){
						float debit=Float.parseFloat(cmd[1]) ;
						float nouveauSolde = c.getSolde()-debit;
						c.setSolde(nouveauSolde);
						msg="solde mis a jour avec success";
						outToClient.println(msg);
						
					}
			
				}		    }
		}catch (Exception e) {
			e.printStackTrace();}}}
