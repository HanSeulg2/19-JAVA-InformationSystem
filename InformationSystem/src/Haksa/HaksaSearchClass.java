//�л����� JTable���� ����� ��ȣ�� �˻��ϱ�
package Haksa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class HaksaSearchClass {

	public void haksasearch(JTable table, JTextField searchuser) {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel)table.getModel();  

		final TableRowSorter<TableModel> sorter; // �˻� ����� ���� �߰�
		sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		String expr = searchuser.getText(); // �˻����
		sorter.setRowFilter(RowFilter.regexFilter(expr));
		sorter.setSortKeys(null);		
	}


}




