//수업담당자 창
package Gangjwa;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Login.Login;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Gangjwa {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gangjwa window = new Gangjwa();
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
	public Gangjwa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("수업담당자");
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // 화면 중간에 뜨기
		frame.getContentPane().setLayout(null);
		
		
		//panel
		JPanel professorpanel = new JPanel();
		professorpanel.setBackground(Color.WHITE);
		professorpanel.setBounds(0, 0, 600, 350);
		frame.getContentPane().add(professorpanel);
		professorpanel.setLayout(null);
		
		
		JButton btnNewButton = new JButton("\uAC15\uC88C \uB4F1\uB85D");
		btnNewButton.setBounds(229, 58, 155, 49);
		professorpanel.add(btnNewButton); //강좌 등록.
		
		JButton btnNewButton_1 = new JButton("\uAC15\uC88C \uC218\uC815/\uC0AD\uC81C");
		btnNewButton_1.setBounds(229, 139, 155, 49);
		professorpanel.add(btnNewButton_1);
		 //로그아웃
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new GangjwaRegister();				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				professorpanel.setVisible(false);
				new GangjwaChange();
			
			}
			});

		
		JButton btnreception = new JButton("\uC218\uAC15\uB8CC \uCCAD\uAD6C\uC11C \uBC1C\uAE09");
		btnreception.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new GangjwaMoney();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnreception.setBounds(229, 221, 155, 49);
		professorpanel.add(btnreception);
		
		JLabel label = new JLabel("\uC218\uC5C5\uB2F4\uB2F9\uC790");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 25));
		label.setBackground(Color.WHITE);
		label.setBounds(39, 135, 145, 33);
		professorpanel.add(label);
		
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				professorpanel.setVisible(false);
				new Login();
			}
		});
		btnLogout.setBounds(17, 272, 131, 29);
		professorpanel.add(btnLogout);
		
	}
}