//��������� û�����߱�
package Gangjwa;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class GangjwaMoneyClaim {

	public void moneyclaim(String snumber) {
		// TODO Auto-generated method stub
		
		String arr = null;
		String str = null;
		BufferedReader file = null;
		try {
			file = new BufferedReader(new InputStreamReader( new FileInputStream("��������.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while ((str = file.readLine()) != null) { 	
				arr=str;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// ������ ���������� ������ �ҷ��ͼ� arr�� ������.
		String nu[] = arr.split("/"); //nu[0] = �̸�, nu[1] = �й�

		
		String arr2[] = null;
		String str2 = null;
		int Sum = 0;
		
		BufferedReader file2 = null;
		try {
			file2 = new BufferedReader(new InputStreamReader( new FileInputStream("�����ͺ��̽�.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((str2 = file2.readLine()) != null) {
				arr2=str2.split("/");		
				if(snumber.equals(arr2[1])) {							//�α����� �й��� ������ �й��� ������
					String mTOs = arr2[6].replaceAll("[^0-9]","");	//����String���� ���ڸ� ����
					int gcountSum = Integer.parseInt(mTOs);			//������ ���ڸ� int�� ��ȯ
					Sum += gcountSum;
				}				
			}
			int money = 45000*Sum;
			JOptionPane.showMessageDialog(null,"�� ������ " + Sum + "�����̰� " + "�� ������� " + money +" �Դϴ�.");
		} 
		
		catch (NumberFormatException | HeadlessException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
