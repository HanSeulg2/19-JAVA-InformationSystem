//강좌 번호로 검색하는 기능
package Student;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StudentApplySearchClass {
	public boolean check = false;
	public void applysearch(JTable table, JTextField searchgangjwaNumber) {
		// TODO Auto-generated method stub

		DefaultTableModel model = (DefaultTableModel)table.getModel();

		final TableRowSorter<TableModel> sorter; // 검색 기능을 위해 추가
		sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		String expr = searchgangjwaNumber.getText(); // 검색기능
		sorter.setRowFilter(RowFilter.regexFilter(expr));
		sorter.setSortKeys(null);
	}
}
