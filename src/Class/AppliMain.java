package Class;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

import View.MainView;

public class AppliMain {
	private static Scanner sc;
	private static int choice;
	
	public static void main(String[] args){
//		boolean quit = false, quitSub = false;
		MainView newView = new MainView();
//		int index;
//		do
//		{
//			user.showAllAccount();
//			menu();
//			switch (choice) {
//			case 1:
//				sc = new Scanner(System.in);
//				System.out.println("Saisir le libelle de votre compte :");
//				String libelle = sc.nextLine();
//				System.out.println("Saisir le montant de votre compte :");
//				float amount = sc.nextFloat();
//				Account newAccount = new Account(libelle, amount);
//				user.addAccount(newAccount);
//				break;
//				
//			case 2:
//				sc = new Scanner(System.in);
//				user.showAllAccount();
//				System.out.println("Saisir le numéro du compte à supprimer :");
//				index = sc.nextInt();
//				user.deleteAccount(index);
//				break;
//			
//			case 3:
//				sc = new Scanner(System.in);
//				user.showAllAccount();
//				System.out.println("Saisir le numéro du compte à gérer :");
//				index = sc.nextInt();
//				Account myAccount = user.getOneAccount(index);
//				do
//				{
//					sc = new Scanner(System.in);
//					System.out.println("+-----------MENU-----------+");
//					System.out.println("| 1 - Ajouter une action   |");
//					System.out.println("| 2 - Supprimer une action |");
//					System.out.println("| 3 - Voir les actions     |");
//					System.out.println("| 4 - Quitter              |");
//					System.out.println("+--------------------------+");
//					System.out.println("Que faire?");
//					choice = sc.nextInt();
//					switch (choice) {
//					case 1:
//						Actions myAction = createAction();
//						myAccount.addAction(myAction);
//						break;
//						
//					case 2:
//						myAccount.showAllActions();
//						System.out.println("Saisir le chiffre de la ligne que vous désirez de supprimer :");
//						int deleteIndex = sc.nextInt();
//						myAccount.deleteAction(deleteIndex);
//						break;
//						
//					case 3:
//						myAccount.showAllActions();
//						break;
//						
//					case 4:
//						quitSub = true;
//						break;
//						
//					default:
//						System.out.println("Ceci n'est pas une option");
//						break;
//					}
//				}while(!quitSub);
//				user.updateAccount(myAccount, index);
//				break;
//				
//			case  4:
//				quit = true;
//				break;
//				
//			default:
//				System.out.println("Ceci n'est pas une option");
//				break;
//			}
//		}while(!quit);
	}

	private static Actions createAction() {
		sc = new Scanner(System.in);
		System.out.println("Saisir la catégorie de votre action :");
		String cat = sc.nextLine();
		System.out.println("Débit ou Crédit?");
		String type = sc.nextLine();
		System.out.println("Saisir le montant :");
		float amount = sc.nextFloat();
		return new Actions(1, "Sans titre",cat, type, amount, new Date(), "false");
	}
//	
//	public static void menu(){
//		sc = new Scanner(System.in);
//		System.out.println("+-----------MENU-----------+");
//		System.out.println("| 1 - Ajouter un compte    |");
//		System.out.println("| 2 - Supprimer un compte  |");
//		System.out.println("| 3 - Gerer un compte      |");
//		System.out.println("| 4 - Quitter              |");
//		System.out.println("+--------------------------+");
//		System.out.println("Que faire?");
//		choice = sc.nextInt();
//	}
}
