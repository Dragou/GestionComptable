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
	

	public Actions(int unId, String unLibelle,String uneCategorie, String unType, float unAmount, Date uneDate, String unAutomated){
		this.id = unId;
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
		// TODO Renvoyer le montant avec un "-" si c'est un d�bit
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

	public Boolean equals(Actions uneAction){
		Boolean bool = false;
		
		if(this.id == uneAction.id){
			bool = true;
		}
		else{
			bool = false;
		}
			
		return bool;		
	}

	public void showAction(Actions action) {
		// TODO Auto-generated method stub
		
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
}