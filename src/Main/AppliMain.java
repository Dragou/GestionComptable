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
		
		ArrayList<Account> p = null;
		try {
			// ouverture d'un flux d'entrée depuis le fichier "Account.serial"
			FileInputStream fis = new FileInputStream("Account.serial");
			// création d'un "flux objet" avec le flux fichier
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {	
				// désérialisation : lecture de l'objet depuis le flux d'entrée
				p = (ArrayList<Account>) ois.readObject(); 
			} finally {
				// on ferme les flux
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
		if(p != null) {
			System.out.println(p + " a ete deserialise");
			System.out.println(p.toString());
		}
		
//		try {
//			// création d'une Account
//			ArrayList<Account> p = new ArrayList<Account>();
//			p.add(new Account("Dupont", 20));
//			p.add(new Account("Dujean", 0));
//			System.out.println("creation de : " + p);
//
//			// ouverture d'un flux de sortie vers le fichier "Account.serial"
//			FileOutputStream fos = new FileOutputStream("Account.serial");
//
//			// création d'un "flux objet" avec le flux fichier
//			ObjectOutputStream oos= new ObjectOutputStream(fos);
//			try {
//				// sérialisation : écriture de l'objet dans le flux de sortie
//				oos.writeObject(p); 
//				// on vide le tampon
//				oos.flush();
//				System.out.println(p + " a ete serialise");
//				
//			} finally {
//				//fermeture des flux
//				try {
//					oos.close();
//				} finally {
//					fos.close();
//				}
//			}
//		} catch(IOException ioe) {
//			ioe.printStackTrace();
//		}
		
//		int choice = 0;
//		do
//		{
//			choice = Menu();
//			switch (choice) {
//			case 1:
//				Actions myAction = CreateAction();
//				myAccount.AddAction(myAction);
//				break;
//
//			default:
//				break;
//			}
//		}while(choice != 4);
	}
	
	private static Actions CreateAction() {
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
		
	}
	
	public static int Menu(){
		sc = new Scanner(System.in);
		System.out.println("Saisir le nom de votre compte :");
		String accountName = sc.nextLine();
		System.out.println("Saisir le montant initial de votre compte :");
		float accountAmount = sc.nextFloat();
		myAccount = new Account(accountName, accountAmount);
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
