package View;


import javax.swing.JTextField;
import Class.Account;
import Controller.AddAccountController;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

public class AddAccountWindow extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account newAccount;
	private JTextField textField_Name;
	private JTextField textField_Amount;
	private JLabel lbl_Name;
	private JLabel lbl_Amount;
	private JButton btn_Add;
	private AddAccountController controller;
	
	public AddAccountWindow() {
		initialize();
		this.setVisible(true);
	}
	
	private void initialize() {
		controller = new AddAccountController(this);
		setTitle("Ajouter un compte");
		getContentPane().setLayout(null);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(88, 21, 86, 20);
		getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Amount = new JTextField();
		textField_Amount.setBounds(88, 52, 86, 20);
		getContentPane().add(textField_Amount);
		textField_Amount.setColumns(10);
		
		lbl_Name = new JLabel("Nom du compte :");
		lbl_Name.setBounds(32, 24, 46, 14);
		getContentPane().add(lbl_Name);
		
		lbl_Amount = new JLabel("Montant actuel :");
		lbl_Amount.setBounds(32, 55, 46, 14);
		getContentPane().add(lbl_Amount);
		
		btn_Add = new JButton("Ajouter");
		btn_Add.setBounds(58, 90, 89, 23);
		getContentPane().add(btn_Add);
	}
	
	public void InterfaceChange(Object source) {
		if  (source == btn_Add)
        {
			newAccount = new Account(this.textField_Name.getText(), Integer.parseInt(this.textField_Amount.getText()));
        }
	}
	
	public Account GetAccount() {
		return this.newAccount;
	}
}
