package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import View.AddAccountView;
import View.AlertView;
import View.MainView;

public class MainController implements ActionListener{
	
	private JFrame myView;
		
	public MainController(JFrame V){
		myView = V;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object  source=e.getSource();
        
		if (myView instanceof AddAccountView){
			((AddAccountView) myView).interfaceChange(source);
		}
		else if(myView instanceof MainView){
			((MainView) myView).interfaceChange(source);
		}
		else if(myView instanceof AlertView){
			((AlertView) myView).interfaceChange(source);
		}
	}
}