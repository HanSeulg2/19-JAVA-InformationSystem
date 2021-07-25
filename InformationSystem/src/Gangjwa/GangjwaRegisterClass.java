package Gangjwa;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GangjwaRegisterClass {

	public void gangjwa(JTextField gangjwaName, JTextField gangjwaNumber, JTextField gangjwaMajor,
			JTextField gangjwaProfessor, JTextField gangjwaCount, JTextField gangjwaMin, JTextField gangjwaMax) {
		// TODO Auto-generated method stub
		try{
			BufferedWriter gangjwalist = new BufferedWriter(new FileWriter("C:\\Users\\joe24\\eclipse-workspace\\MyprojectREAL\\강좌등록.txt",true));
			gangjwalist.write(gangjwaName.getText()+"/");
			gangjwalist.write(gangjwaNumber.getText()+"/");
			gangjwalist.write(gangjwaMajor.getText()+"/");
			gangjwalist.write(gangjwaProfessor.getText()+"/");
			gangjwalist.write(gangjwaCount.getText()+"학점/");
			gangjwalist.write(gangjwaMin.getText()+"명/");
			gangjwalist.write(gangjwaMax.getText()+"명\r\n");
			

			gangjwalist.close();
			JOptionPane.showMessageDialog(null, "강좌가 등록 되었습니다.");
			//dispose();
		}
		catch (Exception ex){
			JOptionPane.showMessageDialog(null, "강좌 등록에 실패 하였습니다.");			
		}
	}

}
