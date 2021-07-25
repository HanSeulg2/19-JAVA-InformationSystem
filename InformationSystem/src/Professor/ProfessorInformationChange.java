//교수 개인정보 수정창

package Professor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Label;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfessorInformationChange {

	private JFrame frame;
	private JTextField sicName;
	private JTextField sicMajor;
	private JTextField sicNumber;
	private JTextField sicJuminFront;
	private JPasswordField sicJuminLast;
	private JPasswordField sicPsd;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorInformationChange window = new ProfessorInformationChange();
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
	public ProfessorInformationChange() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		String str = null;
		BufferedReader file = null;
		try {
			file = new BufferedReader(new InputStreamReader( new FileInputStream("개인정보수정.txt")));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String arr = null;
		try {
			while ((str = file.readLine()) != null) { 	
				arr=str;			
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int UserCount=Integer.parseInt(arr);


		frame = new JFrame();
		frame.setTitle("개인정보 수정");
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);frame.setResizable(false); // 사이즈 변경 불가능
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 578, 294);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnOK = new JButton("\uD655\uC778");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnOK.setBounds(183, 249, 80, 30);
		panel.add(btnOK);

		JButton btnChange = new JButton("\uC218\uC815");
		//수정버튼 이벤트처리기
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String spare = "";
				try {
					BufferedReader pchiR = new BufferedReader(new FileReader("회원정보.txt"));
					String line;
					for(int i=0; i<UserCount; i++) {
						line = pchiR.readLine(); //읽으며 이동
						spare += (line + "\r\n" ); 
					}
					String OldInformaiotn = pchiR.readLine();
					String NewInformation = (sicName.getText()+"/"+sicMajor.getText()+"/"+sicNumber.getText()+"/"+sicJuminFront.getText()+"/"
							+sicJuminLast.getText()+"/"+sicPsd.getText()+"\r\n");
					spare += NewInformation;
					while((line = pchiR.readLine())!=null) {
						spare += (line + "\r\n" ); 
					}
					FileWriter pshiW = new FileWriter("회원정보.txt");
					pshiW.write(spare);
					pshiW.close();
					pchiR.close();
					JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.\r\n" + "수정 전 : " + OldInformaiotn +"\r\n수정 후 : " + NewInformation);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		}); 




		btnChange.setBounds(298, 249, 80, 30);
		panel.add(btnChange);

		JLabel sicNAME = new JLabel("\uC774\uB984");
		sicNAME.setHorizontalAlignment(SwingConstants.CENTER);
		sicNAME.setBounds(85, 15, 141, 29);
		panel.add(sicNAME);

		sicName = new JTextField();
		sicName.setColumns(10);
		sicName.setBounds(284, 15, 153, 29);
		panel.add(sicName);
		sicName.setEditable(false);

		JLabel sicMAJOR = new JLabel("\uD559\uACFC");
		sicMAJOR.setHorizontalAlignment(SwingConstants.CENTER);
		sicMAJOR.setBounds(85, 59, 141, 29);
		panel.add(sicMAJOR);

		sicMajor = new JTextField();
		sicMajor.setColumns(10);
		sicMajor.setBounds(284, 59, 153, 29);
		panel.add(sicMajor);
		sicMajor.setEditable(false);

		JLabel sicNUMBER = new JLabel("\uAD50\uC218\uBC88\uD638");
		sicNUMBER.setHorizontalAlignment(SwingConstants.CENTER);
		sicNUMBER.setBounds(85, 109, 141, 29);
		panel.add(sicNUMBER);

		sicNumber = new JTextField();
		sicNumber.setColumns(10);
		sicNumber.setBounds(284, 109, 153, 29);
		panel.add(sicNumber);
		sicNumber.setEditable(false);

		JLabel sicJUMIN = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		sicJUMIN.setHorizontalAlignment(SwingConstants.CENTER);
		sicJUMIN.setBounds(85, 161, 141, 29);
		panel.add(sicJUMIN);

		sicJuminFront = new JTextField();
		sicJuminFront.setColumns(10);
		sicJuminFront.setBounds(243, 161, 101, 29);
		panel.add(sicJuminFront);
		sicJuminFront.setEditable(false);

		JLabel sicJuminM = new JLabel("-");
		sicJuminM.setHorizontalAlignment(SwingConstants.CENTER);
		sicJuminM.setBounds(355, 165, 23, 21);
		panel.add(sicJuminM);

		sicJuminLast = new JPasswordField();
		sicJuminLast.setBounds(395, 161, 101, 29);
		panel.add(sicJuminLast);
		sicJuminLast.setEditable(false);

		JLabel sicPSD = new JLabel("\uBE44\uBC00\uBC88\uD638");
		sicPSD.setHorizontalAlignment(SwingConstants.CENTER);
		sicPSD.setBounds(85, 205, 141, 29);
		panel.add(sicPSD);

		sicPsd = new JPasswordField();
		sicPsd.setBounds(284, 205, 153, 29);
		panel.add(sicPsd);
		sicPsd.setEditable(true);		//비밀번호만 수정할 수 있도로 설정

		try { //로그인하고 회원정보 데이터 입력
			String s; 
			String[] array;
			int j = 0;
			BufferedReader br = new BufferedReader(new FileReader("회원정보.txt")); 
			while ((s = br.readLine()) != null) { 
				if(j == UserCount) {
					array = s.split("/");

					sicName.setText(array[0]);
					sicMajor.setText(array[1]);
					sicNumber.setText(array[2]);
					sicJuminFront.setText(array[3]);
					sicJuminLast.setText(array[4]);
					//Tmajor.setText(array[5]);
				}
				j += 1;
			} 

			br.close(); 
		} catch (IOException e2) { 
			e2.printStackTrace(); 
		}

	}
}
