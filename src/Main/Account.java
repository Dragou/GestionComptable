package Main;

import java.util.ArrayList;

public class Account {

	private int id;
	private String name;
	private float currentAmount;
	private ArrayList<Actions> listAction;
	
	public Account(String newName, float newAmount){
		this.name = newName;
		this.currentAmount = newAmount;
		this.listAction = new ArrayList<Actions>();
	}
	
	public void AddAction(Actions newAction){
		newAction.Check();
		float actionAmount  = newAction.GetAmount();
		this.currentAmount += actionAmount;
		this.listAction.add(newAction);
	}
	
	public void DeleteAction(){
		
	}
}
