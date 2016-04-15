package Main;

import java.util.Date;

public class Actions {
	private int id;
	private String libelle;
	private String categorie;
	private String type;
	private float amount;
	private Date date;
	private Boolean validate;
	private String automated;
	
	public Actions(String unLibelle,String uneCategorie, String unType, float unAmount, Date uneDate, String unAutomated){
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
	

	//Renvoyer le montant avec un "-" si c'est un débit
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
		System.out.println("Catégorie: " + uneAction.categorie);
		System.out.println("Montant: "+ uneAction.amount);
		System.out.println("Date: "+ uneAction.date);
		System.out.println("Validée: "+ uneAction.validate);
		System.out.println("Automatisé: "+ uneAction.automated);
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
	
}