package JavaSwingThuVien;
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class TheModel1 extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;
    public TheModel1(){}
    
    public TheModel1(Object[][] data, String[] columnName){
    
        this.rows = data;
        this.columns = columnName;
    }

    
    public Class getColumnClass(int column){
// 4 is the index of the column image
        if(column == 5){
            return Icon.class;
        }
        else{
            return getValueAt(0,column).getClass();
        }
    }
      

    
    public int getRowCount() {
     return this.rows.length;
    }

    public int getColumnCount() {
     return this.columns.length;
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
    
    return this.rows[rowIndex][columnIndex];
    }
    public String getColumnName(int col){
        return this.columns[col];
    }


}