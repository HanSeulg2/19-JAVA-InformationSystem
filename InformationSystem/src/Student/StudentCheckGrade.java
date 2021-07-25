//�л� ����Ȯ�� â
package Student;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class StudentCheckGrade {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentCheckGrade window = new StudentCheckGrade();
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
	public StudentCheckGrade() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Container contentPane = frame.getContentPane();
		frame.setTitle("���� Ȯ��");
		frame.setLocationRelativeTo(null);
		
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // ������ ���� �Ұ���
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		
		String colName[] = {"�̸�", "�й�", "���¸�", "���¹�ȣ", "�а�","������","����","����"};		//ǥ�Ӽ�
		DefaultTableModel model = new DefaultTableModel(colName, 0);
		
		int c = 0;
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("��������.txt")));
		String arr = null;
		while ((str = file.readLine()) != null) { 	
			arr=str;
		}	//�������� ���Ͽ��� ���������� �̸��� �й��� �о�ͼ�
		String[] array = null;
		array = arr.split("/");
		String nuName = array[0];		//���������� �̸��� ����
		String nuNumber = array[1];		//���� ������� �й��� ����
		
		JTable table = new JTable(model);		//table ����

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
		
		JButton btnmodify = new JButton("\uC870\uD68C"); //��ȸ��ư ����
		btnmodify.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				StudentCheckGradeClass checkgradeclass = new StudentCheckGradeClass();
				try {
					checkgradeclass.checkgradeclass(model,nuName,nuNumber);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
		});
		
		
		btnmodify.setBounds(402, 13, 74, 29);
		panel.add(btnmodify);
		
		JButton namebutton = new JButton("\uC885\uB8CC"); // ���� ��ư
		namebutton.setBounds(488, 13, 74, 29);
		panel.add(namebutton);
		namebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);								
			}
		});
	}
}

