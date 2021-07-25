//����â
package Professor;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Login.Login;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class Professor {

	private JFrame frame;
	private JTextField getName;
	private JTextField getNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Professor window = new Professor();
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
	public Professor() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("��������.txt")));
		//1-�̸� 2-�а� 3-�й�
		String arr[] = null;
		while ((str = file.readLine()) != null) { 	
			arr = str.split("/");
		}
		String name = arr[0];
		String number = arr[1];
		
		frame = new JFrame();
		frame.setTitle("PROFESSOR");
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // ������ ���� �Ұ���
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // ȭ�� �߰��� �߱�
		frame.getContentPane().setLayout(null);
		
		
		//panel
		JPanel professorpanel = new JPanel();
		professorpanel.setBackground(Color.WHITE);
		professorpanel.setBounds(0, 0, 600, 350);
		frame.getContentPane().add(professorpanel);
		professorpanel.setLayout(null);
		
		//�⼮�� ��ȸ ��ư
				JButton pbtnlist = new JButton("\uCD9C\uC11D\uBD80 \uC870\uD68C");
				pbtnlist.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							new ProfessorList();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				pbtnlist.setBounds(254, 36, 168, 66);
				pbtnlist.setContentAreaFilled(false);
				professorpanel.add(pbtnlist);
		
		
		//���� �Է� ��ư
		JButton pbtngrade = new JButton("\uC131\uC801 \uC785\uB825");
		pbtngrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ProfessorAddGrade();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		pbtngrade.setBounds(254, 126, 168, 66);
		pbtngrade.setFocusPainted(false);
		pbtngrade.setContentAreaFilled(false);
		professorpanel.add(pbtngrade);
		
		
		//�������� ��ư
		JButton pbtnchangeinformation = new JButton("\uAC1C\uC778 \uC815\uBCF4");
		pbtnchangeinformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProfessorInformationChange();
			}
		});
		pbtnchangeinformation.setBounds(254, 213, 168, 66);
		pbtnchangeinformation.setContentAreaFilled(false);
		professorpanel.add(pbtnchangeinformation);
		
		getName = new JTextField(name);
		getName.setEditable(false);
		getName.setHorizontalAlignment(SwingConstants.CENTER);
		getName.setFont(new Font("����", Font.PLAIN, 25));
		getName.setBounds(41, 107, 145, 33);
		professorpanel.add(getName);
		getName.setColumns(10);
		
		getNumber = new JTextField(number);
		getNumber.setEditable(false);
		getNumber.setHorizontalAlignment(SwingConstants.CENTER);
		getNumber.setBounds(41, 163, 145, 33);
		professorpanel.add(getNumber);
		getNumber.setColumns(10);		
		
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
