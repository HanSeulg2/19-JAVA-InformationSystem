package Gangjwa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.table.DefaultTableModel;

public class GangjwaMoneyListAgain {
	public void listagain(DefaultTableModel model) throws IOException {
		// TODO Auto-generated method stub

		model.setNumRows(0);

		int i =0;
		String s;
		String[] array;
		BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("회원정보.txt")));
		while((s=file.readLine())!=null){
			array=s.split("/");			
			if((array[2].contains("S"))){	
				model.addRow(array);				
			}
		}
	}
}
