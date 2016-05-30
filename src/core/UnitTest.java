package core;

public class UnitTest {
	public static Client Initialisation(Client user){
		user = new Client("Elise");
		user.addAccount(new Account("Dimitri", 50));
		user.addAccount(new Account("Elise", 50));
		System.out.println(user.getOneAccount(0).getAmount());
		System.out.println(user.getOneAccount(1).getAmount());
		user.getOneAccount(0).addAction(new Actions(user.getOneAccount(1).getLastIdActions() + 1, "Halo 5", "Jeux", "DEBIT", 50, "", ""));
		user.getOneAccount(0).addAction(new Actions(user.getOneAccount(1).getLastIdActions() + 1, "Salaire", "Salaire", "CREDIT", 5, "", ""));
		DataManager.saveAccount(user, "Client.serial");
		return user;
	}
	
}
