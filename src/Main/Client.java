package Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private ArrayList<Account> listAccount;
	
	public Client(String unNom){
		this.nom = unNom;
		
		this.listAccount = new ArrayList<Account>();
	}
	
	public void addAccount(Account newAccount) {
		this.listAccount.add(newAccount);
	}
	
	public void deleteAccount(int index) {
		this.listAccount.remove(index - 1);
	}
	
	public void showAllAccount() {
		for (Account account : listAccount) {
			System.out.print("1. ");
			account.showAccount();
		}
	}

	public Account getOneAccount(int index) {
		return this.listAccount.get(index - 1);
	}

	public void updateAccount(Account myAccount, int index) {
		this.listAccount.set(index - 1, myAccount);		
	}
}
