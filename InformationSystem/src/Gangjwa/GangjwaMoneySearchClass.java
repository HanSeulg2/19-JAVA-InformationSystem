//수업담당자 수강료 청구서 발급 JTable로 학생만 나타내기
//전달받은 선택된 학생들의 이름과 학생들의 수강신청 정보가 저장되어 있는 데이터베이스.txt파일에서의 학생이름이 일치하는 정보만 JTable에 추가
package Gangjwa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class GangjwaMoneySearchClass {
	public boolean check = false;
	public void moneysearchclass(DefaultTableModel model, String sname, String snumber) throws IOException {
		// TODO Auto-generated method stub

		model.setNumRows(0);	//테이블 초기화
		
		String str = null;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("데이터베이스.txt")));
		String arr[] = null;
		int i=0;
		while ((str = file.readLine()) != null) { 				
			arr=str.split("/");		
			if(sname.equals(arr[0])) {
				model.addRow(arr);
			i++;
			}
		}	
	}	
}