import java.io.*;
import java.util.Scanner;
public class Filewrite {
   public void inputFile() {
		// input File  from keyboard
		try {
			File file = new File("E:\\src.txt");
			Scanner num = new Scanner(System.in);
			System.out.println("请输入要录入的内容：");
			String b = num.nextLine();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(b);
			writer.close();
			} 
	  catch  (Exception e) {
			System.out.println(e);
			}
			}
   //File copy
   public void FileCopy() {
	   try{
		   File read = new File("E:\\src.txt");
		   File write = new File("E:\\dest.txt");
		   BufferedReader br = new BufferedReader(new FileReader(read));
		   BufferedWriter bw = new BufferedWriter(new FileWriter(write));
		   String temp =null;
		   temp=br.readLine();
		   while(temp!=null){
		     //写文件,只适用与windows系统
		      bw.write(temp+"\r\n");
		     //继续写文件
		      temp = br.readLine();
		    
		  }
		   bw.close();
		   br.close();
		}catch(FileNotFoundException fe){
		    System.out.println(fe.getMessage());
		    fe.printStackTrace();
		  }catch(Exception e){
		     System.out.println(e.getMessage());
		     e.printStackTrace();
		  }
		}
   //output File 
   public void OutputFile(String filePath) {
	   try {
		   
		   File file=new File(filePath);
		   if(file.isFile() && file.exists()) //File exit or not
		   { 
		   InputStreamReader read = new InputStreamReader(new FileInputStream(file));
		   BufferedReader bufferedReader = new BufferedReader(read);
		   String lineTxt = null;
		   while((lineTxt = bufferedReader.readLine()) != null){
		   System.out.println(lineTxt);
		   }
		   read.close();
		   }else{
		   System.out.println("找不到指定的文件");
		   }
		   } catch (Exception e) {
		   System.out.println("读取文件内容出错");
		   e.printStackTrace();
		   }
   }
   
   }

