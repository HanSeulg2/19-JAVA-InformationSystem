package Gangjwa;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import Gangjwa.ContactDAOImple;
import Gangjwa.ContactVO;

public class GangjwaRegister {

	private JFrame frame;
	private JTextField gangjwaName;
	private JTextField gangjwaNumber;
	private JTextField gangjwaMajor;
	private JTextField gangjwaProfessor;
	private JTextField gangjwaScore;
	private JTextField gangjwaMin;
	private JTextField gangjwaMax;
	private JTextField gangjwaExplan;
	private ContactDAOImple dao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GangjwaRegister window = new GangjwaRegister();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public  GangjwaRegister() {
		dao = ContactDAOImple.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("강좌등록");
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("강좌 등록");
		frame.getContentPane().setLayout(null);frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);


		////panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 600, 350);
		frame.getContentPane().add(panel);


		////label
		JLabel label = new JLabel("\uAC15\uC88C\uC774\uB984");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(104, 15, 141, 29);
		panel.add(label);

		gangjwaName = new JTextField();
		gangjwaName.setColumns(10);
		gangjwaName.setBounds(258, 17, 153, 29);
		panel.add(gangjwaName);


		////button
		JButton btngangjwa = new JButton("\uB4F1\uB85D");
		btngangjwa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btngangjwa.setBackground(Color.LIGHT_GRAY);
		btngangjwa.setBounds(464, 215, 90, 29);
		panel.add(btngangjwa);
		
		JLabel label_1 = new JLabel("\uAC15\uC88C\uBC88\uD638");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(104, 56, 141, 29);
		panel.add(label_1);
		
		gangjwaNumber = new JTextField();
		gangjwaNumber.setColumns(10);
		gangjwaNumber.setBounds(258, 58, 153, 29);
		panel.add(gangjwaNumber);
		
		JLabel label_2 = new JLabel("\uB2F4\uB2F9\uD559\uACFC");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(104, 100, 141, 29);
		panel.add(label_2);
		
		gangjwaMajor = new JTextField();
		gangjwaMajor.setColumns(10);
		gangjwaMajor.setBounds(258, 100, 153, 29);
		panel.add(gangjwaMajor);
		
		JLabel label_3 = new JLabel("\uB2F4\uB2F9\uAD50\uC218");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(104, 142, 141, 29);
		panel.add(label_3);
		
		gangjwaProfessor = new JTextField();
		gangjwaProfessor.setColumns(10);
		gangjwaProfessor.setBounds(258, 144, 153, 29);
		panel.add(gangjwaProfessor);
		
		JLabel label_4 = new JLabel("\uD559\uC810");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(104, 188, 141, 29);
		panel.add(label_4);
		
		gangjwaScore = new JTextField();
		gangjwaScore.setColumns(10);
		gangjwaScore.setBounds(258, 190, 153, 29);
		panel.add(gangjwaScore);
		
		JLabel label_5 = new JLabel("\uCD5C\uC18C/\uCD5C\uB300 \uC778\uC6D0");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(104, 232, 141, 29);
		panel.add(label_5);
		
		gangjwaMin = new JTextField();
		gangjwaMin.setColumns(10);
		gangjwaMin.setBounds(258, 234, 56, 29);
		panel.add(gangjwaMin);
		
		gangjwaMax = new JTextField();
		gangjwaMax.setColumns(10);
		gangjwaMax.setBounds(355, 233, 56, 29);
		panel.add(gangjwaMax);
		
		JLabel label_6 = new JLabel("\uC124\uBA85");
		label_6.setBounds(162, 269, 33, 15);
		panel.add(label_6);
		
		gangjwaExplan = new JTextField();
		gangjwaExplan.setBounds(258, 276, 153, 21);
		panel.add(gangjwaExplan);
		gangjwaExplan.setColumns(10);
		
		JButton btnExit = new JButton("\uC644\uB8CC");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(464, 268, 90, 29);
		panel.add(btnExit);
		
		
	}
	protected void insert() {
		// TODO Auto-generated method stub
		String name = gangjwaName.getText();
		String number = gangjwaNumber.getText();
		String major = gangjwaMajor.getText();
		String professor = gangjwaProfessor.getText();
		String min = gangjwaMin.getText();
		String max = gangjwaMax.getText();
		String score = gangjwaScore.getText();
		String explan = gangjwaExplan.getText();
		
		ContactVO contact =new ContactVO(name,number,major,professor,score,min,max,explan);
		//ContactVO 인스턴스 생성해서 강좌 이름, 강좌 버호, 학과 , 교수, 최대 , 최소 , 학점 입력
		
		try{
			BufferedWriter bos = new BufferedWriter(new FileWriter("강좌등록.txt",true));
			bos.write(name+"/");
			bos.write(number+"/");
			bos.write(major+"/");
			bos.write(professor+"/");
			bos.write(score+"/");
			bos.write(min+"/");
			bos.write(max+"/");
			bos.write(explan+"\r\n");
			
			bos.close();
			JOptionPane.showMessageDialog(null, "강좌 등록 성공");
			dispose();
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, "강좌 등록 실패.");
		}
		
		int result = dao.insert(contact); 
		if(result>0) {
			System.out.println("강좌 등록 성공");
		}else {
			System.out.println("강좌 등록 실패");
		}
	}

	private void dispose() {
		// TODO Auto-generated method stub
		
	}
}