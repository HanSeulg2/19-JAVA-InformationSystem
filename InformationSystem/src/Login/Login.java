//로그인 창
package Login;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JTextField logId;
	private JPasswordField logPsd;
	/**
	 * Launch the application
	 **/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel welcomepanel = new JPanel();
		welcomepanel.setBackground(Color.WHITE);
		welcomepanel.setBounds(0, 0, 600, 450);		
		frame.getContentPane().add(welcomepanel);
		welcomepanel.setLayout(null);
		
		logId = new JTextField();
		logId.setFont(new Font("굴림", Font.PLAIN, 15));
		logId.setBounds(180, 129, 314, 50);
		welcomepanel.add(logId);
		logId.setToolTipText("");
		logId.setColumns(10);
		
		logPsd = new JPasswordField();
		logPsd.setFont(new Font("굴림", Font.PLAIN, 15));
		logPsd.setBounds(180, 189, 314, 50);
		welcomepanel.add(logPsd);
		
		JButton btnlogin = new JButton("\uB85C\uADF8\uC778");
		btnlogin.setForeground(new Color(255, 255, 255));
		btnlogin.setBackground(new Color(65, 105, 225));
		btnlogin.setFont(new Font("굴림", Font.BOLD, 18));
		btnlogin.setBounds(109, 269, 385, 50);
		welcomepanel.add(btnlogin);
		
		
		////////////////////////////////////////////////////////
		btnlogin.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				LoginClass login = new LoginClass();
				try {
					login.login(logId,logPsd);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		
		/////////////////////////////////////////////////////////
		JLabel lblNewLabel = new JLabel("\uB300\uD559\uC815\uBCF4\uC2DC\uC2A4\uD15C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 64, 250, 50);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		welcomepanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\\uBC31\uB2E4\uC740\\Desktop\\symbol_basic.jpg"));
		lblNewLabel_1.setBounds(55, 38, 114, 104);
		welcomepanel.add(lblNewLabel_1);
		
		JLabel ID = new JLabel("ID");
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setFont(new Font("굴림", Font.PLAIN, 20));
		ID.setBounds(65, 138, 108, 37);
		welcomepanel.add(ID);
		
		JLabel PSD = new JLabel("Password");
		PSD.setHorizontalAlignment(SwingConstants.CENTER);
		PSD.setFont(new Font("굴림", Font.PLAIN, 20));
		PSD.setBounds(61, 195, 108, 37);
		welcomepanel.add(PSD);
		
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // 화면 중간에 뜨기
	}
}
