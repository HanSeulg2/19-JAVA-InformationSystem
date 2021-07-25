//성적 입력 클래스
//성적이 두번 저장되면 안됨


package Professor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ProfessorAddGradeClass { // 파일에 성적 저장
	public void addgradeclass(String sname, String snumber, String gname, String gnumber, String gmajor,
			String gprofessor, String gcount, String grades) {
		// TODO Auto-generated method stub
		
		
		try {
			BufferedWriter DB = new BufferedWriter(new FileWriter("성적입력.txt",true));
			DB.write(sname+"/");
			DB.write(snumber+"/");
			DB.write(gname+"/");
			DB.write(gnumber+"/");
			DB.write(gmajor+"/");
			DB.write(gprofessor+"/");
			DB.write(gcount+"/");
			DB.write(grades+"\r\n");

			DB.close();	

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
			
		JOptionPane.showMessageDialog(null, "성적수정이 되었습니다.");
	}

}