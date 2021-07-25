//수강신청클래스
package Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;


public class StudentApplyClass {
	String nuName;
	String nuNumber;
	public void applyclass(String nowUserName, String nowUserNumber) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter DB = new BufferedWriter(new FileWriter("현재사용자.txt",true));
		DB.write(nowUserName+"/");
		DB.write(nowUserNumber+"/");		
	}	//로그인했을 때 저장한 사용자의 이름과 학점을 불러와서 txt파일에 먼저 저장함.
	
	
	public void apply(int row, String gname, String gnumber, String gmajor, String gprofessor, String gcount) {	
		try {		
			String str = null;
			BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream("현재사용자.txt")));
			String arr = null;
			while ((str = file.readLine()) != null) { 	
				arr=str;
			}	// 저장한 현재사용자의 정보를 불러와서 arr에 저장함.
			String nu[] = arr.split("/"); //nu[0] = 이름, nu[1] = 학번
			String gcountstring= gcount.replaceAll("[^0-9]","");	//String에서 숫자만 추출
			int gcountNumber = Integer.parseInt(gcountstring);			//추출한 숫자를 int로 변환
			
			int gangjwapeople = 0;			
			String arr2[] = null;
			String str2 = null;
			BufferedReader file2 = new BufferedReader(new InputStreamReader( new FileInputStream("데이터베이스.txt")));
			//수강신청이 완료되어 저장된 정보를 불러옴
			int c=0;
			int Sum = gcountNumber;		//현재선택한 강좌의 학점수가 gangjwa의 초기값
			while ((str2 = file2.readLine()) != null) {
				arr2=str2.split("/");	
				//중복신청 안됨
				if(nu[1].equals(arr2[1]) && gname.equals(arr2[2])) {	
					//현재사용자의 학번과 txt파일의 학번, 신청하고자하는 강좌와 txt파일에 저장되어 있는 강좌를 서로 비교하여 두개모두가 일치하면
					JOptionPane.showMessageDialog(null, "이미 신청된 강좌입니다.");
					c=1;	//c를 1로 증가시키고
					break;	//while을 break함
				}
				//최대학점 체크하기
				if(nu[1].equals(arr2[1])) {
					String mTOs = arr2[6].replaceAll("[^0-9]","");	//String에서 숫자만 추출
					int gcountSum = Integer.parseInt(mTOs);			//추출한 숫자를 int로 변환 . gcountSum = 수업마다 학점
					Sum += gcountSum;								//Sum = 총학점
					if(Sum>=18) {
					JOptionPane.showMessageDialog(null, "최대 신청학점을 넘었습니다.");
					c=1;	//c를 1로 증가시키고
					break;	//while을 break함
					}					
				}
				//최대수강인원 체크하기
				else if(gnumber.equals(arr2[3])) {	//강좌번호랑 txt에 있는 강좌번호랑 같으면
					gangjwapeople++;	//증가  . 수업마다 학생수 증가 시키기
					
					int gMax =0;		//강좌 최대학생수 구하기
					String str1 = null;
					String arr1[] = null;
					BufferedReader file1 = new BufferedReader(new InputStreamReader( new FileInputStream("강좌등록.txt")));
					while ((str1 = file1.readLine()) != null) { 
						arr1=str1.split("/");	
						if(gnumber.equals(arr1[1])) {
						String GMAX = arr1[6].replaceAll("[^0-9]","");	//String에서 숫자만 추출
						gMax = Integer.parseInt(GMAX);			//추출한 숫자를 int로 변환
//						System.out.println(gMax);	
						}//강좌 최대수강자 수 읽어오기
					}	
					if(gangjwapeople>=gMax) {
						JOptionPane.showMessageDialog(null, "수강인원을 초과하여 신청할 수 없습니다.");
						c=1;
						break;
					}
				}
				
				else{	//비교하여 일치하는 과목이 없었을때 
					c=0;	//c=0
				}
			}
			switch(c) {	//switch를 통해서 c의 값을 받고
			case 0:	//c가 0이면 즉, else인 경우 선택된 강좌의 값과 현재 사용자를 함께 txt파일에 저장함
				BufferedWriter DB = new BufferedWriter(new FileWriter("데이터베이스.txt",true));

				DB.write(arr+"/");		//학생이름/학번
				DB.write(gname+"/");
				DB.write(gnumber+"/");
				DB.write(gmajor+"/");
				DB.write(gprofessor+"/");
				DB.write(gcount+"\r\n");

				DB.close();	
				JOptionPane.showMessageDialog(null, "수강신청 되었습니다.");
				break;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

	}
}
