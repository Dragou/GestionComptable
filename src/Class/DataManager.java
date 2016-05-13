package Class;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataManager {

	public static void initAccount(Client user){
		user = null;
		try {
			FileInputStream fis = new FileInputStream("Client.serial");
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
			System.out.println("R�cup�ration effectu�e");
		}
		else
		{
			System.out.println("Erreur lors de la r�cup�ration");
		}
	}
	
	private static void saveAccount(Client user) {
		try {
			FileOutputStream fos = new FileOutputStream("Client.serial");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			try {
				oos.writeObject(user);
				oos.flush();
				System.out.println("Sauvegarde effectu�");
			} finally {
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
