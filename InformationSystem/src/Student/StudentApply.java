//������û
package Student;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentApply {

	private JFrame frame;
	private JTextField searchgangjwaNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentApply window = new StudentApply();
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
	public StudentApply() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setTitle("������û");
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // ������ ���� �Ұ���
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		Container contentPane = frame.getContentPane();		//�̰Ŷ� 

		String colName[] = {"���¸�", "���¹�ȣ", "�а�", "������","����"};		//ǥ�Ӽ�
		DefaultTableModel model = new DefaultTableModel(colName, 0);	//���ο� �� �߰�

		int c = 0;
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("���µ��.txt")));
		String arr[] = null;
		while ((str = file.readLine()) != null) { 	
			arr = str.split("/");
			for(int i=0; i<arr.length; i++) {		
			}	//for�� ��
			model.addRow(arr);		//���ο� ���߰� arr�迭�� �߰���[	���¸�,���¹�ȣ,�а�,������,����]
		}			//while �� ��(���� ó�� txt�д°�)

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

		JLabel searchgangjwaNUMBER = new JLabel("\uAC15\uC88C\uBC88\uD638");
		searchgangjwaNUMBER.setHorizontalAlignment(SwingConstants.CENTER);
		searchgangjwaNUMBER.setBounds(137, 14, 82, 21);
		panel.add(searchgangjwaNUMBER);

		searchgangjwaNumber = new JTextField();
		searchgangjwaNumber.setBounds(217, 11, 103, 27);
		panel.add(searchgangjwaNumber);
		searchgangjwaNumber.setColumns(10);

		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(new ActionListener() {	//��ȸ��ư
			public void actionPerformed(ActionEvent e) {
				StudentApplySearchClass applysearch = new StudentApplySearchClass();
				applysearch.applysearch(table,searchgangjwaNumber);
			}	//��ü�� �����Ͽ� Ŭ������ �ش��ϴ� �Լ��� �̿��Ѵ�.
		});
		
		
		
		btnSearch.setBounds(325, 12, 74, 29);
		panel.add(btnSearch);

		JButton btnApply = new JButton("\uC2E0\uCCAD"); //��ư ����


		btnApply.setBounds(422, 12, 74, 29);
		panel.add(btnApply);
		
		JButton btnList = new JButton("\uBAA9\uB85D\uBCF4\uAE30");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setNumRows(0);	//���̺� �ʱ�ȭ

				int c = 0;
				String str = null;
				BufferedReader file = null;
				try {
					file = new BufferedReader(new InputStreamReader( new FileInputStream("���µ��.txt")));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String arr[] = null;
				try {
					while ((str = file.readLine()) != null) { 	
						arr = str.split("/");
						for(int i=0; i<arr.length; i++) {		
						}	//for�� ��
						model.addRow(arr);		//���ο� ���߰� arr�迭�� �߰���[	���¸�,���¹�ȣ,�а�,������,����]
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			//while �� ��(���� ó�� txt�д°�)
			}
		});
		btnList.setBounds(17, 11, 113, 29);
		panel.add(btnList);
		
		JButton button = new JButton("\uC885\uB8CC");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		button.setBounds(503, 12, 74, 29);
		panel.add(button);


		btnApply.addActionListener(new ActionListener() {	//��û��ư
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();

				String gname =(String) table.getValueAt(row, 0);
				String gnumber =(String) table.getValueAt(row, 1);
				String gmajor =(String) table.getValueAt(row, 2);
				String gprofessor =(String) table.getValueAt(row, 3);
				String gcount =(String) table.getValueAt(row, 4);
				
				StudentApplyClass apply = new StudentApplyClass();
				apply.apply(row,gname,gnumber,gmajor,gprofessor,gcount);
			}	//��ü�� �����Ͽ� Ŭ������ �ش��ϴ� �Լ��� �̿�
		}); 
	}
}
