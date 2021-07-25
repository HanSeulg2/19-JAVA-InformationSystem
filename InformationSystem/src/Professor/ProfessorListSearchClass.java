package Professor;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ProfessorListSearchClass {

	public void listsearch(JTable table, JTextField searchuser) {
		// TODO Auto-generated method stub
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();

		final TableRowSorter<TableModel> sorter; // 검색 기능을 위해 추가
		sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		String expr = searchuser.getText(); // 검색기능
		sorter.setRowFilter(RowFilter.regexFilter(expr));
		sorter.setSortKeys(null);	
		
	} // 검색 기능
}


