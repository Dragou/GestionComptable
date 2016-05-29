package view;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.ButtonRenderer;
import view.ButtonEditor;

public class TableActions extends JTable{
	private static final long serialVersionUID = 1L;

	public TableActions(DefaultTableModel dm){
		super();
		this.setBounds(10, 65, 534, 240);
	    this.setModel(dm);
		ButtonRenderer bRenderer = new ButtonRenderer();
	    this.getColumn("Modify").setCellRenderer(bRenderer);
	    this.getColumn("Modify").setCellEditor(new ButtonEditor(new JCheckBox()));
	    this.getColumn("Delete").setCellRenderer(bRenderer);
	    this.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox()));
	    new JScrollPane(this);
	}
	
}
