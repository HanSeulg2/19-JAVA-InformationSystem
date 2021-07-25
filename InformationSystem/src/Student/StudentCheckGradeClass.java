//학생 성적확인 클래스
package Student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentCheckGradeClass {	//조회버튼을 눌렀을 때 실행되는 이벤트처리기 코드

	public void checkgradeclass(DefaultTableModel model, String nuName, String nuNumber) throws IOException {
		// TODO Auto-generated method stub
		
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("성적입력.txt")));
		String arr[] = null;
		while ((str = file.readLine()) != null) { 	
			arr = str.split("/");
			if(nuName.equals(arr[0])) {		//현재사용자이름과 성적입력.txt에 저장된 학생이름이 같은 정보들만 JTable에 추가
				model.addRow(arr);
			}
		}
		
	}
}



