//학생창
package Student;

import java.awt.Color;
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
import javax.swing.SwingConstants;

import Login.Login;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

public class Student {

	private JFrame frame;
	private JTextField getName;
	private JTextField getNumber;
	private JTextField getMajor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
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
	public Student() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {

		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("C:\\Users\\joe24\\eclipse-workspace\\MyprojectREAL\\현재사용자.txt")));
		//1-이름 2-학과 3-학번
		String arr[] = null;
		while ((str = file.readLine()) != null) { 	
			arr = str.split("/");
		}
		String name = arr[0];
		String number = arr[1];

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("STUDENT");
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);


		////panel
		JPanel studentpanel = new JPanel();
		studentpanel.setBounds(0, 0, 600, 350);
		studentpanel.setBackground(Color.WHITE);
		frame.getContentPane().add(studentpanel);
		studentpanel.setLayout(null);


		////수강신청
		JButton subutton = new JButton("\uC218\uAC15\uC2E0\uCCAD");
		subutton.setIcon(new ImageIcon("C:\\Users\\\uBC31\uB2E4\uC740\\Desktop\\su.jpg"));
		subutton.setBounds(254, 36, 168, 66);
		subutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new StudentApply();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
			}
		});
		subutton.setContentAreaFilled(false); // 버튼 안에 색 지우기
		subutton
		.setFocusPainted(false);
		studentpanel.add(subutton);

		//성적확인
		JButton button = new JButton("\uC131\uC801\uD655\uC778");
		button.setIcon(new ImageIcon("C:\\Users\\\uBC31\uB2E4\uC740\\Desktop\\else.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new StudentCheckGrade();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button.setBounds(254, 126, 168, 66);
		button.setContentAreaFilled(false);
		studentpanel.add(button);

		//개인정보
		JButton mybutton = new JButton("\uAC1C\uC778 \uC815\uBCF4");
		mybutton.setIcon(new ImageIcon("C:\\Users\\\uBC31\uB2E4\uC740\\Desktop\\my.jpg"));
		mybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new StudentInformationChange();  //학생 개인정보 수정창 뜨게하기
			}
		});
		mybutton.setBounds(254, 213, 168, 66);
		mybutton.setContentAreaFilled(false);
		studentpanel.add(mybutton);

		getName = new JTextField(name);
		getName.setEditable(false);
		getName.setHorizontalAlignment(SwingConstants.CENTER);
		getName.setFont(new Font("굴림", Font.PLAIN, 25));
		getName.setBounds(41, 107, 145, 33);
		studentpanel.add(getName);
		getName.setColumns(10);

		getNumber = new JTextField(number);
		getNumber.setEditable(false);
		getNumber.setHorizontalAlignment(SwingConstants.CENTER);
		getNumber.setBounds(41, 163, 145, 33);
		studentpanel.add(getNumber);
		getNumber.setColumns(10);
		
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentpanel.setVisible(false);
				new Login();
			}
		});
		btnLogout.setBounds(17, 272, 131, 29);
		studentpanel.add(btnLogout);


	}
}
