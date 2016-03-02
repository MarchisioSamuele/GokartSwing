import javax.swing.table.DefaultTableModel;

/**
 * Created by samuelemarchisio on 02/03/16.
 */
public class MyTableModel extends DefaultTableModel{
    public MyTableModel() {
        super();
    }

    public void clear() {
        while(super.getRowCount() > 0)
            this.removeRow(0);
        while(super.getColumnCount() > 0)
            this.columnIdentifiers.remove(0);
        super.fireTableStructureChanged();
    }

    public void addColumn(String[] columns) {
        for(int i = 0; i < columns.length; i++)
            this.addColumn(columns[i]);
    }
}
