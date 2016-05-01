package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.AddAccountWindow;

public class AddAccountController implements ActionListener {

	private AddAccountWindow myView;
	
	public AddAccountController(AddAccountWindow V){
		myView = V;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object  source=e.getSource();
        
		myView.InterfaceChange(source);
	}
}
