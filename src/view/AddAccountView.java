package view;


import javax.swing.JTextField;

import controller.MainController;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AddAccountView extends JFrame{

	private static final long serialVersionUID = 1L;
	private MainView mainView;
	private JTextField textField_Name;
	private JLabel lbl_Name;
	private JLabel lbl_Amount;
	private JButton btn_Add;
	private MainController controller;
	private JSpinner spinner;
	
	public AddAccountView(MainView v) {
		initialize();
		this.setVisible(true);
		this.mainView = v;
	}
	
	private void initialize() {
		controller = new MainController(this);
		this.setSize(246, 168);
		setTitle("Ajouter un compte");
		getContentPane().setLayout(null);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(131, 21, 86, 20);
		getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		lbl_Name = new JLabel("Nom du compte :");
		lbl_Name.setBounds(10, 24, 111, 14);
		getContentPane().add(lbl_Name);
		
		lbl_Amount = new JLabel("Montant actuel :");
		lbl_Amount.setBounds(10, 55, 111, 14);
		getContentPane().add(lbl_Amount);
		
		btn_Add = new JButton("Ajouter");
		btn_Add.setBounds(70, 83, 89, 23);
		btn_Add.addActionListener(controller);
		getContentPane().add(btn_Add);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(0.5)));
		spinner.setBounds(131, 52, 86, 20);
		getContentPane().add(spinner);
	}
	
	public void interfaceChange(Object source) {
		if  (source == btn_Add)
        {
			if ((float)this.spinner.getValue() != 0 && this.textField_Name.getText().length() != 0){
				try {
					this.mainView.addAccount(this.textField_Name.getText(), (float)(this.spinner.getValue()));
					this.dispose();
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			}
        }
	}
}
