//�л����� ����� ����ϱ�
package Haksa;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class HaksaRegisterClass {

	public void haksaregesiter(JTextField registerName, JTextField registerMajor, JTextField registerNumber,
			JTextField registerJuminFront, JPasswordField registerJuminLast) {
		// TODO Auto-generated method stub
		try{
			BufferedWriter bos = new BufferedWriter(new FileWriter("ȸ������.txt",true));
			// "ȸ������.txt"���Ͽ� �л����ڰ� ȸ���� ����ϴ� �۾�
			bos.write(registerName.getText()+"/");            //�űԵ���� �̸�
			bos.write(registerMajor.getText()+"/");           //�űԵ���� �а�
			bos.write(registerNumber.getText()+"/");          //�űԵ���� �й�
			bos.write(registerJuminFront.getText()+"/");      //�űԵ���� �ֹι�ȣ ���ڸ�
			bos.write(registerJuminLast.getText()+"\r\n");    //�űԵ���� �ֹι�ȣ ���ڸ�
			bos.close();
			JOptionPane.showMessageDialog(null, "����� ����� �Ϸ�Ǿ����ϴ�.");  
			//dispose();
		}
		catch (Exception ex){
			JOptionPane.showMessageDialog(null, "����� ��Ͽ� �����Ͽ����ϴ�.");
		}		
		
	}

}
