//로그인 클래스
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
	public boolean check=false;  //텍스트 데이터 true일떄만 출력
	public int UserCount=0;

	String NowUserName;
	String NowUserNumber;	
	String NName, NNumber;
	public void login(JTextField id, JPasswordField password) throws IOException {
		// TODO Auto-generated method stub
		final JFrame frame = new JFrame();
		try{
			int i =0;  //UserCount 값을 받기 위한 초기값 0을 가진 i
			String s;
			String[] array;
			BufferedReader bos = new BufferedReader(new FileReader("회원정보.txt"));
			while((s=bos.readLine())!=null){
				array=s.split("/");
				if(id.getText().equals(array[2])&&password.getText().equals(array[4])||id.getText().equals(array[2])&&password.getText().equals(array[5])) //변경된 비밀번호로도 로그인되도록 수정
				{
					//비교가 같을떄만 다이얼로그 창을 띄운다.
					check=true;     //조건이 일치 한다면 true
					UserCount = i;  //회정정보.txt에 원하는 회원을 찾기 위해 UserCount를 사용한다.

					NowUserName=array[0];      //사용자 이름에 해당하는 배열
					NowUserNumber = array[2];  //사용자 학번에 해당하는 배열
					
					StudentApplyClass applyclass = new StudentApplyClass();      
					applyclass.applyclass(NowUserName,NowUserNumber); 
					//객체를 생성하여 클래스에 해당하는 함수를 이용
					
					BufferedWriter DB = new BufferedWriter(new FileWriter("현재사용자.txt",true));
					DB.write(NowUserName+"/");      
					DB.write(NowUserNumber+"\r\n");	
					//"현재사용자.txt"에 array[0],array[2]값을 write합니다. 
					//사용자가 로그인 하였을 때  TextFeid를 받아 사용자가 자신을 확인 하기 위해서 입니다.
					DB.close();	
				}
				else{
					i+=1;  //맞지 않다면 1씩 증가 시켜서 
				}
			}
			
			BufferedWriter DB = new BufferedWriter(new FileWriter("개인정보수정.txt",true));
			DB.write(UserCount+"\r\n");   
			//"게인정보.txt"는 개인사용자가 개인수정을 위해 자신이 정보를 가진 라인에 들어가기 위해 UserCount값을 write하여 그값을 쓰기위해 txt를 생성합니다.
			DB.close();			//몇번째 사용자인지 txt에 저장
			bos.close();
			//dispose();
		}catch(IOException e) {
			e.toString();
		} catch(ArrayIndexOutOfBoundsException e) {
			e.toString();
		}
		if(check==true) {
			JOptionPane.showMessageDialog(null, "로그인이 되었습니다!!");

			if(id.getText().contains("S")) {  
				//ID 텍스트 입력에 "S"가 포함되어 있다면 
				frame.dispose(); 
				try {
					new Student(); 		//학생창
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

			}
			if(id.getText().contains("P")) {
				//ID 텍스트 입력에 "P"가 포함되어 있다면 
				frame.dispose(); 
				new Professor(); //교수창
			}
			if(id.getText().contains("H")) {	
				//ID 텍스트 입력에 "H"가 포함되어 있다면 
				frame.dispose(); 
				Haksa haksa = new Haksa();
				haksa.haksa(); //학사담당자 창
			}
			if(id.getText().contains("G")) {
				//ID 텍스트 입력에 "G"가 포함되어 있다면 
				frame.dispose(); 
				new Gangjwa(); //수업담당자 창
			}
		} 
		else {
			JOptionPane.showMessageDialog(null, "로그인 실패하였습니다. 재입력해주세요");
			//학번과 비밀번호가 둘다 동일하지 않다면 로그인 실패하게 됩니다.
		}
	}

}
