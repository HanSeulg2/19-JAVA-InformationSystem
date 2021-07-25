//�л����� ����� ��� JTable�� ���̰��ϱ�
package Haksa;

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

public class HaksaJtable {

	private JFrame frame;
	private JTextField searchuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HaksaJtable window = new HaksaJtable();
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
	public HaksaJtable() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setTitle("ȸ������");
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("����� ���");
		frame.setResizable(false); // ������ ���� �Ұ���
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		Container contentPane = frame.getContentPane();

		String colName[] = {"�̸�", "�а�", "�й�/������ȣ", "�ֹι�ȣ"};		//ǥ�Ӽ�
		DefaultTableModel model = new DefaultTableModel(colName, 0);	//���ο� �� �߰�

		int c = 0;
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("ȸ������.txt")));
		String arr[] = null;
		while ((str = file.readLine()) != null) { 	
			arr = str.split("/");
			for(int i=0; i<arr.length; i++) {
			}	
			model.addRow(arr);
		}

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

		JButton btnChange = new JButton("\uC218\uC815");
		///////////////////////////////////////////////////
		//������ư

		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				String username =(String) table.getValueAt(row, 0);
				String usermajor =(String) table.getValueAt(row, 1);
				String usernumber =(String) table.getValueAt(row, 2);
				String userjumin =(String) table.getValueAt(row, 3);

				HaksaChange haksachange = new HaksaChange();
				try {
					haksachange.haksachange(row,username,usermajor,usernumber,userjumin);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		btnChange.setBounds(321, 15, 74, 29);
		panel.add(btnChange);

		JButton btnSearch = new JButton("\uC870\uD68C");
		///////////////////////////////////////////////////
		//��ȸ��ư
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HaksaSearchClass haksasearch = new HaksaSearchClass();
				haksasearch.haksasearch(table,searchuser);
			}
		});
		btnSearch.setBounds(232, 15, 74, 29);
		panel.add(btnSearch);

		searchuser = new JTextField();
		searchuser.setBounds(131, 16, 97, 27);
		panel.add(searchuser);
		searchuser.setColumns(10);

		JButton btnDelete = new JButton("\uC0AD\uC81C");
		btnDelete.setBounds(412, 15, 74, 29);
		panel.add(btnDelete);

		JButton btnExit = new JButton("\uC885\uB8CC");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setBounds(504, 15, 74, 29);
		panel.add(btnExit);

		JButton button = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		button.addActionListener(new ActionListener() { //���ΰ�ħ ��ư �̺�Ʈ
			public void actionPerformed(ActionEvent arg0) {
				model.setNumRows(0);	//���̺� �ʱ�ȭ
				String str = null;                                        
				BufferedReader file = null;
				try {
					file = new BufferedReader(new InputStreamReader( new FileInputStream("ȸ������.txt")));
					//���, ���� ,������ �ش��ϴ� �̺�Ʈ�� ���� �ǽð����� JTable�� ���� ���� �ֽ�ȭ�۾��Դϴ�.
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String arr[] = null;
				int i=0;
				try {
					while ((str = file.readLine()) != null) { 				
						arr=str.split("/");							
						model.addRow(arr);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		});
		button.setBounds(17, 15, 97, 29);
		panel.add(button);
		///////////////////////////////////////////////////
		//������ư
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				HaksaDeleteClass haksadelete = new HaksaDeleteClass();
				try {
					haksadelete.haksadelete(row);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}

