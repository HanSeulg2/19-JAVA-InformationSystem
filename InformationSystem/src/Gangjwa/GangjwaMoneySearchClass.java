//��������� ������ û���� �߱� JTable�� �л��� ��Ÿ����
//���޹��� ���õ� �л����� �̸��� �л����� ������û ������ ����Ǿ� �ִ� �����ͺ��̽�.txt���Ͽ����� �л��̸��� ��ġ�ϴ� ������ JTable�� �߰�
package Gangjwa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class GangjwaMoneySearchClass {
	public boolean check = false;
	public void moneysearchclass(DefaultTableModel model, String sname, String snumber) throws IOException {
		// TODO Auto-generated method stub

		model.setNumRows(0);	//���̺� �ʱ�ȭ
		
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("�����ͺ��̽�.txt")));
		String arr[] = null;
		int i=0;
		while ((str = file.readLine()) != null) { 				
			arr=str.split("/");		
			if(sname.equals(arr[0])) {
				model.addRow(arr);
			i++;
			}
		}	
	}	
}