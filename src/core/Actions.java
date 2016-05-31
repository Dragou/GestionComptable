package core;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		if (this.getAmount() < 0){
			return new Object[]{this.libelle, this.getAmount(), "", "Modifier"};
		}
		else
		{
			return new Object[]{this.libelle, "", this.getAmount(), "Modifier"};
		}
	}
	
	public Boolean isCredit(){
		if (this.type.toUpperCase() == "DEBIT")
		{
			return false;
		}
		else{
			return true;
		}
	}
	
	public Boolean isDebit(){
		if (this.type.toUpperCase() == "DEBIT")
		{
			return true;
		}
		else{
			return false;
		}
	}

	public void update(String cat, String libelle2, float amount2, Date date2) {
		this.amount = amount2;
		this.categorie = cat;
		this.date = new SimpleDateFormat("dd/MM/yyyy").format(date2); 
		this.libelle = libelle2;
	}

	public String getCat() {
		return this.categorie;
	}

	public String getDate() {
		return this.date;
	}
}