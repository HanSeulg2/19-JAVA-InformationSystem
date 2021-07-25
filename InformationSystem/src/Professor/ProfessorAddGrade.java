//교수 성적입력
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
		frame.setTitle("성적 입력");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);


		String colName[] = {"학생이름", "학번", "강의명", "강의번호", "학과", "교수명", "학점","성적"};		//표속성
		DefaultTableModel model = new DefaultTableModel(colName, 0);


		//로그인한 교수이름/교수번호 가져오기		
		int c = 0;
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("현재사용자.txt")));
		String arr = null;
		while ((str = file.readLine()) != null) { 	
			arr=str;			
		}
		//


		String[] array = null;
		array = arr.split("/");
		String nuName = array[0];	//교수이름
		String nuNumber = array[1];	//교수번호


		//출석부 출력하는건데 교수이름이랑 읽어온 수강신청된 목록의 강좌에 있는 교수 이름이랑 같으면 출력

		String str2 = null;
		String arr2[] = null;
		BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("데이터베이스.txt")));
		//학생이름.학번.강좌명.강좌번호.학과.교수
		while ((str2 = file2.readLine()) != null) { 	
			arr2 = str2.split("/");			
			if(nuName.equals(arr2[5])) {
				model.addRow(arr2);				
			}
		}

		//

		JTable table = new JTable(model);		//table 생성

		TableColumn com = table.getColumnModel().getColumn(7); // 테이블에 콤보박스 넣기
		JComboBox box = new JComboBox();
		box.addItem("A");
		box.addItem("B");
		box.addItem("C");
		box.addItem("D");
		box.addItem("F");
		com.setCellEditor(new DefaultCellEditor(box));


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

		JButton btnmodify = new JButton("\uC218\uC815"); //버튼 생성


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


		btnmodify.addActionListener(new ActionListener() {	//수정버튼
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
		}); //버튼 이벤트처리기 끝

	}
}