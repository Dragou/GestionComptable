package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

import Class.Client;
import Class.DataManager;
import Controller.MainController;

import javax.swing.JComboBox;

public class MainView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Client user;
	private JLabel lbl_Hello;
	private JTable table_Actions;
	private JComboBox comboBox_Account;
	private JButton btn_AddAccount;
	private JButton btn_DeleteAccount;
	private JButton btn_AddAction;
	private MainController controller; 
	
	public MainView() {
		this.user = new Client();
		initialize();
		this.setVisible(true);
	}

	private void initialize() {
		DataManager.initAccount(user);
		controller = new MainController(this);
		getContentPane().setLayout(null);
		
		lbl_Hello = new JLabel("Bonjour ");
		lbl_Hello.setBounds(10, 11, 46, 14);
		getContentPane().add(lbl_Hello);
		
		table_Actions = new JTable();
		table_Actions.setBounds(10, 67, 458, 240);
		getContentPane().add(table_Actions);
		
		comboBox_Account = new JComboBox();
		comboBox_Account.setBounds(10, 34, 184, 20);
		getContentPane().add(comboBox_Account);
		
		btn_AddAccount = new JButton("Ajouter un compte");
		btn_AddAccount.setBounds(204, 33, 121, 23);
		getContentPane().add(btn_AddAccount);
		
		btn_DeleteAccount = new JButton("Supprimer le compte");
		btn_DeleteAccount.setBounds(335, 33, 133, 23);
		getContentPane().add(btn_DeleteAccount);
		
		btn_AddAction = new JButton("Ajouter une action");
		btn_AddAction.setBounds(347, 318, 121, 23);
		getContentPane().add(btn_AddAction);
	}

	public void InterfaceChange(Object source) {
		if  (source == btn_AddAccount)
        {
			this.enable(false);
            AddAccountWindow newAccountView = new AddAccountWindow();
            this.user.addAccount(newAccountView.GetAccount());
        }
        else if (source == btn_DeleteAccount)
        {
        	Object nameDeletedAccount = this.comboBox_Account.getSelectedItem();
        }
        else if (source == btn_AddAction)
        {
        	//Home();
        	System.out.println("test");
        }
	}
}
