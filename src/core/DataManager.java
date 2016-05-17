package core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataManager {

	public static void initAccount(Client user, String fileName){
		user = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {	
				user = (Client) ois.readObject(); 
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
		if(user != null) {
			System.out.println("Récupération effectuée");
		}
		else
		{
			System.out.println("Erreur lors de la récupération");
		}
	}
	
	public static void saveAccount(Client user, String fileName) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			try {
				oos.writeObject(user);
				oos.flush();
				user.getOneAccount(1).showAccount();
				System.out.println("Sauvegarde effectué");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Erreur lors de l'enregistrement");
		}	
	}
}
