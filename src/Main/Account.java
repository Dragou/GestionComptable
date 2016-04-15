package Main;

import java.io.Serializable;
import java.util.ArrayList;

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
	
	public void deleteAction(){
		
	}
}
