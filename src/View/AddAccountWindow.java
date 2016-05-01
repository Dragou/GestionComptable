package View;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Controller.AddAccountController;
import Controller.MainController;

import javax.swing.JLabel;
import javax.swing.JButton;

public class AddAccountWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private AddAccountController controller;
	
	public AddAccountWindow() {
		initialize();
	}
	
	private void initialize() {
		controller = new AddAccountController(this);
		setTitle("Ajouter un compte");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(88, 21, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 52, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(32, 24, 46, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(32, 55, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(58, 90, 89, 23);
		getContentPane().add(btnNewButton);
	}
	
	public void InterfaceChange(Object source) {
		/*if  (source == btn_AddAccount)
        {
            AddAccountWindow newAccountView = new AddAccountWindow();
        }
        else if (source == btn_DeleteAccount)
        {
        	
        }
        else if (source == btn_AddAction)
        {
        	//Home();
        	System.out.println("test");
        }*/
	}
}
