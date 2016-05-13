package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import View.MainView;

public class MainController implements ActionListener{
	
	private MainView myView;
		
	public MainController(MainView V){
		myView = V;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object  source=e.getSource();
        
		myView.InterfaceChange(source);
	}
}