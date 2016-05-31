package view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controller.MainController;

import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

public class ModifyView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textField_Libelle;
	private JTextField textField_Categorie;
	private JButton btn_Modify;
	private JButton btn_Delete;
	private JSpinner spinner_Amount;
	private JSpinner spinner_Date;
	private MainController controller = new MainController(this);
	private MainView mainView;
	
	public ModifyView(MainView v) throws ParseException {
		initialize();
		this.setVisible(true);
		this.mainView = v;
	}
	
	public void initialize() throws ParseException{
		getContentPane().setLayout(null);
		this.setBounds(0, 0, 400, 220);
		
		textField_Libelle = new JTextField();
		textField_Libelle.setBounds(37, 38, 107, 20);
		textField_Libelle.setText(mainView.getNameOfSelectedRow());
		getContentPane().add(textField_Libelle);
		textField_Libelle.setColumns(10);
		
		textField_Categorie = new JTextField();
		textField_Categorie.setBounds(238, 38, 107, 20);
		textField_Categorie.setText(mainView.getCatOfSelectedRow());
		getContentPane().add(textField_Categorie);
		textField_Categorie.setColumns(10);
		
		btn_Modify = new JButton("Modifier");
		btn_Modify.addActionListener(controller);
		btn_Modify.setBounds(216, 131, 89, 23);
		getContentPane().add(btn_Modify);
		
		btn_Delete = new JButton("Supprimer");
		btn_Delete.addActionListener(controller);
		btn_Delete.setBounds(75, 131, 89, 23);
		getContentPane().add(btn_Delete);
		
		spinner_Amount = new JSpinner();
		spinner_Amount.setModel(new SpinnerNumberModel(mainView.getAmountOfSelectedRow(), null, null, new Float(1)));
		spinner_Amount.setBounds(37, 81, 107, 20);
		getContentPane().add(spinner_Amount);
		
		spinner_Date = new JSpinner();
		spinner_Date.setModel(new SpinnerDateModel(mainView.getDateOfSelecteRow(), null, null, Calendar.DAY_OF_YEAR));
		textField_Libelle.setText(mainView.getNameOfSelectedRow());
		spinner_Date.setBounds(238, 81, 107, 20);
		getContentPane().add(spinner_Date);
	}

	public void interfaceChange(Object source) {
		if (source == btn_Delete){
			new AlertView(this.mainView, "Action", this.mainView.getNameOfSelectedRow());
		}
		if (source == btn_Modify){
			this.mainView.updateAction(this.textField_Categorie.getText(), this.textField_Libelle.getText(), (float)this.spinner_Amount.getValue(), (Date)this.spinner_Date.getValue());
		}
	}
}
