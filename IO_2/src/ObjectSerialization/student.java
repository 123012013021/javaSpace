package ObjectSerialization;

import java.io.*;

public class student implements Serializable {
	private static final long serialVersionUID = 1234L;
	private String StudentID=null;
	private String Name=null;
	private String Sex;
	
	public String getStudentID(){
		return StudentID;
	}
	
	public String getName(){
		return Name;
	} 
	
	public String getSex(){
		return Sex;
	}
	
	public void SetName(String name){
		this.Name=name;
	}
	
	public void SetStudentID(String StudentID){
		this.StudentID=StudentID;
	}
	
	public void SetSex(String sex){
		this.Sex=sex;
	}


}


