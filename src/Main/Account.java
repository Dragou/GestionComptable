package Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Account implements Serializable{

	private int id;
	private String name;
	private float currentAmount;
	private ArrayList<Actions> listAction;
	
	public Account(){
		this.name = "Sans titre";
		this.currentAmount = 0;
		this.listAction = new ArrayList<Actions>();
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
	
	public void deleteAction(Actions newAction){
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
		
		int max = Collections.max(listId);
		
		return max;		
	}
	
	
}
