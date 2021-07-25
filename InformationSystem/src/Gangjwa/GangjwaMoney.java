//��������� ������ û��â
package Gangjwa;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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


public class GangjwaMoney { protected static final JTextField StudentName = null;
// �⼮��

JFrame frame;

/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				GangjwaMoney window = new GangjwaMoney();
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
public GangjwaMoney() throws IOException {
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
	frame.setTitle("û���� �߱�");
	frame.setLocationRelativeTo(null);
	frame.getContentPane().setLayout(null);
	frame.setResizable(false); // ������ ���� �Ұ���
	frame.setVisible(true);

	String colName[] = {"�л��̸�", "�й�", "���¸�", "���¹�ȣ","�а�"};		//ǥ�Ӽ�
	DefaultTableModel model = new DefaultTableModel(colName, 0);


	int i =0;
	String s;
	String[] array;
	BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("ȸ������.txt")));
	while((s=file.readLine())!=null){
		array=s.split("/");			
		String check = array[2];
		if((check.contains("S"))){	
			model.addRow(array);				
		}
	}	//ȸ������.txt������ �а� �� �߿��� �й��� 's'�� ���ԵǾ� �ִ� �л����� ������ ��µǰ� ��.

	JTable table = new JTable(model);		//table ����

	DefaultTableCellRenderer center = new DefaultTableCellRenderer();	//�� �ȿ� ���� �������� ������ ����
	center.setHorizontalAlignment(SwingConstants.CENTER);				//ǥ ���� ��� ���
	TableColumnModel tcm = table.getColumnModel();
	for(int k=0; k<tcm.getColumnCount();k++)
		tcm.getColumn(k).setCellRenderer(center);						//��������� ��� ���


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

	JButton btnSearch = new JButton("\uC870\uD68C"); 
	btnSearch.setBounds(282, 13, 74, 29);
	panel.add(btnSearch);


	btnSearch.addActionListener(new ActionListener() {	//��ȸ��ư
		public void actionPerformed(ActionEvent e) {		
			int row = table.getSelectedRow();
			

			String sname =(String) table.getValueAt(row, 0);
			String snumber =(String) table.getValueAt(row, 1);
			GangjwaMoneySearchClass searchclass = new GangjwaMoneySearchClass();
			try {
				searchclass.moneysearchclass(model, sname,snumber);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});


	JButton btnReceipt = new JButton("\uBC1C\uAE09"); 
	btnReceipt.setBounds(385, 13, 74, 29);
	panel.add(btnReceipt);
	btnReceipt.addActionListener(new ActionListener() {	//�߱޹�ư
		public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
			String sname =(String) table.getValueAt(row, 0);
			String snumber =(String) table.getValueAt(row, 1);
			if(row>=0) {
				GangjwaMoneyClaim moneyclaim = new GangjwaMoneyClaim();
				moneyclaim.moneyclaim(snumber);
			}
			else
				JOptionPane.showMessageDialog(null, "�л��� ���� ��ȸ�ϼ���.");				
		}
	});

	JButton btnExit = new JButton("\uC885\uB8CC");
	btnExit.setBounds(487, 13, 74, 29);
	panel.add(btnExit);

	JButton button = new JButton("\uBAA9\uB85D\uBCF4\uAE30");	//��Ϻ��� ��ư
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			GangjwaMoneyListAgain listagain = new GangjwaMoneyListAgain();
			try {
				listagain.listagain(model);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	});
	button.setBounds(147, 13, 105, 29);
	panel.add(button);
	btnExit.addActionListener(new ActionListener() {	//�����ư
		public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
		}
	});

}
}

