//�л����� ����� ���� Ŭ����
package Haksa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class HaksaDeleteClass {

	public void haksadelete(int row) throws IOException {
		int usercount = row;
		BufferedWriter DB = new BufferedWriter(new FileWriter("�������ڹ�ȣ.txt",true));
		DB.write(row+"\r\n");
		DB.close();	
		
		// TODO Auto-generated method stub
		String str = null;
		BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("�������ڹ�ȣ.txt")));
		String arr = null;
		
		while ((str = file2.readLine()) != null) { 	
			arr=str;			
		}
		int UserCount=Integer.parseInt(arr);	
		
		File file = new File("ȸ������.txt");		
		String spare = "";
		try {
			BufferedReader dlR = new BufferedReader(new FileReader("ȸ������.txt"));
			String line;
			for(int i=0; i<UserCount; i++) {
				line = dlR.readLine(); //������ �̵�
				spare += (line + "\r\n" ); //�����Ѱ� �������� spare�� �����͸� �����մϴ�.
			}
			String preData = dlR.readLine();  //���ö����� ���� �ʰ� ������ null�϶����� �н��ϴ�.
			while((line = dlR.readLine())!=null) {
				spare += (line + "\r\n" );   
			}
			FileWriter dlW = new FileWriter("ȸ������.txt");
			dlW.write(spare);;
			dlW.close();
			dlR.close();
			JOptionPane.showMessageDialog(null, "������ �����Ǿ����ϴ�.\r\n");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
