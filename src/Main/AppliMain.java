package Main;

import java.util.Date;
import java.util.Scanner;

public class AppliMain {
	private static Account myAccount;
	private static Scanner sc;
	
	public static void main(String[] args){
		int choice = 0;
		do
		{
			choice = Menu();
			switch (choice) {
			case 1:
				Actions myAction = CreateAction();
				myAccount.AddAction(myAction);
				break;

			default:
				break;
			}
		}while(choice != 4);
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
