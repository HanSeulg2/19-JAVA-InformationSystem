//�α��� Ŭ����
package Login;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Gangjwa.Gangjwa;
import Haksa.Haksa;
import Professor.Professor;
import Student.Student;
import Student.StudentApplyClass;


public class LoginClass {
	public boolean check=false;  //�ؽ�Ʈ ������ true�ϋ��� ���
	public int UserCount=0;

	String NowUserName;
	String NowUserNumber;	
	String NName, NNumber;
	public void login(JTextField id, JPasswordField password) throws IOException {
		// TODO Auto-generated method stub
		final JFrame frame = new JFrame();
		try{
			int i =0;  //UserCount ���� �ޱ� ���� �ʱⰪ 0�� ���� i
			String s;
			String[] array;
			BufferedReader bos = new BufferedReader(new FileReader("ȸ������.txt"));
			while((s=bos.readLine())!=null){
				array=s.split("/");
				if(id.getText().equals(array[2])&&password.getText().equals(array[4])||id.getText().equals(array[2])&&password.getText().equals(array[5])) //����� ��й�ȣ�ε� �α��εǵ��� ����
				{
					//�񱳰� �������� ���̾�α� â�� ����.
					check=true;     //������ ��ġ �Ѵٸ� true
					UserCount = i;  //ȸ������.txt�� ���ϴ� ȸ���� ã�� ���� UserCount�� ����Ѵ�.

					NowUserName=array[0];      //����� �̸��� �ش��ϴ� �迭
					NowUserNumber = array[2];  //����� �й��� �ش��ϴ� �迭
					
					StudentApplyClass applyclass = new StudentApplyClass();      
					applyclass.applyclass(NowUserName,NowUserNumber); 
					//��ü�� �����Ͽ� Ŭ������ �ش��ϴ� �Լ��� �̿�
					
					BufferedWriter DB = new BufferedWriter(new FileWriter("��������.txt",true));
					DB.write(NowUserName+"/");      
					DB.write(NowUserNumber+"\r\n");	
					//"��������.txt"�� array[0],array[2]���� write�մϴ�. 
					//����ڰ� �α��� �Ͽ��� ��  TextFeid�� �޾� ����ڰ� �ڽ��� Ȯ�� �ϱ� ���ؼ� �Դϴ�.
					DB.close();	
				}
				else{
					i+=1;  //���� �ʴٸ� 1�� ���� ���Ѽ� 
				}
			}
			
			BufferedWriter DB = new BufferedWriter(new FileWriter("������������.txt",true));
			DB.write(UserCount+"\r\n");   
			//"��������.txt"�� ���λ���ڰ� ���μ����� ���� �ڽ��� ������ ���� ���ο� ���� ���� UserCount���� write�Ͽ� �װ��� �������� txt�� �����մϴ�.
			DB.close();			//���° ��������� txt�� ����
			bos.close();
			//dispose();
		}catch(IOException e) {
			e.toString();
		} catch(ArrayIndexOutOfBoundsException e) {
			e.toString();
		}
		if(check==true) {
			JOptionPane.showMessageDialog(null, "�α����� �Ǿ����ϴ�!!");

			if(id.getText().contains("S")) {  
				//ID �ؽ�Ʈ �Է¿� "S"�� ���ԵǾ� �ִٸ� 
				frame.dispose(); 
				try {
					new Student(); 		//�л�â
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			}
			if(id.getText().contains("P")) {
				//ID �ؽ�Ʈ �Է¿� "P"�� ���ԵǾ� �ִٸ� 
				frame.dispose(); 
				new Professor(); //����â
			}
			if(id.getText().contains("H")) {	
				//ID �ؽ�Ʈ �Է¿� "H"�� ���ԵǾ� �ִٸ� 
				frame.dispose(); 
				Haksa haksa = new Haksa();
				haksa.haksa(); //�л����� â
			}
			if(id.getText().contains("G")) {
				//ID �ؽ�Ʈ �Է¿� "G"�� ���ԵǾ� �ִٸ� 
				frame.dispose(); 
				new Gangjwa(); //��������� â
			}
		} 
		else {
			JOptionPane.showMessageDialog(null, "�α��� �����Ͽ����ϴ�. ���Է����ּ���");
			//�й��� ��й�ȣ�� �Ѵ� �������� �ʴٸ� �α��� �����ϰ� �˴ϴ�.
		}
	}

}
