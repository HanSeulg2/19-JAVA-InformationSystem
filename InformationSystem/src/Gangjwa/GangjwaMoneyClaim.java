//수업담당자 청구서발급
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
			file = new BufferedReader(new InputStreamReader( new FileInputStream("현재사용자.txt")));
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
		}	// 저장한 현재사용자의 정보를 불러와서 arr에 저장함.
		String nu[] = arr.split("/"); //nu[0] = 이름, nu[1] = 학번

		
		String arr2[] = null;
		String str2 = null;
		int Sum = 0;
		
		BufferedReader file2 = null;
		try {
			file2 = new BufferedReader(new InputStreamReader( new FileInputStream("데이터베이스.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((str2 = file2.readLine()) != null) {
				arr2=str2.split("/");		
				if(snumber.equals(arr2[1])) {							//로그인한 학번과 데베의 학번이 같으면
					String mTOs = arr2[6].replaceAll("[^0-9]","");	//학점String에서 숫자만 추출
					int gcountSum = Integer.parseInt(mTOs);			//추출한 숫자를 int로 변환
					Sum += gcountSum;
				}				
			}
			int money = 45000*Sum;
			JOptionPane.showMessageDialog(null,"총 학점은 " + Sum + "학점이고 " + "총 수강료는 " + money +" 입니다.");
		} 
		
		catch (NumberFormatException | HeadlessException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
