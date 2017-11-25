package ObjectSerialization;
import java.io.*;
import java.util.Scanner;
public class Read_Write extends student{
	public void Read_List(){
		int i=0;
		File file =new File("list.txt");
    	if(file.exists()){
    		try{
    			Scanner scan =new Scanner(new FileInputStream(file));
    			String []StudentId;
    			StudentId=new String[40];
    			String [] Name;
    			Name=new String[40];
    			String []Sex;
    			Sex = new String[40];
    			while(scan.hasNext()){
    				StudentId[i]=scan.next();
    				Name[i]=scan.next();
    				Sex[i]=scan.next();
    				i=i+1;
    			}
    			scan.close();
    			write(StudentId,Name,Sex);
    		}catch(Exception e){
    			e.printStackTrace();
    		}	    	
    	}else{
    		return ;
    	}
	}
	
	public void write(String[] StudentID,String[] Name,String[]Sex)throws FileNotFoundException,IOException{
		int j;
		int compare;
		int i;
		String tempID;
		String tempSex;
		String tempName;
		for(i=0;i<40;i++){
			for(j=i+1;j<40;j++){
				compare = StudentID[i].compareTo(StudentID[j]);
				if(compare>0){
					tempID=StudentID[j];
					tempName=Name[j];
					tempSex=Sex[j];
					
					StudentID[j]=StudentID[i];
					Name[j]=Name[i];
					Sex[j]=Sex[i];
					
					StudentID[i]=tempID;
					Name[i]=tempName;
					Sex[i]=tempSex;
				}
			}
		}
		student[] I =new student[40];
		for(j=0;j<40;j++){
			I[j] =new student();
		}
		for(i=0;i<40;i++){
			I[i].SetStudentID(StudentID[i]);
			I[i].SetName(Name[i]);
			I[i].SetSex(Sex[i]);
		}
		File file=new File("student.bin");
		if(file.exists()){
			ObjectOutputStream WriteOb = new ObjectOutputStream(new FileOutputStream(file));
			for(i=0;i<40;i++){
				WriteOb.writeObject(I[i]);
			}
        }else{
        	file.createNewFile();
        	Read_List();
        }
	}
	
	public void ReadFromNewFile()throws FileNotFoundException,IOException, ClassNotFoundException{//重新的文件里面读取出每个人的数据
		ObjectInputStream ReadOb = new ObjectInputStream(new FileInputStream(new File("student.bin")));
		student [] ST;
		ST=new student[40];
		for(int i=0;i<40;i++){
			ST[i] = new student();
		}
		for(int i=0;i<40;i++){
			ST[i]=(student)ReadOb.readObject();
			System.out.print(ST[i].getStudentID()+"  ");
			System.out.print(ST[i].getName()+"  ");
			System.out.println(ST[i].getSex());
		}
	}
}
