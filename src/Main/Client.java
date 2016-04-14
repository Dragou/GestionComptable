package Main;

import java.util.ArrayList;

public class Client {
	private String nom;
	private ArrayList<Account> listAccount;
	
	public Client(String unNom){
		this.nom = unNom;
		
		this.listAccount = new ArrayList<Account>();
	}
}
