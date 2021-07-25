//학사담당자 창
package Haksa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Login.Login;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Haksa {

	private JFrame frame;
	private JTextField registerName;
	private JTextField registerMajor;
	private JTextField registerNumber;
	private JTextField registerJuminFront;
	private JPasswordField registerJuminLast;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Haksa window = new Haksa();
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
	public Haksa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("학사담장자");
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 600, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel registerNAME = new JLabel("\uC774\uB984");
		registerNAME.setHorizontalAlignment(SwingConstants.CENTER);
		registerNAME.setBounds(83, 36, 141, 29);
		panel.add(registerNAME);
		
		JLabel registerMAJOR = new JLabel("\uD559\uACFC");
		registerMAJOR.setHorizontalAlignment(SwingConstants.CENTER);
		registerMAJOR.setBounds(83, 91, 141, 29);
		panel.add(registerMAJOR);
		
		JLabel registerNUMBER = new JLabel("\uD559\uBC88 / \uAD50\uC218\uBC88\uD638");
		registerNUMBER.setHorizontalAlignment(SwingConstants.CENTER);
		registerNUMBER.setBounds(83, 147, 141, 29);
		panel.add(registerNUMBER);
		
		JLabel registerJUMIN = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		registerJUMIN.setHorizontalAlignment(SwingConstants.CENTER);
		registerJUMIN.setBounds(83, 204, 141, 29);
		panel.add(registerJUMIN);
		
		registerName = new JTextField();
		registerName.setBounds(282, 36, 153, 29);
		panel.add(registerName);
		registerName.setColumns(10);
		
		registerMajor = new JTextField();
		registerMajor.setColumns(10);
		registerMajor.setBounds(282, 91, 153, 29);
		panel.add(registerMajor);
		
		registerNumber = new JTextField();
		registerNumber.setColumns(10);
		registerNumber.setBounds(282, 147, 153, 29);
		panel.add(registerNumber);
		
		registerJuminFront = new JTextField();
		registerJuminFront.setColumns(10);
		registerJuminFront.setBounds(241, 204, 101, 29);
		panel.add(registerJuminFront);
		
		registerJuminLast = new JPasswordField();
		registerJuminFront.setColumns(10);
		registerJuminLast.setBounds(393, 204, 101, 29); //241, 204, 101, 29
		panel.add(registerJuminLast);
		
		JLabel mJUMIN = new JLabel("-");
		mJUMIN.setHorizontalAlignment(SwingConstants.CENTER);
		mJUMIN.setBounds(353, 208, 23, 21);
		panel.add(mJUMIN);
		
		JButton btnShowTable = new JButton("\uBAA9\uB85D\uBCF4\uAE30");
		btnShowTable.addActionListener(new ActionListener() { //목록보기
			public void actionPerformed(ActionEvent arg0) {
//				HaksaList list = new HaksaList(0);
//				list.list();	
				try {
					new HaksaJtable();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShowTable.setBounds(440, 261, 125, 37);
		panel.add(btnShowTable);
		
		JButton btnRegister = new JButton("\uB4F1\uB85D");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HaksaRegisterClass haksaregesiter = new HaksaRegisterClass();
				haksaregesiter.haksaregesiter(registerName,registerMajor,registerNumber,registerJuminFront,registerJuminLast);
			}
		});
		btnRegister.setBounds(298, 261, 125, 37);
		panel.add(btnRegister);
		
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				new Login();
			}
		});
		btnLogout.setBounds(17, 272, 131, 29);
		panel.add(btnLogout);
		
		
	}

	public void haksa() {
		// TODO Auto-generated method stub
		
	}
}
