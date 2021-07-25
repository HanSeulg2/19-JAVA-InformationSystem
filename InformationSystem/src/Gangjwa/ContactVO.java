//���µ��/����/����
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
		String str = "���� �̸�:" + name +"    "
				+"���� ��ȣ:"+number+"    "
				+"�а�:"+major+"    "
				+"����:"+professor+"    "
				+"����:"+score
				+"�ּ�:"+min+"    "
				+"�ִ�:"+max+"    "
				+"����:"+explan;
		
		return str;
	}
}