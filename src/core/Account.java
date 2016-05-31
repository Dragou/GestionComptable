package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private float currentAmount;
	private ArrayList<Actions> listAction;
	
	public Account(){
		this("Sans titre", 0);
	}
	
	public Account(String newName, float newAmount){
		this.name = newName;
		this.currentAmount = newAmount;
		this.listAction = new ArrayList<Actions>();
	}
	
	public void addAction(Actions newAction){
		float actionAmount  = newAction.getAmount();
		this.currentAmount += actionAmount;
		this.listAction.add(newAction);
	}
	
	public void deleteAction(int indexAction){
		Actions newAction = this.listAction.get(indexAction - 1);
		this.listAction.remove(newAction);
	}
	
	public void showAllActions(){
		System.out.println("Toutes les actions sur le comte " + this.name + ": ");
		for (Actions action : listAction) {
			action.showAction(action);
		}
	}
	
	public int getLastIdActions(){
		ArrayList<Integer> listId = new ArrayList<Integer>();
		
		for (Actions actions : listAction) {
			listId.add(actions.getId());			
		}
		try{
			return Collections.max(listId);
		}catch(Exception e){
			return 0;
		}
	}
	
	public void showAccount() {
		System.out.println(this.name + " : " + this.currentAmount);
	}

	public String getName() {
		return this.name;
	}
	
	public int getNumberActions() {
		return this.listAction.size();
	}

	public Object[] getActions(int index) {
		return this.listAction.get(index).getActionToObject();
	}
	
	public float getAmount(){
		return this.currentAmount;
	}
	
	public float getCreditSum(){
		float sum = 0;
		for (Actions actions : listAction) {
			if (actions.isCredit()) {
				sum += actions.getAmount();
			}
		}
		return sum;
	}
	
	public float getDebitSum(){
		float sum = 0;
		for (Actions actions : listAction) {
			if (actions.isDebit()) {
				sum += actions.getAmount();
			}
		}
		return sum;
	}

	public void updateAction(int i, String cat, String libelle, float amount, Date date) {
		this.listAction.get(i).update(cat, libelle, amount, date);
	}

	public Actions getOneAction(int selectedRow) {
		return this.listAction.get(selectedRow - 1);
	}
}
