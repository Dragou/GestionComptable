package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import view.AddAccountView;
import view.AlertView;
import view.MainView;
import view.ModifyView;

public class MainController implements ActionListener{
	
	private JFrame myView;
		
	public MainController(JFrame V){
		myView = V;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object  source=e.getSource();
		System.out.println(e.getActionCommand());
		if (myView instanceof AddAccountView){
			((AddAccountView) myView).interfaceChange(source);
		}
		else if(myView instanceof MainView){
			((MainView) myView).interfaceChange(source);
		}
		else if(myView instanceof AlertView){
			((AlertView) myView).interfaceChange(source);
		}
		else if(myView instanceof ModifyView){
			((ModifyView) myView).interfaceChange(source);
		}
	}
	
	public void onClick(ButtonActionListener e){
		
	}
}