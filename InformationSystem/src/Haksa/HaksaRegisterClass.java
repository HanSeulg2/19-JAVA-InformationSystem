//학사담당자 사용자 등록하기
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
			BufferedWriter bos = new BufferedWriter(new FileWriter("회원정보.txt",true));
			// "회원정보.txt"파일에 학사담당자가 회원을 등록하는 작업
			bos.write(registerName.getText()+"/");            //신규등록자 이름
			bos.write(registerMajor.getText()+"/");           //신규등록자 학과
			bos.write(registerNumber.getText()+"/");          //신규등록자 학번
			bos.write(registerJuminFront.getText()+"/");      //신규등록자 주민번호 앞자리
			bos.write(registerJuminLast.getText()+"\r\n");    //신규등록자 주민번호 뒷자리
			bos.close();
			JOptionPane.showMessageDialog(null, "사용자 등록이 완료되었습니다.");  
			//dispose();
		}
		catch (Exception ex){
			JOptionPane.showMessageDialog(null, "사용자 등록에 실패하였습니다.");
		}		
		
	}

}
