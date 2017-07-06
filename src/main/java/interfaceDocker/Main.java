package interfaceDocker;

import java.awt.EventQueue;
import java.sql.Connection;
import java.util.Scanner; 
import gui.*;

public class Main {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setProperty("line.separator","\n");
					ConnectionControler connectionControler = new ConnectionControler();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	/*
	Credentials creds = new Credentials("administrateur", "srvinfradec2", "L9jbZkc6tp");
	//Credentials creds = new Credentials();
	connection.connect(creds);
	
	Scanner reader = new Scanner(System.in);  // Reading from System.in
	//System.out.println("Enter a number: ");
	//String command = reader.next();
	reader.close();
	
	Boolean ret = connection.test();
	if(ret) System.out.println("Réussite");
	else System.out.println("Echec");
	
	String list = connection.command("docker images");
	System.out.println(list);*/
	}
}
