//���� ��ȣ�� �˻��ϴ� ���
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

		final TableRowSorter<TableModel> sorter; // �˻� ����� ���� �߰�
		sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		String expr = searchgangjwaNumber.getText(); // �˻����
		sorter.setRowFilter(RowFilter.regexFilter(expr));
		sorter.setSortKeys(null);
	}
}
