//학생 성적확인 창
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
		frame.setTitle("성적 확인");
		frame.setLocationRelativeTo(null);
		
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		
		String colName[] = {"이름", "학번", "강좌명", "강좌번호", "학과","교수님","학점","성적"};		//표속성
		DefaultTableModel model = new DefaultTableModel(colName, 0);
		
		int c = 0;
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("현재사용자.txt")));
		String arr = null;
		while ((str = file.readLine()) != null) { 	
			arr=str;
		}	//현재사용자 파일에서 현재사용자의 이름과 학번을 읽어와서
		String[] array = null;
		array = arr.split("/");
		String nuName = array[0];		//현재사용자의 이름을 저장
		String nuNumber = array[1];		//현재 사용자의 학번을 저장
		
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
		
		JButton btnmodify = new JButton("\uC870\uD68C"); //조회버튼 생성
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
		
		JButton namebutton = new JButton("\uC885\uB8CC"); // 종료 버튼
		namebutton.setBounds(488, 13, 74, 29);
		panel.add(namebutton);
		namebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);								
			}
		});
	}
}

