//�л� ����Ȯ�� Ŭ����
package Student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentCheckGradeClass {	//��ȸ��ư�� ������ �� ����Ǵ� �̺�Ʈó���� �ڵ�

	public void checkgradeclass(DefaultTableModel model, String nuName, String nuNumber) throws IOException {
		// TODO Auto-generated method stub
		
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("�����Է�.txt")));
		String arr[] = null;
		while ((str = file.readLine()) != null) { 	
			arr = str.split("/");
			if(nuName.equals(arr[0])) {		//���������̸��� �����Է�.txt�� ����� �л��̸��� ���� �����鸸 JTable�� �߰�
				model.addRow(arr);
			}
		}
		
	}
}



