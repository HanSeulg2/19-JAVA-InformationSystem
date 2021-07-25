//���µ��/����/����
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
		private static final String DATA_FILE="contact.txt";//������ ������ ������ ���� �̸� ����.
		
		private File dataDir;
		private File dataFile; //����, ���ϻ���ϴ� File��ü ����.
		
		private void initDataDir() {
			dataDir=new File(DATA_DIR);
			System.out.println("�������:"+dataDir.getPath());
			System.out.println("���� ���"+dataDir.getAbsolutePath());
			if(!dataDir.exists()) {
				if(dataDir.mkdir()) {
					System.out.println("���� ���� ����");
				}else {
					System.out.println("���� ���� ����");
				}
				
			}else {
				System.out.println("������ �̹� ����");
			}
		}//end initDataDir()
		//--------------------------------------------------------
		private void initDataFile() {
			String filePath =DATA_DIR+File.separator+DATA_FILE;
			dataFile=new File(filePath);
			System.out.println("���� ���:"+dataFile.getPath());
			System.out.println("���� ���:"+dataFile.getAbsolutePath());
			
			if(!dataFile.exists()) {
				System.out.println("���ο� ������ ���� ����");
				list = new ArrayList<>();
			}else {
				System.out.println("���� ������ ����");
				readDataFromFile();
			}
		}//initDataFile(); ������ ���� �˻�, ������ Arraylist�� �� ����Ʈ�� ����.
		//�ִ� ���, ���Ͽ��� �����͸� �о�� ArrayList�� ä���.
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
				System.out.println("���� ��� ����");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}// Contact.txt���Ͽ��� ArrayList��ü�� �����͸� �о ��� ���� list�� ����.
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
	} // ��� ���� list�� ������ Contact.txt�� ����.
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