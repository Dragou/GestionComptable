package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.MainController;

public class AlertView extends JFrame{

	private static final long serialVersionUID = 1L;
	private MainView myView;
	private JButton btn_No;
	private JButton btn_Yes;
	private JLabel lbl_Message;
	
	public AlertView(MainView v, String obj, String objName) {
		this.myView = v;
		String message = "";
		if (obj == "Account"){
			message = "Etes vous sur de vouloir supprimer le compte " + objName + "?";
		}
		if (obj == "Action"){
			message = "Etes vous sur de vouloir supprimer l'action " + objName + "?";
		}
		initialize(message);
	}
	
	private void initialize(String message) {
		MainController controller = new MainController(this);
		this.setSize(400, 150);
		getContentPane().setLayout(null);
		
		btn_No = new JButton("Non");
		btn_No.setBounds(223, 67, 89, 23);
		btn_No.addActionListener(controller);
		getContentPane().add(btn_No);
		
		btn_Yes = new JButton("Oui");
		btn_Yes.setBounds(67, 67, 89, 23);
		btn_Yes.addActionListener(controller);
		getContentPane().add(btn_Yes);
		
		lbl_Message = new JLabel(message);
		lbl_Message.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Message.setBounds(36, 26, 314, 14);
		getContentPane().add(lbl_Message);
		
		this.setVisible(true);
	}

	public void interfaceChange(Object source){
		if  (source == btn_Yes){
			myView.delAccount(true);
			this.dispose();
        }
		else if (source == btn_No){
			myView.delAccount(false);
			this.dispose();
		}
	}
}
