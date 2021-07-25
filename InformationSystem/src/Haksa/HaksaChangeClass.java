//학사담당자 사용자 변경 클래스
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
		BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("현재사용자번호.txt")));
		String arr = null;
		while ((str = file2.readLine()) != null) { 	
			arr=str;			// 로그인했을 때 자기 자신을 찾기위해 UserCount값을 넣은 .txt파일을 읽고 그 문자를 arr에 담습니다.
		}
		
		int UserCount=Integer.parseInt(arr);   //arr를 정수형을 변환해 줍니다.
		
		File file = new File("회원정보.txt");		
		String spare = "";	
		try {
			BufferedReader chR = new BufferedReader(new FileReader("회원정보.txt"));
			String line;
			for(int k=0; k<UserCount; k++) {  // 선택한 JTable을 선택한 사용자 정보 라인 앞까지 읽습니다.
				line = chR.readLine(); //읽으며 이동
				spare += (line + "\r\n" ); //spare에 쌓습니다.
			}
			String Old = chR.readLine();   //읽은 데이터는 이전 데이터로 나누는 String입니다.
			String New = (haksachangeName.getText()+"/"+haksachangeMajor.getText()+"/"+
					haksachangeNumber.getText()+"/"+haksachangeJuminFront.getText()+"/"+((JTextComponent) haksachangeJuminLast).getText()+"\r\n");
            //변경할 정보는 새로운 데이터로 New변수로 지정합니다.
			spare += New;  //이전의 데이터를 담고있는 데이터에 변경한 데이터를 추가해줍니다.
			while((line = chR.readLine())!=null) {
				//이전 데이터를 읽고 새로운 데이터를 추가한 spare에 null일때까지 읽습니다.
				spare += (line + "\r\n" ); 
			}
			//4. FileWriter를 이용해서 덮어쓰기
			FileWriter chW = new FileWriter("회원정보.txt");
			chW.write(spare);
			chW.close();
			chR.close();
			JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.\r\n" + "수정 전 : " + Old +"\r\n수정 후 : " + New);
			//변경 전 데이터와 변경 후 데이터를 사용자가 직접확인할 수 있게 Message가 뜹니다.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}