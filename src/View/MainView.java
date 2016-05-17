package View;

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.MainController;
import core.Account;
import core.Client;
import core.DataManager;

import javax.swing.JComboBox;

public class MainView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private Client user;
	private JLabel lbl_Hello;
	private JTable table_Actions;
	private JComboBox<String> comboBox_Account;
	private JButton btn_AddAccount;
	private JButton btn_DeleteAccount;
	private JButton btn_AddAction;
	private MainController controller;
	private DefaultTableModel tableModel;
	
	public MainView() {
		this.user = new Client();
		
		/*user = new Client("Elise");
		user.addAccount(new Account("Dimitri", 50));
		user.addAccount(new Account("Elise", 50));
		user.getOneAccount(1).addAction(new Actions(user.getOneAccount(1).getLastIdActions()+1, "Halo 5", "Jeux", "DEBIT", 50, "", ""));
		user.getOneAccount(1).addAction(new Actions(user.getOneAccount(1).getLastIdActions()+1, "Pates", "Nourriture", "DEBIT", 5, "", ""));
		DataManager.saveAccount(user, "Client.serial");*/
		initialize();
		System.out.println(user.getNumberAccount());
		
		for (int i = 0; i < user.getNumberAccount(); i++) {
			comboBox_Account.addItem(user.getOneAccount(i + 1).getName());
		}
		this.setVisible(true);
	}

	private void initialize() {
		setTitle("ED Gest");
		DataManager.initAccount(user, "Client.serial");
		controller = new MainController(this);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 570, 400);
		getContentPane().setLayout(null);
		
		lbl_Hello = new JLabel("Bonjour " + user.getName());
		lbl_Hello.setBounds(10, 11, 534, 14);
		getContentPane().add(lbl_Hello);

		table_Actions = new JTable();
		table_Actions.setBounds(10, 65, 534, 240);
		getContentPane().add(table_Actions);
		
		comboBox_Account = new JComboBox<String>();
		comboBox_Account.addActionListener(controller);
		comboBox_Account.setBounds(10, 34, 184, 20);
		comboBox_Account.setMaximumRowCount(10);
		comboBox_Account.addActionListener(controller);
		getContentPane().add(comboBox_Account);
		
		btn_AddAccount = new JButton("Ajouter un compte");
		btn_AddAccount.addActionListener(controller);
		btn_AddAccount.setBounds(378, 31, 166, 23);
		getContentPane().add(btn_AddAccount);
		
		btn_DeleteAccount = new JButton("Supprimer le compte");
		btn_DeleteAccount.setBounds(204, 31, 166, 23);
		getContentPane().add(btn_DeleteAccount);
		
		btn_AddAction = new JButton("Ajouter une action");
		btn_AddAction.setBounds(378, 316, 166, 23);
		getContentPane().add(btn_AddAction);
	}

	public void interfaceChange(Object source) {
		if  (source == btn_AddAccount)
        {
			this.setEnabled(false);
            AddAccountView newAccountView = new AddAccountView(this);
            
            this.setEnabled(true);
        }
        else if (source == btn_DeleteAccount)
        {
        	AlertView newAlert = new AlertView(this, "Account", this.comboBox_Account.getSelectedItem().toString());
        }
        else if (source == btn_AddAction)
        {
        	//Home();
        	System.out.println("test");
        }
        else if(source == comboBox_Account)
        {
        	tableModel = (DefaultTableModel)table_Actions.getModel();
    		tableModel.addColumn("Libelle");
    		tableModel.addColumn("Montant");
    		
    		for(int i = 0; i < this.user.getOneAccount(1).getNumberActions(); i++)
    		{
    			tableModel.addRow(this.user.getOneAccount(1).getActions(i));
    		}
    		
    		table_Actions.setModel(tableModel);
    		table_Actions.repaint();
        }
	}
	
	public void addAccount(String name, int amount) {
		this.user.addAccount(new Account(name, amount));
	}
	
	public void delAccount(Boolean condition) {
		if (condition){
			this.user.deleteAccount(this.user.findAccountIndex(this.comboBox_Account.getSelectedItem().toString()));
		}
	}
}
