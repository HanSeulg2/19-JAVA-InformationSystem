//���� �����Է�
package Professor;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class ProfessorAddGrade { 

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorAddGrade window = new ProfessorAddGrade();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public ProfessorAddGrade() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Container contentPane = frame.getContentPane();
		frame.setTitle("���� �Է�");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // ������ ���� �Ұ���
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);


		String colName[] = {"�л��̸�", "�й�", "���Ǹ�", "���ǹ�ȣ", "�а�", "������", "����","����"};		//ǥ�Ӽ�
		DefaultTableModel model = new DefaultTableModel(colName, 0);


		//�α����� �����̸�/������ȣ ��������		
		int c = 0;
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("��������.txt")));
		String arr = null;
		while ((str = file.readLine()) != null) { 	
			arr=str;			
		}
		//


		String[] array = null;
		array = arr.split("/");
		String nuName = array[0];	//�����̸�
		String nuNumber = array[1];	//������ȣ


		//�⼮�� ����ϴ°ǵ� �����̸��̶� �о�� ������û�� ����� ���¿� �ִ� ���� �̸��̶� ������ ���

		String str2 = null;
		String arr2[] = null;
		BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("�����ͺ��̽�.txt")));
		//�л��̸�.�й�.���¸�.���¹�ȣ.�а�.����
		while ((str2 = file2.readLine()) != null) { 	
			arr2 = str2.split("/");			
			if(nuName.equals(arr2[5])) {
				model.addRow(arr2);				
			}
		}

		//

		JTable table = new JTable(model);		//table ����

		TableColumn com = table.getColumnModel().getColumn(7); // ���̺� �޺��ڽ� �ֱ�
		JComboBox box = new JComboBox();
		box.addItem("A");
		box.addItem("B");
		box.addItem("C");
		box.addItem("D");
		box.addItem("F");
		com.setCellEditor(new DefaultCellEditor(box));


		DefaultTableCellRenderer center = new DefaultTableCellRenderer();	//�� �ȿ� ���� �������� ������ ����
		center.setHorizontalAlignment(SwingConstants.CENTER);				//ǥ ���� ��� ���
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<tcm.getColumnCount();i++)
			tcm.getColumn(i).setCellRenderer(center);						//��������� ��� ���


		table.getTableHeader().setReorderingAllowed(false); // �÷��� �̵� �Ұ�
		table.getTableHeader().setResizingAllowed(false); // �÷� ũ�� ���� �Ұ�


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 578, 252);
		frame.getContentPane().add(scrollPane);
		contentPane.add(scrollPane);		//�̰� �־���� ��ũ�� ��

		JPanel panel = new JPanel();
		panel.setBounds(0, 247, 578, 47);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnmodify = new JButton("\uC218\uC815"); //��ư ����


		btnmodify.setBounds(183, 15, 74, 29);
		panel.add(btnmodify);

		JButton button = new JButton("\uC885\uB8CC");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		button.setBounds(324, 15, 74, 29);
		panel.add(button);


		btnmodify.addActionListener(new ActionListener() {	//������ư
			public void actionPerformed(ActionEvent arg0) {

				int row = table.getSelectedRow();

				String sname =(String) table.getValueAt(row, 0);
				String snumber =(String) table.getValueAt(row, 1);
				String gname =(String) table.getValueAt(row, 2);
				String gnumber =(String) table.getValueAt(row, 3);
				String gmajor =(String) table.getValueAt(row, 4);
				String gprofessor =(String) table.getValueAt(row, 5);
				String gcount =(String) table.getValueAt(row, 6);
				String grades =(String) table.getValueAt(row, 7);

				ProfessorAddGradeClass addgradeclass = new ProfessorAddGradeClass();
				addgradeclass.addgradeclass(sname, snumber, gname, gnumber, gmajor, gprofessor,gcount,grades);
			}
		}); //��ư �̺�Ʈó���� ��

	}
}