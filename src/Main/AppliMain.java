package Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AppliMain {
	private static Account myAccount;
	private static Scanner sc;
	
	public static void main(String[] args){
		int choice = 0;
		initAccount();
		do
		{
			choice = menu();
			switch (choice) {
			case 1:
				Actions myAction = createAction();
				myAccount.AddAction(myAction);
				break;
			case 2:
				myAccount.ShowAction();
				
				break;
			default:
				break;
			}
		}while(choice != 4);
		saveAccount();
	}
	
	private static void saveAccount() {
		try {
			FileOutputStream fos = new FileOutputStream("Account.serial");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			try {
				oos.writeObject(myAccount); 
				oos.flush();
				System.out.println("Sauvegarde effectuée");
			} finally {
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}	
	}

	private static Actions createAction() {
		sc = new Scanner(System.in);
		System.out.println("Saisir la catégorie de votre action :");
		String cat = sc.nextLine();
		System.out.println("Débit ou Crédit?");
		String type = sc.nextLine();
		System.out.println("Saisir le montant :");
		float amount = sc.nextFloat();
		return new Actions(cat, type, amount, new Date(), "false");
	}

	public static void initAccount(){
		myAccount = null;
		try {
			FileInputStream fis = new FileInputStream("Account.serial");
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {	
				myAccount = (Account) ois.readObject(); 
			} finally {
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if(myAccount != null) {
			System.out.println("Récupération effectuée");
		}
		else
		{
			sc = new Scanner(System.in);
			System.out.println("Saisir le nom de votre compte :");
			String accountName = sc.nextLine();
			System.out.println("Saisir le montant initial de votre compte :");
			float accountAmount = sc.nextFloat();
			myAccount = new Account(accountName, accountAmount);
		}
	}
	
	public static int menu(){
		int choice = 0;
		do {
			System.out.println("+-----------MENU-----------+");
			System.out.println("| 1 - Ajouter une action   |");
			System.out.println("| 2 - Supprimer une action |");
			System.out.println("| 3 - Voir les actions     |");
			System.out.println("| 4 - Quitter              |");
			System.out.println("+--------------------------+");
			System.out.println("Que faire?");
			choice = sc.nextInt();
		} while (choice > 5 || choice < 0);
		return choice;
	}
}
