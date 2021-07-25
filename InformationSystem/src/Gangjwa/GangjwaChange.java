//강좌 수정.삭제
package Gangjwa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;

public class GangjwaChange {
	
	private JFrame frame;
	private JTextField textIndex;
	private JTextField textName;
	private JTextField textMajor;
	private JTextField textProfessor;
	private JTextArea textArea;
	private JTextField textMin;
	private JTextField textScore;
	private JTextField textMax;
	private ContactDAOImple dao;
	private JTextField textNumber;
	private JTextField textEX;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GangjwaChange window = new GangjwaChange();
					window.frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GangjwaChange() {
		dao = ContactDAOImple.getInstance();
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100,100,510,639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		// 사이즈 변경 불가능
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 494, 601);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel iblTitle = new JLabel("강좌 수정/삭제 ");
		iblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		iblTitle.setBounds(166, 15, 195, 60);
		panel.add(iblTitle);
		iblTitle.setBorder(new LineBorder(Color.BLACK,2,true));
		iblTitle.setFont(new Font("굴림",Font.BOLD,21));
		
		//--------------------------------------------------------
		JLabel iblIndex = new JLabel("인덱스");
		iblIndex.setBounds(48, 79, 46, 21);
		panel.add(iblIndex);
		//iblIndex.setHorizonTAlignment(SwingConstants,CENTER);
		iblIndex.setBorder(new CompoundBorder(
				 new EtchedBorder(EtchedBorder.RAISED,new Color(255,200,0),new Color(0,0,0)),null));
		iblIndex.setFont(new Font("굴림",Font.PLAIN,14));
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 116, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD559\uACFC");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(48, 187, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("\uAC15\uC88C \uBC88\uD638");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(48, 147, 57, 15);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("\uAD50\uC218");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(48, 224, 57, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC778\uC6D0 \uCD5C\uC18C/\uCD5C\uB300");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(48, 249, 88, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uD559\uC810");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(48, 274, 57, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lalNewLabel_6 = new JLabel("\uC124\uBA85");
		lalNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lalNewLabel_6.setBounds(48, 299, 57, 15);
		panel.add(lalNewLabel_6);
		
		//--------------------------------------------------------
		textName=new JTextField();
		textName.setBounds(143, 113, 285, 21);
		panel.add(textName);
		textName.setColumns(10);
		
		textNumber = new JTextField();
		textNumber.setBounds(143, 144, 285, 21);
		panel.add(textNumber);
		textNumber.setColumns(10);
		//--------------------------------------------------------
		textMajor=new JTextField();
		textMajor.setBounds(143, 184, 285, 21);
		panel.add(textMajor);
		textMajor.setColumns(10);
		
		//--------------------------------------------------------
		textIndex=new JTextField();
		textIndex.setBounds(143, 80, 285, 21);
		panel.add(textIndex);
		textIndex.setColumns(10);
		//--------------------------------------------------------
		textProfessor=new JTextField();
		textProfessor.setBounds(143, 215, 285, 21);
		panel.add(textProfessor);
		textProfessor.setColumns(10);
		
		//------------------------------------------------------
		textMin = new JTextField();
		textMin.setBounds(148, 246, 40, 21);
		panel.add(textMin);
		textMin.setColumns(10);
		//------------------------------------------------------
		textMax = new JTextField();
		textMax.setBounds(186, 246, 40, 21);
		panel.add(textMax);
		textMax.setColumns(10);
		//------------------------------------------------------
		textScore = new JTextField();
		textScore.setBounds(143, 271, 116, 21);
		panel.add(textScore);
		textScore.setColumns(10);
		
		textEX = new JTextField();
		textEX.setBounds(143, 296, 285, 21);
		panel.add(textEX);
		textEX.setColumns(10);
		//------------------------------------------------------
		JButton btnSelect = new JButton("전체검색");
		btnSelect.setBounds(12, 339, 97, 30);
		panel.add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll ();
			}
		});
		
		
		
		btnSelect.setFont(new Font("굴림",Font.BOLD,14));
		
		//------------------------------------------------------
		JButton btnIndexSelect = new JButton("상세검색");
		btnIndexSelect.setBounds(114, 339, 108, 30);
		panel.add(btnIndexSelect);
		btnIndexSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select ();
			}
		});
		
		btnIndexSelect.setFont(new Font("굴림",Font.BOLD,14));
		
		// -------------------------------------------------
		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(246, 339, 79, 32);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update ();
			}
		});
		
		btnUpdate.setFont(new Font("굴림",Font.BOLD,14));
		
		//--------------------------------------------------
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(330, 339, 79, 33);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete ();
			}
		});
		
		btnDelete.setFont(new Font("굴림",Font.BOLD,14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(12, 379, 468, 212);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textArea.setBackground(Color.PINK);
		
		JButton btnExit = new JButton(" \uC885\uB8CC");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Gangjwa();
			}
		});
		btnExit.setFont(new Font("굴림", Font.BOLD, 14));
		btnExit.setBounds(413, 339, 79, 33);
		panel.add(btnExit);
		
	
		//--------------------------------------------------------
		
		JLabel iblName = new JLabel("이름");
		//iblName.setHorizonTAlignment(SwingConstants,CENTER);
		iblName.setBorder(new CompoundBorder(
		 new EtchedBorder(EtchedBorder.RAISED,new Color(255,200,0),new Color(255,255,0)),null));
		iblName.setFont(new Font("굴림",Font.PLAIN,14));
		iblName.setBounds(12,132,160,40);
				
		//--------------------------------------------------------
		JLabel iblPhone = new JLabel("학과");
		//iblPhone.setHorizonTAlignment(SwingConstants,CENTER);
		iblPhone.setBorder(new CompoundBorder(
		 new EtchedBorder(EtchedBorder.RAISED,new Color(255,200,0),new Color(255,255,0)),null));
		iblPhone.setFont(new Font("굴림",Font.PLAIN,14));
		iblPhone.setBounds(12,182,160,40);
				
		//--------------------------------------------------------
		JLabel iblEmail = new JLabel("교수");
		//iblEmail.setHorizonTAlignment(SwingConstants,CENTER);
		iblEmail.setBorder(new CompoundBorder(
		new EtchedBorder(EtchedBorder.RAISED,new Color(255,200,0),new Color(255,255,0)),null));
		iblEmail.setFont(new Font("굴림",Font.PLAIN,14));
		iblEmail.setBounds(12,232,160,40);
	}
	
	
	//--------------------------------------------------
	private void selectAll() {
		ArrayList<ContactVO>list=dao.select();
		StringBuffer buffer = new StringBuffer();
		
		for(int i =0;i<list.size();i++) {
			buffer.append("["+i+"]").append(list.get(i).toString()).append("\n");
		}
		textArea.setText(buffer.toString());
	}
	//--------------------------------------------------
	private void select() {
		try {
			int index =Integer.parseInt(textIndex.getText());
			ContactVO list = dao.select(index);
			textName.setText(list.getName());
			textNumber.setText(list.getnumber());
			textMajor.setText(list.getMajor());
			textProfessor.setText(list.getProfessor());
			textScore.setText(list.getScore());
			textMin.setText(list.getMin());
			textMax.setText(list.getMax());
			textScore.setText(list.getScore());
			textEX.setText(list.getExplan());
			
		}catch(NumberFormatException e) {
			textArea.setText("숫자를 입력하세요.");
		}catch(NullPointerException e) {
			textArea.setText("해당 인덱스가 없습니다.");
		}
	}
	//--------------------------------------------------
	private void update() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			String name = textName.getText();
			String number=textNumber.getText();
			String major = textMajor.getText();
			String professor = textProfessor.getText();
			String min = textMin.getText();
			String max = textMax.getText();
			String score=textScore.getText();
			String explan=textEX.getText();
		
			ContactVO contact = new ContactVO(name,number,major,professor, min, max,score,explan);
			
		 //수정시 회원정보 불러오기
				 
			int result = dao.update(index,contact);
			
			if(result ==1) {
				textArea.setText(index+"강좌 수정 성공");
			}else {
				textArea.setText(index+"강좌 수정 실패");
			}
		}catch(NumberFormatException e) {
			textArea.setText("숫자를 입력하세요");
			e.printStackTrace(); 
		}
	}
	
	@SuppressWarnings("unused")
	private void dispose() {
		// TODO Auto-generated method stub
		
	}


	//--------------------------------------------------
	
	private void delete() {
		try {
			int index = Integer.parseInt(textIndex.getText());
			int result = dao.delete(index);
			
			if(result>0) {
				textArea.setText(index+"강좌 삭제 성공");
			}else {
				textArea.setText(index+"강좌 삭제 실패");
			}
		}catch(NumberFormatException e) {
			textArea.setText("숫자를 입력하세요.");
		}
	}
}