//������ûŬ����
package Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;


public class StudentApplyClass {
	String nuName;
	String nuNumber;
	public void applyclass(String nowUserName, String nowUserNumber) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter DB = new BufferedWriter(new FileWriter("��������.txt",true));
		DB.write(nowUserName+"/");
		DB.write(nowUserNumber+"/");		
	}	//�α������� �� ������ ������� �̸��� ������ �ҷ��ͼ� txt���Ͽ� ���� ������.
	
	
	public void apply(int row, String gname, String gnumber, String gmajor, String gprofessor, String gcount) {	
		try {		
			String str = null;
			BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("��������.txt")));
			String arr = null;
			while ((str = file.readLine()) != null) { 	
				arr=str;
			}	// ������ ���������� ������ �ҷ��ͼ� arr�� ������.
			String nu[] = arr.split("/"); //nu[0] = �̸�, nu[1] = �й�
			String gcountstring= gcount.replaceAll("[^0-9]","");	//String���� ���ڸ� ����
			int gcountNumber = Integer.parseInt(gcountstring);			//������ ���ڸ� int�� ��ȯ
			
			int gangjwapeople = 0;			
			String arr2[] = null;
			String str2 = null;
			BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("�����ͺ��̽�.txt")));
			//������û�� �Ϸ�Ǿ� ����� ������ �ҷ���
			int c=0;
			int Sum = gcountNumber;		//���缱���� ������ �������� gangjwa�� �ʱⰪ
			while ((str2 = file2.readLine()) != null) {
				arr2=str2.split("/");	
				//�ߺ���û �ȵ�
				if(nu[1].equals(arr2[1]) && gname.equals(arr2[2])) {	
					//���������� �й��� txt������ �й�, ��û�ϰ����ϴ� ���¿� txt���Ͽ� ����Ǿ� �ִ� ���¸� ���� ���Ͽ� �ΰ���ΰ� ��ġ�ϸ�
					JOptionPane.showMessageDialog(null, "�̹� ��û�� �����Դϴ�.");
					c=1;	//c�� 1�� ������Ű��
					break;	//while�� break��
				}
				//�ִ����� üũ�ϱ�
				if(nu[1].equals(arr2[1])) {
					String mTOs = arr2[6].replaceAll("[^0-9]","");	//String���� ���ڸ� ����
					int gcountSum = Integer.parseInt(mTOs);			//������ ���ڸ� int�� ��ȯ . gcountSum = �������� ����
					Sum += gcountSum;								//Sum = ������
					if(Sum>=18) {
					JOptionPane.showMessageDialog(null, "�ִ� ��û������ �Ѿ����ϴ�.");
					c=1;	//c�� 1�� ������Ű��
					break;	//while�� break��
					}					
				}
				//�ִ�����ο� üũ�ϱ�
				else if(gnumber.equals(arr2[3])) {	//���¹�ȣ�� txt�� �ִ� ���¹�ȣ�� ������
					gangjwapeople++;	//����  . �������� �л��� ���� ��Ű��
					
					int gMax =0;		//���� �ִ��л��� ���ϱ�
					String str1 = null;
					String arr1[] = null;
					BufferedReader file1 = new BufferedReader(new InputStreamReader( new FileInputStream("���µ��.txt")));
					while ((str1 = file1.readLine()) != null) { 
						arr1=str1.split("/");	
						if(gnumber.equals(arr1[1])) {
						String GMAX = arr1[6].replaceAll("[^0-9]","");	//String���� ���ڸ� ����
						gMax = Integer.parseInt(GMAX);			//������ ���ڸ� int�� ��ȯ
//						System.out.println(gMax);	
						}//���� �ִ������ �� �о����
					}	
					if(gangjwapeople>=gMax) {
						JOptionPane.showMessageDialog(null, "�����ο��� �ʰ��Ͽ� ��û�� �� �����ϴ�.");
						c=1;
						break;
					}
				}
				
				else{	//���Ͽ� ��ġ�ϴ� ������ �������� 
					c=0;	//c=0
				}
			}
			switch(c) {	//switch�� ���ؼ� c�� ���� �ް�
			case 0:	//c�� 0�̸� ��, else�� ��� ���õ� ������ ���� ���� ����ڸ� �Բ� txt���Ͽ� ������
				BufferedWriter DB = new BufferedWriter(new FileWriter("�����ͺ��̽�.txt",true));

				DB.write(arr+"/");		//�л��̸�/�й�
				DB.write(gname+"/");
				DB.write(gnumber+"/");
				DB.write(gmajor+"/");
				DB.write(gprofessor+"/");
				DB.write(gcount+"\r\n");

				DB.close();	
				JOptionPane.showMessageDialog(null, "������û �Ǿ����ϴ�.");
				break;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

	}
}
