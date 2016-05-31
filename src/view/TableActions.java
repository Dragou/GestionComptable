package view;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.Client;
import view.ButtonRenderer;
import view.ButtonEditor;

public class TableActions extends JTable{
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dm;
	private MainView mainView;

	public TableActions(MainView v){
		super();
		this.setBounds(10, 65, 534, 240);
		this.dm = new DefaultTableModel();
	    initializeModel();
	    this.mainView = v;
	}
	
	public void updateTable(Client user, int numberOfAccount){
		for(int i = 0; i < user.getOneAccount(numberOfAccount).getNumberActions(); i++)
		{
			this.dm.addRow(user.getOneAccount(numberOfAccount).getActions(i));
		}
		dm.setRowCount(user.getOneAccount(numberOfAccount).getNumberActions());
		this.setModel(dm);
		this.repaint();
	}

	public void initializeModel() {
		this.dm.setDataVector(new Object[][] {}, new Object[] { "Libelle", "Debit", "Credit", "Modify"});
	    this.setModel(dm);
		ButtonRenderer bRenderer = new ButtonRenderer();
	    this.getColumn("Modify").setCellRenderer(bRenderer);
	    this.getColumn("Modify").setCellEditor(new ButtonEditor(new JCheckBox(), this.mainView));
	    new JScrollPane(this);
	    this.setVisible(true);
	}
}
