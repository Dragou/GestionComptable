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

	public float GetAmount() {
		// TODO Renvoyer le montant avec un "-" si c'est un débit
		return 0;
	}
	
	
	public void modifyAction(Actions uneAction){
		this.categorie = uneAction.categorie;
		this.type = uneAction.type;
		this.amount = uneAction.amount;
		this.date = uneAction.date;
		this.validate = uneAction.validate;
		this.automated = uneAction.automated;
	}
}