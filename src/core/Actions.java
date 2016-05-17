package core;

import java.io.Serializable;

public class Actions implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String libelle;
	private String categorie;
	private String type;
	private float amount;
	private String date;
	private Boolean validate;
	private String automated;
	
	public Actions(int unId, String unLibelle,String uneCategorie, String unType, float unAmount, String uneDate, String unAutomated){
		this.id = unId;
		this.categorie = uneCategorie;
		this.libelle = unLibelle;
		this.type = unType;
		this.amount = unAmount;
		this.date = uneDate;
		this.validate = false;
		this.automated = unAutomated;
	}
	
	public int getId(){
		return id;
	}

	//Renvoyer le montant avec un "-" si c'est un d�bit
	public float getAmount() {
		float montant = this.amount;
		
		if(this.type.toUpperCase() == "DEBIT"){
			montant = montant * (-1);
		}
		return montant;
	}
	
	public void showAction(Actions uneAction){
		System.out.println("Libelle: " + uneAction.libelle);
		System.out.println("Type: " + uneAction.type);
		System.out.println("Cat�gorie: " + uneAction.categorie);
		System.out.println("Montant: "+ uneAction.amount);
		System.out.println("Date: "+ uneAction.date);
		System.out.println("Valid�e: "+ uneAction.validate);
		System.out.println("Automatis�: "+ uneAction.automated);
	}
	
	public void modifyAction(Actions uneAction){
		this.libelle = uneAction.libelle;
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

	public Object[] getActionToObject() {
		return new Object[]{this.libelle, this.getAmount()};
	}
}