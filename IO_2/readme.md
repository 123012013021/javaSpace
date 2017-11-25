## 实验三 带缓冲区的IO


用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。

#### 带缓冲：
------------------------------------------
File rfile=new File("read.txt");
		File wfile=new File("write.txt");
		if(rfile.exists()){
			FileWriter fw=new FileWriter(wfile);
			FileReader fr=new FileReader(rfile);
			BufferedReader read =new BufferedReader(fr);
			BufferedWriter write=new BufferedWriter(fw);
			if(wfile.exists()){
				String s=null;
				while((s=read.readLine())!=null){
					write.write(s);
				}
			}else{
				wfile.createNewFile();
				ReadAndWrite();
			}
  
  -----------------
  #### 不带缓冲：
  -----------------------------------------
File file=new File("read.txt");
		File sfile=new File("write.txt");
		if(file.exists()){
			FileInputStream in=new FileInputStream(file);//读取文件信息
			FileOutputStream out =new FileOutputStream(sfile);//写入文件信息
			byte[] b = new byte[1024];
			int i;
			if(sfile.exists()){//如果文件存在的话，则继续操作，不存在则建该文件夹
				while((i=in.read())!=-1){
					out.write(i);
				}
				in.close();
				out.close();
			}else{
				sfile.createNewFile();
				ReadWriteFile();
  -----------

#### 实验结果截图：

![](https://github.com/123012013021/javaSpace/blob/master/IO_2/img/1.png)<br>
  
  
## 实验四 对象序列化


类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。
----------------------------------
#### 建student类 implements Serializable
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

#### 建Read_Write继承student类 主要有Read_List()、write（）、ReadFromNewFile()方法
--------------------------------------------------------
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
---------------------------------------
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
------------------------------------------------
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

-----------------------------------
#### 实验截图：
#### 实验结果截图：

![](https://github.com/123012013021/javaSpace/blob/master/IO_2/img/2.png)<br>

    


