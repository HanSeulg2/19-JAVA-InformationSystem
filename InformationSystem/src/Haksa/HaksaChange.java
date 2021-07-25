//학사담당자 사용자 정보 변경 GUI
package Haksa;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HaksaChange{

	private JFrame frame;
	private JTextField haksachangeName;
	private JTextField haksachangeMajor;
	private JTextField haksachangeNumber;
	private JTextField haksachangeJuminFront;
	private JTextField haksachangeJuminLast;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HaksaChange window = new HaksaChange();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param userjumin 
	 * @param usernumber 
	 * @param usermajor 
	 * @param username 
	 */
	public HaksaChange() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param i 
	 * @return 
	 * @throws IOException 
	 */
	public void haksachange(int row, String username, String usermajor, String usernumber, String userjumin) throws IOException {
		// TODO Auto-generated method stub		
		haksachangeName.setText(username);
		haksachangeMajor.setText(usermajor);
		haksachangeNumber.setText(usernumber);
		haksachangeJuminFront.setText(userjumin);
		
		int usercount = row;
		BufferedWriter DB = new BufferedWriter(new FileWriter("현재사용자번호.txt",true));
		DB.write(row+"\r\n");
		DB.close();	
		
		//회원정보 txt 읽어서 주민번호 뒷자리 가져오기
		String str2 = null;
		BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("회원정보.txt")));
		//학생이름.학번.강좌명.강좌번호.학과.교수
		String arr2[] = null;
		while ((str2 = file2.readLine()) != null) { 	
			arr2 = str2.split("/");			
			if(username.equals(arr2[0])) {
				haksachangeJuminLast.setText(arr2[4]);				
			}
		}		
	}

	private void initialize() {		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("사용자 정보 변경");
		frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 578, 294);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel haksachangeNAME = new JLabel("\uC774\uB984");
		haksachangeNAME.setHorizontalAlignment(SwingConstants.CENTER);
		haksachangeNAME.setBounds(90, 15, 141, 29);
		panel.add(haksachangeNAME);

		haksachangeName = new JTextField();
		haksachangeName.setColumns(10);
		haksachangeName.setBounds(289, 15, 153, 29);
		panel.add(haksachangeName);

		JLabel haksachangeMAJOR = new JLabel("\uD559\uACFC");
		haksachangeMAJOR.setHorizontalAlignment(SwingConstants.CENTER);
		haksachangeMAJOR.setBounds(90, 70, 141, 29);
		panel.add(haksachangeMAJOR);

		haksachangeMajor = new JTextField();
		haksachangeMajor.setColumns(10);
		haksachangeMajor.setBounds(289, 70, 153, 29);
		panel.add(haksachangeMajor);

		JLabel haksachangeNUMBER = new JLabel("\uD559\uBC88 / \uAD50\uC218\uBC88\uD638");
		haksachangeNUMBER.setHorizontalAlignment(SwingConstants.CENTER);
		haksachangeNUMBER.setBounds(90, 126, 141, 29);
		panel.add(haksachangeNUMBER);

		haksachangeNumber = new JTextField();
		haksachangeNumber.setColumns(10);
		haksachangeNumber.setBounds(289, 126, 153, 29);
		panel.add(haksachangeNumber);

		JLabel haksachangeJUMIN = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		haksachangeJUMIN.setHorizontalAlignment(SwingConstants.CENTER);
		haksachangeJUMIN.setBounds(90, 183, 141, 29);
		panel.add(haksachangeJUMIN);

		haksachangeJuminFront = new JTextField();
		haksachangeJuminFront.setColumns(10);
		haksachangeJuminFront.setBounds(248, 183, 101, 29);
		panel.add(haksachangeJuminFront);

		JLabel haksachangeJuminM = new JLabel("-");
		haksachangeJuminM.setHorizontalAlignment(SwingConstants.CENTER);
		haksachangeJuminM.setBounds(360, 187, 23, 21);
		panel.add(haksachangeJuminM);

		haksachangeJuminLast = new JTextField();		//주민번호 뒷자리
		haksachangeJuminLast.setBounds(400, 183, 101, 29);
		panel.add(haksachangeJuminLast);
		
		
		
		
		JButton btnChange = new JButton("\uC218\uC815");		
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HaksaChangeClass chageclass = new HaksaChangeClass();
				try {
					chageclass.chageclass(haksachangeName,haksachangeMajor,haksachangeNumber,
							haksachangeJuminFront, haksachangeJuminLast);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
			}
		});

		btnChange.setBounds(140, 242, 125, 37);
		panel.add(btnChange);
		
		JButton btnExit = new JButton("\uC885\uB8CC");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				
			}
		});
		btnExit.setBounds(332, 242, 125, 37);
		panel.add(btnExit);
	}
}
