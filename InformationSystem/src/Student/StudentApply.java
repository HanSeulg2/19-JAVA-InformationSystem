//수강신청
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
		frame.setTitle("수강신청");
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		Container contentPane = frame.getContentPane();		//이거랑 

		String colName[] = {"강좌명", "강좌번호", "학과", "교수님","학점"};		//표속성
		DefaultTableModel model = new DefaultTableModel(colName, 0);	//새로운 행 추가

		int c = 0;
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("강좌등록.txt")));
		String arr[] = null;
		while ((str = file.readLine()) != null) { 	
			arr = str.split("/");
			for(int i=0; i<arr.length; i++) {		
			}	//for문 끝
			model.addRow(arr);		//새로운 행추가 arr배열이 추가됨[	강좌명,강좌번호,학과,교수님,학점]
		}			//while 문 끝(제일 처음 txt읽는거)

		JTable table = new JTable(model);		//table 생성	   

		DefaultTableCellRenderer center = new DefaultTableCellRenderer();	//셀 안에 들어가는 데이터의 정렬을 조절
		center.setHorizontalAlignment(SwingConstants.CENTER);				//표 내용 가운데 출력
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<tcm.getColumnCount();i++)
			tcm.getColumn(i).setCellRenderer(center);						//여기까지가 가운데 출력


		table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 578, 252);
		frame.getContentPane().add(scrollPane);
		contentPane.add(scrollPane);		//이거 있어야지 스크롤 댐

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
		btnSearch.addActionListener(new ActionListener() {	//조회버튼
			public void actionPerformed(ActionEvent e) {
				StudentApplySearchClass applysearch = new StudentApplySearchClass();
				applysearch.applysearch(table,searchgangjwaNumber);
			}	//객체를 생성하여 클래스에 해당하는 함수를 이용한다.
		});
		
		
		
		btnSearch.setBounds(325, 12, 74, 29);
		panel.add(btnSearch);

		JButton btnApply = new JButton("\uC2E0\uCCAD"); //버튼 생성


		btnApply.setBounds(422, 12, 74, 29);
		panel.add(btnApply);
		
		JButton btnList = new JButton("\uBAA9\uB85D\uBCF4\uAE30");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setNumRows(0);	//테이블 초기화

				int c = 0;
				String str = null;
				BufferedReader file = null;
				try {
					file = new BufferedReader(new InputStreamReader( new FileInputStream("강좌등록.txt")));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String arr[] = null;
				try {
					while ((str = file.readLine()) != null) { 	
						arr = str.split("/");
						for(int i=0; i<arr.length; i++) {		
						}	//for문 끝
						model.addRow(arr);		//새로운 행추가 arr배열이 추가됨[	강좌명,강좌번호,학과,교수님,학점]
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			//while 문 끝(제일 처음 txt읽는거)
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


		btnApply.addActionListener(new ActionListener() {	//신청버튼
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();

				String gname =(String) table.getValueAt(row, 0);
				String gnumber =(String) table.getValueAt(row, 1);
				String gmajor =(String) table.getValueAt(row, 2);
				String gprofessor =(String) table.getValueAt(row, 3);
				String gcount =(String) table.getValueAt(row, 4);
				
				StudentApplyClass apply = new StudentApplyClass();
				apply.apply(row,gname,gnumber,gmajor,gprofessor,gcount);
			}	//객체를 생성하여 클래스에 해당하는 함수를 이용
		}); 
	}
}
