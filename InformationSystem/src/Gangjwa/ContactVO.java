//강좌등록/수정/삭제
package Gangjwa;

import java.io.Serializable;


public class ContactVO implements Serializable {
	String index;
	String name;
	String number;
	String major;
	String professor;
	String min;
	String max;
	String score;
	String explan;
	public ContactVO(String name, String number, String major, String professor,String score, String min, String max, String explan) 
 {
		this.name=name;
		this.number=number;
		this.major=major;
		this.professor=professor;
		this.min = min;
		this.max=max;
		this.score=score;
		this.explan=explan;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	//--------------------------------------------------------------
	
	public String getnumber() {
		return number;
	}
	public void setnumber(String number) {
		this.number=number;
	}
	//--------------------------------------------------------------
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major=major;
	}
	//--------------------------------------------------------------
	
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor=professor;
	}
	//--------------------------------------------------------------
	
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min=min;
	}
	//--------------------------------------------------------------
	
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max=max;
	}
	//-----------------------------------------------
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score=score;
	}
	//-----------------------------------------------
	public String getExplan() {
		return explan;
	}
	public void setExplan(String explan) {
		this.explan=explan;
	}
	//-----------------------------------------------
	public String toString() {
		String str = "강좌 이름:" + name +"    "
				+"강좌 번호:"+number+"    "
				+"학과:"+major+"    "
				+"교수:"+professor+"    "
				+"학점:"+score
				+"최소:"+min+"    "
				+"최대:"+max+"    "
				+"설명:"+explan;
		
		return str;
	}
}