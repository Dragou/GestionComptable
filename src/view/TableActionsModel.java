package view;

import javax.swing.table.DefaultTableModel;

public class TableActionsModel extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	
	public TableActionsModel(){
		this.setDataVector(new Object[][] { { "", "", "", "Modifier", "Supprimer"},
	        {  "", "", "", "Modifier", "Supprimer" } }, new Object[] { "Libelle", "Debit", "Credit", "Modify", "Delete" });
	}
}
