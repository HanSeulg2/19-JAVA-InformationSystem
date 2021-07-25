//학사담당자 사용자 삭제 클래스
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
		BufferedWriter DB = new BufferedWriter(new FileWriter("현재사용자번호.txt",true));
		DB.write(row+"\r\n");
		DB.close();	
		
		// TODO Auto-generated method stub
		String str = null;
		BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("현재사용자번호.txt")));
		String arr = null;
		
		while ((str = file2.readLine()) != null) { 	
			arr=str;			
		}
		int UserCount=Integer.parseInt(arr);	
		
		File file = new File("회원정보.txt");		
		String spare = "";
		try {
			BufferedReader dlR = new BufferedReader(new FileReader("회원정보.txt"));
			String line;
			for(int i=0; i<UserCount; i++) {
				line = dlR.readLine(); //읽으며 이동
				spare += (line + "\r\n" ); //선택한거 이전까지 spare에 데이터를 저장합니다.
			}
			String preData = dlR.readLine();  //선택라인은 읽지 않고 라인이 null일때까지 읽습니다.
			while((line = dlR.readLine())!=null) {
				spare += (line + "\r\n" );   
			}
			FileWriter dlW = new FileWriter("회원정보.txt");
			dlW.write(spare);;
			dlW.close();
			dlR.close();
			JOptionPane.showMessageDialog(null, "정보가 삭제되었습니다.\r\n");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
