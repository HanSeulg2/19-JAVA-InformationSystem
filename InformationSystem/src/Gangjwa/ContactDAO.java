//강좌등록/수정/삭제
package Gangjwa;

import java.util.ArrayList;

public interface ContactDAO {
	public abstract int insert(ContactVO vo);
	
	public abstract ArrayList<ContactVO> select();
	
	public abstract ContactVO select(int index);
	
	public abstract int update(int index,ContactVO vo);
	
	public abstract int delete(int index);
}
