//강좌등록/수정/삭제
package Gangjwa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;



public class ContactDAOImple implements ContactDAO {
	private static ContactDAOImple instance = null;
	private ContactDAOImple() {
		initDataDir();
		initDataFile();
	}
	

	//--------------------------------------------------------
	public static ContactDAOImple getInstance() {
		if(instance==null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}
	//--------------------------------------------------------
		private ArrayList<ContactVO> list;
		
		private static final String DATA_DIR ="data";
		private static final String DATA_FILE="contact.txt";//데이터 저장할 폴더랑 파일 이름 정의.
		
		private File dataDir;
		private File dataFile; //폴더, 파일사용하는 File객체 선언.
		
		private void initDataDir() {
			dataDir=new File(DATA_DIR);
			System.out.println("폴더경로:"+dataDir.getPath());
			System.out.println("절대 경로"+dataDir.getAbsolutePath());
			if(!dataDir.exists()) {
				if(dataDir.mkdir()) {
					System.out.println("폴더 생성 성공");
				}else {
					System.out.println("폴더 생성 실패");
				}
				
			}else {
				System.out.println("폴더가 이미 존재");
			}
		}//end initDataDir()
		//--------------------------------------------------------
		private void initDataFile() {
			String filePath =DATA_DIR+File.separator+DATA_FILE;
			dataFile=new File(filePath);
			System.out.println("파일 경로:"+dataFile.getPath());
			System.out.println("절대 경로:"+dataFile.getAbsolutePath());
			
			if(!dataFile.exists()) {
				System.out.println("새로운 데이터 파일 생성");
				list = new ArrayList<>();
			}else {
				System.out.println("기존 데이터 있음");
				readDataFromFile();
			}
		}//initDataFile(); 데이터 파일 검사, 없으면 Arraylist에 빈 리스트로 생성.
		//있는 경우, 파일에서 데이터를 읽어와 ArrayList를 채운다.
		//--------------------------------------------------------
		@SuppressWarnings("unchecked")
		private void readDataFromFile() {
			InputStream in = null;
			BufferedInputStream bin =null;
			ObjectInputStream oin = null;
			
			try {
				in = new FileInputStream(dataFile);
				bin = new BufferedInputStream(in);
				oin = new ObjectInputStream(bin);
				
				list = (ArrayList<ContactVO>) oin.readObject();
				System.out.println("파일 출력 성공");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}// Contact.txt파일에서 ArrayList객체로 데이터를 읽어서 멤버 변수 list에 저장.
		//--------------------------------------------------------

	private void writeDataToFile() {
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream("data/contact.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			oout.writeObject(list);
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				oout.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	} // 멤버 변수 list의 내용을 Contact.txt에 쓴다.
	@Override
	public int insert(ContactVO vo) {
		list.add(vo);
		writeDataToFile();
		return 1;

}
	@Override
	public ArrayList<ContactVO> select(){
		return list;
}
	@Override
	public ContactVO select(int index) {
		if(index >=0 && index <list.size()) {
			return list.get(index);
		}else {
			return null;
		}
	}
	@Override
	public int update(int index,ContactVO vo) {
		if(index>=0&&index<list.size()) {
			list.set(index,vo);
			writeDataToFile();
			return 1;
		}else {
			return 0;
		}
	}
	@Override
	public int delete(int index) {
		if(index>=0&&index<list.size()) {
			list.remove(index);
			writeDataToFile();
			return 1;
		}
		else {
			return 0;
		}
	}
	}