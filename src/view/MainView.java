package view;

import javax.swing.JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;

import controller.MainController;
import core.Account;
import core.Client;
import core.DataManager;
import core.UnitTest;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class MainView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private Client user;
	private JLabel lbl_Hello;
	private TableActions table_Actions;
	JComboBox<String> comboBox_Account;
	private JButton btn_AddAccount;
	private JButton btn_DeleteAccount;
	private JButton btn_AddAction;
	private MainController controller;
	private JLabel lbl_CurrentAmount;
	private JLabel lbl_Debit;
	private JLabel lbl_Credit;
	
	public MainView() {
		this.user = new Client();
		initialize();
		repaintCombobox();
		this.setVisible(true);
	}

	private void initialize() {
		setTitle("ED Gest");
		DataManager.initAccount(user, "Client.serial");
		this.user = UnitTest.Initialisation(this.user);
		controller = new MainController(this);
		this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        System.exit(0);
		      }});
		this.setBounds(0, 0, 570, 450);
		getContentPane().setLayout(null);
		
		lbl_Hello = new JLabel("Bonjour " + user.getName());
		lbl_Hello.setBounds(10, 11, 534, 14);
		getContentPane().add(lbl_Hello);

	    table_Actions = new TableActions(this);
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
		btn_DeleteAccount.addActionListener(controller);
		getContentPane().add(btn_DeleteAccount);
		
		btn_AddAction = new JButton("Ajouter une action");
		btn_AddAction.setBounds(378, 377, 166, 23);
		getContentPane().add(btn_AddAction);
		
		lbl_CurrentAmount = new JLabel("Montant actuel du compte :");
		lbl_CurrentAmount.setBounds(238, 352, 306, 14);
		getContentPane().add(lbl_CurrentAmount);
		
		lbl_Debit = new JLabel("New label");
		lbl_Debit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Debit.setBounds(107, 316, 107, 14);
		getContentPane().add(lbl_Debit);
		
		lbl_Credit = new JLabel("New label");
		lbl_Credit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Credit.setBounds(224, 316, 107, 14);
		getContentPane().add(lbl_Credit);
	}

	public void interfaceChange(Object source) {
		if  (source == btn_AddAccount)
        {
			this.setEnabled(false);
            new AddAccountView(this);
            this.setEnabled(true);
        }
        else if (source == btn_DeleteAccount)
        {
        	new AlertView(this, "Account", this.comboBox_Account.getSelectedItem().toString());
        }
        else if (source == btn_AddAction)
        {
        	System.out.println("test");
        }
        else if(source == comboBox_Account)
        {
        	if (this.comboBox_Account.getSelectedIndex() != -1){
        		table_Actions.updateTable(user, comboBox_Account.getSelectedIndex());
        		lbl_CurrentAmount.setText("Montant actuel du compte : " + this.user.getOneAccount(comboBox_Account.getSelectedIndex()).getAmount());
        		lbl_Debit.setText(String.valueOf(this.user.getOneAccount(comboBox_Account.getSelectedIndex()).getDebitSum()));
        		lbl_Credit.setText(String.valueOf(this.user.getOneAccount(comboBox_Account.getSelectedIndex()).getCreditSum()));
    		}
        }
	}
	
	public void addAccount(String name, float amount) {
		this.user.addAccount(new Account(name, amount));
		DataManager.saveAccount(user, "Client.serial");
		repaintCombobox();
	}
	
	public void delAccount(Boolean condition) {
		if (condition){
			this.user.deleteAccount(this.comboBox_Account.getSelectedIndex());
			DataManager.saveAccount(user, "Client.serial");
			this.repaintCombobox();
		}
	}
	
	private void repaintCombobox() {
		System.out.println(user.getNumberAccount());
		this.comboBox_Account.removeAllItems();
		for (int i = this.comboBox_Account.getItemCount(); i < user.getNumberAccount(); i++) {
			comboBox_Account.addItem(user.getOneAccount(i).getName());
		}
	}

	public void updateAction(String cat, String libelle, float amount, Date date) {
		this.user.getOneAccount(this.comboBox_Account.getSelectedIndex()).updateAction(this.table_Actions.getSelectedRow(), cat, libelle, amount, date);
	}
	
	public String getNameOfSelectedRow(){
		int row = this.table_Actions.getSelectedRow();
		return this.table_Actions.getValueAt(row, 1).toString();
	}
	
	public float getAmountOfSelectedRow(){
		if (this.table_Actions.getValueAt(this.table_Actions.getSelectedRow(), 2) == null)
			return (float) this.table_Actions.getValueAt(this.table_Actions.getSelectedRow(), 3);
		else
			return (float) this.table_Actions.getValueAt(this.table_Actions.getSelectedRow(), 2);
	}
	
	public String getCatOfSelectedRow(){
		return this.user.getOneAccount(this.comboBox_Account.getSelectedIndex()).getOneAction(this.table_Actions.getSelectedRow()).getCat();
	}
	
	public Date getDateOfSelecteRow() throws ParseException{
		return new SimpleDateFormat("dd-MMM-yyyy").parse(this.user.getOneAccount(this.comboBox_Account.getSelectedIndex()).getOneAction(this.table_Actions.getSelectedRow()).getDate());
	}
}
