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
			BufferedWriter gangjwalist = new BufferedWriter(new FileWriter("C:\\Users\\joe24\\eclipse-workspace\\MyprojectREAL\\���µ��.txt",true));
			gangjwalist.write(gangjwaName.getText()+"/");
			gangjwalist.write(gangjwaNumber.getText()+"/");
			gangjwalist.write(gangjwaMajor.getText()+"/");
			gangjwalist.write(gangjwaProfessor.getText()+"/");
			gangjwalist.write(gangjwaCount.getText()+"����/");
			gangjwalist.write(gangjwaMin.getText()+"��/");
			gangjwalist.write(gangjwaMax.getText()+"��\r\n");
			

			gangjwalist.close();
			JOptionPane.showMessageDialog(null, "���°� ��� �Ǿ����ϴ�.");
			//dispose();
		}
		catch (Exception ex){
			JOptionPane.showMessageDialog(null, "���� ��Ͽ� ���� �Ͽ����ϴ�.");			
		}
	}

}
