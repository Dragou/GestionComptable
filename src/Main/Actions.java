package Main;

import java.util.Date;

public class Actions {
	private int id;
	private String categorie;
	private String type;
	private float amount;
	private Date date;
	private Boolean validate;
	private String automated;
	
	public Actions(String uneCategorie, String unType, float unAmount, Date uneDate, String unAutomated){
		this.categorie = uneCategorie;
		this.type = unType;
		this.amount = unAmount;
		this.date = uneDate;
		this.validate = false;
		this.automated = unAutomated;
	}

	public void Check() {
		// TODO Check si l'action est correcte ou non
		
	}

	public float GetAmount() {
		// TODO Renvoyer le montant avec un "-" si c'est un débit
		return 0;
	}
	
}