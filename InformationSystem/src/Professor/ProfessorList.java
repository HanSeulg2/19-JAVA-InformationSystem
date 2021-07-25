//교수 출석부 JTable
package Professor;

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


public class ProfessorList {

	JFrame frame;
	private JTextField gangjwaName;
	private JTextField searchuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorList window = new ProfessorList();
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
	public ProfessorList() throws IOException {
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
		frame.setTitle("출석부");
		frame.setLocationRelativeTo(null);
		
		frame.getContentPane().setLayout(null);frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		
		String colName[] = {"학생이름", "학번", "강의명", "강의번호", "학과"};		//표속성
		DefaultTableModel model = new DefaultTableModel(colName, 0);
		
				
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
		
		JLabel text = new JLabel("\uD559\uBC88");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBounds(125, 270, 74, 21);
		frame.getContentPane().add(text);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessorListSearchClass listsearch = new ProfessorListSearchClass();
				listsearch.listsearch(table,searchuser);
			}
		});
		btnSearch.setBounds(310, 267, 74, 29);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExit = new JButton("\uC885\uB8CC");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setBounds(489, 268, 74, 29);
		frame.getContentPane().add(btnExit);
		
		searchuser = new JTextField();
		searchuser.setColumns(10);
		searchuser.setBounds(191, 267, 103, 27);
		frame.getContentPane().add(searchuser);
		
		//로그인한 교수이름/교수번호 가져오기
				int c = 0;
				String str = null;
				BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("현재사용자.txt")));
				String arr = null;
				while ((str = file.readLine()) != null) { 	
					arr=str;			
				}
				
				String[] array = null;
				array = arr.split("/");
				String nuName = array[0];	//교수이름
				String nuNumber = array[1];	//교수번호
		
		//출석부 출력하는건데 교수이름이랑 읽어온 수강신청된 목록의 강좌에 있는 교수 이름이랑 같으면 출력
		String str2 = null;
		BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("데이터베이스.txt")));
		//학생이름.학번.강좌명.강좌번호.학과.교수
		String arr2[] = null;
		while ((str2 = file2.readLine()) != null) { 	
			arr2 = str2.split("/");			
			if(nuName.equals(arr2[5])) {
				model.addRow(arr2);				
			}
		}		
	}
}

