//�л����� ����� ���� Ŭ����
package Haksa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class HaksaChangeClass {

	
	public void chageclass(JTextField haksachangeName, JTextField haksachangeMajor, JTextField haksachangeNumber,
			JTextField haksachangeJuminFront, JTextField haksachangeJuminLast) throws IOException  {
		// TODO Auto-generated method stub
		String str = null;
		BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("�������ڹ�ȣ.txt")));
		String arr = null;
		while ((str = file2.readLine()) != null) { 	
			arr=str;			// �α������� �� �ڱ� �ڽ��� ã������ UserCount���� ���� .txt������ �а� �� ���ڸ� arr�� ����ϴ�.
		}
		
		int UserCount=Integer.parseInt(arr);   //arr�� �������� ��ȯ�� �ݴϴ�.
		
		File file = new File("ȸ������.txt");		
		String spare = "";	
		try {
			BufferedReader chR = new BufferedReader(new FileReader("ȸ������.txt"));
			String line;
			for(int k=0; k<UserCount; k++) {  // ������ JTable�� ������ ����� ���� ���� �ձ��� �н��ϴ�.
				line = chR.readLine(); //������ �̵�
				spare += (line + "\r\n" ); //spare�� �׽��ϴ�.
			}
			String Old = chR.readLine();   //���� �����ʹ� ���� �����ͷ� ������ String�Դϴ�.
			String New = (haksachangeName.getText()+"/"+haksachangeMajor.getText()+"/"+
					haksachangeNumber.getText()+"/"+haksachangeJuminFront.getText()+"/"+((JTextComponent) haksachangeJuminLast).getText()+"\r\n");
            //������ ������ ���ο� �����ͷ� New������ �����մϴ�.
			spare += New;  //������ �����͸� ����ִ� �����Ϳ� ������ �����͸� �߰����ݴϴ�.
			while((line = chR.readLine())!=null) {
				//���� �����͸� �а� ���ο� �����͸� �߰��� spare�� null�϶����� �н��ϴ�.
				spare += (line + "\r\n" ); 
			}
			//4. FileWriter�� �̿��ؼ� �����
			FileWriter chW = new FileWriter("ȸ������.txt");
			chW.write(spare);
			chW.close();
			chR.close();
			JOptionPane.showMessageDialog(null, "������ �����Ǿ����ϴ�.\r\n" + "���� �� : " + Old +"\r\n���� �� : " + New);
			//���� �� �����Ϳ� ���� �� �����͸� ����ڰ� ����Ȯ���� �� �ְ� Message�� ��ϴ�.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}