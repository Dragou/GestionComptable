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
	
}